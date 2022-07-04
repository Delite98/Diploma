package tests;

import com.codeborne.selenide.Condition;
import configurations.ReadProperties;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.WelcomePage;

import static com.codeborne.selenide.Condition.text;

public class LoginTest {

    @Test
    public void signInTest() {
        new WelcomePage().signIn();
    }

    @Test(dependsOnMethods = "signInTest")
    public void successLoginTest() {
        new LoginPage().successLogin(ReadProperties.username(),ReadProperties.password())
                .getPageIdentifier()
                .shouldBe(Condition.exist);
    }

    @Test(dependsOnMethods = "signInTest")
    public void incorrectPSW() throws InterruptedException {

        new LoginPage().inCorrectLogin(ReadProperties.username(), "test")
                .getErrorText()
                .shouldHave(text("Incorrect username or password."));
    }
}
