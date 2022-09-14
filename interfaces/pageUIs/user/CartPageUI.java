package pageUIs.user;

public class CartPageUI {
	public static final String DYNAMIC_PRODUCT_NAME_BY_TEXT = "xpath=//tr/td/a[text()='%s']";
	public static final String DYNAMIC_CLOLUMN_NAME_BY_TEXT = "xpath=//tr/th[text()='%s']/preceding-sibling::th";
	public static final String DYNAMIC_DELETE_BUTTON_IN_TABLE_BY_COLUMN_INDEX_ROW_NUMBER = "xpath=//tbody/tr[%s]/td[%s]/button";
	public static final String DYNAMIC_QUANTITY_TEXTBOX_IN_TABLE_BY_COLUMN_INDEX_ROW_NUMBER = "xpath=//tbody/tr[%s]/td[%s]/input";
	public static final String DYNAMIC_PRICE_IN_TABLE_BY_COLUMN_INDEX_ROW_NUMBER = "xpath=//tbody/tr[%s]/td[%s]/span";
	public static final String EMPTY_MESSAGE = "xpath=//div[@class='no-data']";
	public static final String TERMS_OF_SERVICE_CHECKBOX = "xpath=//input[@id='termsofservice']";
	public static final String DYNAMIC_CONTINUE_BUTTON_BY_ID_DIV = "xpath=//div[@id='%s']/button[text()='Continue']";
	public static final String DYNAMIC_RADIO_BUTTON_BY_LABEL_TEXT = "xpath=//label[text()='%s']/preceding-sibling::input";
}
