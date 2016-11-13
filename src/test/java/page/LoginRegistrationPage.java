package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *
 */
public class LoginRegistrationPage extends BasePage {



	@FindBy(id = "reg-firstname")
	private WebElement firstNameField;

	@FindBy(id = "reg-lastname")
	private WebElement lastNameField;

	@FindBy(id = "reg-email")
	private WebElement emailField;

	@FindBy(id = "reg-password")
	private WebElement passwordField;

	@FindBy(id = "registration-submit")
	private WebElement joinNowButton;

	@FindBy(id = "login-email")
	private WebElement loginEmailField;

	@FindBy(id = "login-password")
	private WebElement loginPasswordField;

	@FindBy(id = "login-submit")
	private WebElement signInButton;

	@FindBy(className = "alert-content")
	private WebElement errorMessageBox;

	public LoginRegistrationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);

	}

	public HomePage loginFormFillAndSubmit(String loginEmail, String loginPassword) {
		loginEmailField.sendKeys(loginEmail);
		loginPasswordField.sendKeys(loginPassword);
		signInButton.click();
		return new HomePage(driver);
	}

	public HomePage registrationFormFillAndSubmit(String firstName, String lastName, String email, String password ) {
		firstNameField.clear();
		firstNameField.sendKeys(firstName);
		lastNameField.clear();
		lastNameField.sendKeys(lastName);
		emailField.clear();
		emailField.sendKeys(email);
		passwordField.clear();
		passwordField.sendKeys(password);
		joinNowButton.click();
		return new HomePage(driver);
	}

	public String getErrorMessageText() {
		return errorMessageBox.getText();
	}

}
