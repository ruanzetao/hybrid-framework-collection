package pageObjects.liveguru;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.liveguru.ShoppingCartPageUI;

public class ShoppingCartPageObject extends BasePage {

	private WebDriver driver;

	public ShoppingCartPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToCouponCodeTextbox(String code) {
		waitForElementVisible(driver, ShoppingCartPageUI.DISCOUNT_CODES_TEXTBOX);
		sendKeyToElement(driver, ShoppingCartPageUI.DISCOUNT_CODES_TEXTBOX, code);
	}

	public void clickToApplyButton() {
		waitForElementClickable(driver, ShoppingCartPageUI.APPLY_BUTTON);
		clickToElement(driver, ShoppingCartPageUI.APPLY_BUTTON);
	}

	public String getDiscountValue() {
		waitForElementVisible(driver, ShoppingCartPageUI.DISCOUNT_VALUE_LABEL);
		return getWebElement(driver, ShoppingCartPageUI.DISCOUNT_VALUE_LABEL).getText();
	}

	public String getGrandTotalDiscountedPrice() {
		waitForElementVisible(driver, ShoppingCartPageUI.GRAND_TOTAL_DISCOUNTED_PRICE_LABEL);
		return getWebElement(driver, ShoppingCartPageUI.GRAND_TOTAL_DISCOUNTED_PRICE_LABEL).getText();
	}

	public MobilePageObject clickToMobileMenu() {
		waitForElementVisible(driver, ShoppingCartPageUI.MOBILE_MENU);
		clickToElement(driver, ShoppingCartPageUI.MOBILE_MENU);
		return PageGeneratorManager.getMobilePage(driver);
	}

	public void inputToQuantityTextbox(String quantity) {
		waitForElementVisible(driver, ShoppingCartPageUI.QUANTITY_TEXTBOX);
		sendKeyToElement(driver, ShoppingCartPageUI.QUANTITY_TEXTBOX, quantity);
	}

	public void clickToUpdateButton() {
		waitForElementClickable(driver, ShoppingCartPageUI.UPDATE_BUTTON);
		clickToElement(driver, ShoppingCartPageUI.UPDATE_BUTTON);
	}

	public String getErrorMessage() {
		waitForElementVisible(driver, ShoppingCartPageUI.ERROR_MESSAGE);
		return getWebElement(driver, ShoppingCartPageUI.ERROR_MESSAGE).getText();
	}

	public String getItemErrorMessage() {
		waitForElementVisible(driver, ShoppingCartPageUI.ITEM_ERROR_MESSAGE);
		return getWebElement(driver, ShoppingCartPageUI.ITEM_ERROR_MESSAGE).getText();
	}

}
