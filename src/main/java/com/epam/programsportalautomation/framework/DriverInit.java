package com.epam.programsportalautomation.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static com.epam.programsportalautomation.constants.BrowserConfigurations.*;

public class DriverInit {
    public  static WebDriver getDriver(String browserType) throws Exception {
        WebDriver driver=null;
        switch (browserType.toLowerCase()){
            case "chrome":
                System.setProperty(CHROMEDRIVER_PROPERTY, CHROME_DRIVER_PATH );
                driver = new ChromeDriver();
                break;
            case "edge":
                System.setProperty(EDGEDRIVER_SYSTEM_PROPERTY, EDGEDRIVER_SYSTEM_PATH);
                driver = new EdgeDriver();
                break;
            default:
                throw new Exception("no such browser is present to be initiated. Browser name:"+browserType);
        }
        return driver;
    }
}
