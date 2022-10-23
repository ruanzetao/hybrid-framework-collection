package com.nopcommerce.user;

import commons.BaseTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopcommerce.user.*;

public class Suite_07_Wishlist extends BaseTest {

	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private ProductByTypePageObject productByTypePage;
	private ProductDetailPageObject productDetailPage;
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
	public void TC_01_Wishlist_Add_To_Wishlist() {
		//update something
		log.info("Step: hover on Category header menu.");
		homePage.hoverOnProductCategoryByHeader(driver, "Computers");
		log.info("Step: select Product Type by Header");
		productByTypePage = homePage.selectProductTypeByHeader("Computers", "Notebooks");
		productDetailPage = productByTypePage.clickToProductNameLink("Apple MacBook Pro 13-inch");
		productDetailPage.clickToAddToWishlistButton();
		verifyEquals(productDetailPage.getAddToWishlistSuccessMessage(), "The product has been added to your wishlist");
	}

	@Test
	public void TC_02_Wishlist_Add_Product_To_Cart() {
		//update something
	}

	@Test
	public void TC_03_Wishlist_Remove_Product() {
		//update something
	}

	@Test
	public void TC_04_Wishlist_Add_To_Compare() {
		//update something
	}

	@Test
	public void TC_05_Recent_Viewed_Products() {
		//update something
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

}
