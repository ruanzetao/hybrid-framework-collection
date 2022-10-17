package com.nopcommerce.user;

import commons.BaseTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopcommerce.*;

public class Suite_06_Sort_Display extends BaseTest {

	private HomePageObject homePage;
	private SearchPageObject searchPage;
	private RegisterPageObject registerPage;
	private ProductByTypePageObject productByTypePage;
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
	public void TC_01_Sort_Name_A_To_Z() {
		log.info("Step: hover on Category header menu.");
		homePage.hoverOnProductCategoryByHeader(driver, "Computers");
		log.info("Step: select Product Type by Header");
		productByTypePage = homePage.selectProductTypeByHeader("Computers", "Notebooks");
		productByTypePage.selectSortByDropdown("Name: A to Z");
		log.info("Step: verify the Result is in alphabetical order");
		verifyTrue(productByTypePage.isListProductsAToZ());
	}

	@Test
	public void TC_02_Sort_Name_Z_To_A() {
		log.info("Step: hover on Category header menu.");
		homePage.hoverOnProductCategoryByHeader(driver, "Computers");
		log.info("Step: select Product Type by Header");
		productByTypePage = homePage.selectProductTypeByHeader("Computers", "Notebooks");
		productByTypePage.selectSortByDropdown("Name: Z to A");
		log.info("Step: verify the Result is in reverse-alphabetical order");
		verifyTrue(productByTypePage.isListProductsZToA());
	}

	@Test
	public void TC_03_Sort_Price_Low_To_High() {
		log.info("Step: hover on Category header menu.");
		homePage.hoverOnProductCategoryByHeader(driver, "Computers");
		log.info("Step: select Product Type by Header");
		productByTypePage = homePage.selectProductTypeByHeader("Computers", "Notebooks");
		productByTypePage.selectSortByDropdown("Price: Low to High");
		log.info("Step: verify the Price is low to high");
		verifyTrue(productByTypePage.isListProductsPriceLowToHigh());
	}

	@Test
	public void TC_04_Sort_Price_High_To_Low() {
		driver.getTitle();
	}

	@Test
	public void TC_05_Display_3_Product_Per_Page() {
		log.info("Step: hover on Category header menu.");
		homePage.hoverOnProductCategoryByHeader(driver, "Computers");
		log.info("Step: select Product Type by Header");
		productByTypePage = homePage.selectProductTypeByHeader("Computers", "Notebooks");
		productByTypePage.selectDisplayDropdown("3");
		verifyTrue(productByTypePage.isDisplayNumberItemPerPage(3));
	}

	@Test
	public void TC_06_Display_6_Product_Per_Page() {
		log.info("Step: hover on Category header menu.");
		homePage.hoverOnProductCategoryByHeader(driver, "Computers");
		log.info("Step: select Product Type by Header");
		productByTypePage = homePage.selectProductTypeByHeader("Computers", "Notebooks");
		productByTypePage.selectDisplayDropdown("6");
		verifyTrue(productByTypePage.isDisplayNumberItemPerPage(6));
	}

	@Test
	public void TC_07_Display_9_Product_Per_Page() {
		log.info("Step: hover on Category header menu.");
		homePage.hoverOnProductCategoryByHeader(driver, "Computers");
		log.info("Step: select Product Type by Header");
		productByTypePage = homePage.selectProductTypeByHeader("Computers", "Notebooks");
		productByTypePage.selectDisplayDropdown("9");
		verifyTrue(productByTypePage.isDisplayNumberItemPerPage(9));
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

}
