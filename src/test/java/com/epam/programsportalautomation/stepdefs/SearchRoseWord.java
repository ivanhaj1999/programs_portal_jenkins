//package com.epam.programsportalautomation.stepdefs;
//
//import com.epam.programsportalautomation.framework.DriverInit;
//
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//
//import static com.epam.programsportalautomation.constants.BrowserConfigurations.*;
//
//public class SearchRoseWord {
//    static WebDriver driver;
//    @Before
//    public void openChrome() throws Exception {
//        System.setProperty(CHROMEDRIVER_PROPERTY,CHROME_DRIVER_PATH);
//        driver = new ChromeDriver();
//
//
//    }
//    @Given("^user will be in google page to search a word$")
//    public void userEntersGoogleUrl(){
//        driver.get("https://www.google.com");
//    }
//    @When("^user types the word name rose and press the enter button$")
//    public void userEnterWordAndClickSearch(){
//        WebElement webElement = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
//        webElement.sendKeys("rose");
//        webElement.sendKeys(Keys.ENTER);
//    }
//    @Then("^user validates whether word was found or not$")
//    public void userValidatesTheResult(){
//        WebElement webElement = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div[1]/a/h3"));
//        String word = webElement.getText();
//        System.out.println("word "+word);
//        Assert.assertEquals("Rose - Wikipedia",word);
//    }
//    @After
//    public void tearDown(){
//        driver.close();
//    }
//}
