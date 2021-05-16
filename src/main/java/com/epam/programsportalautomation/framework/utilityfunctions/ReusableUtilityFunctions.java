package com.epam.programsportalautomation.framework.utilityfunctions;

import org.openqa.selenium.WebDriver;

public class ReusableUtilityFunctions {


    public static void maximizeScreen(WebDriver driver){
        driver.manage().window().maximize();

    }
    public static void fullScreen(WebDriver driver){
        driver.manage().window().fullscreen();

    }
}
