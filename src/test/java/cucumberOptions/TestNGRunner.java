package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features",glue="stepDefinitions" ,monochrome=true,
plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","rerun:target/failedscenarios.txt"})
public class TestNGRunner extends AbstractTestNGCucumberTests {
	
	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios()
	{
		return super.scenarios();
	}

}
