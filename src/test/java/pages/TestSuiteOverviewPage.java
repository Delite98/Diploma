package pages;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class TestSuiteOverviewPage extends BasePage {
    //locators
    private SelenideElement pageIdentifier = $x("//a[@id='navigation-suites-sectionscases']");
    private SelenideElement editButtonLocator = $x("//a[contains(@class,'content-header-button')]/span[@class='button-text' and text()='Edit']");

    //corpuscular methods
    @Override
    protected SelenideElement getPageIdentifier() {
        return pageIdentifier;
    }

    public SelenideElement getEditButtonLocator() {
        return editButtonLocator;
    }
}
