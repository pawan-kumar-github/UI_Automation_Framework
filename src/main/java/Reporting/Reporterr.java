package Reporting;


import Basepackage.WebdriverManagera;

import Utilitiies.Screenshotsss;
import Utilitiies.TestConfig;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.net.InetAddress;
public class Reporterr {



        public static WebDriver driver;
        public static ExtentTest extenttest;
        private static ExtentReports extentreport;
        private static ExtentSparkReporter sparkreporter;

        private static TestConfig config = new TestConfig();
        public static Screenshotsss SS;

        public Reporterr() {
            Reporterr.driver = WebdriverManagera.tldriver.get();
            SS = new Screenshotsss();

        }

        public static void attachreport() throws IOException {


            //        -Spark report -
            extentreport = new ExtentReports();
            sparkreporter = new ExtentSparkReporter("target/test-output/SparkReport/MySparkReport.html");
            extentreport.attachReporter(sparkreporter);
            ReportConfiguration();

//         Html report-
            String filePath = "target/test-output/ExtentHtml-report/ExtenthtmlReport.html";
            ExtentHtmlReporter htmlreporter= new ExtentHtmlReporter(filePath);
            extentreport.attachReporter(htmlreporter);

            //        Klov report (Not in use now)
//        ExtentKlovReporter klov = new ExtentKlovReporter("FrameworkUnderstanding").initWithDefaultSettings();
//        extentreport.attachReporter(klov);


        }

        public static void CreateTest(String testname, Scenario sc) throws IOException, ClassNotFoundException {
            String Devicename = InetAddress.getLocalHost().getHostName();
            extenttest = extentreport.createTest(testname).createNode(sc.getName()).assignDevice(Devicename).assignCategory(sc.getSourceTagNames().toString());
            extenttest.assignAuthor(config.Property().getProperty("ExecutionBy"));
            //----=--------------------gerkins------------------------
        }

        public static void ReportConfiguration() throws IOException {
            extentreport.setSystemInfo("Browser", config.Property().getProperty("browser"));
            extentreport.setSystemInfo("Operating System", System.getProperty("os.name"));
            extentreport.setSystemInfo("Env", config.Property().getProperty("ExecutionEnv"));
            extentreport.setSystemInfo("Execution start time", extentreport.getReport().getStartTime().toString());
            extentreport.setSystemInfo("Execution end time", extentreport.getReport().getEndTime().toString());
        }

        public static void reportLog(String lognamr) {
            extenttest.log(Status.INFO, lognamr);

        }

        public static void reportEeventPass(String msg) {
            extenttest.log(Status.PASS, "<b>" + msg + "</b>");
        }

        public static void reportEeventFail(String msg) {
            extenttest.log(Status.FAIL, msg);
        }

        public static void reportEeventWarning(String msg) {
            extenttest.log(Status.WARNING, msg);
        }

        public static void reportEeventSkipped(String msg) {
            extenttest.log(Status.SKIP, msg);
        }

        public static void Flush() {
            extentreport.flush();
        }


        public static void attacScreenshotbase64(String SSName) {
            extenttest.log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromBase64String(SS.takescreenhostbase64(), SSName).build());
        }

        public static void attachScreensotfromfomlocation(String SSName) throws IOException {
            String path = config.Property().getProperty("ScreenshotPath");
//       ToDo
//       Reporter.extenttest.log(Status.INFO,SC.Takescreenhot(SSName),MediaEntityBuilder.createScreenCaptureFromPath(path).build()) ;

        }

        public static void SendEmail(){

//        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

            // Generate your report and save it to a file
//        String reportPath = "path/to/report.html";

            // Send the email with the report
//            EmailUtil.sendEmail("kumarpk98pawansah@gmail.com", "Test Report", "Please find the attached test report.");
        }

    }
