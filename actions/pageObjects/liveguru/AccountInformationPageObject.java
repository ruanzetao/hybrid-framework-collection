package pageObjects.liveguru;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.liveguru.AccountInformationPageUI;

public class AccountInformationPageObject extends BasePage {

	private WebDriver driver;

	public AccountInformationPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getFirstNameValue() {
		waitForElementVisible(driver, AccountInformationPageUI.FIRST_NAME_TEXTBOX);
		return getWebElement(driver, AccountInformationPageUI.FIRST_NAME_TEXTBOX).getAttribute("value");
	}

	public String getLastNameValue() {
		waitForElementVisible(driver, AccountInformationPageUI.LAST_NAME_TEXTBOX);
		return getWebElement(driver, AccountInformationPageUI.LAST_NAME_TEXTBOX).getAttribute("value");
	}

	public String getEmailAddressValue() {
		waitForElementVisible(driver, AccountInformationPageUI.EMAIL_ADDRESS_TEXTBOX);
		return getWebElement(driver, AccountInformationPageUI.EMAIL_ADDRESS_TEXTBOX).getAttribute("value");
	}

	public void clickToAccountButton() {
		waitForElementClickable(driver, AccountInformationPageUI.ACCOUNT_BUTTON);
		clickToElement(driver, AccountInformationPageUI.ACCOUNT_BUTTON);
	}

	public HomePagePageObject clickToLogoutMenu() {
		waitForElementClickable(driver, AccountInformationPageUI.LOGOUT_MENU);
		clickToElement(driver, AccountInformationPageUI.LOGOUT_MENU);
		sleepInSecond(10);
		return PageGeneratorManager.getHomePage(driver);
	}

}
