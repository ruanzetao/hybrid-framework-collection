package com.nopcommerce.user;

import commons.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.PageGeneratorManager;
import pageObjects.nopcommerce.RegisterPageObject;
import utilities.DataHelper;

public class Suite_01_Register_Account_Faker extends BaseTest {

	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private DataHelper dataFaker;
	//Generate a valid account
	String firstName, lastName, validEmail, validPassword;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		System.out.println("Browser name: " + browserName);
		getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
		dataFaker = DataHelper.getDataHelper();
		firstName = dataFaker.getFirstName();
		lastName = dataFaker.getLastName();
		validEmail = dataFaker.getEmailAddress();
		validPassword = dataFaker.getPassword();
	}

	@Test
	public void TC_01_Register_Empty_Data() {
		log.info("Testcase: " + getClass().toString());
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

	@Test
	public void TC_02_Register_Invalid_Email() {
		log.info("Testcase: " + getClass().toString());
		log.info("Step: click to Register Link");
		registerPage = homePage.clickToRegisterLink();
		log.info("Step: click to Register button");
		registerPage.clickToRegisterButton();
		log.info("Step: Input to FirstName textbox: " + firstName);
		registerPage.inputToFirstNameTextbox(firstName);
		log.info("Step: Input to LastName textbox: " + lastName);
		registerPage.inputToLastNameTextbox("XSang");
		//Missing @ at email
		String invalidEmail = "seleniumonline" + generateFakeNumber() + "mailinator.com";
		log.info("Step: Input to Email textbox: " + invalidEmail);
		registerPage.inputToEmailTextbox(invalidEmail);
		log.info("Step: Input to Password textbox");
		registerPage.inputToPasswordTextbox("Abc@123");
		log.info("Step: Input to ConfirmPassword textbox");
		registerPage.inputToConfirmPasswordTextbox("Abc@123");
		log.info("Step: Assert the results");
		Assert.assertEquals(registerPage.getEmailErrorMessage(), "Wrong email");
	}

	@Test
	public void TC_03_Register_Valid_Information() {
		log.info("Testcase: " + getClass().toString());
		log.info("Step: click to Register Link");
		registerPage = homePage.clickToRegisterLink();
		log.info("Step: click to Register button");
		registerPage.clickToRegisterButton();
		log.info("Step: Input to FirstName textbox: " + firstName);
		registerPage.inputToFirstNameTextbox(firstName);
		log.info("Step: Input to LastName textbox: " + lastName);
		registerPage.inputToLastNameTextbox(lastName);
		log.info("Step: Input to Email textbox: " + validEmail);
		registerPage.inputToEmailTextbox(validEmail);
		log.info("Step: Input to Password textbox: " + validPassword);
		registerPage.inputToPasswordTextbox(validPassword);
		log.info("Step: Input to ConfirmPassword textbox: " + validPassword);
		registerPage.inputToConfirmPasswordTextbox(validPassword);
		log.info("Step: click to Register button");
		registerPage.clickToRegisterButton();
		log.info("Step: Assert the results");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		log.info("Step: click to Logout button");
		homePage = registerPage.clickToLogoutLink();
	}

	@Test
	public void TC_04_Register_Existing_Email() {
		log.info("Testcase: " + getClass().toString());
		registerPage = homePage.clickToRegisterLink();
		registerPage.clickToRegisterButton();
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		log.info("Input to Email textbox: " + validEmail);
		registerPage.inputToEmailTextbox(validEmail);
		registerPage.inputToPasswordTextbox(validPassword);
		registerPage.inputToConfirmPasswordTextbox(validPassword);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getExistingEmailErrorMessage(), "The specified email already exists");
	}

	@Test
	public void TC_05_Register_Password_Less_Than_6_Chars() {
		log.info("Testcase: " + getClass().toString());
		registerPage = homePage.clickToRegisterLink();
		registerPage.clickToRegisterButton();
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

	@Test
	public void TC_06_Register_Invalid_Confirm_Password() {
		log.info("Testcase: " + getClass().toString());
		registerPage = homePage.clickToRegisterLink();
		registerPage.clickToRegisterButton();
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		//Missing @ at email
		registerPage.inputToEmailTextbox("seleniumonline" + generateFakeNumber() + "@mailinator.com");
		String invalidPassword = "1235";
		registerPage.inputToPasswordTextbox(invalidPassword);
		log.info("Input to ConfirmPassword textbox");
		registerPage.inputToConfirmPasswordTextbox("Abc@123");
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), "The password and confirmation password do not match.");
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

}
