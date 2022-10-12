package pageObjects.nopcommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopcommerce.ProductReviewsPageUI;

public class ProductReviewsPageObject extends BasePage {

	private WebDriver driver;

	public ProductReviewsPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToReviewTitle(String title) {
		waitForElementVisible(driver, ProductReviewsPageUI.REVIEW_TITLE_TEXTBOX);
		sendKeyToElement(driver, ProductReviewsPageUI.REVIEW_TITLE_TEXTBOX, title);
	}

	public void inputToReviewText(String reviewText) {
		waitForElementVisible(driver, ProductReviewsPageUI.REVIEW_TEXT_TEXTBOX);
		sendKeyToElement(driver, ProductReviewsPageUI.REVIEW_TEXT_TEXTBOX, reviewText);
	}

	public void clickToSubmitReviewButton() {
		waitForElementClickable(driver, ProductReviewsPageUI.SUBMIT_REVIEW_BUTTON);
		clickToElement(driver, ProductReviewsPageUI.SUBMIT_REVIEW_BUTTON);
	}

}
