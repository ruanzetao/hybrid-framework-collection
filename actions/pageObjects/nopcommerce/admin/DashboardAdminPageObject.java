package pageObjects.nopcommerce.admin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.nopcommerce.user.PageGeneratorManager;
import pageUIs.nopcommerce.admin.DashboardAdminPageUI;

public class DashboardAdminPageObject extends BasePage {

	private WebDriver driver;

	public DashboardAdminPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void expandLevel1MenuByName(String level1Menu) {
		waitForElementClickable(driver, DashboardAdminPageUI.DYNAMIC_LEVEL1_LEFT_PANEL_MENU, level1Menu);
		clickToElement(driver, DashboardAdminPageUI.DYNAMIC_LEVEL1_LEFT_PANEL_MENU, level1Menu);
		sleepInSecond(10);
	}

	public void openLevel2PageByName(String level2Menu) {
		waitForElementClickable(driver, DashboardAdminPageUI.DYNAMIC_LEVEL2_LEFT_PANEL_MENU, level2Menu);
		clickToElement(driver, DashboardAdminPageUI.DYNAMIC_LEVEL2_LEFT_PANEL_MENU, level2Menu);
		sleepInSecond(10);
	}

	public CustomersCustomersPageObject goToCustomersLevel2Page() {
		waitForElementClickable(driver, DashboardAdminPageUI.CUSTOMERS_LEVEL2_LEFT_PANEL_MENU);
		clickToElement(driver, DashboardAdminPageUI.CUSTOMERS_LEVEL2_LEFT_PANEL_MENU);
		sleepInSecond(10);
		return PageGeneratorManager.getCustomersCustomersAdminPage(driver);
	}

}
