package com.epam.programsportalautomation.web.pages;
import com.epam.programsportalautomation.dataproviders.ExcelDataProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

import static com.epam.programsportalautomation.constants.CollegeDetailsElementsByName.*;
import static com.epam.programsportalautomation.constants.ExcelPaths.*;


    public class EnterAndEditCollegeDetails {
        private WebDriver driver;

        @FindBy(name = COLLEGE_NAME)
        WebElement collegename;
        @FindBy(name = COLLEGE_GROUP)
        WebElement collegegroup;
        @FindBy(name = COLLEGE_CITY)
        WebElement collegecity;
        @FindBy(name = COLLEGE_PTO_NAME)
        WebElement collegeptoname;
        @FindBy(name = COLLEGE_PTO_EMAIL)
        WebElement collegeptoemail;
        @FindBy(xpath = SAVE_BUTTON)
        WebElement savebutton;


        public EnterAndEditCollegeDetails(WebDriver driver) throws IOException {
            this.driver = driver;
            PageFactory.initElements(this.driver, this);
        }

        ExcelDataProvider excelsheet = new ExcelDataProvider(EXCEL_PATH, COLLEGE_DETAILS_EXCELSHEET);

        public EnterAndEditCollegeDetails enterCollegeName() throws IOException {
            collegename.sendKeys(excelsheet.getCellDataOfCollegeCredentials(1,0));
            return new EnterAndEditCollegeDetails(driver);
        }
        public EnterAndEditCollegeDetails enterCollegeGroup() throws IOException {
            collegegroup.sendKeys(excelsheet.getCellDataOfCollegeCredentials(1,1));
            return new EnterAndEditCollegeDetails(driver);
        }
        public EnterAndEditCollegeDetails enterCollegeCity() throws IOException {
            collegecity.sendKeys(excelsheet.getCellDataOfCollegeCredentials(1,2));
            return new EnterAndEditCollegeDetails(driver);
        }
        public EnterAndEditCollegeDetails enterCollegePtoName() throws IOException {
            collegeptoname.sendKeys(excelsheet.getCellDataOfCollegeCredentials(1,3));
            return new EnterAndEditCollegeDetails(driver);
        }
        public EnterAndEditCollegeDetails enterCollegePtoEmail() throws IOException {
            collegeptoemail.sendKeys(excelsheet.getCellDataOfCollegeCredentials(1,4));
            return new EnterAndEditCollegeDetails(driver);
        }
        public EnterAndEditCollegeDetails enteringCollegeDetails() throws IOException{
            EnterAndEditCollegeDetails enter = new EnterAndEditCollegeDetails(driver).enterCollegeName().enterCollegeGroup().enterCollegeCity().enterCollegePtoName().enterCollegePtoEmail();
            return  enter;
        }
        public EnterAndEditCollegeDetails enterAllCollegeDetails(String name, String group, String city, String ptoname, String ptomail) throws IOException {
            collegename.sendKeys(name);
            collegegroup.sendKeys(group);
            collegecity.sendKeys(city);
            collegeptoname.sendKeys(ptoname);
            collegeptoemail.sendKeys(ptomail);
            return new EnterAndEditCollegeDetails(driver);
        }
        public CollegePage clickSaveButton() throws InterruptedException, IOException {
            savebutton.click();
            Thread.sleep(3000);
            return new CollegePage(driver);
        }

    public EnterAndEditCollegeDetails clearEmailColumn() throws IOException {
       collegeptoemail.clear();
        return new EnterAndEditCollegeDetails(driver);
    }

    public EnterAndEditCollegeDetails changeEmail(String changedMail) throws IOException {
       collegeptoemail.sendKeys(changedMail);
        return new EnterAndEditCollegeDetails(driver);
    }
    public EnterAndEditCollegeDetails enterChangedMail(String changedMail) throws IOException {
            clearEmailColumn().changeEmail(changedMail);
            return new EnterAndEditCollegeDetails(driver);

    }

}
