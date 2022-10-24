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

	public void selectCategoryDropdown(String category) {
		waitForElementClickable(driver, ProductsCatalogPageUI.CATEGORY_DROPDOWN);
		selectItemDefaultDropdown(driver, ProductsCatalogPageUI.CATEGORY_DROPDOWN, category);
	}

	public void uncheckSubcategories() {
		waitForElementClickable(driver, ProductsCatalogPageUI.SUBCATEGOGY_CHECKBOX);
		uncheckDefaultCheckboxRadio(driver, ProductsCatalogPageUI.SUBCATEGOGY_CHECKBOX);
	}

	public String getReturnedMessage() {
		waitForElementVisible(driver, ProductsCatalogPageUI.RETURNED_MESSAGE);
		return getWebElement(driver, ProductsCatalogPageUI.RETURNED_MESSAGE).getText();
	}

	public void checkSubcategories() {
		waitForElementClickable(driver, ProductsCatalogPageUI.SUBCATEGOGY_CHECKBOX);
		checkDefaultCheckboxRadio(driver, ProductsCatalogPageUI.SUBCATEGOGY_CHECKBOX);
	}

	public void selectManufacturerDropdown(String manufacturer) {
		waitForElementClickable(driver, ProductsCatalogPageUI.MANUFACTURER_DROPDOWN);
		selectItemDefaultDropdown(driver, ProductsCatalogPageUI.MANUFACTURER_DROPDOWN, manufacturer);
	}

	public void inputToGoProductSKUTextbox(String productSKU) {
		waitForElementVisible(driver, ProductsCatalogPageUI.PRODUCT_SKU_TEXTBOX);
		sendKeyToElement(driver, ProductsCatalogPageUI.PRODUCT_SKU_TEXTBOX, productSKU);
	}

	public void clickToGoButton() {
		waitForElementClickable(driver, ProductsCatalogPageUI.GO_SKU_BUTTON);
		clickToElement(driver, ProductsCatalogPageUI.GO_SKU_BUTTON);
		sleepInSecond(10);
	}

	public String getProductNameAtSKUPage() {
		waitForElementVisible(driver, ProductsCatalogPageUI.PRODUCT_NAME_TEXTBOX_AT_SKU_PAGE);
		return getWebElement(driver, ProductsCatalogPageUI.PRODUCT_NAME_TEXTBOX_AT_SKU_PAGE).getAttribute("value");
	}

}
