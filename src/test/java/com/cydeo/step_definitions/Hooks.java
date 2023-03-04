package com.cydeo.step_definitions;
/*
In this class will we be able to pass pre & post conditions
to each scenario and each step
 */

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    // import from io.cucumber.java
    //@Before(order = 1)
    public void setupScenario() {
        System.out.println("===Setting up browser using cucumber @Before===");
    }

    //@Before(value = "@Login", order = 2)
    public void setupScenarioForLogins() {
        System.out.println("===this will apply only to scenarios with @Login tag===");
    }

    //@Before(value = "@db", order = 0)
    public void setupForDataBaseScenarios() {
        System.out.println("===this will apply only to scenarios with @db tag===");
    }

    @After
    public void teardownScenario(Scenario scenario){

        //scenario.isFailed() --> if scenario fails this method will return TRUE boolean value


        if (scenario.isFailed()){

            byte [] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        Driver.closeDriver();

        //System.out.println("====Closing browser using cucumber @After");
        //System.out.println("====Scenario ended/ Take screenshot if failed!");
    }

   // @BeforeStep
    //public void setupStep() {
       // System.out.println("======Applying setup using @BeforeStep======");
    //}

    //@AfterStep
    public void afterStep() {
        System.out.println("========>applying tearDown using @AfterStep<==========");
    }
}
