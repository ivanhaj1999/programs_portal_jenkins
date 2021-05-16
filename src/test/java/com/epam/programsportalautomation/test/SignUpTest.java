package com.epam.programsportalautomation.test;

import com.epam.programsportalautomation.framework.DriverInit;
import com.epam.programsportalautomation.framework.screenshot.ScreenShotTaker;
import com.epam.programsportalautomation.web.pages.SignInPage;
import com.epam.programsportalautomation.web.pages.SignUpPage;
import com.epam.reportportal.testng.ReportPortalTestNGListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.epam.programsportalautomation.constants.RegisterCredentials.EMAIL;
import static com.epam.programsportalautomation.constants.RegisterCredentials.PASSWORD;

//@Listeners({ReportPortalTestNGListener.class})
public class SignUpTest {
   public static  WebDriver driver;
    @BeforeClass
    public void setup() throws Exception {
        DriverInit driverInit = new DriverInit();
        driver = driverInit.getDriver("chrome");
    }

    @Test
    public void signIn() throws Exception {

//        System.out.println("SignIn and Signup test class The thread ID for Chrome is " + Thread.currentThread().getId());
        SignInPage signInPage = new SignUpPage(driver).signup(EMAIL, PASSWORD);
        Thread.sleep(3000);
//        ScreenShotTaker.takeScreenshot(driver,"signInPage");
    }
    @AfterClass
    public void tearDown()
    {
        driver.close();
    }

}
