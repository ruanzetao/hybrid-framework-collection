package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {

	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}

	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}

	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}

	public static MyAccountPageObject getMyAccountPage(WebDriver driver) {
		return new MyAccountPageObject(driver);
	}

	public static AddressesPageObject getAddressesPage(WebDriver driver) {
		return new AddressesPageObject(driver);
	}

	public static ChangePasswordPageObject getChangePasswordPage(WebDriver driver) {
		return new ChangePasswordPageObject(driver);
	}

	public static ComputersPageObject getComputersPage(WebDriver driver) {
		return new ComputersPageObject(driver);
	}

	public static ProductByTypePageObject getProductByTypePage(WebDriver driver) {
		return new ProductByTypePageObject(driver);
	}

	public static ProductDetailPageObject getProductDetailPage(WebDriver driver) {
		return new ProductDetailPageObject(driver);
	}

	public static ProductReviewsPageObject getProductReviewsPage(WebDriver driver) {
		return new ProductReviewsPageObject(driver);
	}

	public static SearchPageObject getSearchPage(WebDriver driver) {
		return new SearchPageObject(driver);
	}

}
