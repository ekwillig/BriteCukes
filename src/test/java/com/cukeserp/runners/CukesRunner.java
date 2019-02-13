package com.cukeserp.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith ( Cucumber.class )
@CucumberOptions (
        plugin = {
                "json:target/cucumber.json" ,
                "html:target/cucumber/" ,
                "rerun:target/rerun.txt"},
        features = "src/test/resources/features",
        glue = "com.cukeserp.step_definitions"
        ,dryRun = false
        ,tags = "@login"

)
public class CukesRunner {
}
