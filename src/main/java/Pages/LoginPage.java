package Pages;

import Basepackage.WebdriverManagera;
import Reporting.Reporterr;
import Utilitiies.Screenshotsss;
import Utilitiies.baseUIAction;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class LoginPage {

        private static baseUIAction baseuiacton;
        public static WebDriver Driver;
        private static Screenshotsss SC;

        public LoginPage() {
            this.Driver = WebdriverManagera.tldriver.get();
            baseuiacton = new baseUIAction();
            SC = new Screenshotsss();
            PageFactory.initElements(Driver, this);
        }

        @FindBy(how = How.XPATH, using = "(//*[text()='Selenium Training'])[1]")
        public static WebElement training;
        @FindBy(how = How.XPATH, using = "//*[text()='Go To Registration ']")
        public static WebElement registration;
        @FindBy(how = How.XPATH, using = "(//a[text()='Demo Site'])[1]")
        public static WebElement demositelink;
        @FindBy(how = How.XPATH, using = "//*[text()='Alerts, Frame & Windows']")
        public static WebElement AlertfraneWindow;
        @FindBy(how = How.XPATH, using = "//ul[@class='menu-list']/li[@id='item-0']//span[text()='Browser Windows']")
        public static WebElement panel;
        @FindBy(how = How.XPATH, using = "//*[@id='windowButton']")
        public static WebElement newWindow;
        @FindBy(how = How.XPATH, using = "//*[@id='sampleHeading']")
        public static WebElement textfromsnewwindow;
        @FindBy(how = How.XPATH, using = "//*[text()='Why Selenium certification?']")
        public static WebElement whycertification;
        @FindBy(how = How.XPATH, using = "(//*[text()='Alerts'])[1]")
        public static WebElement alertpanel;
        @FindBy(how = How.XPATH, using = "//*[@id='confirmButton']")
        public static WebElement clickmealertconfirmationbutton;
        @FindBy(how = How.XPATH, using = "//*[@id='promtButton']")
        public static WebElement propmptbutton;
        @FindBy(how = How.XPATH, using = "//*[text()='Elements']")
        public static WebElement Elements;
        @FindBy(how = How.XPATH, using = "(//*[text()='Upload and Download'])[1]")
        public static WebElement UploadnDownload;
        @FindBy(how = How.XPATH, using = "//*[@id='uploadFile']")
        public static WebElement upload;
        @FindBy(how = How.XPATH, using = "//*[@id='uploadFie']")
        public static WebElement wrongxpath;


        public static void GoforRegistration() throws InterruptedException {
            baseuiacton.click(training);
            baseuiacton.jseClick(registration);
            baseuiacton.scrolltoElement(whycertification);
            Reporterr.attacScreenshotbase64("Registration sucesss");
            baseuiacton.scrollToTopofScreen();
            Reporterr.reportEeventPass("Go For Registration passed");
            Reporterr.attacScreenshotbase64("Registration sucess");


        }

        public static void visitDemosite(String name) {
            if(name.equals("wrong")){
                baseuiacton.click(wrongxpath);
            }
//        baseuiacton.click(demositelink);
            baseuiacton.jseClick(demositelink);
            String parentwindow = baseuiacton.driver.getWindowHandle();
            Set<String> childwindow = baseuiacton.driver.getWindowHandles();

            for (String window : childwindow) {
                if (!childwindow.equals(parentwindow)) {
                    baseuiacton.driver.switchTo().window(window);
                }
            }
            baseuiacton.click(AlertfraneWindow);
            Reporterr.reportEeventPass("Visit demo passed");
            Reporterr.attacScreenshotbase64("inside demo site");
//        baseuiacton.driver.close();
//        baseuiacton.driver.switchTo().window(parentwindow);
        }

        public static void ExperimentwithAlertWindow() throws InterruptedException {
            baseuiacton.click(Elements);
            baseuiacton.click(UploadnDownload);

//            upload.sendKeys("C:\\Users\\891172\\Downloads\\891172_11-11-2024_8-15-14.pdf");
//            Thread.sleep(10000);


        }

        public static void InfiniteScroll() throws InterruptedException {
            JavascriptExecutor js = (JavascriptExecutor) baseuiacton.driver;
            long lastHeight = (long) js.executeScript("return document.body.scrollHeight");

            while (true) {
                js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
                Thread.sleep(3003);
                long newHeight = (long) js.executeScript("return document.scrollHeight");
                if (newHeight == lastHeight) {
                    break;
                }
                lastHeight = newHeight;
            }


        }

        public static void endsession() {
//        baseuiacton.driver.navigate().to("localhost:63342/FrameworkUnderstanding/target/test-output/SparkReport/MySparkReport.html");
//        baseuiacton.click(title);
//        Driver.quit();
        }
}
