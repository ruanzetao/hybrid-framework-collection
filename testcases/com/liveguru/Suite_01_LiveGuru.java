package com.liveguru;

import commons.BaseTest;
import commons.GlobalConstants;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.liveguru.*;

public class Suite_01_LiveGuru extends BaseTest {

	private HomePagePageObject dashboardPage;
	private MyAccountPageObject myAccountPage;
	private CreateAnAccountPageObject createAnAccountPage;
	private AccountDashboardPageObject accountDashboardPage;
	private AccountInformationPageObject accountInformationPage;
	String emailAddress, firstName, lastName, password;

	@Parameters("browserName")
	@BeforeClass
	public void beforeClass(String browserName) {
		System.out.println("Browser name: " + browserName);
		getBrowserDriver(browserName, GlobalConstants.LIVE_GURU_PORTAL_URL);
		dashboardPage = PageGeneratorManager.getHomePage(driver);
		sleepInSecond(10);
		myAccountPage = dashboardPage.clickToMyAccountLiveGuru(driver);
	}

	@Test
	public void TC_01_Register_Success() {
		createAnAccountPage = myAccountPage.clickToCreateAnAccountButton();
		firstName = "Nguyen";
		lastName = "XSang";
		password = "Abc@123";
		createAnAccountPage.inputToFirstNameTextbox(firstName);
		createAnAccountPage.inputToLastNameTextbox(lastName);
		emailAddress = getRandomEmail();
		System.out.println("Email: " + emailAddress);
		System.out.println("Password: Abc@123");
		createAnAccountPage.inputToEmailAddressTextbox(emailAddress);
		createAnAccountPage.inputToPasswordTextbox(password);
		createAnAccountPage.inputToConfirmPasswordTextbox(password);
		accountDashboardPage = createAnAccountPage.clickToRegisterButton();
		sleepInSecond(20);
	}

	@Test
	public void TC_02_Verify_Information() {
		accountInformationPage = accountDashboardPage.clickToAccountInformationLink();
		verifyEquals(accountInformationPage.getFirstNameValue(), firstName);
		verifyEquals(accountInformationPage.getLastNameValue(), lastName);
		verifyEquals(accountInformationPage.getEmailAddressValue(), emailAddress);
	}

	@Test
	public void TC_03_Login_Success() {
	}

	@Test
	public void TC_04_Product_Cost_Equal() {
	}

	@Test
	public void TC_05_Discount_Coupon_Work_Correctly() {
	}

	@Test
	public void TC_06_Unable_To_Add_Over_500_Product() {
	}

	@Test
	public void TC_07_Able_To_Compare_Two_Items() {
	}

	@Test
	public void TC_08_Share_Wishlist() {
	}

	@Test
	public void TC_09_Add_Your_Review() {
	}

	@Test
	public void TC_10_Purchase_Product() {
	}

	@Test
	public void TC_11_Search_Funtions() {
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

}
