package pageObjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

	By checkedOutProduct = By.xpath("//tbody//tr//td//p[@class='product-name']");
	By applyButton = By.xpath("//button[@class='promoBtn']");
	By placeOrderButton = By.xpath("//button[text()='Place Order']");
	By select =By.xpath("//select");
	By agreeCheckbox = By.xpath("//input[@type='checkbox']");
	By proceedButton = By.xpath("//button[text()='Proceed']");
	By successMessage=By.xpath("//div[@class='wrapperTwo']//span[contains(.,'Thank')]");
	WebDriver driver;
	WebDriverWait wait;
	

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}

	public String verifyCheckout() throws IOException {
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//test//resources//Global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlToBe(prop.getProperty("checkoutURL")));
		return driver.findElement(checkedOutProduct).getText();
	}
	public void placeOrder() throws InterruptedException
	{
		driver.findElement(placeOrderButton).click();
		Thread.sleep(2000);
	}
	public void selectDropdown(String country)
	{
		Select s = new Select(driver.findElement(select));
		s.selectByVisibleText(country);
		driver.findElement(agreeCheckbox).click();
		driver.findElement(proceedButton).click();
		}
	public String verifyOrderPlaced()
	{
		return driver.findElement(successMessage).getText();
		
		
	}
}
