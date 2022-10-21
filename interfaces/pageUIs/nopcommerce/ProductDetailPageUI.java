package pageUIs.nopcommerce;

public class ProductDetailPageUI {

	//Input fields:
	public static final String ADD_YOUR_REVIEW = "xpath=//a[text()='Add your review']";
	public static final String ADD_TO_WISHLIST_BUTTON = "xpath=//button[@id='add-to-wishlist-button-4']";
	public static final String ADD_TO_CART_BUTTON = "xpath=//button[@id='add-to-cart-button-1']";
	public static final String ADD_TO_CART_SUCCESS_MESSAGE = "xpath=//div[@id='bar-notification']//p";
	public static final String CLOSE_BUTTON = "xpath=//button[@title='Close']";
	public static final String CLOSE_UPDATE_BUTTON = "xpath=//span[@title='Close']";
	public static final String UPDATE_BUTTON = "xpath=//button[@id='add-to-cart-button-1']";
	public static final String ADD_TO_WISHLIST_SUCCESS_MESSAGE = "xpath=//p[@class='content']";
	public static final String PROCESSOR_DROPDOWN = "xpath=//select[@id='product_attribute_1']";
	public static final String RAM_DROPDOWN = "xpath=//select[@id='product_attribute_2']";
	public static final String HDD_RADIO = "xpath=//dd[@id='product_attribute_input_3']//label[text()='%s']/preceding-sibling::input";
	public static final String OS_RADIO = "xpath=//dd[@id='product_attribute_input_4']//label[text()='%s']/preceding-sibling::input";
	public static final String SOFTWARE_CHECKBOX = "xpath=//dd[@id='product_attribute_input_5']//label[text()" +
			                                               "='%s']/preceding-sibling::input";

}
