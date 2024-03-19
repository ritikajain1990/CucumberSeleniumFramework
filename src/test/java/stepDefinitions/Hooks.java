package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utilities.TestContextSetup;

public class Hooks {
	public WebDriver driver;
public TestContextSetup testContextSetup;
	public Hooks(TestContextSetup testContextSetup) {
		this.testContextSetup=testContextSetup;
	}
	
	@After
	public void tearDown() throws IOException
	{
		testContextSetup.testBase.WebdriverManager().quit();
	}
	@AfterStep
	public void afterTestStep(Scenario scenario) throws IOException {
		if(scenario.isFailed())
		{
			driver=testContextSetup.testBase.WebdriverManager();
			
			TakesScreenshot ts = (TakesScreenshot)driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			byte[] readFile=FileUtils.readFileToByteArray(src);
			scenario.attach(readFile, "image/png", "image");
			
		}
	}
}
