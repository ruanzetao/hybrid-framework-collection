package com.nopcommerce.user;

import commons.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopcommerce.*;

public class Suite_03_My_Account extends BaseTest {

	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private MyAccountPageObject myAccountPage;
	String firstName, lastName, validEmail, validPassword;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		System.out.println("Browser name: " + browserName);
		getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
		firstName = "Nguyen";
		lastName = "Xsang";
		validEmail = getRandomEmail();
		validPassword = "Abc@123";
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
		//Login with valid information:
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

	@Test
	public void TC_01_Update_Customer_Info() {
		myAccountPage = homePage.clickToMyAccountLink();
		myAccountPage.selectGenderRadio("Female");
		myAccountPage.inputToFirstNameTextbox("Automation");
		myAccountPage.inputToLastNameTextbox("FC");
		myAccountPage.selectDayDropdown("1");
		myAccountPage.selectMonthDropdown("January");
		myAccountPage.selectYearDropdown("1999");
		String randomEmail = getRandomEmail();
		System.out.println("Random email: " + randomEmail);
		myAccountPage.inputToEmailTextbox(randomEmail);
		myAccountPage.inputToCompanyName("Automation FC Company");
		log.info("Step: click to Save button");
		myAccountPage.clickToSaveButton();
	}

	@Test
	public void TC_02_Add_Address() {
	}

	@Test
	public void TC_03_Change_Password() {
	}

	@Test
	public void TC_04_My_Product_Reviews() {
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

}
