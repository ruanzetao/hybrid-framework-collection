package pageObjects.nopcommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.nopcommerce.BasePageUI;
import pageUIs.nopcommerce.ProductByTypePageUI;

import java.util.ArrayList;
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
		sleepInSecond(3);
	}

	public boolean isListProductsAToZ() {
		boolean checkTrue = true;
		List<WebElement> allProducts = getListWebElement(driver, ProductByTypePageUI.PRODUCT_TITLES);
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
		List<WebElement> allProducts = getListWebElement(driver, ProductByTypePageUI.PRODUCT_TITLES);
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

	public boolean isListProductsPriceLowToHigh() {
		boolean checkTrue = true;
		List<WebElement> allProducts = getListWebElement(driver, ProductByTypePageUI.PRODUCT_PRICES);
		ArrayList<Float> newPrices = removeSpecialCharactersInString(allProducts);
		for (int index = 0; index < newPrices.size() - 1; index++) {
			if (newPrices.get(index) < newPrices.get(index + 1)) {
				return checkTrue = true;
			} else if (newPrices.get(index) == newPrices.get(index + 1)) {
				return checkTrue = true;
			} else {
				checkTrue = false;
				break;
			}
		}
		return checkTrue;
	}

	public boolean isListProductsPriceHighToLow() {
		boolean checkTrue = true;
		List<WebElement> allProducts = getListWebElement(driver, ProductByTypePageUI.PRODUCT_PRICES);
		ArrayList<Float> newPrices = removeSpecialCharactersInString(allProducts);
		for (int index = 0; index > newPrices.size() - 1; index++) {
			if (newPrices.get(index) > newPrices.get(index + 1)) {
				return checkTrue = true;
			} else if (newPrices.get(index) == newPrices.get(index + 1)) {
				return checkTrue = true;
			} else {
				checkTrue = false;
				break;
			}
		}
		return checkTrue;
	}

	public ArrayList<Float> removeSpecialCharactersInString(List<WebElement> allProducts) {
		ArrayList<Float> newList = new ArrayList<>();
		for (int index = 0; index < allProducts.size() - 1; index++) {
			System.out.println("Before text: " + allProducts.get(index).getText() + " Index: " + index);
			String cleanPrice = allProducts.get(index).getText();
			cleanPrice = cleanPrice.replace("$", "").replace(",", "");
//			cleanPrice = cleanPrice.replace(",", "");
//			Float floatCleanPrice = Float.parseFloat(cleanPrice);
			System.out.println("Clean price: " + cleanPrice);
			newList.add(Float.parseFloat(cleanPrice));
		}
		return newList;
	}

	public void selectDisplayDropdown(String number) {
		waitForElementClickable(driver, ProductByTypePageUI.DISPLAY_DROPDOWN);
		selectItemDefaultDropdown(driver, ProductByTypePageUI.DISPLAY_DROPDOWN, number);
		sleepInSecond(3);
	}

	public boolean isDisplayNumberItemPerPage(int number) {
		List<WebElement> allProduct = getListWebElement(driver, ProductByTypePageUI.PRODUCT_TITLES);
		System.out.println("Size: " + allProduct.size());
		return allProduct.size() == number;
		//update something
	}

}
