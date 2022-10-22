package pageObjects.nopcommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopcommerce.BasePageUI;
import pageUIs.nopcommerce.ProductDetailPageUI;

public class ProductDetailPageObject extends BasePage {

	private WebDriver driver;

	public ProductDetailPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public ProductReviewsPageObject clickToAddYourReviewLink() {
		waitForElementClickable(driver, ProductDetailPageUI.ADD_YOUR_REVIEW);
		clickToElement(driver, ProductDetailPageUI.ADD_YOUR_REVIEW);
		return PageGeneratorManager.getProductReviewsPage(driver);
	}

	public void clickToAddToWishlistButton() {
		waitForElementClickable(driver, ProductDetailPageUI.ADD_TO_WISHLIST_BUTTON);
		clickToElement(driver, ProductDetailPageUI.ADD_TO_WISHLIST_BUTTON);
	}

	public String getAddToWishlistSuccessMessage() {
		waitForElementVisible(driver, ProductDetailPageUI.ADD_TO_WISHLIST_SUCCESS_MESSAGE);
		return getWebElement(driver, ProductDetailPageUI.ADD_TO_WISHLIST_SUCCESS_MESSAGE).getText();
	}

	public void selectProcessorDropdown(String processorValue) {
		waitForElementClickable(driver, ProductDetailPageUI.PROCESSOR_DROPDOWN);
		selectItemDefaultDropdown(driver, ProductDetailPageUI.PROCESSOR_DROPDOWN, processorValue);
	}

	public void selectRamDropdown(String ramValue) {
		waitForElementClickable(driver, ProductDetailPageUI.RAM_DROPDOWN);
		selectItemDefaultDropdown(driver, ProductDetailPageUI.RAM_DROPDOWN, ramValue);
	}

	public void selectHDDRadio(String HddValue) {
		waitForElementClickable(driver, ProductDetailPageUI.HDD_RADIO, HddValue);
		checkDefaultCheckboxRadio(driver, ProductDetailPageUI.HDD_RADIO, HddValue);
	}

	public void selectOSRadio(String OSValue) {
		waitForElementClickable(driver, ProductDetailPageUI.OS_RADIO, OSValue);
		checkDefaultCheckboxRadio(driver, ProductDetailPageUI.OS_RADIO, OSValue);
	}

	public void selectSoftwareCheckbox(String softwareValue) {
		waitForElementClickable(driver, ProductDetailPageUI.SOFTWARE_CHECKBOX, softwareValue);
		checkDefaultCheckboxRadio(driver, ProductDetailPageUI.SOFTWARE_CHECKBOX, softwareValue);
	}

	public void clickToAddToCartButton() {
		waitForElementClickable(driver, ProductDetailPageUI.ADD_TO_CART_BUTTON);
		clickToElement(driver, ProductDetailPageUI.ADD_TO_CART_BUTTON);
//		waitForElementInvisible(driver, ProductDetailPageUI.CLOSE_BUTTON);
	}

	public void clickToCloseButton() {
		waitForElementClickable(driver, ProductDetailPageUI.CLOSE_BUTTON);
		clickToElement(driver, ProductDetailPageUI.CLOSE_BUTTON);
		waitForElementInvisible(driver, ProductDetailPageUI.CLOSE_BUTTON);
	}

	public String isAddToCartSuccessMessageDisplayed() {
		waitForElementVisible(driver, ProductDetailPageUI.ADD_TO_CART_SUCCESS_MESSAGE);
		return getWebElement(driver, ProductDetailPageUI.ADD_TO_CART_SUCCESS_MESSAGE).getText();
	}

	public ShoppingCartPageObject selectShoppingCartLink() {
		waitForElementClickable(driver, BasePageUI.SHOPPING_CART_LINK);
		clickToElement(driver, BasePageUI.SHOPPING_CART_LINK);
		return PageGeneratorManager.getShoppingCartPage(driver);
	}

	public void clickToUpdateButton() {
		waitForElementClickable(driver, ProductDetailPageUI.UPDATE_BUTTON);
		clickToElement(driver, ProductDetailPageUI.UPDATE_BUTTON);
	}

	public void clickToCloseUpdateButton() {
		waitForElementClickable(driver, ProductDetailPageUI.CLOSE_UPDATE_BUTTON);
		clickToElement(driver, ProductDetailPageUI.CLOSE_UPDATE_BUTTON);
		waitForElementInvisible(driver, ProductDetailPageUI.CLOSE_UPDATE_BUTTON);
	}

	public void waitForNotificationBarDisappeared() {
		waitForElementInvisible(driver, ProductDetailPageUI.CLOSE_BUTTON);
	}

}
