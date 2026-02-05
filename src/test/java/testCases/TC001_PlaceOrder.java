package testCases;

import org.testng.annotations.Test;

import pageObjects.AccountLogin;
import pageObjects.CartPage;
import pageObjects.CheckoutConfirmationPage;
import pageObjects.GuestCheckOutPage;
import pageObjects.HomePage;
import pageObjects.MakeUpPage;
import testBase.BaseClass;

public class TC001_PlaceOrder extends BaseClass {
	
	@Test
	public void placeOrder() {
		logger.info("Home Page...");
		HomePage hmp = new HomePage(driver);
		hmp.validateHomePageLoad();
		hmp.clickMakeUp();
		
		logger.info("Makeup Page...");
		MakeUpPage mkp = new MakeUpPage(driver);
		mkp.clickTMLRProduct();
		mkp.pdpDisplayed();
		
		logger.info("Tropiques Minerale Loose Bronzer");
		
		mkp.prodctColourChange();
		mkp.updateQuantity("2");
		mkp.addToCart();
		logger.info("Cart Page...");
		CartPage cp = new CartPage(driver);
		cp.productNameValidation();
		cp.quantityValidation();
		//cp.productColourValidation();
		cp.priceValidation();
		cp.clickContinue();
		
		logger.info("Guest Page...");
		AccountLogin guestLogin = new AccountLogin(driver);
		guestLogin.clickGuestCheckout();
		guestLogin.clickContinue();
		
		logger.info("Checkout Page...");
		GuestCheckOutPage gcp = new GuestCheckOutPage(driver);
		gcp.enterFirstName("TestUser");
		gcp.enterLastName("Test");
		gcp.enterEmail("testuser@gmail.com");
		gcp.enterAddress("Address1");
		gcp.enterCity("city");
		gcp.enterCountry("India");
		gcp.selectRegion("Andhra Pradesh");
		gcp.enterZipCode("516130");
		gcp.clickContinue();
		
		CheckoutConfirmationPage ccp = new CheckoutConfirmationPage(driver);
		ccp.getProductName();
		ccp.getTotalPrice();
		ccp.clickConfirmOrder();
		ccp.getSuccessMsg();	
		
	}

}
