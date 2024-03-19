package pageObjects;

import org.openqa.selenium.WebDriver;

import utilities.GeneralUtilities;

public class FactoryManager {
public LandingPage landingPage;
public OffersPage offersPage;
public GeneralUtilities generalUtilities;
public CheckoutPage checkoutPage;
public WebDriver driver;

public FactoryManager(WebDriver driver) {
	this.driver = driver;
}

public LandingPage getLandingPageObject()
{
	landingPage = new LandingPage(driver);
	return landingPage;
	
}
public OffersPage getOffersPageObject()
{
	offersPage= new OffersPage(driver);
	return offersPage;
	
}
public GeneralUtilities getGeneralUtilitiesObject()
{
	generalUtilities= new GeneralUtilities(driver);
	return generalUtilities;
	
}
public CheckoutPage getCheckoutObject()
{
	checkoutPage = new CheckoutPage(driver);
	return checkoutPage;
	
}
}
