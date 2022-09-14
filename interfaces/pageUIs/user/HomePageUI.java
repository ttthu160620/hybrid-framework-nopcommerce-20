package pageUIs.user;

public class HomePageUI {
	public static final String REGISTER_LINK = "xpath=//a[@class='ico-register']";
	public static final String LOGIN_LINK="xpath=//a[@class='ico-login']";
	public static final String MY_ACCOUNT_LINK = "xpath=//a[@class='ico-account']";
	public static final String HOME_PAGE_LOGO = "xpath=//div[@class='header-logo']/a";
	public static final String DYNAMIC_PRODUCT_LINK_IN_FEATURE_BY_TEXT = "xpath=//h2[@class='product-title']/a[text()='%s']";
	public static final String DYNAMIC_HEADER_MENU_BY_TEXT = "xpath=//div[@class='header-menu']//a[text()='%s']";
	public static final String DYNAMIC_SUB_MENU_BY_TEXT = "xpath=//ul[contains(@class,'notmobile')]//a[text()='%s']/following-sibling::ul[@class='sublist first-level']//a[text()='%s']";
	public static final String WISHLIST_LINK = "xpath=//a[@class='ico-wishlist']";
	public static final String SHOPPING_CART_LINK = "xpath=//a[@class='ico-cart']";
	
}
