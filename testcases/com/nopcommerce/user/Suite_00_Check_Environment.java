package com.nopcommerce.user;

import commons.BaseTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Suite_00_Check_Environment extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		System.out.println("Browser name: " + browserName);
		getBrowserDriver(browserName);
	}
	@Test
	public void TC_01_GetCurrentPageTitle() {
		driver.getTitle();
	}
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

}
