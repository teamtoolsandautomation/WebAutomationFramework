package com.ttaa.framework.base;

import org.openqa.selenium.WebDriver;

public class Browser extends Base{

    private WebDriver driver;
    public BrowserType type;

    public Browser(WebDriver driver){
        this.driver=driver;
    }

    public void GoToUrl(String url){
        driver.get(url);
    }

    public void MaximizeWindow(){
        driver.manage().window().maximize();
    }
}
