package pageObjects.nopCommerce.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.user.SortPageUI;

public class SortPageObject extends BasePage{
	private WebDriver driver;

	public SortPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public void selectInDropdownByID(String dropdownID, String textItem) {
		waitForElementVisible(driver, SortPageUI.DYNAMIC_DROPDOWN_BY_ID, dropdownID);
		selectItemInDefaultDropdown(driver, SortPageUI.DYNAMIC_DROPDOWN_BY_ID, textItem, dropdownID);
	}
	
	public String getFirstSelectedInDropwdownByID(String dropdownID) {
		waitForElementVisible(driver, SortPageUI.DYNAMIC_DROPDOWN_BY_ID, dropdownID);
		return getFirstItemIsSelectedDropdown(driver, SortPageUI.DYNAMIC_DROPDOWN_BY_ID, dropdownID);
	}
	
	public List<WebElement> getProductsNameList (){
		List<WebElement> listProducts = getListWebElements(driver, SortPageUI.PRODUCT_NAME);
		return listProducts;
	}
	
	public boolean isProductNameAscensding() {
		isLoadPageSuccess(driver);
		//array chua list product da sort a-z in UI
		ArrayList<String> listProductsUI = new ArrayList<String>();
		List<WebElement> listProducts = getProductsNameList();
		for(WebElement productName : listProducts) {
			listProductsUI.add(productName.getText());
			System.out.println("Product Name in UI:" + productName.getText());
		}
		
		// sort listUI lai xem dung khong
		ArrayList<String> listSortProduct = new ArrayList<String>();
		for(String productName : listProductsUI) {
			listSortProduct.add(productName);
		}
		
		Collections.sort(listSortProduct);
		
		for(String productName : listSortProduct) {
			System.out.println("Product Name is ascensding: " + productName);
		}
		return listProductsUI.equals(listSortProduct);
	}
	
	public boolean isProductNameDescensding() {
		isLoadPageSuccess(driver);
		
		ArrayList<String> listProductsUI = new ArrayList<String>();
		List<WebElement> listProducts = getProductsNameList();
		for(WebElement productName : listProducts) {
			listProductsUI.add(productName.getText());
			System.out.println("Product Name in UI:" + productName.getText());
		}
		
		ArrayList<String> listSortProduct = new ArrayList<String>();
		for(String productName : listProductsUI) {
			listSortProduct.add(productName);
		}
		
		Collections.sort(listSortProduct);
		for(String productName : listSortProduct) {
			System.out.println("Product Name after sort (ascensding): " + productName);
		}
		
		Collections.reverse(listSortProduct);
		for(String productName : listSortProduct) {
			System.out.println("Product Name is descensding: " + productName);
		}
		return listProductsUI.equals(listSortProduct);
	}
	
	public boolean isProductPriceAscensding() {
		isLoadPageSuccess(driver);
		
		ArrayList<Float> listProductsUI = new ArrayList<>();
		List<WebElement> listProducts = getListWebElements(driver, SortPageUI.PRODUCT_PRICE);
		for(WebElement productPrice : listProducts) {
			listProductsUI.add(Float.parseFloat(productPrice.getText().replace("$", "").replace(",", "")));
			System.out.println("Product Price in UI:" + Float.parseFloat(productPrice.getText().replace("$", "").replace(",", "")));
		}
		
		ArrayList<Float> listSortProduct = new ArrayList<>();
		for(Float productPrice : listProductsUI) {
			listSortProduct.add(productPrice);
		}
		
		Collections.sort(listSortProduct);
		
		for(Float productPrice : listSortProduct) {
			System.out.println("Product Price is ascensding: " + productPrice);
		}
		return listProductsUI.equals(listSortProduct);
	}
	
	public boolean isProductPriceDescensding() {
		isLoadPageSuccess(driver);
		
		ArrayList<Float> listProductsUI = new ArrayList<>();
		List<WebElement> listProducts = getListWebElements(driver, SortPageUI.PRODUCT_PRICE);
		for(WebElement productName : listProducts) {
			listProductsUI.add(Float.parseFloat(productName.getText().replace("$", "").replace(",", "")));
			System.out.println("Product Price in UI:" + Float.parseFloat(productName.getText().replace("$", "").replace(",", "")));
		}
		
		ArrayList<Float> listSortProduct = new ArrayList<>();
		for(Float productName : listProductsUI) {
			listSortProduct.add(productName);
		}
		
		Collections.sort(listSortProduct);
		for(Float productName : listSortProduct) {
			System.out.println("Product Name is ascensding: " + productName);
		}
		
		Collections.reverse(listSortProduct);
		for(Float productName : listSortProduct) {
			System.out.println("Product Name is descensding: " + productName);
		}
		
		return listProductsUI.equals(listSortProduct);
	}
	
	public boolean isNextPagingIconDisplayed() {
		waitForElementVisible(driver, SortPageUI.NEXT_PAGING_ICON);
		return isElementDisplayed(driver, SortPageUI.NEXT_PAGING_ICON);
	}
	
	public boolean isPreviousPagingIconDisplayed() {
		waitForElementVisible(driver, SortPageUI.PREVIOUS_PAGING_ICON);
		return isElementDisplayed(driver, SortPageUI.PREVIOUS_PAGING_ICON);
	}
	
	public void clickToNextPagingIcon() {
		waitForClickable(driver, SortPageUI.NEXT_PAGING_ICON);
		clickToElement(driver, SortPageUI.NEXT_PAGING_ICON);
	}
	
	public void clickToPreviousPagingIcon() {
		waitForClickable(driver, SortPageUI.PREVIOUS_PAGING_ICON);
		clickToElement(driver, SortPageUI.PREVIOUS_PAGING_ICON);
	}
	
	public boolean isPagingUndisplayed() {
		waitForElementInVisible(driver, SortPageUI.NEXT_PAGING_ICON);
		return isElementUndisplayed(driver, SortPageUI.NEXT_PAGING_ICON);
	}
}
