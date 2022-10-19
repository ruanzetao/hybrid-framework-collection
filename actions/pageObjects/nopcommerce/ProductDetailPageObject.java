package pageObjects.nopcommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
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

}
