package com.nopcommerce.user;

import commons.BaseTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopcommerce.*;

public class Suite_08_Order extends BaseTest {

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
	public void TC_01_Order_Add_Product_To_Cart() {
	}

	@Test
	public void TC_02_Order_Edit_Product_In_Shopping_Cart() {
	}

	@Test
	public void TC_03_Order_Remove_From_Cart() {
	}

	@Test
	public void TC_04_Order_Update_Product_From_Cart() {
	}

	@Test
	public void TC_05_Order_Payment_Method_Cheque() {
	}

	@Test
	public void TC_06_Order_Payment_Method_Card() {
	}

	@Test
	public void TC_07_Order_ReOrder_Product() {
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

}
