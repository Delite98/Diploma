package pages;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage {
    //locators
    private SelenideElement pageIdentifier = $(".logo-loginpage");
    private SelenideElement emailInputLocator = $("#name");
    private SelenideElement pswInputLocator = $("#password");
    private SelenideElement loginButtonLocator = $(".loginpage-button-sso-disable");
    private SelenideElement errorTextLocator = $(".error-text");
    private SelenideElement errorLocator = $x("//div[text()='Field Email/User is too long (250 characters at most).']");
    private SelenideElement loginPageMessage = $(".loginpage-message-image");

    //corpuscular methods
    protected SelenideElement getPageIdentifier() {
        return pageIdentifier;
    }

    public SelenideElement getEmailInputLocator() {
        return emailInputLocator;
    }

    public SelenideElement getPswInputLocator() {
        return pswInputLocator;
    }

    public SelenideElement getLoginButtonLocator() {
        return loginButtonLocator;
    }

    public SelenideElement getErrorTextLocator() {
        return errorTextLocator;
    }

    public SelenideElement getErrorLocator() {
        return errorLocator;
    }

    public SelenideElement getLoginPageMessage() {
        return loginPageMessage;
    }
}
