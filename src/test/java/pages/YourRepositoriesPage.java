package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class YourRepositoriesPage {
    //locators
    private SelenideElement pageIdentifier = $x("//img[contains(@class,'width-full')]");

    //corpuscular methods
    public SelenideElement getPageIdentifier() {
        return pageIdentifier;
    }
}
