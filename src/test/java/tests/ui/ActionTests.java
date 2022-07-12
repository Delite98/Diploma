package tests.ui;

import baseEntities.BaseTest;
import com.codeborne.selenide.SelenideElement;
import configurations.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class ActionTests extends BaseTest {

    @Test
    public void dialogWindowTest(){

        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());

        actions()
                .moveToElement(dashboardPage.getIconHeaderMail())
                .pause(5000)
                .build()
                .perform();
Assert.assertTrue(dashboardPage.getTextIconHeaderMail().isDisplayed());
    }


}
