package com.nopcommerce.user;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.user.HomePageObject;
import pageObjects.nopCommerce.user.PageGeneratorManager;
import pageObjects.nopCommerce.user.RegisterPageObjects;
import utilities.DataHelperFaker;
import utilities.ServerName;

public class UserWishList extends BaseTest{
	WebDriver driver;	
	HomePageObject homePage;
	RegisterPageObjects registerPage;
	ServerName server;
	DataHelperFaker dataFaker;
	String firstName, lastName, email, password;
	
	@Parameters({"browser, serverName"})
	@BeforeClass
	public void beforeClass(String browserName, String serverName) {
		server = ConfigFactory.create(ServerName.class);
		driver = getBrowserDriver(browserName);
		
		dataFaker = DataHelperFaker.getData();
		firstName = dataFaker.getFirstName();
		lastName = dataFaker.getLastName();
		email = dataFaker.getEmail();
		password = dataFaker.getPassword();
		
		log.info("Precondition 01 - Step 01: Open home page");
		homePage = PageGeneratorManager.getHomePage(driver);
		
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
		
	}
}  
