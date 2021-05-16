package com.epam.programsportalautomation.framework.screenshot;

import com.epam.programsportalautomation.framework.DriverInit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShotTaker {
    public static  String fileName = "screenshots_output";


    public static void takeScreenshot(WebDriver driver, String fileName) {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file,new File("src/main/java/screenshots_output/"+fileName+".jpeg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
