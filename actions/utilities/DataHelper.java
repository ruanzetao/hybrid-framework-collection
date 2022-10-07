package utilities;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataHelper {

	private Locale locale = new Locale("vi");
	private Faker faker = new Faker();

	public static DataHelper getDataHelper() {
		return new DataHelper();
	}

	public String getFirstName() {
		return faker.address().firstName();
	}

	public String getLastName() {
		return faker.address().lastName();
	}

	public String getEmailAddress() {
		return faker.internet().emailAddress();
	}

	public String getCityName() {
		return faker.address().cityName();
	}

	public String getPhoneNumber() {
		return faker.phoneNumber().phoneNumber();
	}

	public String getAddress() {
		return faker.address().streetAddress();
	}

	public String getPassword() {
		return faker.internet().password(8, 12, true, true);
	}

}
