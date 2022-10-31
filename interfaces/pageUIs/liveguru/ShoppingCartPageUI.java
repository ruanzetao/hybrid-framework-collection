package pageUIs.liveguru;

public class ShoppingCartPageUI {

	//Input fields:
	public static final String MY_ACCOUNT_LINK = "xpath=//a[@class='ico-account']";
	public static final String DISCOUNT_CODES_TEXTBOX = "xpath=//input[@id='coupon_code']";
	public static final String APPLY_BUTTON = "xpath=//button//span[text()='Apply']";
	public static final String DISCOUNT_VALUE_LABEL = "xpath=//td[contains(text(),'Discount')]/following-sibling::td/span";
	public static final String GRAND_TOTAL_DISCOUNTED_PRICE_LABEL = "xpath=//td/strong[contains(text(),'Grand Total')]/ancestor::tr//span";

}
