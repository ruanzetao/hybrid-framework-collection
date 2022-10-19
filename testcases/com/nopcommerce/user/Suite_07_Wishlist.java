package com.nopcommerce.user;

import commons.BaseTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.PageGeneratorManager;

public class Suite_07_Wishlist extends BaseTest {

	private HomePageObject homePage;

	@Parameters("browserName")
	@BeforeClass
	public void beforeClass(String browserName) {
		System.out.println("Browser name: " + browserName);
		getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void TC_01_GetCurrentPageTitle() {
		//update something
		driver.getTitle();
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

}
