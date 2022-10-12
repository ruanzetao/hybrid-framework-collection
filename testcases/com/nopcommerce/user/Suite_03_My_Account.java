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
	private AddressesPageObject addressPage;
	private ChangePasswordPageObject changePasswordPage;
	private ProductByTypePageObject productByTypePage;
	private ProductDetailPageObject productDetailPage;
	private ProductReviewsPageObject productReviewsPage;
	String firstName, lastName, validEmail, validPassword, newPassword;

	@Parameters("browserName")
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
		log.info("Step: open My Account menu: Addresses");
		myAccountPage.openMyAccountMenuByName(driver, "Addresses");
		log.info("Step: change driver to Addresses page");
		addressPage = PageGeneratorManager.getAddressesPage(driver);
		log.info("Step: click to Add New button");
		addressPage.clickToAddNewButton();
		log.info("Step: input to required Fields");
		addressPage.inputToFirstNameTextbox("Automation");
		addressPage.inputToLastNameTextbox("FC");
		addressPage.inputToEmailTextbox(validEmail);
		addressPage.inputToCompanyTextbox("Company FC");
		addressPage.selectCountryDropdown("Viet Nam");
		addressPage.selectStateDropdown("Other");
		addressPage.inputToCityTextbox("City");
		addressPage.inputToAddress1Textbox("Address 1");
		addressPage.inputToAddress2Textbox("Address 2");
		addressPage.inputToZipPostalTextbox("700000");
		addressPage.inputToPhoneNumberTextbox("0932658717");
		addressPage.inputToFaxNumberTextbox("1111658717");
		log.info("Step: click to Save button");
		addressPage.clickToSaveButton();
		log.info("Step: assert the Results");
	}
//	@Test
//	public void TC_03_Change_Password() {
//		log.info("Step: open My Account menu: Change Password");
//		myAccountPage.openMyAccountMenuByName(driver, "Change password");
//		changePasswordPage = PageGeneratorManager.getChangePasswordPage(driver);
//		log.info("Step: input to mandatory Fields");
//		changePasswordPage.inputToOldPassword(validPassword);
//		newPassword = "Abc@124";
//		changePasswordPage.inputToNewPassword(newPassword);
//		changePasswordPage.inputToConfirmPassword(newPassword);
//		changePasswordPage.clickToChangePasswordButton();
//		changePasswordPage.clickToCloseButton();
//		log.info("Step: Logout and Login again");
//		homePage = changePasswordPage.clickToLogoutLink(driver);
//		loginPage = homePage.clickToLoginLink(driver);
//		log.info("Step: Login with Old Password.");
//		loginPage.inputToEmailTextbox(validEmail);
//		loginPage.inputToPasswordTextbox(validPassword);
//		log.info("Step: assert the Results");
//		log.info("Step: Login with New Password.");
//		loginPage.refreshCurrentPage(driver);
//		loginPage.inputToEmailTextbox(validEmail);
//		loginPage.inputToPasswordTextbox(newPassword);
//		log.info("Step: assert the Results");
//	}

	//Category > Prod Type > Product
	@Test
	public void TC_04_My_Product_Reviews() {
		log.info("Step: hover on Product Category.");
		addressPage.hoverOnProductCategoryByHeader("Computers");
		log.info("Step: select Product Type by Header");
		productByTypePage = homePage.selectProductTypeByHeader("Computers", "Desktops");
		log.info("Step: select Product by Name");
		productDetailPage = productByTypePage.clickToProductNameLink("Lenovo IdeaCentre 600 All-in-One PC");
		log.info("Step: click to Add your review button.");
		productReviewsPage = productDetailPage.clickToAddYourReviewLink();
		log.info("Step: input to madatory Fields.");
		productReviewsPage.inputToReviewTitle("Title Title");
		productReviewsPage.inputToReviewText("Review Text 1111");
//		productReviewsPage.selectRating("ratingValue");
//		productReviewsPage.clickToSubmitReviewButton();
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

}
