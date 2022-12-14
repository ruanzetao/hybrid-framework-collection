package com.nopcommerce.user;

import commons.BaseTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopcommerce.user.HomePageObject;
import pageObjects.nopcommerce.user.PageGeneratorManager;
import pageObjects.nopcommerce.user.RegisterPageObject;
import pageObjects.nopcommerce.user.SearchPageObject;

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
		log.info("Step: click to Search Hyperlink at Footer");
		searchPage = homePage.clickToFooterSearchLink();
		log.info("Step: enter Keywords to Search Keywords textbox");
		searchPage.inputToSearchKeywordsTextbox("Macbook Pro 2050");
		log.info("Step: click to Search button.");
		searchPage.clickToSearchButton();
		log.info("Step: verify the Result.");
		verifyEquals(searchPage.getSearchNoResultErrorMessage(), "No products were found that matched your criteria.");
	}

	@Test
	public void TC_03_Search_Relative_Product_Name() {
		String keyword = "Lenovo";
		System.out.println("Keyword: " + keyword);
		//init TCs
		log.info("Step: click to Search Hyperlink at Footer");
		searchPage = homePage.clickToFooterSearchLink();
		log.info("Step: enter Keywords to Search Keywords textbox");
		searchPage.inputToSearchKeywordsTextbox(keyword);
		log.info("Step: click to Search button.");
		searchPage.clickToSearchButton();
		log.info("Step: verify the Result contains Keyword.");
		verifyTrue(searchPage.isReturnedProductsContainsKeyword(keyword));
	}

	@Test
	public void TC_04_Search_Absolute_Product_Name() {
		String keyword = "Thinkpad X1 Carbon";
		System.out.println("Keyword: " + keyword);
		//init TCs
		log.info("Step: click to Search Hyperlink at Footer");
		searchPage = homePage.clickToFooterSearchLink();
		log.info("Step: enter Keywords to Search Keywords textbox");
		searchPage.inputToSearchKeywordsTextbox(keyword);
		log.info("Step: click to Search button.");
		searchPage.clickToSearchButton();
		log.info("Step: verify the Result contains Keyword.");
		verifyTrue(searchPage.isReturnedProductsContainsKeyword(keyword));
	}

	@Test
	public void TC_05_Search_Advanced_Parent_Categories() {
		String keyword = "Apple Macbook Pro";
		System.out.println("Keyword: " + keyword);
		//init TCs
		log.info("Step: click to Search Hyperlink at Footer");
		searchPage = homePage.clickToFooterSearchLink();
		log.info("Step: enter Keywords to Search Keywords textbox");
		searchPage.inputToSearchKeywordsTextbox(keyword);
		searchPage.checkToAdvancedSearchCheckbox();
		searchPage.selectCategoryDropdown("Computers");
		log.info("Step: click to Search button.");
		searchPage.clickToSearchButton();
		log.info("Step: verify the Result.");
		verifyEquals(searchPage.getSearchNoResultErrorMessage(), "No products were found that matched your criteria.");
	}

	@Test
	public void TC_06_Search_Advanced_Sub_Categories() {
		String keyword = "Apple Macbook Pro";
		System.out.println("Keyword: " + keyword);
		//init TCs
		log.info("Step: click to Search Hyperlink at Footer");
		searchPage = homePage.clickToFooterSearchLink();
		log.info("Step: enter Keywords to Search Keywords textbox");
		searchPage.inputToSearchKeywordsTextbox(keyword);
		searchPage.checkToAdvancedSearchCheckbox();
		searchPage.selectCategoryDropdown("Computers");
		searchPage.checkToAutomaticSearchSubCategory();
		log.info("Step: click to Search button.");
		searchPage.clickToSearchButton();
		log.info("Step: verify the Result.");
		verifyTrue(searchPage.isReturnedProductsContainsKeyword(keyword));
	}

	@Test
	public void TC_07_Search_Advanced_Incorrect_Manufacturer() {
		String keyword = "Apple Macbook Pro";
		System.out.println("Keyword: " + keyword);
		//init TCs
		log.info("Step: click to Search Hyperlink at Footer");
		searchPage = homePage.clickToFooterSearchLink();
		log.info("Step: enter Keywords to Search Keywords textbox");
		searchPage.inputToSearchKeywordsTextbox(keyword);
		searchPage.checkToAdvancedSearchCheckbox();
		searchPage.selectCategoryDropdown("Computers");
		searchPage.checkToAutomaticSearchSubCategory();
		searchPage.selectManufacturerDropdown("HP");
		log.info("Step: click to Search button.");
		searchPage.clickToSearchButton();
		log.info("Step: verify the Result.");
		verifyEquals(searchPage.getSearchNoResultErrorMessage(), "No products were found that matched your criteria.");
	}

	@Test
	public void TC_08_Search_Advanced_Correct_Manufacturer() {
		String keyword = "Apple Macbook Pro";
		System.out.println("Keyword: " + keyword);
		//init TCs
		log.info("Step: click to Search Hyperlink at Footer");
		searchPage = homePage.clickToFooterSearchLink();
		log.info("Step: enter Keywords to Search Keywords textbox");
		searchPage.inputToSearchKeywordsTextbox(keyword);
		searchPage.checkToAdvancedSearchCheckbox();
		searchPage.selectCategoryDropdown("Computers");
		searchPage.checkToAutomaticSearchSubCategory();
		searchPage.selectManufacturerDropdown("Apple");
		log.info("Step: click to Search button.");
		searchPage.clickToSearchButton();
		log.info("Step: verify the Result.");
		verifyTrue(searchPage.isReturnedProductsContainsKeyword(keyword));
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

}
