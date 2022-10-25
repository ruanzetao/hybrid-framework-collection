package pageObjects.nopcommerce.admin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.nopcommerce.admin.CustomersCustomersPageUI;

import java.util.List;

public class CustomersCustomersPageObject extends BasePage {

	private WebDriver driver;

	public CustomersCustomersPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToAddNewButton() {
		waitForElementClickable(driver, CustomersCustomersPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, CustomersCustomersPageUI.ADD_NEW_BUTTON);
	}

	public void expandCustomerInfoArea() {
		waitForElementClickable(driver, CustomersCustomersPageUI.CUSTOMER_INFO_AREA);
		clickToElement(driver, CustomersCustomersPageUI.CUSTOMER_INFO_AREA);
	}

	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, CustomersCustomersPageUI.EMAIL_TEXTBOX_ADD_NEW);
		sendKeyToElement(driver, CustomersCustomersPageUI.EMAIL_TEXTBOX_ADD_NEW, email);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, CustomersCustomersPageUI.PASSWORD_TEXTBOX_ADD_NEW);
		sendKeyToElement(driver, CustomersCustomersPageUI.PASSWORD_TEXTBOX_ADD_NEW, password);
	}

	public void inputToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, CustomersCustomersPageUI.FIRST_NAME_TEXTBOX_ADD_NEW);
		sendKeyToElement(driver, CustomersCustomersPageUI.FIRST_NAME_TEXTBOX_ADD_NEW, firstName);
	}

	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, CustomersCustomersPageUI.LAST_NAME_TEXTBOX_ADD_NEW);
		sendKeyToElement(driver, CustomersCustomersPageUI.LAST_NAME_TEXTBOX_ADD_NEW, lastName);
	}

	public void inputToCompanyName(String companyName) {
		waitForElementVisible(driver, CustomersCustomersPageUI.COMPANY_NAME_TEXTBOX_ADD_NEW);
		sendKeyToElement(driver, CustomersCustomersPageUI.COMPANY_NAME_TEXTBOX_ADD_NEW, companyName);
	}

	public void inputToAdminComment(String adminComment) {
		waitForElementVisible(driver, CustomersCustomersPageUI.ADMIN_COMMENT_TEXTBOX_ADD_NEW);
		sendKeyToElement(driver, CustomersCustomersPageUI.ADMIN_COMMENT_TEXTBOX_ADD_NEW, adminComment);
	}

	public void clickToSaveAndContinueEditButton() {
		waitForElementClickable(driver, CustomersCustomersPageUI.SAVE_AND_CONTINUE_ADD_NEW);
		clickToElement(driver, CustomersCustomersPageUI.SAVE_AND_CONTINUE_ADD_NEW);
	}

	public void checkToGenderRadio(String gender) {
		waitForElementVisible(driver, CustomersCustomersPageUI.GENDER_RADIO_ADD_NEW, gender);
		clickToElement(driver, CustomersCustomersPageUI.GENDER_RADIO_ADD_NEW, gender);
	}

	public void checkToActiveCheckbox() {
		waitForElementVisible(driver, CustomersCustomersPageUI.ACTIVE_CHECKBOX_ADD_NEW);
		checkDefaultCheckboxRadio(driver, CustomersCustomersPageUI.ACTIVE_CHECKBOX_ADD_NEW);
	}

	public void inputToDateOfBirthDatePicker(String date) {
		waitForElementVisible(driver, CustomersCustomersPageUI.DATE_OF_BIRTH_PICKER_ADD_NEW);
		sendKeyToElement(driver, CustomersCustomersPageUI.DATE_OF_BIRTH_PICKER_ADD_NEW, date);
	}

	public void inputToEmailSearchTextbox(String email) {
		waitForElementVisible(driver, CustomersCustomersPageUI.EMAIL_SEARCH_TEXTBOX);
		sendKeyToElement(driver, CustomersCustomersPageUI.EMAIL_SEARCH_TEXTBOX, email);
	}

	public void clickToSearchButton() {
		waitForElementClickable(driver, CustomersCustomersPageUI.SEARCH_BUTTON);
		clickToElement(driver, CustomersCustomersPageUI.SEARCH_BUTTON);
	}

	public boolean isReturnedCustomersContainsKeyword(String email) {
		List<WebElement> returnedCustomers = getListWebElement(driver, CustomersCustomersPageUI.RETURNED_CUSTOMERS_BY_EMAIL);
		for (WebElement element : returnedCustomers) {
			if (element.getText().contains(email)) {
				return true;
			}
		}
		return false;
	}

	public void inputToFirstNameSearchTextbox(String firstName) {
		waitForElementVisible(driver, CustomersCustomersPageUI.FIRST_NAME_TEXTBOX);
		sendKeyToElement(driver, CustomersCustomersPageUI.FIRST_NAME_TEXTBOX, firstName);
	}

	public void inputToLastNameSearchTextbox(String lastName) {
		waitForElementVisible(driver, CustomersCustomersPageUI.LAST_NAME_TEXTBOX);
		sendKeyToElement(driver, CustomersCustomersPageUI.LAST_NAME_TEXTBOX, lastName);
	}

	public boolean isReturnedCustomersContainsName(String combinedName) {
		List<WebElement> returnedCustomers = getListWebElement(driver, CustomersCustomersPageUI.RETURNED_CUSTOMERS_BY_NAME);
		for (WebElement element : returnedCustomers) {
			if (element.getText().contains(combinedName)) {
				return true;
			}
		}
		return false;
	}

	public void inputToCompanySearchTextbox(String companyName) {
		waitForElementVisible(driver, CustomersCustomersPageUI.COMPANY_NAME_TEXTBOX);
		sendKeyToElement(driver, CustomersCustomersPageUI.COMPANY_NAME_TEXTBOX, companyName);
	}

	public boolean isReturnedCustomersContainsCompany(String companyName) {
		List<WebElement> returnedCustomers = getListWebElement(driver, CustomersCustomersPageUI.RETURNED_CUSTOMERS_BY_COMPANY);
		for (WebElement element : returnedCustomers) {
			if (element.getText().contains(companyName)) {
				return true;
			}
		}
		return false;
	}

}
