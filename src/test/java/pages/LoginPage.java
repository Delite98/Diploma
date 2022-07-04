package pages;

import com.codeborne.selenide.SelenideElement;
import configurations.ReadProperties;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    //locators
    private SelenideElement pageIdentifier = $x("//h1[text()='Sign in to GitHub']");
    private SelenideElement username = $("#login_field");
    private SelenideElement psw = $("#password");
    private SelenideElement signInButton = $x("//input[@type='submit']");
    private SelenideElement errorText = $x("//div[@class='px-2']");

    //corpuscular methods
    public SelenideElement getPageIdentifier() {
        return pageIdentifier;
    }

    public SelenideElement getUsername() {
        return username;
    }

    public SelenideElement getPsw() {
        return psw;
    }

    public SelenideElement getSignInButton() {
        return signInButton;
    }

    public SelenideElement getErrorText() {
        return errorText;
    }

    //complex methods
    public MainPage successLogin(String username, String psw) {
        login(username, psw);
        return new MainPage();
    }

    public LoginPage inCorrectLogin(String inCorrectEmail, String incorrectPsw) {
        login(inCorrectEmail, incorrectPsw);
        return this;
    }

    public void login(String username, String psw) {
        getUsername().setValue(username);
        getPsw().setValue(psw);
        signInButton.click();
    }
}
