package com.ttaa.framework.controls.api;

import com.ttaa.framework.controls.internals.Control;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

// This is the replacement of selenium class LocatingElementListHandler which helps in finding list of web-elements
public class ControlListHandler implements InvocationHandler {

    private final ElementLocator locator;
    private final Class<?> wrappingType;


    public <T> ControlListHandler(Class<T> interfaceType, ElementLocator locator) {
        this.locator = locator;
        if(!Control.class.isAssignableFrom(interfaceType)) {
            throw new RuntimeException("interface is not assignable to Control.");
        }
        this.wrappingType = ImplementedByProcessor.getWrapperClass( interfaceType);
    }

    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        List<Object> wrappedList = new ArrayList<Object>();
        Constructor<?> cons = wrappingType.getConstructor(WebElement.class);

        for (WebElement element : locator.findElements()) {
            Object thing = cons.newInstance(element);
            wrappedList.add(wrappingType.cast(thing));
        }

        try {
            return method.invoke(wrappedList, objects);
        } catch (InvocationTargetException e) {
            throw e.getCause();
        }
    }
}
