package pageObjects.nopcommerce.admin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.nopcommerce.user.PageGeneratorManager;
import pageUIs.nopcommerce.admin.LoginAdminPageUI;

public class LoginAdminPageObject extends BasePage {

	private WebDriver driver;

	public LoginAdminPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToEmailTextbox(String emailValue) {
		waitForElementClickable(driver, LoginAdminPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, LoginAdminPageUI.EMAIL_TEXTBOX, emailValue);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementClickable(driver, LoginAdminPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, LoginAdminPageUI.PASSWORD_TEXTBOX, password);
	}

	public DashboardAdminPageObject clickToLoginButton() {
		waitForElementClickable(driver, LoginAdminPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginAdminPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getDashboardAdminPage(driver);
	}

}
