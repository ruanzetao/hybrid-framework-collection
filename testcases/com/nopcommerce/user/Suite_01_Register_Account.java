package com.nopcommerce.user;

import commons.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.PageGeneratorManager;
import pageObjects.nopcommerce.RegisterPageObject;

@Epic("Regression test")
@Feature("Register Account")
public class Suite_01_Register_Account extends BaseTest {

	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	//Generate a valid account
	String firstName = "Nguyen";
	String lastName = "XSang";
	String validEmail = "selenium" + generateFakeNumber() + "@mailinator.com";
	String validPassword = "Abc@123";
	@BeforeSuite
	public void deleteAllFilesInAllureFolder(){
		String folder="allure-results";
		System.out.println("----Start deleting Files in Allure Report----");
		deleteAllFilesInFolder(folder);
		System.out.println("----End deleting Files in Allure Report----");
	}
	@Parameters("browserName")
	@BeforeClass
	public void beforeClass(String browserName) {
		System.out.println("Browser name: " + browserName);
		getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Description("Register Account with Empty data")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC_01_Register_Empty_Data() {
		log.info("Step: click to Register Link");
		registerPage = homePage.clickToRegisterLink();
		log.info("Step: click to Register button");
		registerPage.clickToRegisterButton();
		log.info("Step: Assert the results");
		Assert.assertEquals(registerPage.getFirstNameErrorMessage(), "First name is required.");
		Assert.assertEquals(registerPage.getLastNameErrorMessage(), "Last name is required.");
		Assert.assertEquals(registerPage.getEmailErrorMessage(), "Email is required.");
		Assert.assertEquals(registerPage.getPasswordErrorMessage(), "Password is required.");
		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), "Password is required.");
	}
	@Description("Register Account with invalid Email")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC_02_Register_Invalid_Email() {
		log.info("Step: click to Register Link");
		registerPage = homePage.clickToRegisterLink();
		log.info("Step: click to Register button");
		registerPage.clickToRegisterButton();
		log.info("Step: input to all required Fields");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox("XSang");
		//Missing @ at email
		String invalidEmail = "seleniumonline" + generateFakeNumber() + "mailinator.com";
		log.info("Step: Input invalid Email: "+invalidEmail);
		registerPage.inputToEmailTextbox(invalidEmail);
		registerPage.inputToPasswordTextbox("Abc@123");
		registerPage.inputToConfirmPasswordTextbox("Abc@123");
		log.info("Step: Assert the results");
		Assert.assertEquals(registerPage.getEmailErrorMessage(), "Wrong email");
	}
	@Description("Register Account with valid Email")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC_03_Register_Valid_Information() {
		log.info("Step: click to Register Link");
		registerPage = homePage.clickToRegisterLink();
		log.info("Step: click to Register button");
		registerPage.clickToRegisterButton();
		log.info("Step: input to all required Fields");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		log.info("Step: input valid Email address: "+validEmail);
		registerPage.inputToEmailTextbox(validEmail);
		registerPage.inputToPasswordTextbox(validPassword);
		registerPage.inputToConfirmPasswordTextbox(validPassword);
		log.info("Step: click to Register button");
		registerPage.clickToRegisterButton();
		log.info("Step: Assert the results");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		log.info("Step: click to Logout button");
		homePage = registerPage.clickToLogoutLink();
	}

	@Description("Register with Existing email")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC_04_Register_Existing_Email() {
		registerPage = homePage.clickToRegisterLink();
		registerPage.clickToRegisterButton();
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		log.info("Step: input existing Email to Email textbox: " + validEmail);
		registerPage.inputToEmailTextbox(validEmail);
		registerPage.inputToPasswordTextbox(validPassword);
		registerPage.inputToConfirmPasswordTextbox(validPassword);
		log.info("Step: input to Register button");
		registerPage.clickToRegisterButton();
		log.info("Step: assert the Results");
		Assert.assertEquals(registerPage.getExistingEmailErrorMessage(), "The specified email already exists");
	}
	@Description("Register with Password less than 6 chars")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC_05_Register_Password_Less_Than_6_Chars() {
		log.info("Testcase: " + getClass().toString());
		registerPage = homePage.clickToRegisterLink();
		registerPage.clickToRegisterButton();
		log.info("Step: input to all required Fields");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		//Missing @ at email
		registerPage.inputToEmailTextbox("seleniumonline" + generateFakeNumber() + "@mailinator.com");
		String invalidPassword = "1235";
		log.info("Input to Password textbox: " + invalidPassword);
		registerPage.inputToPasswordTextbox(invalidPassword);
		registerPage.inputToConfirmPasswordTextbox(invalidPassword);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getPasswordErrorMessage(), "Password must meet the following rules:\nmust have at least 6 characters");
	}
	@Description("Register with invalid Confirm Password")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC_06_Register_Invalid_Confirm_Password() {
		log.info("Step: click to Register link");
		registerPage = homePage.clickToRegisterLink();
		log.info("Step: click to Register button");
		registerPage.clickToRegisterButton();
		log.info("Step: input to all require Fields");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		//Missing @ at email
		registerPage.inputToEmailTextbox("seleniumonline" + generateFakeNumber() + "@mailinator.com");
		String invalidPassword = "1235";
		registerPage.inputToPasswordTextbox(invalidPassword);
		log.info("Step: input to ConfirmPassword textbox");
		registerPage.inputToConfirmPasswordTextbox("Abc@123");
		log.info("Step: click to Register button.");
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), "The password and confirmation password do not match.");
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

}
