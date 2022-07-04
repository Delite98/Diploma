package tests;

import com.codeborne.selenide.Condition;
import configurations.ReadProperties;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.WelcomePage;
import pages.YourRepositoriesPage;


public class RepositoriesTest {

    @Test
    public void openRepositoryTest() {
        new WelcomePage().signIn();
        new LoginPage().successLogin(ReadProperties.username(),ReadProperties.password());
        new MainPage().openYourRepositories();
        new YourRepositoriesPage().getPageIdentifier()
                .shouldBe(Condition.exist);
    }
}
