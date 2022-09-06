package com.nopcommerce.user;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import pageObjects.nopCommerce.user.HomePageObject;
import utilities.ServerName;

public class UserWishList extends BaseTest{
	WebDriver driver;	
	HomePageObject homePage;
	
	@Parameters({"browser, environment"})
	@BeforeClass
	public void beforeClass(String browserName, String evironmentName) {
		ServerName environment = ConfigFactory.create(ServerName.class);
		driver = getBrowserDriver(browserName);
	}
}  
