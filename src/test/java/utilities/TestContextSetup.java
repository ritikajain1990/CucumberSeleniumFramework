package utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.FactoryManager;


public class TestContextSetup {

	public WebDriver driver;
	public String actualProduct;
	public FactoryManager factoryManager;
	public TestBase testBase;

	public TestContextSetup() throws IOException {
		testBase = new TestBase();
		factoryManager = new FactoryManager(testBase.WebdriverManager());
		
	}
}
