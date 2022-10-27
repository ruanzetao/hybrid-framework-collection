package pageObjects.liveguru;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.liveguru.AccountDashboardPageUI;

public class AccountDashboardPageObject extends BasePage {

	private WebDriver driver;

	public AccountDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public AccountInformationPageObject clickToAccountInformationLink() {
		waitForElementVisible(driver, AccountDashboardPageUI.ACCOUNT_INFORMATION_LINK);
		clickToElement(driver, AccountDashboardPageUI.ACCOUNT_INFORMATION_LINK);
		return PageGeneratorManager.getAccountInformationPage(driver);
	}

}
