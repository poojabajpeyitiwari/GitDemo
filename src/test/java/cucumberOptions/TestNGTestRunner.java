package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features",glue="stepDefinitions",monochrome=true, tags="@PlaceOrder or @OffersPage",
plugin= {"html:target/cucumber.html", "json:target/json.html", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"rerun:target/failed_scenarios.txt"}) //dryRun=true //tags="@PlaceOrder"
public class TestNGTestRunner extends AbstractTestNGCucumberTests{
	
	  @Override
	  
	  @DataProvider(parallel=true) public Object[][] scenarios() { return
	  super.scenarios(); }
	 
}
