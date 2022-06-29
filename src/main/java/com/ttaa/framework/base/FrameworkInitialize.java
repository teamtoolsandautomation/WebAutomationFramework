package com.ttaa.framework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameworkInitialize extends Base{

    public void InitializeBrowser(BrowserType browserType){

        WebDriver driver = null;
        switch (browserType){
            case FireFox:
                break;
            case Chrome:
                System.setProperty("webdriver.chrome.driver","/home/manoj/Documents/workspace/TtaaWebAutomationFramework/chromedriver");
                driver = new ChromeDriver();
                break;
            case Safari:
                break;
            case InternetExplorer:
                break;
        }

        DriverContext.setDriver(driver);
        DriverContext.Browser = new Browser(driver);
    }

}
