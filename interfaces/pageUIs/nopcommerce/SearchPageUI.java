package pageUIs.nopcommerce;

public class SearchPageUI {

	//Input fields:
	public static final String MY_ACCOUNT_LINK = "xpath=//a[@class='ico-account']";
	public static final String SEARCH_KEYWORD_TEXTBOX = "xpath=//input[@class='search-text' and @id='q']";
	public static final String SEARCH_BUTTON = "xpath=//div[@class='page-body']//button[@type='submit' and text()='Search']";
	public static final String SEARCH_ERROR_MESSAGE = "xpath=//div[@class='search-results']//div[@class='warning']";
	public static final String SEARCH_NO_RESULT_ERROR_MESSAGE = "xpath=//div[@class='no-result']";
	public static final String RETURNED_PRODUCT_TITLE = "xpath=//div[@class='search-results']//h2[@class='product-title']//a";
	public static final String ADVANCED_SEARCH_CHECKBOX = "xpath=//label[text()='Advanced search' and @for='advs']";
	public static final String AUTOMATIC_SEARCH_SUB_CATEGORIES_CHECKBOX = "xpath=//label[text()='Automatically search sub categories' and @for='isc']";
	public static final String CATEGORY_DROPDOWN = "xpath=//select[@id='cid']";
	public static final String MANUFACTURER_DROPDOWN = "xpath=//select[@id='mid']";

}
