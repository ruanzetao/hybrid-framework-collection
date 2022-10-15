package com.nopcommerce.user;

import commons.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.PageGeneratorManager;
import pageObjects.nopcommerce.RegisterPageObject;
import pageObjects.nopcommerce.SearchPageObject;

public class Suite_05_Search extends BaseTest {

	private HomePageObject homePage;
	private SearchPageObject searchPage;
	private RegisterPageObject registerPage;
	String firstName, lastName, validEmail, validPassword;

	@Parameters("browserName")
	@BeforeClass
	public void beforeClass(String browserName) {
		System.out.println("Browser name: " + browserName);
		getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
		//Generate test data
		firstName = "Nguyen";
		lastName = "Xsang";
		validEmail = getRandomEmail();
		validPassword = "Abc@123";
		log.info("Testcase: " + getClass().toString());
		registerPage = homePage.clickToRegisterLink();
		registerPage.clickToRegisterButton();
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		log.info("Step: Input to Email textbox: " + validEmail);
		registerPage.inputToEmailTextbox(validEmail);
		log.info("Step: Input to Password textbox: " + validPassword);
		registerPage.inputToPasswordTextbox(validPassword);
		log.info("Step: Input to ConfirmPassword textbox: " + validPassword);
		registerPage.inputToConfirmPasswordTextbox(validPassword);
		log.info("Step: click to Register button");
		registerPage.clickToRegisterButton();
		homePage = registerPage.clickToLogoutLink();
	}

	@Test
	public void TC_01_Search_Empty_Data() {
		log.info("Step: click to Search Hyperlink at Footer");
		searchPage = homePage.clickToFooterSearchLink();
		log.info("Step: enter Keywords to Search Keywords textbox");
		searchPage.inputToSearchKeywordsTextbox("");
		log.info("Step: click to Search button.");
		searchPage.clickToSearchButton();
		log.info("Step: verify the Result.");
		verifyEquals(searchPage.getSearchErrorMessage(), "Search term minimum length is 3 characters");
	}

	@Test
	public void TC_02_Search_Data_Not_Existed() {
		//init TCs
		driver.getTitle();
	}

	@Test
	public void TC_03_Search_Relative_Product_Name() {
		//init TCs
		driver.getTitle();
	}

	@Test
	public void TC_04_Search_Absolute_Product_Name() {
		//init TCs
		driver.getTitle();
	}

	@Test
	public void TC_05_Search_Advanced_Parent_Categories() {
		//init TCs
		driver.getTitle();
	}

	@Test
	public void TC_06_Search_Advanced_Sub_Categories() {
		//init TCs
		driver.getTitle();
	}

	@Test
	public void TC_07_Search_Advanced_Incorrect_Manufacturer() {
		//init TCs
		driver.getTitle();
	}

	@Test
	public void TC_08_Search_Advanced_Correct_Manufacturer() {
		//init TCs
		driver.getTitle();
	}
//	@AfterClass(alwaysRun = true)
//	public void afterClass() {
//		closeBrowserAndDriver();
//	}
}
