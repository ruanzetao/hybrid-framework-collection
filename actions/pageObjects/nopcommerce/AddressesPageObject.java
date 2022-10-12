package pageObjects.nopcommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopcommerce.AddressesPageUI;
import pageUIs.nopcommerce.BasePageUI;

public class AddressesPageObject extends BasePage {

	private WebDriver driver;

	public AddressesPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToAddNewButton() {
		waitForElementClickable(driver, AddressesPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, AddressesPageUI.ADD_NEW_BUTTON);
	}

	public void inputToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, AddressesPageUI.FIRST_NAME_TEXTBOX);
		sendKeyToElement(driver, AddressesPageUI.FIRST_NAME_TEXTBOX, firstName);
	}

	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, AddressesPageUI.LAST_NAME_TEXTBOX);
		sendKeyToElement(driver, AddressesPageUI.LAST_NAME_TEXTBOX, lastName);
	}

	public void inputToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, AddressesPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, AddressesPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	public void inputToCompanyTextbox(String companyName) {
		waitForElementVisible(driver, AddressesPageUI.COMPANY_NAME_TEXTBOX);
		sendKeyToElement(driver, AddressesPageUI.COMPANY_NAME_TEXTBOX, companyName);
	}

	public void selectCountryDropdown(String countryName) {
		waitForElementClickable(driver, AddressesPageUI.COUNTRY_DROPDOWN);
		selectItemDefaultDropdown(driver, AddressesPageUI.COUNTRY_DROPDOWN, countryName);
	}

	public void selectStateDropdown(String stateProvinceName) {
		waitForElementClickable(driver, AddressesPageUI.STATE_PROVINCE_DROPDOWN);
		selectItemDefaultDropdown(driver, AddressesPageUI.STATE_PROVINCE_DROPDOWN, stateProvinceName);
	}

	public void inputToCityTextbox(String city) {
		waitForElementVisible(driver, AddressesPageUI.CITY_NAME_TEXTBOX);
		sendKeyToElement(driver, AddressesPageUI.CITY_NAME_TEXTBOX, city);
	}

	public void inputToAddress1Textbox(String address1) {
		waitForElementVisible(driver, AddressesPageUI.ADDRESS1_NAME_TEXTBOX);
		sendKeyToElement(driver, AddressesPageUI.ADDRESS1_NAME_TEXTBOX, address1);
	}

	public void inputToAddress2Textbox(String address2) {
		waitForElementVisible(driver, AddressesPageUI.ADDRESS2_NAME_TEXTBOX);
		sendKeyToElement(driver, AddressesPageUI.ADDRESS2_NAME_TEXTBOX, address2);
	}

	public void inputToZipPostalTextbox(String zipPostalCode) {
		waitForElementVisible(driver, AddressesPageUI.ZIP_POSTAL_CODE_TEXTBOX);
		sendKeyToElement(driver, AddressesPageUI.ZIP_POSTAL_CODE_TEXTBOX, zipPostalCode);
	}

	public void inputToPhoneNumberTextbox(String phoneNumber) {
		waitForElementVisible(driver, AddressesPageUI.PHONE_NUMBER_TEXTBOX);
		sendKeyToElement(driver, AddressesPageUI.PHONE_NUMBER_TEXTBOX, phoneNumber);
	}

	public void inputToFaxNumberTextbox(String faxNumber) {
		waitForElementVisible(driver, AddressesPageUI.FAX_NUMBER_TEXTBOX);
		sendKeyToElement(driver, AddressesPageUI.FAX_NUMBER_TEXTBOX, faxNumber);
	}

	public void clickToSaveButton() {
		waitForElementClickable(driver, AddressesPageUI.SAVE_BUTTON);
		clickToElement(driver, AddressesPageUI.SAVE_BUTTON);
	}

	public void hoverOnProductCategoryByHeader(String productCategory) {
		waitForElementClickable(driver, BasePageUI.PRODUCT_CATEGORY_LABEL_HEADER, productCategory);
		hoverOnElement(driver, BasePageUI.PRODUCT_CATEGORY_LABEL_HEADER, productCategory);
	}

}
