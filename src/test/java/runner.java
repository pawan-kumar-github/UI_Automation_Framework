import Basepackage.CustomizeTestNGCucumberclass;
import Utilitiies.CustomizeListeners;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Listeners;


@CucumberOptions(
        features = "src/test/java/Feature/Login.feature",
        glue = {"StepDef", "Hooks"},
//        monochrome = true,
//        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "json:target/cucumber-report.json"},
        plugin = {"html:target/cucumber-reports/cucumber-html-report.html", "json:target/cucumber-reports/cucumber.json", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
//      plugin = {"html:target/cucumber-html-report.html","json:target/cucumber-reports/cucumber.json"},
        tags = "@Regression or @Smoke"

//        publish = true
//        dryRun = true

)

@Listeners(CustomizeListeners.class)
public class runner extends CustomizeTestNGCucumberclass {


}