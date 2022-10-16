package pageUIs.nopcommerce;

public class SearchPageUI {

	//Input fields:
	public static final String MY_ACCOUNT_LINK = "xpath=//a[@class='ico-account']";
	public static final String SEARCH_KEYWORD_TEXTBOX = "xpath=//input[@class='search-text' and @id='q']";
	public static final String SEARCH_BUTTON = "xpath=//div[@class='page-body']//button[@type='submit' and text()='Search']";
	public static final String SEARCH_ERROR_MESSAGE = "xpath=//div[@class='search-results']//div[@class='warning']";
	public static final String SEARCH_NO_RESULT_ERROR_MESSAGE = "xpath=//div[@class='no-result']";
	public static final String RETURNED_PRODUCT_TITLE = "xpath=//div[@class='search-results']//h2[@class='product-title']//a";

}
