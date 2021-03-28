package Com.Test.KarthickSrinivasan.testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/main/resources",
		glue={"Com.Test.KarthickSrinivasan.stepDefinitions"},
		plugin= {"html:testOutput.html","json:testOutput.json"},
		dryRun=false
		) 
public class TestRunner {

}
