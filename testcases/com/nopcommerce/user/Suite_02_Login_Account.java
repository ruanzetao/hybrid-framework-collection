package com.nopcommerce.user;

import commons.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.LoginPageObject;
import pageObjects.nopcommerce.PageGeneratorManager;
import pageObjects.nopcommerce.RegisterPageObject;

public class Suite_02_Login_Account extends BaseTest {

	//Collase code: Ctrl Shift -
	//Expanse code: Ctrl Shift +
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	String firstName = "Nguyen";
	String lastName = "XSang";
	String validEmail = "afcxansan" + generateFakeNumber() + "@mailinator.com";
	String validPassword = "Abc@123";

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		System.out.println("Browser name: " + browserName);
		getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
		//Generate an Account
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
	public void TC_01_Login_Empty_Data() {
		log.info("Step: click to Login link");
		loginPage = homePage.clickToLoginLink();
		log.info("Step: input to Email textbox");
		loginPage.inputToEmailTextbox("");
		log.info("Step: input to Password textbox");
		loginPage.inputToPasswordTextbox("");
		log.info("Step: click to Login button");
		loginPage.clickToLoginButton();
		log.info("Step: assert the Results");
		Assert.assertEquals(loginPage.getEmailErrorMessage(), "Please enter your email");
	}

	@Test
	public void TC_02_Login_Invalid_Email() {
		log.info("Step: click to Login link");
		loginPage = homePage.clickToLoginLink();
		String invalidEmail = "afcxansan" + generateFakeNumber() + "mailinator.com";
		log.info("Step: input to Email textbox" + invalidEmail);
		loginPage.inputToEmailTextbox(invalidEmail);
		log.info("Step: input to Password textbox" + validPassword);
		loginPage.inputToPasswordTextbox(validPassword);
		log.info("Step: click to Login button");
		loginPage.clickToLoginButton();
		log.info("Step: assert the Results");
		Assert.assertEquals(loginPage.getEmailErrorMessage(), "Wrong email");
	}

	@Test
	public void TC_03_Login_Not_Register_Account() {
		log.info("Step: click to Login link");
		loginPage = homePage.clickToLoginLink();
		String invalidEmail = "afcxansan" + generateFakeNumber() + "@mailinator.com";
		log.info("Step: input to Email textbox" + invalidEmail);
		loginPage.inputToEmailTextbox(invalidEmail);
		log.info("Step: input to Password textbox" + validPassword);
		loginPage.inputToPasswordTextbox(validPassword);
		log.info("Step: click to Login button");
		loginPage.clickToLoginButton();
		log.info("Step: assert the Results");
		Assert.assertEquals(loginPage.getSummaryErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void TC_04_Login_Existing_Email_Without_Password() {
		log.info("Step: click to Login link");
		loginPage = homePage.clickToLoginLink();
		log.info("Step: input to Email textbox" + validEmail);
		loginPage.inputToEmailTextbox(validEmail);
		log.info("Step: input to Password textbox");
		loginPage.inputToPasswordTextbox("");
		log.info("Step: click to Login button");
		loginPage.clickToLoginButton();
		log.info("Step: assert the Results");
		Assert.assertEquals(loginPage.getSummaryErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void TC_05_Login_Existing_Email_Wrong_Password() {
		log.info("Step: click to Login link");
		loginPage = homePage.clickToLoginLink();
		log.info("Step: input to Email textbox" + validEmail);
		loginPage.inputToEmailTextbox(validEmail);
		String wrongPassword = "123456";
		log.info("Step: input to Password textbox: " + wrongPassword);
		loginPage.inputToPasswordTextbox(wrongPassword);
		log.info("Step: click to Login button");
		loginPage.clickToLoginButton();
		log.info("Step: assert the Results");
		Assert.assertEquals(loginPage.getSummaryErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void TC_06_Valid_Email_Valid_Password() {
		log.info("Step: click to Login link");
		loginPage = homePage.clickToLoginLink();
		log.info("Step: input to Email textbox" + validEmail);
		loginPage.inputToEmailTextbox(validEmail);
		log.info("Step: input to Password textbox: " + validPassword);
		loginPage.inputToPasswordTextbox(validPassword);
		log.info("Step: click to Login button");
		loginPage.clickToLoginButton();
		log.info("Step: assert the Results");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

}
