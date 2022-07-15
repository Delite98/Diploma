package tests.ui;

import baseEntities.BaseTest;
import configurations.ReadProperties;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;

public class uiTests extends BaseTest {

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

    @Test(priority = 2)
    public void emptyUsernameTest() {
        loginStep.emptyLogin(ReadProperties.password());
        loginPage.getLoginPageMessage().shouldHave(text("Email/Login is required."));
    }

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
    }
}
