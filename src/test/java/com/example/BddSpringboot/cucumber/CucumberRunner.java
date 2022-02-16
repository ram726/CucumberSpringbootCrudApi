package com.example.BddSpringboot.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "D:/WorkSpaces/Learning/BDD/BddSpringboot/src/test/resources/features",
        plugin = {"pretty", "html:src/test/report/cucumber.html"},
        dryRun = false
//        tags = "@Create2"
//        name={"Addition"}
)
public class CucumberRunner {
}
