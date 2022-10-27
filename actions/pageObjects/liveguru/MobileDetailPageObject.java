package pageObjects.liveguru;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.liveguru.MobileDetailPageUI;

public class MobileDetailPageObject extends BasePage {

	private WebDriver driver;

	public MobileDetailPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getPriceAtMobileDetailPage() {
		waitForElementVisible(driver, MobileDetailPageUI.PRICE_DETAIL_PAGE);
		return getWebElement(driver, MobileDetailPageUI.PRICE_DETAIL_PAGE).getText();
	}

	public boolean comparePrice(String priceAtMobilePage, String priceAtMobileDetailPage) {
		return priceAtMobilePage.equals(priceAtMobileDetailPage);
	}

}
