package pageObjects.nopcommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopcommerce.BasePageUI;

public class ProductByTypePageObject extends BasePage {

	private WebDriver driver;

	public ProductByTypePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public ProductDetailPageObject clickToProductNameLink(String product) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_PRODUCT_BY_NAME, product);
		clickToElement(driver, BasePageUI.DYNAMIC_PRODUCT_BY_NAME, product);
		return PageGeneratorManager.getProductDetailPage(driver);
	}

}
