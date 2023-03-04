package com.cydeo.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                //"pretty",
                "html:target/cucumber-report.html",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber"
        },
        features = "src/test/resources/features",
        glue = "com/cydeo/step_definitions",
        dryRun = false,//turns of the running of step_definitions.
                     // if dryRun = true--> do not run my step_definitions , but
                     // only check if any step is missing snippet
                     // if dryRun = false--> is going to run the whole program
        tags = ""// we have: - "or" option--> have to match at least one scenario name
                       //          - "and" option--> have to match both scenarios names
                       //          - "and not" option--> will exclude one of the scenario
     // publish = true
)


public class CukesRunner {
}
