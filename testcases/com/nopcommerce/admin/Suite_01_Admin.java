package com.nopcommerce.admin;

import commons.BaseTest;
import commons.GlobalConstants;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopcommerce.admin.CustomersCustomersPageObject;
import pageObjects.nopcommerce.admin.DashboardAdminPageObject;
import pageObjects.nopcommerce.admin.LoginAdminPageObject;
import pageObjects.nopcommerce.admin.ProductsCatalogAdminPageObject;
import pageObjects.nopcommerce.user.PageGeneratorManager;

public class Suite_01_Admin extends BaseTest {

	private LoginAdminPageObject loginAdminPage;
	private DashboardAdminPageObject dashboardAdminPage;
	private ProductsCatalogAdminPageObject productsCatalogAdminPage;
	private CustomersCustomersPageObject customersCustomersPage;
	String email = getRandomEmail();

	@Parameters("browserName")
	@BeforeClass
	public void beforeClass(String browserName) {
		log.info("Testcase: " + getClass().toString());
		System.out.println("Browser name: " + browserName);
		getBrowserDriver(browserName, GlobalConstants.ADMIN_TESTING_URL);
		System.out.println("URL: " + GlobalConstants.ADMIN_TESTING_URL);
		log.info("Step: navigate to Login page");
		loginAdminPage = PageGeneratorManager.getLoginAdminPage(driver);
		loginAdminPage.inputToEmailTextbox("admin@yourstore.com");
		loginAdminPage.inputToPasswordTextbox("admin");
		log.info("Step: navigate to Dashboard admin page");
		dashboardAdminPage = loginAdminPage.clickToLoginButton();
	}

	//	@Test
//	public void TC_01_Admin_Search_Product_Name() {
//		log.info("Step: expand Level1 Menu");
//		dashboardAdminPage.expandLevel1MenuByName("Catalog");
//		log.info("Step: select Level2 Menu");
//		dashboardAdminPage.openLevel2PageByName("Products");
//		productsCatalogAdminPage = PageGeneratorManager.getProductsCatalogAdminPage(driver);
//		//update something
//		String productName = "Lenovo IdeaCentre 600 All-in-One PC";
//		productsCatalogAdminPage.inputToProductNameTextbox(productName);
//		log.info("Step: click to Search button");
//		productsCatalogAdminPage.clickToSearchButton();
//		log.info("Step: verify the Result");
//		verifyTrue(productsCatalogAdminPage.isReturnedProductsContainKeyword(productName));
//	}
//
//	@Test
//	public void TC_02_Admin_Search_Product_Name_Parent_Category_Unchecked() {
//		productsCatalogAdminPage.selectCategoryDropdown("Computers");
//		productsCatalogAdminPage.uncheckSubcategories();
//		productsCatalogAdminPage.clickToSearchButton();
//		verifyEquals(productsCatalogAdminPage.getReturnedMessage(), "No data available in table");
//	}
//
//	@Test
//	public void TC_03_Admin_Search_Product_Name_Parent_Category_Checked() {
//		String productName = "Lenovo IdeaCentre 600 All-in-One PC";
//		productsCatalogAdminPage.selectCategoryDropdown("Computers");
//		productsCatalogAdminPage.checkSubcategories();
//		productsCatalogAdminPage.clickToSearchButton();
//		verifyTrue(productsCatalogAdminPage.isReturnedProductsContainKeyword(productName));
//	}
//
//	@Test
//	public void TC_04_Admin_Search_Product_Name_Child_Category() {
//		String productName = "Lenovo IdeaCentre 600 All-in-One PC";
//		productsCatalogAdminPage.selectCategoryDropdown("Computers >> Desktops");
//		productsCatalogAdminPage.uncheckSubcategories();
//		productsCatalogAdminPage.clickToSearchButton();
//		verifyTrue(productsCatalogAdminPage.isReturnedProductsContainKeyword(productName));
//	}
//
//	@Test
//	public void TC_05_Admin_Search_Product_Name_Manufacturer() {
//		String productName = "Lenovo IdeaCentre 600 All-in-One PC";
//		productsCatalogAdminPage.selectCategoryDropdown("All");
//		productsCatalogAdminPage.uncheckSubcategories();
//		productsCatalogAdminPage.selectManufacturerDropdown("Apple");
//		productsCatalogAdminPage.clickToSearchButton();
//		verifyEquals(productsCatalogAdminPage.getReturnedMessage(), "No data available in table");
//	}
//
//	@Test
//	public void TC_06_Admin_Go_To_ProductSKU() {
//		productsCatalogAdminPage.inputToGoProductSKUTextbox("LE_IC_600");
//		productsCatalogAdminPage.clickToGoButton();
//		verifyEquals(productsCatalogAdminPage.getProductNameAtSKUPage(), "Lenovo IdeaCentre 600 All-in-One PC");
//	}
//
	@Test
	public void TC_07_Admin_Create_New_Customer() {
		log.info("Step: expand Level1 Menu");
		dashboardAdminPage.expandLevel1MenuByName("Customers");
		log.info("Step: select Level2 Menu");
		customersCustomersPage = dashboardAdminPage.goToCustomersLevel2Page();
		customersCustomersPage.clickToAddNewButton();
		customersCustomersPage.expandCustomerInfoArea();
		System.out.println("Email: " + email);
		customersCustomersPage.inputToEmailTextbox(email);
		customersCustomersPage.inputToPasswordTextbox("Abc@123");
		customersCustomersPage.inputToFirstNameTextbox("Nguyen");
		customersCustomersPage.inputToLastNameTextbox("XSang");
		customersCustomersPage.checkToGenderRadio("Male");
		customersCustomersPage.inputToDateOfBirthDatePicker("02/19/1996");
		customersCustomersPage.inputToCompanyName("companyName");
//		customersCustomersPage.inputToCustomerRoles("Guests");
		customersCustomersPage.checkToActiveCheckbox();
		customersCustomersPage.inputToAdminComment("adminComment");
		customersCustomersPage.clickToSaveAndContinueEditButton();
	}

	@Test
	public void TC_08_Admin_Search_Customer_Email() {
		driver.getTitle();
	}

	@Test
	public void TC_09_Admin_Search_Customer_Firstname_Lastname() {
		driver.getTitle();
	}

	@Test
	public void TC_10_Admin_Search_Customer_Company() {
		driver.getTitle();
	}

	@Test
	public void TC_11_Admin_Search_Customer_Full_Data() {
		driver.getTitle();
	}

	@Test
	public void TC_12_Admin_Edit_Customer() {
		driver.getTitle();
	}

	@Test
	public void TC_13_Admin_Add_Customer_Address() {
		driver.getTitle();
	}

	@Test
	public void TC_14_Admin_Edit_Customer_Address() {
		driver.getTitle();
	}

	@Test
	public void TC_15_Admin_Delete_Customer_Address() {
		driver.getTitle();
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

}
