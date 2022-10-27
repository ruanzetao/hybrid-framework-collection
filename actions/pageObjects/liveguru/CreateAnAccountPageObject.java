package pageObjects.liveguru;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.liveguru.CreateAnAccountPageUI;

public class CreateAnAccountPageObject extends BasePage {

	private WebDriver driver;

	public CreateAnAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, CreateAnAccountPageUI.FIRST_NAME_TEXTBOX);
		sendKeyToElement(driver, CreateAnAccountPageUI.FIRST_NAME_TEXTBOX, firstName);
	}

	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, CreateAnAccountPageUI.LAST_NAME_TEXTBOX);
		sendKeyToElement(driver, CreateAnAccountPageUI.LAST_NAME_TEXTBOX, lastName);
	}

	public void inputToEmailAddressTextbox(String emailAddress) {
		waitForElementVisible(driver, CreateAnAccountPageUI.EMAIL_ADDRESS_TEXTBOX);
		sendKeyToElement(driver, CreateAnAccountPageUI.EMAIL_ADDRESS_TEXTBOX, emailAddress);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, CreateAnAccountPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, CreateAnAccountPageUI.PASSWORD_TEXTBOX, password);
	}

	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, CreateAnAccountPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendKeyToElement(driver, CreateAnAccountPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
	}

	public AccountDashboardPageObject clickToRegisterButton() {
		waitForElementClickable(driver, CreateAnAccountPageUI.REGISTER_BUTTON);
		clickToElement(driver, CreateAnAccountPageUI.REGISTER_BUTTON);
		return PageGeneratorManager.getAccountDashboardPage(driver);
	}

}
