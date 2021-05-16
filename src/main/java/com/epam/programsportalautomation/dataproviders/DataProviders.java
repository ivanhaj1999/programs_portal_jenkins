package com.epam.programsportalautomation.dataproviders;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "EditCollegeMail")
    public Object[][] enterChangedMail() {
        return new Object[][]{
                {"wisely@ron.com"}
        };
    }
}
