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

}
