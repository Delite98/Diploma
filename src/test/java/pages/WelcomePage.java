package pages;

import com.codeborne.selenide.SelenideElement;
import configurations.ReadProperties;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class WelcomePage {
    //locators
    private SelenideElement pageIdentifier = $x("//h1[text()=' Where the world builds software ']");
    private SelenideElement signInButton = $x("//a[@href='/login']");

    //corpuscular methods
    public SelenideElement getPageIdentifier() {
        return pageIdentifier;
    }

    public SelenideElement getSignInButton() {
        return signInButton;
    }

    //complex methods
    public void signIn() {
        open(ReadProperties.getUrl());
        signInButton.click();
    }
}
