package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    //locators
    private SelenideElement pageIdentifier = $x("//div[contains(@class,'dashboard-sidebar')]/div/div/h2[contains(text(),'Recent Repositories')]");
    private SelenideElement dropDownCaret = $x("//summary[contains(@aria-label,'View profile')]/span[@class='dropdown-caret']");
    private SelenideElement yourRepositoriesButton = $x("//a[contains(text(),'Your repositories')]");

    //corpuscular methods
    public SelenideElement getPageIdentifier() {
        return pageIdentifier;
    }

    public SelenideElement getDropDownCaret() {
        return dropDownCaret;
    }

    public void openYourRepositories() {
        getDropDownCaret().click();
        yourRepositoriesButton.click();
    }

    public YourRepositoriesPage openRepositories() {
        openYourRepositories();
        return new YourRepositoriesPage();
    }
}