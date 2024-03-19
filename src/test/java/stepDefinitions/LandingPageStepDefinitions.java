package stepDefinitions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utilities.TestContextSetup;

public class LandingPageStepDefinitions {
	TestContextSetup testContextSetUp;
	LandingPage landingPage;

	public LandingPageStepDefinitions(TestContextSetup testContextSetUp) {
		this.testContextSetUp = testContextSetUp;
		 this.landingPage = testContextSetUp.factoryManager.getLandingPageObject();
	}

	@Given("user is on GreeCart application")
	public void user_is_on_gree_cart_application() {
	

	}

	@Given("^user search product (.+) short name$")
	public void user_search_product_short_name(String product) throws InterruptedException {

		
		System.out.println(landingPage);
		landingPage.searchProduct(product);
		Thread.sleep(1000);
		testContextSetUp.actualProduct = landingPage.getProduct()
				.split("-")[0].trim();
		// System.out.println(actualProduct);
		landingPage.clickOffersLink();

	}

@Given("^user search product (.+) to add to cart$")
public void user_search_product_tom_to_add_to_cart(String product) throws InterruptedException {
	
	landingPage.searchProduct(product);
	Thread.sleep(1000);
	testContextSetUp.actualProduct = landingPage.getProduct();
}
@When("user add {int} product to the cart")
public void user_add_product_to_the_cart(Integer value) throws InterruptedException {

	landingPage.addToCart(value);
	
}

}
