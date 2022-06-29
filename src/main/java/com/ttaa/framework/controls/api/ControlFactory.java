package com.ttaa.framework.controls.api;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

// Replacement of PageFactory of selenium
public class ControlFactory extends PageFactory {

    // Fetched from InstantiatePage method of PageFactory and made changes
    public static <T> T initElements(WebDriver driver, Class<T> pageClassToProxy){

        try {
            T page = pageClassToProxy.newInstance();
            PageFactory.initElements( new ControlFieldDecorator(new DefaultElementLocatorFactory(driver)), page);
            return pageClassToProxy.cast(page);
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }
}
