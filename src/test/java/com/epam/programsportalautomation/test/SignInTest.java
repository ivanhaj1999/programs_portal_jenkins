package com.epam.programsportalautomation.test;

import com.epam.programsportalautomation.database.DataBaseUtility;
import com.epam.programsportalautomation.framework.DriverInit;
import com.epam.programsportalautomation.framework.logs.LogUtilityFunctions;
import com.epam.programsportalautomation.web.pages.DashBoardPage;
import com.epam.programsportalautomation.web.pages.SignUpPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static com.epam.programsportalautomation.constants.RegisterCredentials.*;


public class SignInTest {

	
	static Logger logger =LogManager.getLogger(SignInTest.class);
	WebDriver driver;
	@BeforeClass
	public void setup() throws Exception {
		driver = DriverInit.getDriver("chrome");
	}

	@Test
	public void signIn() throws InterruptedException {
		
		DashBoardPage dash = new SignUpPage(driver).signup(EMAIL,PASSWORD).signIn(EMAIL,PASSWORD);
//		LogUtilityFunctions.logInfoMessage("signin successful");
		logger.info("signIn test is successful");
		Thread.sleep(3000);
	}
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}
	

}
