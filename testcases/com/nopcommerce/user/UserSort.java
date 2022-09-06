package com.nopcommerce.user;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.user.HomePageObject;
import pageObjects.nopCommerce.user.PageGeneratorManager;
import pageObjects.nopCommerce.user.SortPageObject;
import utilities.ServerName;

public class UserSort extends BaseTest{
	WebDriver driver;
	HomePageObject homePage;
	SortPageObject sortPage;
	ServerName server;
	String sortByDropdownID, displayedDropdownID;
	
	@Parameters({"browser", "serverName", "envName", "ipAddress", "portNumber", "osName", "osVersion"})
	@BeforeClass
	public void beforeClass(@Optional("chrome ")String browserName, @Optional("testing") String serverName, @Optional("local") String envName,
			@Optional("localhost") String ipAddress,@Optional("4444") String portNumber, @Optional("Windows") String osName,@Optional("11") String osVersion) {
		log.info("Pre-Condition 01: Open Home page");
		ConfigFactory.setProperty("serverName", serverName);
		server = ConfigFactory.create(ServerName.class);
		driver = getBrowserDriver(browserName, server.appUrl(), envName, ipAddress, portNumber, osName, osVersion);
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
	
	@Test
	public void Displayed_01_3_Products_Page() {
		log.info("Displayed_01_3_Products_Page - Step 01: Select '3' in Display dropdown");
		sortPage.selectInDropdownByID(displayedDropdownID, "3");
		
		log.info("Displayed_01_3_Products_Page - Step 02: Verify displayed 3 products in page 1");
		sortPage.isLoadPageSuccess(driver);
		Assert.assertEquals(sortPage.getProductsNameList().size(), 3);
		
		log.info("Displayed_01_3_Products_Page - Step 03: Verify displayed 'Next page' icon in page 1");
		Assert.assertTrue(sortPage.isNextPagingIconDisplayed());
		
		log.info("Displayed_01_3_Products_Page - Step 04: Click to 'Next page' icon in page 1");
		sortPage.clickToNextPagingIcon();
		
		log.info("Displayed_01_3_Products_Page - Step 05: Verify displayed 3 products in page 2");
		sortPage.isLoadPageSuccess(driver);
		Assert.assertEquals(sortPage.getProductsNameList().size(), 3);
		
		log.info("Displayed_01_3_Products_Page - Step 06: Verify displayed 'Previous page' icon in page 2");
		Assert.assertTrue(sortPage.isPreviousPagingIconDisplayed());;
	}
	
	@Test
	public void Displayed_02_6_Products_Page() {
		log.info("Displayed_02_6_Products_Page - Step 01: Select '6' in Display dropdown");
		sortPage.selectInDropdownByID(displayedDropdownID, "6");
		
		log.info("Displayed_02_6_Products_Page - Step 02: Verify displayed <= 6 products/page");
		Assert.assertTrue(sortPage.getProductsNameList().size() <= 6);
		
		log.info("Displayed_02_6_Products_Page - Step 03: Verify Paging is not dispalyed"); 
		Assert.assertTrue(sortPage.isPagingUndisplayed());
	}
	
	@Test
	public void Displayed_03_9_Products_Page() {
		log.info("Displayed_03_9_Products_Page - Step 01: Select '9' in Display dropdown");
		sortPage.selectInDropdownByID(displayedDropdownID, "9");
		
		log.info("Displayed_03_9_Products_Page - Step 02: Verify displayed <=9 products/page");
		Assert.assertTrue(sortPage.getProductsNameList().size() <= 9);
		
		log.info("Displayed_03_9_Products_Page - Step 03: Verify Paging is not dispalyed"); 
		Assert.assertTrue(sortPage.isPagingUndisplayed());
	}
}
