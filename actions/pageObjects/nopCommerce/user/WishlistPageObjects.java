package pageObjects.nopCommerce.user;

import org.apache.commons.logging.Log;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.WishlistPageUI;

public class WishlistPageObjects extends BasePage{
	WebDriver driver;
	Log log;

	public WishlistPageObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isProductNameDisplayed(String productName) {
		waitForElementVisible(driver, WishlistPageUI.DYNAMIC_PRODUCT_NAME_BY_TEXT, productName);
		return isElementDisplayed(driver, WishlistPageUI.DYNAMIC_PRODUCT_NAME_BY_TEXT, productName);
	}
	
	public boolean isProductNameUndisplayed(String productName) {
		return isElementUndisplayed(driver, WishlistPageUI.DYNAMIC_PRODUCT_NAME_BY_TEXT, productName);
	}
	
	public boolean isSharingLinkDisplayed() {
		waitForElementVisible(driver, WishlistPageUI.SHARING_LINK);
		return isElementDisplayed(driver, WishlistPageUI.SHARING_LINK);
	}
	
	public void clickToSharingLink() {
		waitForClickable(driver, WishlistPageUI.SHARING_LINK);
		clickToElement(driver, WishlistPageUI.SHARING_LINK);
	}
	
	public boolean isSharingLinkUndisplayed() {
		return isElementUndisplayed(driver, WishlistPageUI.SHARING_LINK);
	}
	
	public void checkToAddToCartCheckboxByColumnNameAndRowNumber(String columnName, String rowNumber) {
		int columnIndex = getListElementSize(driver, WishlistPageUI.DYNAMIC_CLOLUMN_NAME_BY_TEXT, columnName) + 1;
		waitForClickable(driver, WishlistPageUI.DYNAMIC_CHECKBOX_IN_TABLE_BY_COLUMN_INDEX_ROW_NUMBER, rowNumber, String.valueOf(columnIndex));
		checkToDefaultCheckboxRadio(driver, WishlistPageUI.DYNAMIC_CHECKBOX_IN_TABLE_BY_COLUMN_INDEX_ROW_NUMBER, rowNumber, String.valueOf(columnIndex));
	}
	
	public void checkToAddToCartCheckboxByColumnNameAndRowNumber() {
		waitForClickable(driver, WishlistPageUI.DYNAMIC_CHECKBOX_IN_TABLE_BY_COLUMN_INDEX_ROW_NUMBER);
		checkToDefaultCheckboxRadio(driver, WishlistPageUI.DYNAMIC_CHECKBOX_IN_TABLE_BY_COLUMN_INDEX_ROW_NUMBER);
	}
	
	public boolean isAddToCartCheckboxSelectedByColumnNameAndRowNumber(String columnName, String rowNumber) {
		int columnIndex = getListElementSize(driver, WishlistPageUI.DYNAMIC_CLOLUMN_NAME_BY_TEXT, columnName) + 1;
		return isElementSelected(driver, WishlistPageUI.DYNAMIC_CHECKBOX_IN_TABLE_BY_COLUMN_INDEX_ROW_NUMBER, String.valueOf(columnIndex), rowNumber);
	}
	
	public void clickToDeleteButtonByColumnNameAndRowNumber(String columnName, String rowNumber) {
		int columnIndex = getListElementSize(driver, WishlistPageUI.DYNAMIC_CLOLUMN_NAME_BY_TEXT, columnName) + 1;
		waitForClickable(driver, WishlistPageUI.DYNAMIC_DELETE_BUTTON_IN_TABLE_BY_COLUMN_INDEX_ROW_NUMBER, rowNumber, String.valueOf(columnIndex));
		clickToElement(driver, WishlistPageUI.DYNAMIC_DELETE_BUTTON_IN_TABLE_BY_COLUMN_INDEX_ROW_NUMBER, rowNumber, String.valueOf(columnIndex));
	}
	
	public String getEmptyWishlistMessage() {
		waitForElementVisible(driver, WishlistPageUI.EMPTY_MESSAGE);
		return getElementText(driver, WishlistPageUI.EMPTY_MESSAGE);
	}
	
}
