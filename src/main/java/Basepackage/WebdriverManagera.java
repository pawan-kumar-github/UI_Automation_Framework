package Basepackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import java.io.IOException;


import Utilitiies.TestConfig;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


    public class WebdriverManagera {

        private static WebDriver driver;
        public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();
        private static TestConfig config = new TestConfig();


        public static void SetupDriver() throws IOException {
            String broswer = config.Property().getProperty("browser");
            if (broswer.equalsIgnoreCase("Chrome")) {
                RuninLocal();
//            RuninGrid();
            }
            if (broswer.equalsIgnoreCase("Edge")) {
                WebDriverManager.edgedriver().setup();
//            ChromeOptions opt= new ChromeOptions();
//            opt.addArguments("--headless=new");
                driver = new EdgeDriver();
                System.out.println("Inside Before Suite");
            }


            driver.get(config.Property().getProperty("url"));
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
//        driver.switchTo().newWindow(WindowType.TAB);
//        driver.navigate().to("https://www.google.com/");
            tldriver.set(driver);


        }


        public static void Quitme() {
            tldriver.get().quit();
            System.out.println("Inside after suit");

//        fw.until(ExpectedConditions.visibilityOf(WebElement ele);


        }

        public static void RuninGrid() throws MalformedURLException {
            ChromeOptions opt = new ChromeOptions();

            opt.setCapability("browserVersion", "125");
            opt.setCapability("platformName", "Windows 11");
            driver = new RemoteWebDriver(new URL("http://192.168.0.114:4444/wd/hub"), opt);
        }

        public static void RuninLocal() {
            WebDriverManager.chromedriver().setup();
            ChromeOptions opt = new ChromeOptions();
            opt.addArguments("--start-maximized");
//            opt.addArguments("--headless=new");
            driver = new ChromeDriver(opt);
            System.out.println("Driver started successfully");
        }
}
