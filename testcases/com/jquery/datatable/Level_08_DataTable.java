package com.jquery.datatable;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObject.noopCommerce.admin.AdminHomePageObject;
import pageObject.noopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.CustomerInforPageObject;
import pageObjects.nopCommerce.user.HomePageObject;
import pageObjects.nopCommerce.user.LoginPageObjects;
import pageObjects.nopCommerce.user.PageGeneratorManager;
import pageObjects.nopCommerce.user.RegisterPageObjects;

public class Level_08_DataTable{
  WebDriver driver;
  String projectPath = System.getProperty("user.dir");
  
  @Parameters("browser")
  @BeforeClass
  public void beforeClass() {
	 driver.get("");
  }
  
  @Test
  public void Table_01() {
	  
	  
  }
  

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  
  public int getRandomNumber() {
	  Random random = new Random();
	  return  random.nextInt(999);
  }

}
