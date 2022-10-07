//package com.nopcommerce.user;
//
//import commons.BaseTest;
//import org.testng.annotations.*;
//
//public class Suite_00_Check_Environment_Refactor extends BaseTest {
//
//	@Parameters({"envName", "serverName", "browserName", "ipAddress", "portNumber", "osName", "osVersion"})
//	@BeforeClass
//	public void beforeClass(@Optional("local") String envName, @Optional("TESTING") String serverName, @Optional("firefox") String browserName
//			, @Optional("localhost") String ipAddress, @Optional("4444") String portNumber,
//			                @Optional("Windows") String osName, @Optional("10") String osVersion) {
//		System.out.println("Browser name: " + browserName);
//		getBrowserDriver(envName, serverName, browserName, ipAddress, portNumber, osName, osVersion);
//	}
//
//	@Test
//	public void TC_01_GetCurrentPageTitle() {
//		driver.getTitle();
//	}
//
//	@AfterClass(alwaysRun = true)
//	public void afterClass() {
//		closeBrowserAndDriver();
//	}
//
//}
