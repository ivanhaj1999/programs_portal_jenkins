//package com.epam.programsportalautomation.framework.listeners;
//
//import com.epam.programsportalautomation.framework.DriverInit;
//import com.epam.programsportalautomation.framework.logs.LogUtilityFunctions;
//import com.epam.programsportalautomation.framework.screenshot.ScreenShotTaker;
//import com.epam.programsportalautomation.web.pages.SignUpPage;
//import org.openqa.selenium.WebDriver;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//
//public class ListenersTest  implements ITestListener {
//
//
//    public ListenersTest() throws Exception {
//
//    }
//
//
//
//    @Override
//        public void onTestStart(ITestResult result) {
//
//        }
//
//        @Override
//        public void onTestSuccess(ITestResult result) {
//            LogUtilityFunctions.logInfoMessage(result.getName());
//            ScreenShotTaker.takeScreenshot(driver,result.getName());
//        }
//
//        @Override
//        public void onTestFailure(ITestResult result) {
//            LogUtilityFunctions.logInfoMessage(result.getName());
//
//
//
//        }
//
//        @Override
//        public void onTestSkipped(ITestResult result) {
//            LogUtilityFunctions.logInfoMessage(result.getName());
//        }
//}
