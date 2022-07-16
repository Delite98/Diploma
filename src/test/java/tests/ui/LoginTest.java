package tests.ui;

import baseEntities.BaseTest;
import com.codeborne.selenide.Condition;
import configurations.ReadProperties;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;

@Epic("login testing")
public class LoginTest extends BaseTest {

    @Feature("successful login")
    @Test(priority = 3)
    public void successLoginTest() {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password())
                .getPageIdentifier()
                .shouldBe(Condition.exist);
    }

    @Feature("login validation with incorrect email")
    @Test(priority = 2)
    public void incorrectEmailTest() {
        loginStep.inCorrectLogin("test", ReadProperties.password())
                .getErrorTextLocator()
                .shouldHave(text("Email/Login or Password is incorrect. Please try again."));
    }

    @Feature("login validation with incorrect password")
    @Test(priority = 1)
    public void incorrectPswTest() {
        loginStep.inCorrectLogin(ReadProperties.username(), "test")
                .getErrorTextLocator()
                .shouldHave(text("incorrect text!!!"));
    }
}
