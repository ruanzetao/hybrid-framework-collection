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
	private ShoppingCartPageObject shoppingCartPage;
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
	public void TC_01_Order_Add_Product_To_Cart() {
		log.info("Step: hover on Category header menu.");
		homePage.hoverOnProductCategoryByHeader(driver, "Computers");
		log.info("Step: select Product Type by Header");
		productByTypePage = homePage.selectProductTypeByHeader("Computers", "Desktops");
		productDetailPage = productByTypePage.clickToProductNameLink("Build your own computer");
		productDetailPage.selectProcessorDropdown("2.2 GHz Intel Pentium Dual-Core E2200");
		productDetailPage.selectRamDropdown("2 GB");
		productDetailPage.selectHDDRadio("320 GB");
		productDetailPage.selectOSRadio("Vista Premium [+$60.00]");
		productDetailPage.selectSoftwareCheckbox("Total Commander [+$5.00]");
		productDetailPage.clickToAddToCartButton();
		verifyEquals(productDetailPage.isAddToCartSuccessMessageDisplayed(), "The product has been added to your shopping cart");
		productDetailPage.waitForNotificationBarDisappeared();
//		productDetailPage.clickToCloseButton();
	}

	@Test
	public void TC_02_Order_Edit_Product_In_Shopping_Cart() {
		shoppingCartPage = productDetailPage.selectShoppingCartLink();
		productDetailPage = shoppingCartPage.clickToEditButton();
		productDetailPage.selectProcessorDropdown("2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]");
		productDetailPage.selectRamDropdown("4GB [+$20.00]");
		productDetailPage.selectHDDRadio("400 GB [+$100.00]");
		productDetailPage.selectOSRadio("Vista Home [+$50.00]");
		productDetailPage.selectSoftwareCheckbox("Acrobat Reader [+$10.00]");
		productDetailPage.clickToUpdateButton();
		productDetailPage.clickToCloseUpdateButton();
	}

	@Test
	public void TC_03_Order_Remove_From_Cart() {
		shoppingCartPage = productDetailPage.selectShoppingCartLink();
		shoppingCartPage.clickToRemoveButton();
		verifyEquals(shoppingCartPage.getRemoveProductFromCartDisplayed(), "Your Shopping Cart is empty!");
	}

	@Test
	public void TC_04_Order_Update_Product_From_Cart() {
		log.info("Step: hover on Category header menu.");
		homePage.hoverOnProductCategoryByHeader(driver, "Computers");
		log.info("Step: select Product Type by Header");
		productByTypePage = homePage.selectProductTypeByHeader("Computers", "Desktops");
		productDetailPage = productByTypePage.clickToProductNameLink("Build your own computer");
		productDetailPage.selectProcessorDropdown("2.2 GHz Intel Pentium Dual-Core E2200");
		productDetailPage.selectRamDropdown("2 GB");
		productDetailPage.selectHDDRadio("320 GB");
		productDetailPage.selectOSRadio("Vista Premium [+$60.00]");
		productDetailPage.selectSoftwareCheckbox("Total Commander [+$5.00]");
		productDetailPage.clickToAddToCartButton();
		verifyEquals(productDetailPage.isAddToCartSuccessMessageDisplayed(), "The product has been added to your shopping cart");
		productDetailPage.waitForNotificationBarDisappeared();
		log.info("Step: move to Shopping Cart page.");
		shoppingCartPage = productDetailPage.selectShoppingCartLink();
		shoppingCartPage.inputToQuantityTextbox("5");
		log.info("Step: click to Update button");
		shoppingCartPage.clickToUpdateShoppingCartButton();
		log.info("Step: Done!.");
	}

	@Test
	public void TC_05_Order_Payment_Method_Cheque() {
//		shoppingCartPage.selectGiftWrappingDropdown("No");
//		shoppingCartPage.checkToAgreeTermCheckbox();
//		shoppingCartPage.clickToCheckoutButton();
//		shoppingCartPage.selectCountryDropdown("Viet Nam");
//		shoppingCartPage.selectStateProvinceDropdown("Other (Non US)");
//		shoppingCartPage.inputToCityTextbox("City");
//		shoppingCartPage.inputToAddress1Textbox("Address1");
//		shoppingCartPage.inputToZipPostalCodeTextbox("550000");
//		shoppingCartPage.inputToPhoneNumberTextbox("0932658888");
	}

	@Test
	public void TC_06_Order_Payment_Method_Card() {
		//init TCs
	}

	@Test
	public void TC_07_Order_ReOrder_Product() {
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

}
