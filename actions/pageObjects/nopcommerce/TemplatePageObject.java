package pageObjects.nopcommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class TemplatePageObject extends BasePage {
	private WebDriver driver;

	public TemplatePageObject(WebDriver driver) {
		this.driver = driver;
	}

}
