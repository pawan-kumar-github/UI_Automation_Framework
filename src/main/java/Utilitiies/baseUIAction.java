package Utilitiies;

import Basepackage.WebdriverManagera;
import Reporting.Reporterr;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;


import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.Set;


    public class baseUIAction {
        public WebDriver driver;
        public WebDriverWait wait;
        private Actions act;

        public baseUIAction() {
            this.driver = WebdriverManagera.tldriver.get();
            act=new Actions(this.driver);
        }

        public void click(WebElement ele) {
            Waitforclicable(ele);
            HilightElement(ele);
            UnHilightElement(ele);
            ele.click();
            String xpath=CollectXpathtoShowinReport(ele);
            Reporterr.extenttest.log(Status.INFO, "Clicked on " + xpath);
        }
        public void sendKeys(WebElement ele){
            ele.sendKeys();
        }


        synchronized public final void Waitforclicable(WebElement ele) {
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(ele));
        }

        public final void scrolltoElement(WebElement ele) throws InterruptedException {
            act = new Actions(driver);
            act.scrollToElement(ele).build().perform();
        }

        public final void swithctoWindow(String windowtitle) {
            String parent = driver.getWindowHandle();
            Set<String> childwindows = driver.getWindowHandles();

            for (String windows : childwindows) {
                String title = driver.getTitle();
                System.out.println(title);
                if (title.equalsIgnoreCase(windowtitle)) {
                    if (!childwindows.equals(parent)) {
                        driver.switchTo().window(windows);
                    }
                }
            }
        }

        public final void jseClick(WebElement ele) {
            JavascriptExecutor js = ((JavascriptExecutor) driver);
            HilightElement(ele);
            UnHilightElement(ele);
            js.executeScript("arguments[0].click();", ele);
            String xpath=CollectXpathtoShowinReport(ele);
            Reporterr.extenttest.log(Status.INFO, "Clicked on " + xpath);
        }

        public final void scrollToTopofScreen() {
            JavascriptExecutor js = ((JavascriptExecutor) driver);
            js.executeScript("window.scrollTo(0,0)");

        }

        public final void HilightElement(WebElement ele) {
            JavascriptExecutor js = ((JavascriptExecutor) driver);
            js.executeScript("arguments[0].style.border='5px solid red'", ele);
        }

        public final void UnHilightElement(WebElement ele) {
            JavascriptExecutor js = ((JavascriptExecutor) driver);
            js.executeScript("arguments[0].style.border='5px solid white'", ele);
        }

        public final String CollectXpathtoShowinReport(WebElement ele) {
            String[] eleArr =ele.toString().split("xpath:");
            System.out.println(eleArr);
            return  eleArr[1];
        }

        public final void ScrolltoMiddle(WebElement ele){
            act.scrollToElement(ele);

        }
}
