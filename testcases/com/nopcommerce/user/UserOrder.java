package com.nopcommerce.user;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.user.CartPageObject;
import pageObjects.nopCommerce.user.HomePageObject;
import pageObjects.nopCommerce.user.PageGeneratorManager;
import pageObjects.nopCommerce.user.ProductPageObject;
import pageObjects.nopCommerce.user.RegisterPageObjects;
import utilities.DataHelperFaker;
import utilities.ServerName;

public class UserOrder extends BaseTest{
	WebDriver driver;
	HomePageObject homePage;
	RegisterPageObjects registerPage;
	ProductPageObject productPage;
	CartPageObject cartPage;
	ServerName server;
	DataHelperFaker dataFaker;
	String firstName, lastName, email, password, product;
	float productPrice, totalPriceProduct;
	int productQuantity;
	
	@Parameters({"browser", "serverName", "envName", "ipAddress", "portNumber", "osName", "osVersion"})
	@BeforeClass
	public void beforeClass(@Optional("chrome ")String browserName, @Optional("testing") String serverName, @Optional("local") String envName,
			@Optional("localhost") String ipAddress,@Optional("4444") String portNumber, @Optional("Windows") String osName,@Optional("11") String osVersion) {
		
		log.info("Pre-Condition 01: Open Home page");
		ConfigFactory.setProperty("serverName", serverName);
		server = ConfigFactory.create(ServerName.class);
		driver = getBrowserDriver(browserName, server.appUrl(), envName, ipAddress, portNumber, osName, osVersion);
		
		log.info("Precondition 01 - Step 01: Open home page");
		homePage = PageGeneratorManager.getHomePage(driver);
		
		dataFaker = DataHelperFaker.getData();
		firstName = dataFaker.getFirstName();
		lastName = dataFaker.getLastName();
		email = dataFaker.getEmail();
		password = dataFaker.getPassword();
		product = "Apple MacBook Pro 13-inch";
		productQuantity = 5;
		
		log.info("Precondition 02 - Step 01: Register successfully");
		log.info("Precondition 02 - Step 01: Navigate to Register page");
		registerPage = homePage.clickToRegisterLink();
		
		log.info("Precondition 02 - Step 02: Enter to FirstName textbox with value: " + firstName);
		registerPage.inputTextboxByID(driver, "FirstName", firstName);
		
		log.info("Precondition 02 - Step 03: Enter to LastName textbox with value: " + lastName);
		registerPage.inputTextboxByID(driver, "LastName", lastName);
		
		log.info("Precondition 02 - Step 04: Enter to Email textbox with value: " + email);
		registerPage.inputTextboxByID(driver, "Email", email);
		
		log.info("Precondition 02 - Step 05: Enter to Password textbox with value: " + password);
		registerPage.inputTextboxByID(driver, "Password", password);
		
		log.info("Precondition 02 - Step 06: Enter to Confirm Password textbox with value: " + password);
		registerPage.inputTextboxByID(driver, "ConfirmPassword", password);
		
		log.info("Precondition 02 - Step 07: Click to 'Register' button");
		registerPage.clickRegisterButton();
		
		log.info("Precondition 02 - Step 08: Verify successful register message is displayed");
		Assert.assertEquals(registerPage.getSuccessRegisterMessage(), "Your registration completed");
	}
	
	
	public void Order_01_Add_Product_To_Cart() {
		log.info("Order_01_Add_Product_To_Cart - Step 01: Open Home page");
		homePage.openHomePage();
		
		log.info("Order_01_Add_Product_To_Cart - Step 02: Click to Product link is: " + product);
		productPage = homePage.clickToProductLinkInFeatureByText(product);
		
		log.info("Order_01_Add_Product_To_Cart - Step 03: Click to 'Add to Cart' button");
		cartPage = productPage.clickToAddToCartButton();
		
		log.info("Order_01_Add_Product_To_Cart - Step 04: Verify successful message is displayed.");
		Assert.assertEquals(productPage.getSuccessfulMessageInBarNotification(), "The product has been added to your shopping cart");
		
		log.info("Order_01_Add_Product_To_Cart - Step 05: Click to 'X' icon to close the message.");
		productPage.clickToCloseBarNotificationIcon();
		sleepInSecond(2);
		
		log.info("Order_01_Add_Product_To_Cart - Step 06: Click to 'Shopping Cart' link");
		cartPage = homePage.clickToShoppingCartLink();
		
		log.info("Order_01_Add_Product_To_Cart - Step 07: Verify '" + product + "' is displayed in shopping cart");
		cartPage.isProductNameDisplayedByText(product);
	}
	
	
	public void Order_02_Update_Shopping_Cart() {
		log.info("Order_02_Update_Shopping_Cart - Step 01: Input Quantity textbox with value: " + productQuantity);
		cartPage.inputQuantityTextboxByColumnNameAndRowNumber("Qty.", "1", String.valueOf(productQuantity));
		
		log.info("Order_02_Update_Shopping_Cart - Step 02: Click to Update Shopping Cart button");
		cartPage.clickToButtonByText(driver, "Update shopping cart");
		
		log.info("Order_02_Update_Shopping_Cart - Step 03: Click to 'Shopping Cart' link");
		homePage.clickToShoppingCartLink();
		
		log.info("Order_02_Update_Shopping_Cart - Step 04: Verify subtotal");
		productPrice = cartPage.getPriceByColumnNameAndRowNumber("Price", "1");
		productQuantity = cartPage.getQuantityTextboxAttribute("Qty.", "1", "value");
		totalPriceProduct = cartPage.getPriceByColumnNameAndRowNumber("Total", "1");
		Assert.assertEquals(productPrice * productQuantity, totalPriceProduct);
	}
	
	public void Order_03_Remove_Fromm_Cart() {
		log.info("Order_03_Remove_Fromm_Cart - Step 01: Click to remove icon");
		cartPage.clickToDeleteButtonByColumnNameAndRowNumber("Remove", "1");
		
		log.info("Order_03_Remove_Fromm_Cart - Step 02: Verify empty message is displayed");
		Assert.assertTrue(cartPage.getEmptyWishlistMessage().contains("Your Shopping Cart is empty!"));
		
		log.info("Order_03_Remove_Fromm_Cart - Step 03: Verify '" + product + "' is not displayed in shopping cart");
		Assert.assertTrue(cartPage.isProductNameUndisplayed(product));
	}
	
	@Test
	public void Order_04_Order_Successful_By_Cheque() {
		log.info("Order_04_Order_Successful_By_Cheque - Step 01: Open Home page");
		homePage.openHomePage();
		
		log.info("Order_04_Order_Successful_By_Cheque - Step 02: Click to Product link is: " + product);
		productPage = homePage.clickToProductLinkInFeatureByText(product);
		
		log.info("Order_04_Order_Successful_By_Cheque - Step 03: Click to 'Add to Cart' button");
		cartPage = productPage.clickToAddToCartButton();
		
		log.info("Order_04_Order_Successful_By_Cheque - Step 04: Verify successful message is displayed.");
		Assert.assertEquals(productPage.getSuccessfulMessageInBarNotification(), "The product has been added to your shopping cart");
		
		log.info("Order_04_Order_Successful_By_Cheque - Step 05: Click to 'X' icon to close the message.");
		productPage.clickToCloseBarNotificationIcon();
		sleepInSecond(2);
		
		log.info("Order_04_Order_Successful_By_Cheque - Step 06: Click to 'Shopping Cart' link");
		cartPage = homePage.clickToShoppingCartLink();
		
		log.info("Order_04_Order_Successful_By_Cheque - Step 07: Verify '" + product + "' is displayed in shopping cart");
		cartPage.isProductNameDisplayedByText(product);
		
		log.info("Order_04_Order_Successful_By_Cheque - Step 08: Click to accept the term on service checkbox");
		cartPage.checkTermsOfserviceChecbox();
		
		log.info("Order_04_Order_Successful_By_Cheque - Step 09: Click to Checkout button");
		cartPage.clickToButtonByText(driver, " Checkout ");
		
		log.info("Order_04_Order_Successful_By_Cheque - Step 10: Select country dropdown with: ");
		cartPage.selectDropdownByID(driver, "BillingNewAddress_CountryId", "Viet Nam");
		
		log.info("Order_04_Order_Successful_By_Cheque - Step 11: Select State/province dropdown with: ");
		cartPage.selectDropdownByID(driver, "BillingNewAddress_StateProvinceId", "Other");
		
		log.info("Order_04_Order_Successful_By_Cheque - Step 12: Enter to City textbox with value is: ");
		cartPage.inputTextboxByID(driver, "BillingNewAddress_City", "Da Nang");
		
		log.info("Order_04_Order_Successful_By_Cheque - Step 13: Enter to 'Address 1' textbox withh value is: ");
		cartPage.inputTextboxByID(driver, "BillingNewAddress_Address1", "123 Le Loi");
		
		log.info("Order_04_Order_Successful_By_Cheque - Step 14: Enter to Zip/Postal Code textbox with value: ");
		cartPage.inputTextboxByID(driver, "BillingNewAddress_ZipPostalCode", "12345");
		
		log.info("Order_04_Order_Successful_By_Cheque - Step 15: Enter to Phone Number textbox with value is: ");
		cartPage.inputTextboxByID(driver, "BillingNewAddress_PhoneNumber", "0123123123");
		
		log.info("Order_04_Order_Successful_By_Cheque - Step 16: Click to 'Continue' button");
		cartPage.clickToContinueButtonByIDDiv("billing-buttons-container");
		
		log.info("Order_04_Order_Successful_By_Cheque - Step 17: Check to 'shipping method' radio button");
		cartPage.checkRadioButtonByLabelText("Ground ($0.00)");
		
		log.info("Order_04_Order_Successful_By_Cheque - Step 18: Click to 'Continue' button");
		cartPage.clickToContinueButtonByIDDiv("shipping-method-buttons-container");
		
		log.info("Order_04_Order_Successful_By_Cheque - Step 19: Check to 'Payment method' radio button: Check/Money Order");
		cartPage.checkRadioButtonByLabelText("Check / Money Order");
		
		log.info("Order_04_Order_Successful_By_Cheque - Step 20: Click to 'Continue' button ");
		cartPage.clickToContinueButtonByIDDiv("payment-method-buttons-container");
		
		log.info("Order_04_Order_Successful_By_Cheque - Step 21: Click to 'Continue' button");
		cartPage.clickToContinueButtonByIDDiv("payment-info-buttons-container");
		
		
		log.info("Order_04_Order_Successful_By_Cheque - Step 22: Click to 'Confirm' button");
		cartPage.clickToButtonByText(driver, "Confirm");
	}
	
	@Test
	public void Order_05_Order_Successful_By_Card() {
		
	}
	
	@Test
	public void Order_06_PreOder_Successful() {
		
	}
}
