package com.epam.programsportalautomation.test;

import com.epam.programsportalautomation.framework.DriverInit;
import com.epam.programsportalautomation.web.pages.DashBoardPage;
import com.epam.programsportalautomation.web.pages.EnterAndEditCollegeDetails;
import com.epam.programsportalautomation.web.pages.SignUpPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.epam.programsportalautomation.constants.RegisterCredentials.*;

public class CollegeOperationsTest {
    WebDriver driver;
    @BeforeClass
    public void setup() throws Exception {
        DriverInit driverInit = new DriverInit();
        driver = driverInit.getDriver("chrome");
        new SignUpPage(driver).signup(EMAIL, PASSWORD).signIn(EMAIL,PASSWORD);
    }
    @Test
    public void collegeOperations() throws IOException, InterruptedException {
        EnterAndEditCollegeDetails edit = new DashBoardPage(driver).dashBoardOperations().clickOnCollege().clickOnAddCollege();
    }
    @AfterClass
    public void tearDown()
    {
        driver.close();
    }
}
