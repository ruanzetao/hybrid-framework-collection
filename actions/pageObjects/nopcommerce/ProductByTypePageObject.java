package pageObjects.nopcommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.nopcommerce.BasePageUI;
import pageUIs.nopcommerce.ProductByTypePageUI;

import java.util.List;

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

	public void selectSortByDropdown(String sortBy) {
		waitForElementClickable(driver, ProductByTypePageUI.SORT_BY_DROPDOWN);
		selectItemDefaultDropdown(driver, ProductByTypePageUI.SORT_BY_DROPDOWN, sortBy);
	}

	public boolean isListProductsAToZ() {
		boolean checkTrue = true;
		List<WebElement> allProducts = getListWebElement(driver, ProductByTypePageUI.PRODUCT_TITLE);
		for (int index = 0; index < allProducts.size() - 1; index++) {
			if (allProducts.get(index).getText().toUpperCase().charAt(0) < allProducts.get(index + 1).getText().toUpperCase().charAt(0)) {
				checkTrue = true;
			} else if (allProducts.get(index).getText().toUpperCase().charAt(0) == allProducts.get(index + 1).getText().toUpperCase().charAt(0)) {
				checkTrue = true;
			} else {
				checkTrue = false;
				break;
			}
		}
		return checkTrue;
	}

	public boolean isListProductsZToA() {
		boolean checkTrue = true;
		List<WebElement> allProducts = getListWebElement(driver, ProductByTypePageUI.PRODUCT_TITLE);
		for (int index = 0; index < allProducts.size() - 1; index++) {
			if (allProducts.get(index).getText().toUpperCase().charAt(0) > allProducts.get(index + 1).getText().toUpperCase().charAt(0)) {
				checkTrue = true;
			} else if (allProducts.get(index).getText().toUpperCase().charAt(0) == allProducts.get(index + 1).getText().toUpperCase().charAt(0)) {
				checkTrue = true;
			} else {
				checkTrue = false;
				break;
			}
		}
		return checkTrue;
	}

}
