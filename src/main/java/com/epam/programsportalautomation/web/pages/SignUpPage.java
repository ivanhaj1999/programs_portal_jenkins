package com.epam.programsportalautomation.web.pages;

import com.epam.programsportalautomation.framework.logs.LogUtilityFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.epam.programsportalautomation.constants.UrlsProgramsPortal.signUpURL;


public class SignUpPage {
	public WebDriver driver;



	@FindBy(id = "exampleInputEmail1")
	@CacheLookup
	WebElement userName;

	@FindBy(id = "exampleInputPassword1")
	@CacheLookup
	WebElement password;

	@FindBy(id = "form_submit")
	@CacheLookup
	WebElement signUpButton;

	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);

	}

	public SignUpPage() {
	}


	public void launchBrowserWithSignUpPage() {
		driver.get(signUpURL);
	}


	public void enterUserName(String email) {
		userName.sendKeys(email);
	}

	public void enterPassword(String passWord) {
		password.sendKeys(passWord);
	}

	public boolean isSignUpButtonEnabled() {
		return signUpButton.isEnabled();
	}

	public void clickOnSignupButton() {
		if (signUpButton.isEnabled())
			signUpButton.click();
		else
			LogUtilityFunctions.logInfoError("SignUp button is disabled");

	}

	public SignInPage signup(String email, String password) {
		launchBrowserWithSignUpPage();
		enterUserName(email);
		enterPassword(password);
		clickOnSignupButton();
		return new SignInPage(driver);

	}
}
