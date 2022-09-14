package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.HomePageUI;

public class HomePageObject extends BasePage{
	private WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public RegisterPageObjects  clickToRegisterLink() {
		waitForClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
	}
	
	public LoginPageObjects clickToLoginLink() {
		waitForClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getHometLoginPage(driver);
	}
	
	public CustomerInforPageObject clickMyAccountLink() {
		waitForClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getCustomerInforPage(driver);
	}
	
	public boolean isMyAccountDisplayed() {
		waitForElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);
	}
	
	public HomePageObject openHomePage() {
		clickToElement(driver, HomePageUI.HOME_PAGE_LOGO);
		return PageGeneratorManager.getHomePage(driver);
	}
	
	public ProductPageObject clickToProductLinkInFeatureByText(String productText) {
		waitForClickable(driver, HomePageUI.DYNAMIC_PRODUCT_LINK_IN_FEATURE_BY_TEXT, productText);
		clickToElement(driver, HomePageUI.DYNAMIC_PRODUCT_LINK_IN_FEATURE_BY_TEXT, productText);
		return PageGeneratorManager.getProductPage(driver);
	}
	
	public void hoverToMenuHeaderByText(String categoryName) {
		waitForElementVisible(driver, HomePageUI.DYNAMIC_HEADER_MENU_BY_TEXT, categoryName);
		hoverMouseToElement(driver, HomePageUI.DYNAMIC_HEADER_MENU_BY_TEXT, categoryName);
	}
	
	public ProductPageObject clickToSubMenuByText(String menuName, String subName) {
		waitForClickable(driver, HomePageUI.DYNAMIC_SUB_MENU_BY_TEXT, menuName, subName);
		clickToElement(driver, HomePageUI.DYNAMIC_SUB_MENU_BY_TEXT, menuName, subName);
		return PageGeneratorManager.getProductPage(driver);
	}
	
	public WishlistPageObjects clickToWishlistLink() {
		waitForClickable(driver, HomePageUI.WISHLIST_LINK);
		clickToElement(driver, HomePageUI.WISHLIST_LINK);
		return PageGeneratorManager.getWishlistPage(driver);
	}
	
	public CartPageObject clickToShoppingCartLink() {
		waitForClickable(driver, HomePageUI.SHOPPING_CART_LINK);
		clickToElement(driver, HomePageUI.SHOPPING_CART_LINK);
		return PageGeneratorManager.getCartPageObject(driver);
	}
}
