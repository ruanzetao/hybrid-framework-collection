package pageObjects.nopcommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopcommerce.BasePageUI;
import pageUIs.nopcommerce.HomePageUI;

public class HomePageObject extends BasePage {

	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public RegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, BasePageUI.REGISTER_LINK);
		clickToElement(driver, BasePageUI.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
	}

	public LoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, BasePageUI.LOGIN_LINK);
		clickToElement(driver, BasePageUI.LOGIN_LINK);
		return PageGeneratorManager.getLoginPage(driver);
	}

	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
		return getWebElement(driver, HomePageUI.MY_ACCOUNT_LINK).isDisplayed();
	}

	public MyAccountPageObject clickToMyAccountLink() {
		waitForElementClickable(driver, BasePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, BasePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getMyAccountPage(driver);
	}

	public ProductByTypePageObject selectProductTypeByHeader(String category, String productType) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_PRODUCT_TYPE_BY_HEADER, category, productType);
		clickToElement(driver, BasePageUI.DYNAMIC_PRODUCT_TYPE_BY_HEADER, category, productType);
		return PageGeneratorManager.getProductByTypePage(driver);
	}

	public SearchPageObject clickToFooterSearchLink() {
		waitForElementClickable(driver, HomePageUI.SEARCH_LINK_FOOTER);
		clickToElement(driver, HomePageUI.SEARCH_LINK_FOOTER);
		return PageGeneratorManager.getSearchPage(driver);
	}

}
