package pageObjects.nopcommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopcommerce.ShoppingCartPageUI;

public class ShoppingCartPageObject extends BasePage {

	private WebDriver driver;

	public ShoppingCartPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public ProductDetailPageObject clickToEditButton() {
		waitForElementClickable(driver, ShoppingCartPageUI.EDIT_SHOPPING_CART_BUTTON);
		clickToElement(driver, ShoppingCartPageUI.EDIT_SHOPPING_CART_BUTTON);
		return PageGeneratorManager.getProductDetailPage(driver);
	}

	public void clickToRemoveButton() {
		waitForElementClickable(driver, ShoppingCartPageUI.REMOVE_BUTTON);
		clickToElement(driver, ShoppingCartPageUI.REMOVE_BUTTON);
	}

	public String getRemoveProductFromCartDisplayed() {
		waitForElementVisible(driver, ShoppingCartPageUI.REMOVE_PRODUCT_MESSAGE);
		return getWebElement(driver, ShoppingCartPageUI.REMOVE_PRODUCT_MESSAGE).getText();
	}

	public void inputToQuantityTextbox(String quantity) {
		waitForElementClickable(driver, ShoppingCartPageUI.QUANTITY_TEXTBOX);
		sendKeyToElement(driver, ShoppingCartPageUI.QUANTITY_TEXTBOX, quantity);
	}

	public void clickToUpdateShoppingCartButton() {
		waitForElementClickable(driver, ShoppingCartPageUI.UPDATE_BUTTON);
		clickToElement(driver, ShoppingCartPageUI.UPDATE_BUTTON);
	}

	public void selectGiftWrappingDropdown(String response) {
		waitForElementClickable(driver, ShoppingCartPageUI.GIFT_WRAPPING_DROPDOWN);
		selectItemDefaultDropdown(driver, ShoppingCartPageUI.GIFT_WRAPPING_DROPDOWN, response);
	}

	public void checkToAgreeTermCheckbox() {
		waitForElementClickable(driver, ShoppingCartPageUI.TERM_AND_CONDITION_CHECKBOX);
		checkDefaultCheckboxRadio(driver, ShoppingCartPageUI.TERM_AND_CONDITION_CHECKBOX);
	}

	public void clickToCheckoutButton() {
		waitForElementClickable(driver, ShoppingCartPageUI.CHECKOUT_BUTTON);
		clickToElement(driver, ShoppingCartPageUI.CHECKOUT_BUTTON);
	}

	public void selectCountryDropdown(String country) {
		waitForElementVisible(driver, ShoppingCartPageUI.COUNTRY_DROPDOWN);
		selectItemDefaultDropdown(driver, ShoppingCartPageUI.COUNTRY_DROPDOWN, country);
	}

	public void selectStateProvinceDropdown(String stateProvince) {
		waitForElementVisible(driver, ShoppingCartPageUI.STATE_PROVINCE_DROPDOWN);
		selectItemDefaultDropdown(driver, ShoppingCartPageUI.STATE_PROVINCE_DROPDOWN, stateProvince);
	}

	public void inputToCityTextbox(String city) {
		waitForElementVisible(driver, ShoppingCartPageUI.CITY_TEXTBOX);
		sendKeyToElement(driver, ShoppingCartPageUI.CITY_TEXTBOX, city);
	}

	public void inputToAddress1Textbox(String address1) {
		waitForElementVisible(driver, ShoppingCartPageUI.ADDRESS1_TEXTBOX);
		sendKeyToElement(driver, ShoppingCartPageUI.ADDRESS1_TEXTBOX, address1);
	}

	public void inputToZipPostalCodeTextbox(String zipPostal) {
		waitForElementVisible(driver, ShoppingCartPageUI.ZIP_POSTAL_TEXTBOX);
		sendKeyToElement(driver, ShoppingCartPageUI.ZIP_POSTAL_TEXTBOX, zipPostal);
	}

	public void inputToPhoneNumberTextbox(String phoneNumber) {
		waitForElementVisible(driver, ShoppingCartPageUI.PHONE_NUMBER_TEXTBOX);
		sendKeyToElement(driver, ShoppingCartPageUI.PHONE_NUMBER_TEXTBOX, phoneNumber);
	}

}
