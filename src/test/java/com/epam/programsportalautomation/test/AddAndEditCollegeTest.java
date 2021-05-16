package com.epam.programsportalautomation.test;

import com.epam.programsportalautomation.database.DataBaseUtility;
import com.epam.programsportalautomation.dataproviders.ExcelDataProvider;
import com.epam.programsportalautomation.framework.DriverInit;
import com.epam.programsportalautomation.web.pages.CollegePage;
import com.epam.programsportalautomation.web.pages.DashBoardPage;
import com.epam.programsportalautomation.web.pages.SignUpPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;


import static com.epam.programsportalautomation.constants.RegisterCredentials.EMAIL;
import static com.epam.programsportalautomation.constants.RegisterCredentials.PASSWORD;

public class AddAndEditCollegeTest {
    WebDriver driver;
    @BeforeClass
    public void setup() throws Exception {
       DriverInit driverInit = new DriverInit();
        driver = driverInit.getDriver("chrome");
        new SignUpPage(driver).signup(EMAIL, PASSWORD).signIn(EMAIL,PASSWORD);
    }

    @Test(priority = 1)
    public void dashboardOperations() throws IOException {
        CollegePage collegePage = new DashBoardPage(driver).dashBoardOperations().clickOnCollege();
    }
    @Test(dataProviderClass = ExcelDataProvider.class,dataProvider = "AddCollegeDetailsFromExcelSheet",priority = 2)
    public void collegeOperations(String name, String group, String city, String ptoname, String ptomail) throws IOException, InterruptedException, SQLException {
        CollegePage collegePage = new CollegePage(driver).clickOnAddCollege().enterAllCollegeDetails(name,group,city,ptoname,ptomail).clickSaveButton();
        Assert.assertTrue(JdbcFunctionsTest.checkIfCollegeAdded());
          }
    @AfterClass
    public void tearDown()
    {
        driver.close();
    }
}
