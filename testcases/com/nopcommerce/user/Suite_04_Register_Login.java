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

public class Suite_04_Register_Login extends BaseTest {

	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	String firstName = "Nguyen";
	String lastName = "XSang";
	String validEmail = "seleniumonline" + generateFakeNumber() + "@mailinator.com";
	String validPassword = "Abc@123";

	@Parameters("browserName")
	@BeforeClass
	public void beforeClass(String browserName) {
		System.out.println("Browser name: " + browserName);
		getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
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
	public void TC_06_Login_Valid_Email_Valid_Password() {
		log.info("Step: click to Login link");
		loginPage = homePage.clickToLoginLink();
		log.info("Step: input to Email textbox: " + validEmail);
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
