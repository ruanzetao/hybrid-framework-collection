package pageUIs.nopcommerce.admin;

public class CustomersCustomersPageUI {

	//Input fields:
	public static final String ADD_NEW_BUTTON = "xpath=//a[@class='btn btn-primary']";
	public static final String SEARCH_BUTTON = "xpath=//button[@id='search-customers']";
	public static final String EMAIL_SEARCH_TEXTBOX = "xpath=//input[@id='SearchEmail']";
	public static final String FIRST_NAME_TEXTBOX = "xpath=//input[@id='SearchFirstName']";
	public static final String LAST_NAME_TEXTBOX = "xpath=//input[@id='SearchLastName']";
	public static final String COMPANY_NAME_TEXTBOX = "xpath=//input[@id='SearchCompany']";
	public static final String RETURNED_CUSTOMERS_BY_EMAIL = "xpath=//tbody/tr/td[2]";
	public static final String RETURNED_CUSTOMERS_BY_NAME = "xpath=//tbody/tr/td[3]";
	public static final String RETURNED_CUSTOMERS_BY_COMPANY = "xpath=//tbody/tr/td[4]";
	//Add New page:
	public static final String CUSTOMER_INFO_AREA = "xpath=//div[@class='card-title']";
	public static final String EMAIL_TEXTBOX_ADD_NEW = "xpath=//input[@id='Email']";
	public static final String PASSWORD_TEXTBOX_ADD_NEW = "xpath=//input[@id='Password']";
	public static final String FIRST_NAME_TEXTBOX_ADD_NEW = "xpath=//input[@id='FirstName']";
	public static final String LAST_NAME_TEXTBOX_ADD_NEW = "xpath=//input[@id='LastName']";
	public static final String COMPANY_NAME_TEXTBOX_ADD_NEW = "xpath=//input[@id='Company']";
	public static final String ADMIN_COMMENT_TEXTBOX_ADD_NEW = "xpath=//textarea[@id='AdminComment']";
	public static final String ACTIVE_CHECKBOX_ADD_NEW = "xpath=//input[@id='Active']";
	public static final String DATE_OF_BIRTH_PICKER_ADD_NEW = "xpath=//input[@id='DateOfBirth']";
	public static final String SAVE_AND_CONTINUE_ADD_NEW = "xpath=//button[@name='save-continue']";
	public static final String GENDER_RADIO_ADD_NEW = "xpath=//input[@name='Gender']/following-sibling::label[text()[normalize-space()='%s']]";

}
