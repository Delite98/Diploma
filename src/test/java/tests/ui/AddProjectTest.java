package tests.ui;

import baseEntities.BaseTest;
import configurations.ReadProperties;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;

public class AddProjectTest extends BaseTest {
    @Test
    public void addProject() {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        dashboardStep.successAddProject();
        addProjectStep.createProject("test", "test", false,
                        "suite_mode_single", false)
                .getTabByName("test")
                .isDisplayed();
    }

    @Test
    public void addTestSuiteTest() {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        dashboardStep.openProject("test2");
        projectOverviewStep.selectTestSuite();
        testSuitesStep.addTestSuite();
        addTestSuiteStep.createTestSuite("testSuite1", "test")
                .getMessageLocator()
                .isDisplayed();
        navigationStep.navigateToDashboard();

    }

    @Test(dependsOnMethods = "addTestSuiteTest")
    public void deleteTestSuiteTest() {
        dashboardStep.openProject("test2");
        projectOverviewStep.selectTestSuite();
        testSuitesStep.openTestSuite("testSuite1");
        testSuiteOverviewStep.selectEditTestSuite();
        editTestSuiteStep.deleteTestSuite("testSuite1")
                .getDeleteMessageLocator()
                .shouldHave(text("Successfully deleted the test suite."));
    }
}
