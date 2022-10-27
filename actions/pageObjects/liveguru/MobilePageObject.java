package pageObjects.liveguru;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.liveguru.MobilePageUI;

public class MobilePageObject extends BasePage {

	private WebDriver driver;

	public MobilePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getPriceAtMobilePage(String product) {
		waitForElementVisible(driver, MobilePageUI.PRODUCT_PRICE);
		return getWebElement(driver, MobilePageUI.PRODUCT_PRICE).getText();
	}

	public MobileDetailPageObject clickToProductNameHyperlink(String product) {
		waitForElementClickable(driver, MobilePageUI.PRODUCT_NAME);
		clickToElement(driver, MobilePageUI.PRODUCT_NAME);
		return PageGeneratorManager.getMobileDetailPage(driver);
	}

}
