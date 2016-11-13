package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {


	@FindBy(id = "in-logo")
	private WebElement homeMenuLink;

	@FindBy(id = "advanced-search")
	private WebElement advancedSearchLink;


	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}

	/**
	 * Checking the page load
	 * @return Element homeMenuLink is displayed
	 */
	public boolean isPageLoaded() {
		return waitUntilElementDisplayed(homeMenuLink).isDisplayed();
	}


	public SearchInformationPage clikAdvancedSearchBtn() {
		waitUntilElementDisplayed(advancedSearchLink, 20).click();
		return new SearchInformationPage(driver);

	}

}