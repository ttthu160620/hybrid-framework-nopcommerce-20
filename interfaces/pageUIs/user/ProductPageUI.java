package pageUIs.user;

public class ProductPageUI {
	public static final String DYNAMIC_DROPDOWN_BY_ID = "xpath=//select[@id='%s']";
	public static final String PRODUCT_NAME = "css=.product-title a";
	public static final String PRODUCT_PRICE = "xpath=//span[@class='price actual-price']";
	public static final String NEXT_PAGING_ICON = "xpath=//li[@class='next-page']/a[text()='Next']";
	public static final String PREVIOUS_PAGING_ICON = "xpath=//li[@class='previous-page']/a[text()='Previous']";
	public static final String ADD_WISHLIST_BUTTON_IN_DETAIL = "xpath=//div[@class='add-to-wishlist']//button[text()='Add to wishlist']";
	public static final String ADD_TO_CART_BUTTON_IN_DETAIL = "xpath=//div[@class='add-to-cart']//button[text()='Add to cart']";
	public static final String ADD_COMPARE_BUTTON_IN_DETAIL = "xpath=//div[@class='compare-products']//button[text()='Add to compare list']";
	public static final String DYNAMIC_BUTTON_PRODUCT_DETAIL_BY_CLASS = "xpath=//div[@class='%s']//button";
	public static final String SUCCESS_MESSAGE_BAR_NOTIFICATION = "xpath=//div[@class='bar-notification success']/p";
	public static final String CLOSE_MESSAGE_ICON = "xpath=//div[@class='bar-notification success']/span[@class='close']";
}
