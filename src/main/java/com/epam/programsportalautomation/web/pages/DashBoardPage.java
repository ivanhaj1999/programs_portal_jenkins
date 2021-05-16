package com.epam.programsportalautomation.web.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.epam.programsportalautomation.framework.utilityfunctions.ReusableUtilityFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.epam.programsportalautomation.constants.DashBoardConstants.*;



public class DashBoardPage {
	private WebDriver driver;
	
	@FindBy(className = MENUBAR)
	WebElement toggleBox;
	
	@FindBy(xpath = MDM_TEXT_XPATH)
	WebElement masterDataManagement;
	
	@FindBy(xpath = COLLEGES)
	WebElement collegesButton;
	
	public DashBoardPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	public DashBoardPage clickOnToggleButton()
	{
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		toggleBox.click();
		return new DashBoardPage(driver);
	}
	public DashBoardPage clickMasterDataManagementLink()
	{
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		masterDataManagement.click();
		return new DashBoardPage(driver);
	}
	public DashBoardPage dashBoardOperations(){

		ReusableUtilityFunctions.maximizeScreen(driver);
		DashBoardPage dashboard = new DashBoardPage(driver).clickOnToggleButton().clickMasterDataManagementLink();
		return dashboard;
	}
	public CollegePage clickOnCollege() throws IOException {
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);
		collegesButton.click();
		return new CollegePage(driver);
	}
	
	
}
