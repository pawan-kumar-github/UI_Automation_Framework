package Hooks;

import Reporting.Reporterr;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.IOException;

public class Hook { 
    //    private final List<PickleStepTestStep> testsetp;
public static int PassCount;
public static int Failcount;
public static long teststarttime;
public static long testendtime;


@Before
public void IntiateTest(Scenario scenario) throws IOException, ClassNotFoundException {
    System.out.println("Inside Before tag");
    System.out.println("+++++=====Test Scenario Execution begins+++========");
//    System.out.println(STR."Scenario name : \{scenario.getName()}");

    Reporterr.CreateTest(scenario.getName(), scenario);
//        Reporter.CreateTesthtml(scenario.getName(), scenario);

    teststarttime = System.currentTimeMillis();

}

@AfterStep
public void AfterStep(Scenario scenario) {

    System.out.println("Inside after step");


}

@After
public void After(Scenario scenario) {

    if ("PASSED".equalsIgnoreCase(scenario.getStatus().toString())) {
        ++PassCount;
    }
    if ("FAILED".equalsIgnoreCase(scenario.getStatus().toString())) {
        ++Failcount;
    }
    testendtime = System.currentTimeMillis();

}

}

