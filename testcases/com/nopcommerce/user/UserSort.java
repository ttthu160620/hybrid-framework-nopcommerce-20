package com.nopcommerce.user;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import freemarker.core.Environment;
import pageObjects.nopCommerce.user.HomePageObject;
import pageObjects.nopCommerce.user.PageGeneratorManager;
import pageObjects.nopCommerce.user.SortPageObject;

public class UserSort extends BaseTest{
	WebDriver driver;
	HomePageObject homePage;
	SortPageObject sortPage;
	utilities.Environment environment;
	String sortByDropdownID, displayedDropdownID;
	
	@Parameters({"browser", "environment"})
	@BeforeClass
	public void beforeClass(String browserName, String environmentName) {
		log.info("Pre-Condition 01: Open Home page");
		
		ConfigFactory.setProperty("environment", environmentName);
		environment = ConfigFactory.create(utilities.Environment.class);
		driver = getBrowserDriver(browserName, environment.appUrl());
		homePage = PageGeneratorManager.getHomePage(driver);
		
		sortByDropdownID = "products-orderby";
		displayedDropdownID = "products-pagesize";
		
		log.info("Pre-Condition 02: Select Notebooks in menu");
		log.info("Pre-Condition 02 - Step 01: Hover to 'Computer' dropdown");
		homePage.hoverToMenuHeaderByText("Computers ");
		
		log.info("Pre-Condition 02 - Step 02: Click to 'Notebooks' link");
		sortPage = homePage.clickToSubMenuByText("Computers ", "Notebooks ");
	}
	
	@Test
	public void Sort_Notebooks_01_Name_A_To_Z() {
		log.info("Sort_Notebooks_01_Name_A_To_Z - Step 01: Select 'Name: A to Z' in Sort by dropdown");
		sortPage.selectDropdownByID(driver, sortByDropdownID, "Name: A to Z");
		
		log.info("Sort_Notebooks_01_Name_A_To_Z - Step 02: Verify 'Name: A to Z' is selected.");
		Assert.assertEquals(sortPage.getFirstSelectedInDropwdownByID(sortByDropdownID), "Name: A to Z");
		
		log.info("Sort_Notebooks_01_Name_A_To_Z - Step 02: Verify all products display ascensding");
		Assert.assertTrue(sortPage.isProductNameAscensding());
	}
	
	@Test
	public void Sort_Notebooks_02_Name_Z_To_A() {
		log.info("Sort_Notebooks_02_Name_Z_To_A - Step 01: Select 'Name: Z to A' in Sort by dropdown");
		sortPage.selectDropdownByID(driver, sortByDropdownID, "Name: Z to A");
		
		log.info("Sort_Notebooks_02_Name_Z_To_A - Step 02: Verify 'Name: Z to A' is selected.");
		Assert.assertEquals(sortPage.getFirstSelectedInDropwdownByID(sortByDropdownID), "Name: Z to A");
		
		log.info("Sort_Notebooks_02_Name_Z_To_A - Step 02: Verify all products display descensding");
		Assert.assertTrue(sortPage.isProductNameDescensding());
	}
	
	@Test
	public void Sort_Notebooks_03_Price_Low_to_High() {
		log.info("Sort_Notebooks_03_Price_Low_to_High - Step 01: Select 'Price: Low to High' in Sort by dropdown");
		sortPage.selectDropdownByID(driver, sortByDropdownID, "Price: Low to High");
		
		log.info("Sort_Notebooks_03_Price_Low_to_High - Step 02: Verify 'Price: Low to High' is selected.");
		Assert.assertEquals(sortPage.getFirstSelectedInDropwdownByID(sortByDropdownID), "Price: Low to High");
		
		log.info("Sort_Notebooks_03_Price_Low_to_High - Step 03: Verify all products display ascensding");
		Assert.assertTrue(sortPage.isProductPriceAscensding());
	}
	
	@Test
	public void Sort_Notebooks_04_Price_High_To_Low() {
		log.info("Sort_Notebooks_04_Price_High_To_Low - Step 01: Select 'Price: High to Low' in Sort by dropdown");
		sortPage.selectDropdownByID(driver, sortByDropdownID, "Price: High to Low");
		
		log.info("Sort_Notebooks_04_Price_High_To_Low - Step 02: Verify 'Price: High to Low' is selected.");
		Assert.assertEquals(sortPage.getFirstSelectedInDropwdownByID(sortByDropdownID), "Price: High to Low");
		
		log.info("Sort_Notebooks_04_Price_High_To_Low - Step 03: Verify all products display descensding");
		Assert.assertTrue(sortPage.isProductPriceDescensding());
	}
}
