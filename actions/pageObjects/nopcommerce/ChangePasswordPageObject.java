package pageObjects.nopcommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopcommerce.ChangePasswordPageUI;

public class ChangePasswordPageObject extends BasePage {
	private WebDriver driver;

	public ChangePasswordPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToOldPassword(String oldPassword) {
		waitForElementVisible(driver, ChangePasswordPageUI.OLD_PASSWORD);
		sendKeyToElement(driver, ChangePasswordPageUI.OLD_PASSWORD, oldPassword);
	}

	public void inputToNewPassword(String newPassword) {
		waitForElementVisible(driver, ChangePasswordPageUI.NEW_PASSWORD);
		sendKeyToElement(driver, ChangePasswordPageUI.NEW_PASSWORD, newPassword);
	}

	public void inputToConfirmPassword(String confirmPassword) {
		waitForElementVisible(driver, ChangePasswordPageUI.CONFIRM_PASSWORD);
		sendKeyToElement(driver, ChangePasswordPageUI.CONFIRM_PASSWORD, confirmPassword);
	}

	public void clickToChangePasswordButton() {
		waitForElementClickable(driver, ChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
		clickToElement(driver, ChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
	}

	public void clickToCloseButton() {
		waitForElementClickable(driver, ChangePasswordPageUI.CLOSE_CHANGE_PASSWORD_BUTTON);
		clickToElement(driver, ChangePasswordPageUI.CLOSE_CHANGE_PASSWORD_BUTTON);
		waitForElementInvisible(driver, ChangePasswordPageUI.CLOSE_CHANGE_PASSWORD_BUTTON);
	}

}
