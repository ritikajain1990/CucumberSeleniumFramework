package stepDefinitions;

import java.io.IOException;

import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckoutPage;
import utilities.GeneralUtilities;
import utilities.TestContextSetup;

public class CheckoutPageStepDefinitions {
	TestContextSetup testContextSetup;
	CheckoutPage checkoutPage;
	 SoftAssert sa ;
	public CheckoutPageStepDefinitions(TestContextSetup testContextSetup) {
		this.testContextSetup=testContextSetup;
		this.checkoutPage = testContextSetup.factoryManager.getCheckoutObject();
	}
	

	@Then("user verify the added product in Checkout Outpage")
	public void user_verify_the_added_product_in_checkout_outpage_and_place_order() throws IOException, InterruptedException {
	    
	    String checkedOutProduct = checkoutPage.verifyCheckout();
	    sa = new SoftAssert();
	    sa.assertEquals(testContextSetup.actualProduct, checkedOutProduct);
	 ;
	    
	}
	@Then("place the order")
	public void place_the_order() throws InterruptedException {
		checkoutPage.placeOrder();
	}
	@When("^user selects (.+) and agree terms$")
	public void user_selects_india_and_agree_terms(String country) {
         
         checkoutPage.selectDropdown(country);
	}
	@Then("verify order is placed successfully")
	public void verify_order_is_placed_successfully() throws InterruptedException {
String message =checkoutPage.verifyOrderPlaced();
sa.assertTrue(message.contains("successfully "));
Thread.sleep(1000);
	}
}
