package Utilitiies;

import Basepackage.WebdriverManagera;
import Reporting.Reporterr;
import org.openqa.selenium.WebDriver;
import org.testng.*;

public class CustomizeListeners extends TestListenerAdapter implements ITestListener, IReporter, IExecutionListener {


    private Screenshotsss SC;
    public WebDriver driver;

    public CustomizeListeners() {
        this.driver = WebdriverManagera.tldriver.get();
        SC = new Screenshotsss();
    }

    public void onTestStart(ITestResult result) {


    }

    public void onTestSuccess(ITestResult result) {
// Screensot as file
//        Reporter.extenttest.addScreenCaptureFromPath("C:\\Users\\891172\\IdeaProjects\\FrameworkUnderstanding\\src\\test\\Screenshots");

//        Screenshot as base64 format
        Reporterr.extenttest.addScreenCaptureFromBase64String(SC.takescreenhostbase64());
//        ITestContext tc = null;
//        tc = result.getTestContext();
//
//        System.out.println("Number of passed TCs are ----"+tc.getPassedTests().size());
//        System.out.println("Number of failed TCs are ----"+tc.getFailedTests().size());


        Reporterr.reportLog("<b>"+"Test successfully completed"+"<b>");

    }

    public void onTestFailure(ITestResult result) {

//        Reporter.extenttest.addScreenCaptureFromPath("C:\\Users\\891172\\IdeaProjects\\FrameworkUnderstanding\\src\\test\\Screenshots");
        Reporterr.extenttest.addScreenCaptureFromBase64String(SC.takescreenhostbase64());
//        Reporter.attacScreenshotbase64("Test Failed");

    }

    public void onTestSkipped(ITestResult result) {
        Reporterr.reportEeventSkipped("Script skiped");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onTestFailedWithTimeout(ITestResult result) {

    }

    public void onStart(ITestContext context) {

    }

    public void onFinish(ITestContext context) {
//       Reporter.reportLog("Test case passed successfully");
    }

    public void onExecutionStart() {

    }

    public void onExecutionFinish() {

    }
}
