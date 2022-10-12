package pageUIs.nopcommerce;

public class ProductReviewsPageUI {

	//Input fields:
	public static final String REVIEW_TITLE_TEXTBOX = "xpath=//label[text()='Review title:']/following-sibling::input[@id='AddProductReview_Title']";
	public static final String REVIEW_TEXT_TEXTBOX = "xpath=//label[text()='Review " +
			                                                 "text:']/following-sibling::textarea[@id='AddProductReview_ReviewText']";
	public static final String SUBMIT_REVIEW_BUTTON = "xpath=//button[text()='Submit review']";

}
