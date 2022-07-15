package tests.ui;

import baseEntities.BaseTest;
import com.codeborne.selenide.Condition;
import configurations.ReadProperties;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;

public class LoginTest extends BaseTest {

    @Test(priority = 3)
    public void successLoginTest() {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password())
                .getPageIdentifier()
                .shouldBe(Condition.exist);
    }

    @Test(priority = 2)
    public void incorrectEmailTest() {
        loginStep.inCorrectLogin("test", ReadProperties.password())
                .getErrorTextLocator()
                .shouldHave(text("Email/Login or Password is incorrect. Please try again."));
    }

    @Test(priority = 1)
    public void incorrectPswTest() {
        loginStep.inCorrectLogin(ReadProperties.username(), "test")
                .getErrorTextLocator()
                .shouldHave(text("Email/Login or Password is incorrect. Please try again."));
    }
}
