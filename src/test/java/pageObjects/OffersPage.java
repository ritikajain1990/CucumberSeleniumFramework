package pageObjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {

	WebDriver driver ;
	By searchBox = By.xpath("//input[@id='search-field']");
	By searchedProduct = By.xpath("//table[@class='table table-bordered']//tbody//tr//td");
	public OffersPage(WebDriver driver) {
		this.driver=driver;
	}
	

	public void searchProduct(String product)
	{
	driver.findElement(searchBox).sendKeys(product);;
	}
	public String getProduct()
	{
	return driver.findElement(searchedProduct).getText();
	
	}
}
