package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.CartPageUI;

public class CartPageObject extends BasePage{
	WebDriver driver;

	public CartPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public boolean isProductNameDisplayedByText(String columnName) {
		waitForElementVisible(driver, CartPageUI.DYNAMIC_PRODUCT_NAME_BY_TEXT, columnName);
		return isElementDisplayed(driver, CartPageUI.DYNAMIC_PRODUCT_NAME_BY_TEXT, columnName);
	}
	
	public void inputQuantityTextboxByColumnNameAndRowNumber(String columnName, String rowNumber, String quantity) {
		int columnIndex = getListElementSize(driver, CartPageUI.DYNAMIC_CLOLUMN_NAME_BY_TEXT, columnName) + 1;
		waitForElementVisible(driver, CartPageUI.DYNAMIC_QUANTITY_TEXTBOX_IN_TABLE_BY_COLUMN_INDEX_ROW_NUMBER, rowNumber, String.valueOf(columnIndex));
		senkeyToElement(driver, CartPageUI.DYNAMIC_QUANTITY_TEXTBOX_IN_TABLE_BY_COLUMN_INDEX_ROW_NUMBER, quantity, rowNumber, String.valueOf(columnIndex));
	}
	
	public float getPriceByColumnNameAndRowNumber(String columnName, String rowNumber) {
		int columnIndex = getListElementSize(driver, CartPageUI.DYNAMIC_CLOLUMN_NAME_BY_TEXT, columnName) + 1;
		waitForElementVisible(driver, CartPageUI.DYNAMIC_PRICE_IN_TABLE_BY_COLUMN_INDEX_ROW_NUMBER, rowNumber, String.valueOf(columnIndex));
		return Float.parseFloat(getElementText(driver, CartPageUI.DYNAMIC_PRICE_IN_TABLE_BY_COLUMN_INDEX_ROW_NUMBER, rowNumber, String.valueOf(columnIndex))
				.trim().replace("$", "").replace(",", ""));
	}
	
	public int getQuantityTextboxAttribute(String columnName, String rowNumber, String attributeName) {
		int columnIndex = getListElementSize(driver, CartPageUI.DYNAMIC_CLOLUMN_NAME_BY_TEXT, columnName) + 1;
		waitForElementVisible(driver, CartPageUI.DYNAMIC_QUANTITY_TEXTBOX_IN_TABLE_BY_COLUMN_INDEX_ROW_NUMBER, rowNumber, String.valueOf(columnIndex));
		return Integer.parseInt(getElementAttributeValue(driver, CartPageUI.DYNAMIC_QUANTITY_TEXTBOX_IN_TABLE_BY_COLUMN_INDEX_ROW_NUMBER, attributeName, rowNumber, String.valueOf(columnIndex)));
	}
	
	public void clickToDeleteButtonByColumnNameAndRowNumber(String columnName, String rowNumber) {
		int columnIndex = getListElementSize(driver, CartPageUI.DYNAMIC_CLOLUMN_NAME_BY_TEXT, columnName) + 1;
		waitForClickable(driver, CartPageUI.DYNAMIC_DELETE_BUTTON_IN_TABLE_BY_COLUMN_INDEX_ROW_NUMBER, rowNumber, String.valueOf(columnIndex));
		clickToElement(driver, CartPageUI.DYNAMIC_DELETE_BUTTON_IN_TABLE_BY_COLUMN_INDEX_ROW_NUMBER, rowNumber, String.valueOf(columnIndex));
	}
	
	public String getEmptyWishlistMessage() {
		waitForElementVisible(driver, CartPageUI.EMPTY_MESSAGE);
		return getElementText(driver, CartPageUI.EMPTY_MESSAGE);
	}
	
	public boolean isProductNameUndisplayed(String productName) {
		return isElementUndisplayed(driver, CartPageUI.DYNAMIC_PRODUCT_NAME_BY_TEXT, productName);
	}
	
	public void checkTermsOfserviceChecbox() {
		waitForClickable(driver, CartPageUI.TERMS_OF_SERVICE_CHECKBOX);
		checkToDefaultCheckboxRadio(driver, CartPageUI.TERMS_OF_SERVICE_CHECKBOX);
	}
	
	public void clickToContinueButtonByIDDiv(String divID){
		waitForClickable(driver, CartPageUI.DYNAMIC_CONTINUE_BUTTON_BY_ID_DIV, divID);
		clickToElement(driver, CartPageUI.DYNAMIC_CONTINUE_BUTTON_BY_ID_DIV, divID);
	}
	
	public void checkRadioButtonByLabelText(String labelText) {
		waitForClickable(driver, CartPageUI.DYNAMIC_RADIO_BUTTON_BY_LABEL_TEXT, labelText);
		checkToDefaultCheckboxRadio(driver, CartPageUI.DYNAMIC_RADIO_BUTTON_BY_LABEL_TEXT, labelText);
	}
	
}
