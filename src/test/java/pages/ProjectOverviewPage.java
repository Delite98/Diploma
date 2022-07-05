package pages;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ProjectOverviewPage extends BasePage {
    //locators
    private SelenideElement pageIdentifier = $(".chart-line");
    private String tabLocator = "//li/a[. = 'Replace']";

    //corpuscular methods
    @Override
    protected SelenideElement getPageIdentifier() {
        return pageIdentifier;
    }

    public SelenideElement getTabByName(String tabName) {
        return $x(tabLocator.replace("Replace", tabName));
    }
}
