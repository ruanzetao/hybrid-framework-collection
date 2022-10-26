package pageObjects.liveguru;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class LoginPageObject extends BasePage {

	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

}
