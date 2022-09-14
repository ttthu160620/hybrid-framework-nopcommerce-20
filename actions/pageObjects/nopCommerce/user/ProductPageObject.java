package pageObjects.nopCommerce.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.user.ProductPageUI;

public class ProductPageObject extends BasePage{
	private WebDriver driver;

	public ProductPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public void selectInDropdownByID(String dropdownID, String textItem) {
		waitForElementVisible(driver, ProductPageUI.DYNAMIC_DROPDOWN_BY_ID, dropdownID);
		selectItemInDefaultDropdown(driver, ProductPageUI.DYNAMIC_DROPDOWN_BY_ID, textItem, dropdownID);
	}
	
	public String getFirstSelectedInDropwdownByID(String dropdownID) {
		waitForElementVisible(driver, ProductPageUI.DYNAMIC_DROPDOWN_BY_ID, dropdownID);
		return getFirstItemIsSelectedDropdown(driver, ProductPageUI.DYNAMIC_DROPDOWN_BY_ID, dropdownID);
	}
	
	public List<WebElement> getProductsNameList (){
		List<WebElement> listProducts = getListWebElements(driver, ProductPageUI.PRODUCT_NAME);
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
		List<WebElement> listProducts = getListWebElements(driver, ProductPageUI.PRODUCT_PRICE);
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
		List<WebElement> listProducts = getListWebElements(driver, ProductPageUI.PRODUCT_PRICE);
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
		waitForElementVisible(driver, ProductPageUI.NEXT_PAGING_ICON);
		return isElementDisplayed(driver, ProductPageUI.NEXT_PAGING_ICON);
	}
	
	public boolean isPreviousPagingIconDisplayed() {
		waitForElementVisible(driver, ProductPageUI.PREVIOUS_PAGING_ICON);
		return isElementDisplayed(driver, ProductPageUI.PREVIOUS_PAGING_ICON);
	}
	
	public void clickToNextPagingIcon() {
		waitForClickable(driver, ProductPageUI.NEXT_PAGING_ICON);
		clickToElement(driver, ProductPageUI.NEXT_PAGING_ICON);
	}
	
	public void clickToPreviousPagingIcon() {
		waitForClickable(driver, ProductPageUI.PREVIOUS_PAGING_ICON);
		clickToElement(driver, ProductPageUI.PREVIOUS_PAGING_ICON);
	}
	
	public boolean isPagingUndisplayed() {
		waitForElementInVisible(driver, ProductPageUI.NEXT_PAGING_ICON);
		return isElementUndisplayed(driver, ProductPageUI.NEXT_PAGING_ICON);
	}
	
	public void clickToButtonInProductDetailByClassName(String buttonClass) {
		waitForClickable(driver,ProductPageUI.DYNAMIC_BUTTON_PRODUCT_DETAIL_BY_CLASS, buttonClass);
		clickToElement(driver,ProductPageUI.DYNAMIC_BUTTON_PRODUCT_DETAIL_BY_CLASS, buttonClass);
	}
	
	public String getSuccessfulMessageInBarNotification() {
		waitForElementVisible(driver, ProductPageUI.SUCCESS_MESSAGE_BAR_NOTIFICATION);
		return getElementText(driver, ProductPageUI.SUCCESS_MESSAGE_BAR_NOTIFICATION);
	}
	
	public void clickToCloseBarNotificationIcon() {
		waitForClickable(driver, ProductPageUI.CLOSE_MESSAGE_ICON);
		clickToElement(driver, ProductPageUI.CLOSE_MESSAGE_ICON);
	}
	
	public CartPageObject clickToAddToCartButton() {
		waitForClickable(driver, ProductPageUI.ADD_TO_CART_BUTTON_IN_DETAIL);
		clickToElement(driver, ProductPageUI.ADD_TO_CART_BUTTON_IN_DETAIL);
		return PageGeneratorManager.getCartPageObject(driver);
	}
}
