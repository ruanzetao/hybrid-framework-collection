package pageObjects.nopcommerce.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.nopcommerce.user.SearchPageUI;

import java.util.List;

public class SearchPageObject extends BasePage {

	private WebDriver driver;

	public SearchPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToSearchKeywordsTextbox(String keywords) {
		waitForElementVisible(driver, SearchPageUI.SEARCH_KEYWORD_TEXTBOX);
		sendKeyToElement(driver, SearchPageUI.SEARCH_KEYWORD_TEXTBOX, keywords);
	}

	public void clickToSearchButton() {
		waitForElementClickable(driver, SearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, SearchPageUI.SEARCH_BUTTON);
	}

	public String getSearchErrorMessage() {
		waitForElementVisible(driver, SearchPageUI.SEARCH_ERROR_MESSAGE);
		return getWebElement(driver, SearchPageUI.SEARCH_ERROR_MESSAGE).getText();
	}

	public String getSearchNoResultErrorMessage() {
		waitForElementVisible(driver, SearchPageUI.SEARCH_NO_RESULT_ERROR_MESSAGE);
		return getWebElement(driver, SearchPageUI.SEARCH_NO_RESULT_ERROR_MESSAGE).getText();
	}

	public boolean isReturnedProductsContainsKeyword(String keyword) {
		boolean checkTrue = true;
		List<WebElement> returnedProducts = getListWebElement(driver, SearchPageUI.RETURNED_PRODUCT_TITLE);
		System.out.println("Total of Returned Products list: " + returnedProducts.size());
		for (WebElement product : returnedProducts) {
			if (product.getText().toLowerCase().contains(keyword.toLowerCase())) {
				checkTrue = true;
			} else {
				checkTrue = false;
				break;
			}
		}
		return checkTrue;
	}

	public boolean isReturnedProductsContainsKeywordCaseSensitive(String keyword) {
		boolean checkTrue = true;
		List<WebElement> returnedProducts = getListWebElement(driver, SearchPageUI.RETURNED_PRODUCT_TITLE);
		System.out.println("Total of Returned Products list: " + returnedProducts.size());
		for (WebElement product : returnedProducts) {
			if (product.getText().contains(keyword)) {
				checkTrue = true;
			} else {
				checkTrue = false;
				break;
			}
		}
		return checkTrue;
	}

	public void checkToAdvancedSearchCheckbox() {
		waitForElementClickable(driver, SearchPageUI.ADVANCED_SEARCH_CHECKBOX);
		checkDefaultCheckboxRadio(driver, SearchPageUI.ADVANCED_SEARCH_CHECKBOX);
	}

	public void selectCategoryDropdown(String category) {
		waitForElementClickable(driver, SearchPageUI.CATEGORY_DROPDOWN);
		selectItemDefaultDropdown(driver, SearchPageUI.CATEGORY_DROPDOWN, category);
	}

	public void checkToAutomaticSearchSubCategory() {
		waitForElementClickable(driver, SearchPageUI.AUTOMATIC_SEARCH_SUB_CATEGORIES_CHECKBOX);
		checkDefaultCheckboxRadio(driver, SearchPageUI.AUTOMATIC_SEARCH_SUB_CATEGORIES_CHECKBOX);
	}

	public void selectManufacturerDropdown(String manufacturer) {
		waitForElementClickable(driver, SearchPageUI.MANUFACTURER_DROPDOWN);
		selectItemDefaultDropdown(driver, SearchPageUI.MANUFACTURER_DROPDOWN, manufacturer);
	}

}
