package com.epam.programsportalautomation.test;

import com.epam.programsportalautomation.dataproviders.DataProviders;
import com.epam.programsportalautomation.dataproviders.ExcelDataProvider;
import com.epam.programsportalautomation.framework.DriverInit;
import com.epam.programsportalautomation.web.pages.CollegePage;
import com.epam.programsportalautomation.web.pages.DashBoardPage;
import com.epam.programsportalautomation.web.pages.EnterAndEditCollegeDetails;
import com.epam.programsportalautomation.web.pages.SignUpPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.epam.programsportalautomation.constants.RegisterCredentials.EMAIL;
import static com.epam.programsportalautomation.constants.RegisterCredentials.PASSWORD;

public class SearchAndValidateCollegeTest {
    WebDriver driver;
    @BeforeClass
    public void setup() throws Exception {
        DriverInit driverInit = new DriverInit();
        driver = driverInit.getDriver("chrome");
        new SignUpPage(driver).signup(EMAIL, PASSWORD).signIn(EMAIL,PASSWORD);
    }
    @Test(priority = 1)
    public void clickOnAddCollege() throws IOException, InterruptedException {
        CollegePage collegePage = new DashBoardPage(driver).dashBoardOperations().clickOnCollege();
    }
//    @Test(priority = 2)
//    public void enterAllCollegeDetails() throws IOException, InterruptedException {
//        CollegePage  collegePage= new EnterAndEditCollegeDetails(driver).enteringCollegeDetails().clickSaveButton();
//    }
     @Test(priority = 2,dataProvider ="SearchCollegeMail",dataProviderClass = ExcelDataProvider.class)
    public void seachCollegeWithMail(String mailId) throws IOException, InterruptedException {
        CollegePage  collegePage= new CollegePage(driver).seachingAddedCollege(mailId).clearSearchColumn();
    }
    @Test(dataProvider = "EditCollegeMail",dataProviderClass = DataProviders.class,priority = 3)
    public void searchAndEditCollege(String changedmailid) throws IOException, InterruptedException {
        CollegePage collegePage = new CollegePage(driver).searchAndEditCollege().enterChangedMail(changedmailid).clickSaveButton();
    }
    @Test(dataProvider = "EditCollegeMail",dataProviderClass = DataProviders.class,priority = 4)
    public void validatingCollege(String changedmailid) throws IOException, InterruptedException {
        CollegePage collegePage = new CollegePage(driver).validateCollege(changedmailid);
        Assert.assertEquals(collegePage.getEditedCollege(),"wisely@ron.com");
    }
    @AfterClass
    public void tearDown()
    {
        driver.close();
    }
}
