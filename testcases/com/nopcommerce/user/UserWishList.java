package com.nopcommerce.user;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObjects.nopCommerce.user.CartPageObject;
import pageObjects.nopCommerce.user.HomePageObject;
import pageObjects.nopCommerce.user.PageGeneratorManager;
import pageObjects.nopCommerce.user.ProductPageObject;
import pageObjects.nopCommerce.user.RegisterPageObjects;
import pageObjects.nopCommerce.user.WishlistPageObjects;
import utilities.DataHelperFaker;
import utilities.ServerName;

public class UserWishList extends BaseTest{
	WebDriver driver;	
	HomePageObject homePage;
	RegisterPageObjects registerPage;
	ProductPageObject productPage;
	WishlistPageObjects wishlistPage;
	CartPageObject cartPage;
	ServerName server;
	DataHelperFaker dataFaker;
	String firstName, lastName, email, password, productWishlist;

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
		productWishlist = "Apple MacBook Pro 13-inch";
		
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
	
	@Test
	public void TC_01_Add_Product_To_Wishlist_Successful() {
		log.info("TC_01_Add_Product_To_Wishlist_Successful - Step 01: Open Home page");
		homePage.openHomePage();
		
		log.info("TC_01_Add_Product_To_Wishlist_Successful - Step 02: Click to Product link is: " + productWishlist);
		productPage = homePage.clickToProductLinkInFeatureByText(productWishlist);
		
		log.info("TC_01_Add_Product_To_Wishlist_Successful - Step 03: Click to 'Add to Wishlist' button");
		productPage.clickToButtonInProductDetailByClassName("add-to-wishlist");
		
		log.info("TC_01_Add_Product_To_Wishlist_Successful - Step 04: Verify successful message is displayed.");
		Assert.assertEquals(productPage.getSuccessfulMessageInBarNotification(), "The product has been added to your wishlist");
		
		log.info("TC_01_Add_Product_To_Wishlist_Successful - Step 05: Click to 'X' icon to close the message.");
		productPage.clickToCloseBarNotificationIcon();
		sleepInSecond(2);
		
		log.info("TC_01_Add_Product_To_Wishlist_Successful - Step 06: Lick to Wishlist link");
		wishlistPage = homePage.clickToWishlistLink();
		
		log.info("TC_01_Add_Product_To_Wishlist_Successful - Step 07: Verify  product displayed in Wishlist page");
		Assert.assertTrue(wishlistPage.isProductNameDisplayed(productWishlist));
		
		log.info("TC_01_Add_Product_To_Wishlist_Successful - Step 08: Verify sharing link is displayed");
		Assert.assertTrue(wishlistPage.isSharingLinkDisplayed());
		
		log.info("TC_01_Add_Product_To_Wishlist_Successful - Step 09: Click to 'Sharing' link.");
		wishlistPage.clickToSharingLink();
		
		log.info("TC_01_Add_Product_To_Wishlist_Successful - Step 09: Verify sharing link is not displayed");
		Assert.assertTrue(wishlistPage.isSharingLinkUndisplayed());
	}
	
	@Test
	public void TC_02_Add_Product_To_Cart_From_Wishlist() {
		log.info("TC_02_Add_Product_To_Cart_From_Wishlist - Step 01: Check 'Add to cart' check box with product is: "+ productWishlist);
		wishlistPage.overrideImplicitTimeOut(driver, GlobalConstants.SHORT_TIMEOUT);
		wishlistPage.checkToAddToCartCheckboxByColumnNameAndRowNumber("Add to cart", "1");
		wishlistPage.overrideImplicitTimeOut(driver, GlobalConstants.LONG_TIMEOUT);
		
		log.info("TC_02_Add_Product_To_Cart_From_Wishlist - Step 02: Verify 'Add to cart' checkbox is selected");
		//verifyTrue(wishlistPage.isAddToCartCheckboxSelectedByColumnNameAndRowNumber("Add to cart", "1"));
		
		log.info("TC_02_Add_Product_To_Cart_From_Wishlist - Step 03: Click to 'Add to cart' button");
		wishlistPage.clickToButtonByText(driver, "Add to cart");
		
		log.info("TC_02_Add_Product_To_Cart_From_Wishlist - Step 04: Verify this product is displayed in Cart page");
		cartPage = PageGeneratorManager.getCartPageObject(driver);
		cartPage.isProductNameDisplayedByText(productWishlist);
		
		log.info("TC_02_Add_Product_To_Cart_From_Wishlist - Step 05: Click to Wishlist link");
		wishlistPage = homePage.clickToWishlistLink();
		
		log.info("TC_02_Add_Product_To_Cart_From_Wishlist - Step 06: Verify this product is not displayed in Wishlist page");
		Assert.assertTrue(wishlistPage.isProductNameUndisplayed(productWishlist));
	}
	
	@Test
	public void TC_03_Remove_Product_In_Wishlist() {
		log.info("TC_03_Remove_Product_In_Wishlist - Step 01: Open Home page");
		homePage.openHomePage();
		
		log.info("TC_03_Remove_Product_In_Wishlist - Step 02: Click to Product link is: " + productWishlist);
		productPage = homePage.clickToProductLinkInFeatureByText(productWishlist);
		
		log.info("TC_03_Remove_Product_In_Wishlist - Step 03: Click to 'Add to Wishlist' button");
		productPage.clickToButtonInProductDetailByClassName("add-to-wishlist");
		
		log.info("TC_03_Remove_Product_In_Wishlist - Step 04: Verify successful message is displayed.");
		Assert.assertEquals(productPage.getSuccessfulMessageInBarNotification(), "The product has been added to your wishlist");
		
		log.info("TC_03_Remove_Product_In_Wishlist - Step 05: Click to 'X' icon to close the message.");
		productPage.clickToCloseBarNotificationIcon();
		sleepInSecond(2);
		
		log.info("TC_03_Remove_Product_In_Wishlist - Step 06: Lick to Wishlist link");
		wishlistPage = homePage.clickToWishlistLink();
		
		log.info("TC_03_Remove_Product_In_Wishlist - Step 07: Verify  product displayed in Wishlist page");
		verifyTrue(wishlistPage.isProductNameDisplayed(productWishlist));
		
		log.info("TC_03_Remove_Product_In_Wishlist -  Step 08: Click to 'Delete' icon");
		wishlistPage.clickToDeleteButtonByColumnNameAndRowNumber("Remove", "1");
		
		log.info("TC_03_Remove_Product_In_Wishlist -  Step 09: Verify the message is displayed.");
		Assert.assertTrue(wishlistPage.getEmptyWishlistMessage().contains("The wishlist is empty!"));
	}
	
	@Test
	public void TC_04_Add_Product_To_Compare() {
		log.info("TC_04_Add_Product_To_Compare - Step 01: Open Home page");
		homePage.openHomePage();
		
		log.info("TC_04_Add_Product_To_Compare - Step 02: Click to Product link is: " + productWishlist);
		productPage = homePage.clickToProductLinkInFeatureByText(productWishlist);
		
		log.info("TC_04_Add_Product_To_Compare - Step 03: Click to 'Add to Compare list' button");
		productPage.clickToButtonInProductDetailByClassName("compare-products");
		
		log.info("TC_04_Add_Product_To_Compare - Step 04: Verify successful message is displayed.");
		Assert.assertEquals(productPage.getSuccessfulMessageInBarNotification(), "The product has been added to your product comparison");
		
		log.info("TC_04_Add_Product_To_Compare - Step 05: Click to 'X' icon to close the message.");
		productPage.clickToCloseBarNotificationIcon();
		sleepInSecond(2);
		
		log.info("TC_04_Add_Product_To_Compare - Step 06: Open Home page");
		homePage.openHomePage();
		
		log.info("TC_04_Add_Product_To_Compare - Step 07: Click to Product link is: " + productWishlist);
		productPage = homePage.clickToProductLinkInFeatureByText(productWishlist);
		
		log.info("TC_04_Add_Product_To_Compare - Step 08: Click to 'Add to Compare list' button");
		productPage.clickToButtonInProductDetailByClassName("compare-products");
		
		log.info("TC_04_Add_Product_To_Compare - Step 09: Verify successful message is displayed.");
		Assert.assertEquals(productPage.getSuccessfulMessageInBarNotification(), "The product has been added to your product comparison");
		
		log.info("TC_04_Add_Product_To_Compare - Step 10: Click to 'X' icon to close the message.");
		productPage.clickToCloseBarNotificationIcon();
		sleepInSecond(2);
		
		productPage.openDynamicMorePageFooterByText(driver, "Compare products list");
	}
	
	@Test 
	public void TC_05_Recently_View_Product() {
		
	}
}  
