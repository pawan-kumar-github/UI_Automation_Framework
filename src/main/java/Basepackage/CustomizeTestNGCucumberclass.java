package Basepackage;

import Hooks.Hook;
import Reporting.Reporterr;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.*;

import java.io.IOException;

public class CustomizeTestNGCucumberclass extends AbstractTestNGCucumberTests {

    private TestNGCucumberRunner testNGCucumberRunner;
    private Hook hook = new Hook();

    public CustomizeTestNGCucumberclass() {
    }

    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws IOException {

        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
        System.out.println("Inside Before class");
        Reporterr.attachreport();

    }

    @BeforeTest
    public void BeforeTest() {
        System.out.println("Inside Before test");

    }



    @BeforeMethod
    public void Beforemethod() {
        System.out.println("Inside Before method");
    }

    @BeforeSuite
    public void beforesuit() throws ClassNotFoundException, IOException {
        System.out.println("before suit");

        WebdriverManagera.SetupDriver();

    }


    @Test(groups = {"cucumber"}, description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
    public void runScenario(PickleWrapper picklewrapper, FeatureWrapper featurewrap) {
        testNGCucumberRunner.runScenario(picklewrapper.getPickle());
        System.out.println("This is Test");


    }

    @DataProvider
    public Object[][] scenarios() {
        return this.testNGCucumberRunner == null ? new Object[0][0] : this.testNGCucumberRunner.provideScenarios();

    }

    //
    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        if (this.testNGCucumberRunner != null) {
            this.testNGCucumberRunner.finish();
            System.out.println("Inside after  class");

        }
        Reporterr.Flush();
        WebdriverManagera.Quitme();
        System.out.println("===================Test Result Summary=================");
        int executedscenario= Hook.Failcount + Hook.PassCount;
        System.out.println("Scenario Executed : " + executedscenario);
        System.out.println("Scenario Passed : " + Hook.PassCount + " | failed :" + Hook.Failcount);
        long executiontime = Hook.testendtime - Hook.teststarttime;
//        System.out.println(STR."Time Elapsed in execution :\{TimeUnit.MILLISECONDS.toSeconds(executiontime)}");
        System.out.println("===================Test Result Summary=================");
//        Reporter.SendEmail();

    }

    @AfterSuite(alwaysRun = true)
    public void aftersuite() {

        System.out.println("After suit");
        WebdriverManagera.Quitme();

    }

    @AfterMethod
    public void AfterMethid() {
        System.out.println("Inside after method");

    }

    @AfterTest
    public void AfterTest() {
        System.out.println("Inside after Test");

    }

}
