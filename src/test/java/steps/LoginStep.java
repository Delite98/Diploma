package steps;

import baseEntities.BaseStep;
import configurations.ReadProperties;
import pages.DashboardPage;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.*;

public class LoginStep extends BaseStep {

    public DashboardPage successLogin(String username, String psw) {
        login(username, psw);
        return dashboardPage;
    }

    public LoginPage inCorrectLogin(String inCorrectEmail, String incorrectPsw) {
        login(inCorrectEmail, incorrectPsw);
        return loginPage;
    }

    public void login(String username, String psw) {
        open(ReadProperties.getUrl());
        loginPage.getEmailInputLocator().setValue(username);
        loginPage.getPswInputLocator().setValue(psw);
        loginPage.getLoginButtonLocator().click();
    }

    public void emptyLogin(String psw) {
        open(ReadProperties.getUrl());
        loginPage.getPswInputLocator().setValue(psw);
        loginPage.getLoginButtonLocator().click();
    }

    public LoginPage logout() {
        actions()
                .moveToElement($(".navigation-username"))
                .click()
                .moveToElement($("#navigation-user-logout"))
                .click()
                .build()
                .perform();
        return loginPage;
    }
}
