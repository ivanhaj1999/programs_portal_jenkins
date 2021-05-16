package com.epam.programsportalautomation.stepdefs;

import com.epam.programsportalautomation.framework.DriverInit;

import com.epam.programsportalautomation.web.pages.DashBoardPage;
import com.epam.programsportalautomation.web.pages.SignUpPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static com.epam.programsportalautomation.constants.CollegeOperationsXpaths.*;
import static com.epam.programsportalautomation.constants.DashBoardConstants.*;
import static com.epam.programsportalautomation.constants.RegisterCredentials.*;

public class AddCollege{

    static WebDriver driver;


    @Before
    public void openChrome() throws Exception {
        driver=DriverInit.getDriver("chrome");

    }
    public void signupAndLoginDetails(){
        driver.findElement(By.id("exampleInputEmail1")).sendKeys(EMAIL);
        driver.findElement(By.id("exampleInputPassword1")).sendKeys(PASSWORD);
        driver.findElement(By.id("form_submit")).click();
    }

    @Given("^user will be in home page of programs portal$")
    public void userWillBeInHomePage() throws InterruptedException {
//        driver.navigate().to(signUpURL);
//        signupAndLoginDetails();
//        driver.navigate().to(signInURL);
//        signupAndLoginDetails();
        DashBoardPage dash = new SignUpPage(driver).signup(EMAIL,PASSWORD).signIn(EMAIL,PASSWORD);

        Thread.sleep(3000);
    }
    @When("^user clicks on menu button on top left corner$")
    public void whenUserClicksOnMenuBar() throws InterruptedException {
//        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(By.className(MENUBAR))).click();
        driver.findElement(By.className(MENUBAR)).click();

        Thread.sleep(3000);
    }
    @And("^user clicks on master data management option$")
    public void andUserClicksMDMoption() throws InterruptedException {
        driver.findElement(By.xpath(MDM_TEXT_XPATH)).click();
        Thread.sleep(3000);
    }
    @And("^user clicks on colleges option$")
    public void andUserClicksCollegesOption() throws InterruptedException {
        driver.findElement(By.xpath(COLLEGES)).click();
        Thread.sleep(3000);
    }
    @Then("^user validates whether it navigated to add colleges page$")
    public void thenUserNavigatestoCollegesPage() throws InterruptedException {
        WebElement webElement = driver.findElement(By.xpath(ADD_COLLEGE));
        String str = webElement.getText();
        System.out.println(str);
        Assert.assertEquals(str," ADD COLLEGE");
    }

    @After
    public void tearDown(){
        driver.close();
    }
}
