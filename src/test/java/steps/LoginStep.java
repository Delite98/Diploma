package steps;

import baseEntities.BaseStep;
import configurations.ReadProperties;
import pages.LoginPage;
import pages.DashboardPage;

import static com.codeborne.selenide.Selenide.open;

public class LoginStep extends BaseStep {

    public LoginStep(){
        super();
    }

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
}
