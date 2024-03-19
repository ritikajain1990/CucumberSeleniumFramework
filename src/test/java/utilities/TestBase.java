package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	public WebDriver driver;

	public WebDriver WebdriverManager() throws IOException {
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//test//resources//Global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String propertyBorwser = prop.getProperty("browser");
		String mavenBrowser = System.getProperty("browser");
		String browser = mavenBrowser != null ? mavenBrowser : propertyBorwser;

		if (driver == null) {
			if (browser.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
				driver.get(prop.getProperty("QAUrl"));
				driver.manage().window().maximize();
			}
			if (browser.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
				driver.get(prop.getProperty("QAUrl"));
				driver.manage().window().maximize();
			}
		}
		return driver;
	}
}
