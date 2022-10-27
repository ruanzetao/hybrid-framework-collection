package pageObjects.liveguru;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.liveguru.HomePagePageUI;

public class HomePagePageObject extends BasePage {

	private WebDriver driver;

	public HomePagePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public MyAccountPageObject clickToMyAccountLiveGuru(WebDriver driver) {
		waitForElementClickable(driver, HomePagePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePagePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getMyAccountPage(driver);
	}

}
