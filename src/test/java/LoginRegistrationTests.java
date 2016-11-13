import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginRegistrationPage;

public class LoginRegistrationTests extends BaseTest {

	/**
	 * Check the error message
	 */

	@DataProvider(name = "RegistrationForm")
	public Object[][] registrationFormData() {
		return new Object[][]{
				{"", "", "", "", "Please enter your first name"},
				{"FirstName", "", "", "", "Please enter your last name" },
				{"FirstName", "LastName", "", "", "Please enter your email address" },
				{"FirstName", "LastName", "qa@i.com", "", "Please enter your password"},
		};
	}

	@Test (dataProvider = "RegistrationForm")
	public void errorMessageOnEmptyFormSubmit(String firstName, String lastName, String email, String password, String ErrorMassageTest) {
		LoginRegistrationPage registrationPage = new LoginRegistrationPage(getDriver());
		registrationPage.registrationFormFillAndSubmit(firstName, lastName, email, password);
		Assert.assertEquals(registrationPage.getErrorMessageText(), ErrorMassageTest, "Expected error massage was not found");
	}

	/**
	 * Check the successful login
	 */
	@Test
	public void successfulLoginTest() {
		LoginRegistrationPage registrationPage = new LoginRegistrationPage(getDriver());
		HomePage homePage = registrationPage.loginFormFillAndSubmit("", "");
		Assert.assertTrue(homePage.isPageLoaded());

	}
}

