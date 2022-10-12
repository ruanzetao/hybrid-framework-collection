package pageUIs.nopcommerce;

public class BasePageUI {

	//Common Page Objects
	public static final String REGISTER_LINK = "xpath=//a[@class='ico-register']";
	public static final String LOGOUT_LINK = "xpath=//a[@class='ico-logout']";
	public static final String LOGIN_LINK = "xpath=//a[@class='ico-login']";
	public static final String MY_ACCOUNT_LINK = "xpath=//a[@class='ico-account']";
	//Pattern Objects
	public static final String DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA = "xpath=//div[contains(@class,'account-navigation')]//a[text()='%s']";
	public static final String DYNAMIC_TEXTBOX_BY_ID = "xpath=//input[@id='%s']";
	public static final String DYNAMIC_BUTTON_BY_TEXT = "xpath=//button[text()='%s']";
	public static final String DYNAMIC_DROPDOWN_BY_NAME = "xpath=//select[@name='%s']";
	public static final String DYNAMIC_RADIO_BUTTON_BY_LABEL = "xpath=//label[text()='%s']/preceding-sibling::input";
	public static final String DYNAMIC_CHECKBOX_BY_LABEL = "xpath=//label[contains(text(),'%s')]/following-sibling::input";
	public static final String DYNAMIC_PRODUCT_TYPE_BY_HEADER = "xpath=//ul[@class='top-menu notmobile']//li[a[text()" +
			                                                            "[normalize-space()='%s']]]//a[text()" +
			                                                            "[normalize-space()='%s']]";
	public static final String DYNAMIC_PRODUCT_BY_NAME = "xpath=//a[text()='%s']";
	public static final String PRODUCT_CATEGORY_LABEL_HEADER = "xpath=//ul[@class='top-menu notmobile']//a[text()" +
			                                                           "[normalize-space()='%s']]";

}
