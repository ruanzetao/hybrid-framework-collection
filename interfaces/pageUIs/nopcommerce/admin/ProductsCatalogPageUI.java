package pageUIs.nopcommerce.admin;

public class ProductsCatalogPageUI {

	//Input fields:
	public static final String PRODUCT_NAME_TEXTBOX = "xpath=//input[@id='SearchProductName']";
	public static final String PRODUCT_SKU_TEXTBOX = "xpath=//input[@id='GoDirectlyToSku']";
	public static final String CATEGORY_DROPDOWN = "xpath=//select[@id='SearchCategoryId']";
	public static final String MANUFACTURER_DROPDOWN = "xpath=//select[@id='SearchManufacturerId']";
	public static final String SUBCATEGOGY_CHECKBOX = "xpath=//input[@id='SearchIncludeSubCategories']";
	public static final String RETURNED_MESSAGE = "xpath=//td[@class='dataTables_empty']";
	public static final String SEARCH_BUTTON = "xpath=//button[@id='search-products']";
	public static final String GO_SKU_BUTTON = "xpath=//button[@id='go-to-product-by-sku']";
	public static final String LEARN_MORE = "xpath=//span[text()='Learn more about ']";
	public static final String RETURNED_PRODUCTS_NAME = "xpath=//th[text()='Product name']/ancestor::div[@id='products-grid_wrapper']//td[3]";
	//Product SKU Page:
	public static final String PRODUCT_NAME_TEXTBOX_AT_SKU_PAGE = "xpath=//input[@id='Name']";

}
