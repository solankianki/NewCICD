package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features="src/test/java/cucumber", 
					glue="ankitsolanki.stepDefinitations",
			  monochrome= true,
			  tags = "@ErrorValidations",
			  plugin="html:target/cucumber.html")
public class TestNGtestRunner extends AbstractTestNGCucumberTests {
	
}
