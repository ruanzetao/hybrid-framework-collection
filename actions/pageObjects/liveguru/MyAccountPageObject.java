package pageObjects.liveguru;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.liveguru.AccountDashboardPageUI;

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

}
