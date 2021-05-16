package com.epam.programsportalautomation.web.pages;

import com.epam.programsportalautomation.framework.logs.LogUtilityFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.epam.programsportalautomation.constants.UrlsProgramsPortal.*;


public class SignInPage {
	private WebDriver driver;
	
	@FindBy(id = "exampleInputEmail1")
	@CacheLookup
    WebElement userName;
	
	@FindBy(id = "exampleInputPassword1")
	@CacheLookup
    WebElement password;
	
	@FindBy(id = "form_submit")
	@CacheLookup
    WebElement signInButton;
	

    
    public SignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
//	static Logger logger= LogManager.getLogger();
    public SignInPage launchBrowserWithSignInPage()
    {
    	driver.get(signInURL);
    	return new SignInPage(driver);
    }
    

    public void enterUserName(String email)
    {
    	userName.sendKeys(email);
    }

    public void enterPassword(String passWord)
    {
    	password.sendKeys(passWord);
    }
    public boolean isSignInButtonEnabled()
    {
    	return signInButton.isEnabled();
    }
    public void clickOnSigninButton()
    {
    	if(signInButton.isEnabled())
    		signInButton.click();
		else
			LogUtilityFunctions.logInfoError("SignUp button is disabled");

	}
    
    public DashBoardPage signIn(String email, String password)
    {
    	launchBrowserWithSignInPage();
    	enterUserName(email);
    	enterPassword(password);
    	clickOnSigninButton();
		LogUtilityFunctions.logInfoMessage("login Successful");
    	return new DashBoardPage(driver);
    }
     
}
