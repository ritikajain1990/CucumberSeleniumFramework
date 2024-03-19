package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	By searchBox = By.xpath("//input[@type='search']");
	By searchedProduct = By.cssSelector("h4.product-name");
	By topDealLink = By.linkText("Top Deals");
    By addToCart = By.xpath("//div[@class='product']//button");
    By increment = By.xpath("//div[@class='product']//div[@class='stepper-input']//a[@class='increment']");
    By cart= By.cssSelector("a.cart-icon");
    By checkoutButton = By.xpath("//button[text()='PROCEED TO CHECKOUT']");
    

	public void searchProduct(String product) {
		System.out.println(driver);
		driver.findElement(searchBox).sendKeys(product);
	}

	public String getProduct() {
	
		String retrivedProduct = driver.findElement(searchedProduct).getText();
		return retrivedProduct;

	}

	public void clickOffersLink() {
		driver.findElement(topDealLink).click();
	}
	
	public void addToCart(int value) throws InterruptedException
	{
		for(int i=1;i<value;i++)
		{
		driver.findElement(increment).click();
		}
		driver.findElement(addToCart).click();
		Thread.sleep(1000);
		driver.findElement(cart).click();
		driver.findElement(checkoutButton).click();
	
	}
	
}
