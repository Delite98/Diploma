package tests.ui;

import baseEntities.BaseTest;
import configurations.ReadProperties;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.actions;

@Epic("specific UI tests")
public class UITests extends BaseTest {

    @Feature("login validation with boundary values")
    @Test(priority = 1)
    public void limitValuesTest() {
        String generatedName1 = RandomStringUtils.randomAlphabetic(251);
        loginStep.login(generatedName1, ReadProperties.password());
        loginPage.getErrorLocator().shouldHave(text("Field Email/User is too long (250 characters at most)."));

        String generatedName2 = RandomStringUtils.randomAlphabetic(250);
        loginStep.login(generatedName2, ReadProperties.password());
        loginPage.getErrorTextLocator().shouldHave(text("Email/Login or Password is incorrect. Please try again."));

        String generatedName3 = RandomStringUtils.randomAlphabetic(249);
        loginStep.login(generatedName3, ReadProperties.password());
        loginPage.getErrorTextLocator().shouldHave(text("Email/Login or Password is incorrect. Please try again."));
    }

    @Feature("login validation with empty email")
    @Test(priority = 2)
    public void emptyUsernameTest() {
        loginStep.emptyLogin(ReadProperties.password());
        loginPage.getLoginPageMessage().shouldHave(text("Email/Login is required."));
    }

    @Feature("dialog window validation")
    @Test(priority = 3)
    public void dialogWindowDeleteTestSuiteTest() {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        dashboardStep.openProject("testUI");
        projectOverviewStep.selectTestSuite();
        testSuitesStep.addTestSuite();
        addTestSuiteStep.createTestSuite("testSuite3", "test");
        testSuiteOverviewStep.selectEditTestSuite();
        editTestSuiteStep.deleteSuite("testSuite3");
        editTestSuitePage.getDialogTitleLocator().shouldHave(text("Confirmation"));
        editTestSuitePage.getConfirmationCancelButtonLocator().click();
    }

    @Feature("tooltip validation")
    @Test(priority = 4)
    public void emergeTextTest() {
        actions()
                .moveToElement(dashboardPage.getIconHeaderMail())
                .pause(5000)
                .build()
                .perform();
        Assert.assertTrue(dashboardPage.getTextIconHeaderMail().isDisplayed());
    }
}
