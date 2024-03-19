package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="@target/failedscenarios.txt",glue="stepDefinitions" ,monochrome=true,
plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class FailedTestNGRunner extends AbstractTestNGCucumberTests {
	
	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios()
	{
		return super.scenarios();
	}

}
