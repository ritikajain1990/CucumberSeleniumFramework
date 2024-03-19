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
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.OffersPage;
import utilities.GeneralUtilities;
import utilities.TestContextSetup;

public class OffersPageStepDefinitions {

	TestContextSetup testContextSetUp;

	public OffersPageStepDefinitions(TestContextSetup testContextSetUp) {
		this.testContextSetUp = testContextSetUp;
	}

	@Then("^user search the same product (.+) on offers page and check product exist$")
	public void user_search_the_same_product_on_offers_page_and_check_product_exist(String product)
			throws InterruptedException {

		GeneralUtilities generalUtilities= testContextSetUp.factoryManager.getGeneralUtilitiesObject();
		generalUtilities.switchToWindow();
		OffersPage offersPage=testContextSetUp.factoryManager.getOffersPageObject();
		offersPage.searchProduct(product);
		Thread.sleep(1000);
		String offerProduct = offersPage.getProduct().trim();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(testContextSetUp.actualProduct, offerProduct);
		sa.assertAll();
		
	}
}
