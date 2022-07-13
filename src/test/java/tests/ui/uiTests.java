package tests.ui;

import baseEntities.BaseTest;
import configurations.ReadProperties;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;

import static com.codeborne.selenide.Condition.text;

public class uiTests extends BaseTest {

    @Test
    public void tooltipTest() {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        dashboardPage.getTooltipLocator().hover()
                .shouldHave();
    }
}
