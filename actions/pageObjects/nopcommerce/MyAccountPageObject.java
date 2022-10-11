package pageObjects.nopcommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopcommerce.BasePageUI;
import pageUIs.nopcommerce.MyAccountPageUI;

public class MyAccountPageObject extends BasePage {

	private WebDriver driver;

	public MyAccountPageObject(WebDriver driver) {
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

	public void selectGenderRadio(String gender) {
		waitForElementClickable(driver, MyAccountPageUI.GENDER_RADIO, gender);
		checkDefaultCheckboxRadio(driver, MyAccountPageUI.GENDER_RADIO, gender);
	}

	public void inputToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, MyAccountPageUI.FIRST_NAME_TEXTBOX);
		sendKeyToElement(driver, MyAccountPageUI.FIRST_NAME_TEXTBOX, firstName);
	}

	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, MyAccountPageUI.LAST_NAME_TEXTBOX);
		sendKeyToElement(driver, MyAccountPageUI.LAST_NAME_TEXTBOX, lastName);
	}

	public void selectDayDropdown(String day) {
		waitForElementClickable(driver, MyAccountPageUI.DATE_OF_BIRTH_DROPDOWN);
		selectItemDefaultDropdown(driver, MyAccountPageUI.DATE_OF_BIRTH_DROPDOWN, day);
	}

	public void selectMonthDropdown(String month) {
		waitForElementClickable(driver, MyAccountPageUI.MONTH_OF_BIRTH_DROPDOWN);
		selectItemDefaultDropdown(driver, MyAccountPageUI.MONTH_OF_BIRTH_DROPDOWN, month);
	}

	public void selectYearDropdown(String year) {
		waitForElementClickable(driver, MyAccountPageUI.YEAR_OF_BIRTH_DROPDOWN);
		selectItemDefaultDropdown(driver, MyAccountPageUI.YEAR_OF_BIRTH_DROPDOWN, year);
	}

	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, MyAccountPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, MyAccountPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputToCompanyName(String companyName) {
		waitForElementVisible(driver, MyAccountPageUI.COMPANY_NAME_TEXTBOX);
		sendKeyToElement(driver, MyAccountPageUI.COMPANY_NAME_TEXTBOX, companyName);
	}

	public void clickToSaveButton() {
		waitForElementClickable(driver, MyAccountPageUI.SAVE_BUTTON);
		clickToElement(driver, MyAccountPageUI.SAVE_BUTTON);
	}

	public void openMyAccountMenuByName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA, pageName);
		clickToElement(driver, BasePageUI.DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA, pageName);
	}

}
