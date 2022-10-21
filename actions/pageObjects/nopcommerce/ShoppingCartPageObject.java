package pageObjects.nopcommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopcommerce.ShoppingCartPageUI;

public class ShoppingCartPageObject extends BasePage {

	private WebDriver driver;

	public ShoppingCartPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public ProductDetailPageObject clickToEditButton() {
		waitForElementClickable(driver, ShoppingCartPageUI.EDIT_SHOPPING_CART_BUTTON);
		clickToElement(driver, ShoppingCartPageUI.EDIT_SHOPPING_CART_BUTTON);
		return PageGeneratorManager.getProductDetailPage(driver);
	}

}
