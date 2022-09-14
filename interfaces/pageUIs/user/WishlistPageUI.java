package pageUIs.user;

public class WishlistPageUI {
	public static final String DYNAMIC_PRODUCT_NAME_BY_TEXT = "xpath=//tr/td/a[text()='%s']";
	public static final String SHARING_LINK = "xpath=//a[@class='share-link']";
	public static final String DYNAMIC_CLOLUMN_NAME_BY_TEXT = "xpath=//tr/th[text()='%s']/preceding-sibling::th";
	public static final String DYNAMIC_CHECKBOX_IN_TABLE_BY_COLUMN_INDEX_ROW_NUMBER = "xpath=//tbody/tr[%s]/td[%s]/input[@type='checkbox']";
	public static final String DYNAMIC_DELETE_BUTTON_IN_TABLE_BY_COLUMN_INDEX_ROW_NUMBER = "xpath=//tbody/tr[%s]/td[%s]/button";
	public static final String EMPTY_MESSAGE = "xpath=//div[@class='no-data']";
}
