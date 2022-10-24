package pageObjects.nopcommerce.admin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.nopcommerce.admin.ProductsCatalogPageUI;

import java.util.List;

public class ProductsCatalogAdminPageObject extends BasePage {

	private WebDriver driver;

	public ProductsCatalogAdminPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToProductNameTextbox(String productName) {
		waitForElementVisible(driver, ProductsCatalogPageUI.PRODUCT_NAME_TEXTBOX);
		sendKeyToElement(driver, ProductsCatalogPageUI.PRODUCT_NAME_TEXTBOX, productName);
	}

	public void clickToSearchButton() {
		waitForElementClickable(driver, ProductsCatalogPageUI.SEARCH_BUTTON);
		clickToElement(driver, ProductsCatalogPageUI.SEARCH_BUTTON);
		sleepInSecond(10);
	}

	public boolean isReturnedProductsContainKeyword(String keyword) {
		scrollToElement(driver, ProductsCatalogPageUI.LEARN_MORE);
		boolean checkTrue = false;
		List<WebElement> returnedProducts = getListWebElement(driver, ProductsCatalogPageUI.RETURNED_PRODUCTS_NAME);
		System.out.println("Size: " + returnedProducts.size());
		for (WebElement product : returnedProducts) {
			System.out.println("In for loop.");
			System.out.println("Get text: " + product.getText());
			System.out.println("Keyword: " + keyword);
			if (product.getText().contains(keyword)) {
				checkTrue = true;
				break;
			}
		}
		System.out.println("Check true: " + checkTrue);
		return checkTrue;
	}

}
