package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Fiil and click advanced search page.
 */
public class SearchInformationPage extends BasePage {

    @FindBy(id = "advs")
    private WebElement advancedSearchBox;

    @FindBy(id = "advs-keywords")
    private WebElement keyWordsField;

    @FindBy(className = "submit-advs")
    private WebElement submitAdvancedSeardBtn;

    @FindBy(xpath = "//div[@class='description']")
    private List<WebElement> searchResultDescriptionsList;

    @FindBy(xpath = "//div[@class='search-info']/p[contains(text(),'результата для') or contains(text(),'result for') or contains(text(),'результатов для') or contains(text(),'результат для')]")
    private WebElement resultForInfoText;

    @FindBy(xpath = "//ol[@id='results']/li[contains(@class, 'people')]")
    private List<WebElement> listOfFoundPeople;

    @FindBy (xpath = "//div[@class='description']/b")
    private WebElement PersonTitle;

    public SearchInformationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        waitUntilElementDisplayed(advancedSearchBox);
    }

    public void fillClickSearchForm(String SearchTerm) {
        keyWordsField.clear();
        keyWordsField.sendKeys(SearchTerm);
        keyWordsField.submit();
        waitUntilElementDisplayed(resultForInfoText);

        /*keyWordsField.sendKeys(SearchTerm);
        keyWordsField.submit();
        waitUntilElementDisplayed(resultForInfoText);*/
    }

    public int getSearchResultOnPage() {
        return searchResultDescriptionsList.size();
    }

    /**
     * @return wait AdvancedSearchPageIsLoaded
     */
    public boolean AdvancedSearchPageIsLoaded() {
        return waitUntilElementDisplayed(advancedSearchBox, 5).isDisplayed();
    }


    public List<String> getDescriptionStringList() {
        List<String> searchResultDescriptionsStringList = new ArrayList<String>();

        for (WebElement searchResultDescriptionsElement : searchResultDescriptionsList) {
             searchResultDescriptionsStringList.add(searchResultDescriptionsElement.getText());
        }
        return searchResultDescriptionsStringList;
    }

    public List<WebElement> getListOfFoundPeople() {
        return listOfFoundPeople;
    }

    public String getThePersonsTitle(WebElement title) {
        return PersonTitle.getText();
    }

    /**
     * @param wordsSearch
     * @return
     */
    public boolean isSearchedWordsPresentInPersonsTitle(String wordsSearch) {
        for (WebElement title: this.getListOfFoundPeople()) {
            if (!this.getThePersonsTitle(title).equals(wordsSearch)) {
                return false;
            }
        }
        return true;
    }
}

