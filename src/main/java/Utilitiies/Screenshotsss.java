package Utilitiies;

import Basepackage.WebdriverManagera;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screenshotsss {

        public WebDriver driver;

        public Screenshotsss() {
            this.driver = WebdriverManagera.tldriver.get();

        }

        public void Takescreenhot(String filename) throws IOException {
            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        String screenshotBase64 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
            FileUtils.copyFile(file, new File(new File(System.getProperty("user.dir")+"src\\test\\Screenshots\\") + filename + ".jpg"));


        }

        public String takescreenhostbase64() {
            driver = WebdriverManagera.tldriver.get();
            String ss = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
            return ss;
        }

        public byte[] TakescreenshotInBytes() {
            driver = WebdriverManagera.tldriver.get();
            byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            return screenshotBytes;
        }

        // Call the TakescreenshotInBytes method and store the screenshot at a local path
        public void saveScreenshotToFile(String filename) throws IOException {
            byte[] screenshotBytes = TakescreenshotInBytes();
            File screenshotFile = new File("C:\\Users\\891172\\IdeaProjects\\FrameworkUnderstanding\\src\\test\\Screenshots\\" + filename + ".jpg");
            FileUtils.writeByteArrayToFile(screenshotFile, screenshotBytes);
        }
}
