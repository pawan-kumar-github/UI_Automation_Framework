package StepDef;

import Basepackage.WebdriverManagera;
import Pages.LoginPage;
import Reporting.Reporterr;
import Utilitiies.Screenshotsss;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

public class LoginStep {

    public static WebDriver driver;
    public LoginPage loginpage;
    private Screenshotsss SC;
    private Reporterr reporter;

    public LoginStep() {
        driver = WebdriverManagera.tldriver.get();
        loginpage = new LoginPage();
        SC = new Screenshotsss();
        reporter = new Reporterr();
    }


    @Then("End the session and show report")
    public void End_the_session() throws InterruptedException {
//        loginpage.endsession();


    }

    @Given("Navigate to google {string}")
    public void navigateToGoogle(String arg0) throws IOException, IOException {
        System.out.println("Inside this_is_the_given_line_fef");
        if (arg0.equals("wrong")) {
            Reporterr.reportEeventFail("Naviation failed");
//            Assert.fail();
            Assert.assertTrue(false);
        }

        Reporterr.extenttest.addScreenCaptureFromBase64String(SC.takescreenhostbase64());

        Reporterr.extenttest.log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromBase64String(SC.takescreenhostbase64(), "User navigated to google page").build());
        Reporterr.reportEeventPass("User navigated to oogle page");
        Reporterr.attacScreenshotbase64("User naviated to google page");
        Reporterr.attachScreensotfromfomlocation("ScreenshotsScreenshot on failure");
    }


    @Given("Navigate to ToolsQA home page and gofor registration")
    public void navigateToToolsQAHomePageAndGoforRegistration() throws InterruptedException {
        LoginPage.GoforRegistration();

    }

    @When("Visit Demo site {string}")
    public void visitDemoSite(String name) {
        LoginPage.visitDemosite(name);
    }

    @And("Do experiment with Alert Window")
    public void doExperimentWithAlertWindow() throws InterruptedException {
        LoginPage.ExperimentwithAlertWindow();
    }

}


