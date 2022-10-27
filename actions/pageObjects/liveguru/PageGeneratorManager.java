package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {

	public static HomePagePageObject getHomePage(WebDriver driver) {
		return new HomePagePageObject(driver);
	}

	public static MyAccountPageObject getMyAccountPage(WebDriver driver) {
		return new MyAccountPageObject(driver);
	}

	public static CreateAnAccountPageObject getCreateAnAccountPage(WebDriver driver) {
		return new CreateAnAccountPageObject(driver);
	}

	public static AccountDashboardPageObject getAccountDashboardPage(WebDriver driver) {
		return new AccountDashboardPageObject(driver);
	}

	public static AccountInformationPageObject getAccountInformationPage(WebDriver driver) {
		return new AccountInformationPageObject(driver);
	}

	public static MobilePageObject getMobilePage(WebDriver driver) {
		return new MobilePageObject(driver);
	}

	public static MobileDetailPageObject getMobileDetailPage(WebDriver driver) {
		return new MobileDetailPageObject(driver);
	}

}
