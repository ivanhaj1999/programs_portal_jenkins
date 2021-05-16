package com.epam.programsportalautomation.web.pages;

import com.epam.programsportalautomation.dataproviders.ExcelDataProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;


import static com.epam.programsportalautomation.constants.CollegeOperationsXpaths.*;
import static com.epam.programsportalautomation.constants.ExcelPaths.EXCEL_PATH;
import static com.epam.programsportalautomation.constants.ExcelPaths.COLLEGE_DETAILS_EXCELSHEET;


public class CollegePage {
    private WebDriver driver;

    @FindBy(xpath = ADD_COLLEGE)
    WebElement addcollege;
    @FindBy(xpath = SEARCH)
    WebElement search;
    @FindBy(xpath = EDIT)
    WebElement edit;
    @FindBy(xpath = GET_STRING)
    WebElement getstring;

    public CollegePage(WebDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    ExcelDataProvider excelsheet = new ExcelDataProvider(EXCEL_PATH, COLLEGE_DETAILS_EXCELSHEET);

    public EnterAndEditCollegeDetails clickOnAddCollege() throws IOException, InterruptedException {

//        Thread.sleep(5000);
//        WebDriverWait wait = new WebDriverWait(driver,10);
//        wait.ignoring(NoSuchElementException.class).until(ExpectedConditions.elementToBeClickable(addcollege));
        addcollege.click();
        return new EnterAndEditCollegeDetails(driver);
    }



    public CollegePage searchCollege() throws InterruptedException, IOException {
        search.sendKeys(excelsheet.getCellDataOfCollegeCredentials(1,4));
        Thread.sleep(3000);
        return new CollegePage(driver);
    }

    public EnterAndEditCollegeDetails editCollege() throws IOException, InterruptedException {
        edit.click();
        Thread.sleep(3000);
        return new EnterAndEditCollegeDetails(driver);
    }
    public EnterAndEditCollegeDetails searchAndEditCollege() throws IOException, InterruptedException {
        searchCollege().editCollege();
        return new EnterAndEditCollegeDetails(driver);
    }


    public CollegePage validateCollege(String searcheditedclg) throws IOException, InterruptedException {
        search.sendKeys(searcheditedclg);
        Thread.sleep(3000);
        return new CollegePage(driver);
    }

    public String getEditedCollege() throws InterruptedException {
        Thread.sleep(3000);
        return  getstring.getText();
    }
    public CollegePage seachingAddedCollege(String mail) throws InterruptedException, IOException {
        search.sendKeys(mail);
        Thread.sleep(3000);
        return new CollegePage(driver);
    }
    public CollegePage clearSearchColumn() throws IOException {
        search.clear();
        return new CollegePage(driver);
    }
}
