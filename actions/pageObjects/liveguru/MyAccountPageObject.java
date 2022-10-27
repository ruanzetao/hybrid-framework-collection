package pageObjects.liveguru;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.liveguru.AccountDashboardPageUI;
import pageUIs.liveguru.MyAccountPageUI;

public class MyAccountPageObject extends BasePage {

	private WebDriver driver;

	public MyAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public CreateAnAccountPageObject clickToCreateAnAccountButton() {
		waitForElementClickable(driver, AccountDashboardPageUI.CREATE_AN_ACCOUNT_BUTTON);
		clickToElement(driver, AccountDashboardPageUI.CREATE_AN_ACCOUNT_BUTTON);
		return PageGeneratorManager.getCreateAnAccountPage(driver);
	}

	public void inputToEmailAddressTextbox(String email) {
		waitForElementVisible(driver, MyAccountPageUI.EMAIL_ADDRESS_TEXTBOX);
		sendKeyToElement(driver, MyAccountPageUI.EMAIL_ADDRESS_TEXTBOX, email);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, MyAccountPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, MyAccountPageUI.PASSWORD_TEXTBOX, password);
	}

	public AccountDashboardPageObject clickToLoginButton() {
		waitForElementClickable(driver, MyAccountPageUI.LOGIN_BUTTON);
		clickToElement(driver, MyAccountPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getAccountDashboardPage(driver);
	}

}
