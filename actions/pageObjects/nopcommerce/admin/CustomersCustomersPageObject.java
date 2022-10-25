package pageObjects.nopcommerce.admin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopcommerce.admin.CustomersCustomersPageUI;

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

}
