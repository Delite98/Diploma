package tests.ui;

import baseEntities.BaseTest;
import configurations.ReadProperties;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;

public class AddProjectTest extends BaseTest {
    @Test(priority = 1)
    public void addProjectTest() {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        dashboardStep.successAddProject();
        addProjectStep.createProject("testUI", "test", false,
                        "suite_mode_multi", false)
                .getTabByName("test")
                .isDisplayed();
        navigationStep.navigateToDashboardFromProjectOverviewPage();
    }

    @Test(priority = 2)
    public void createTestSuiteTest() {
        //loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        dashboardStep.openProject("testUI");
        projectOverviewStep.selectTestSuite();
        testSuitesStep.addTestSuite();
        addTestSuiteStep.createTestSuite("testSuite1", "test")
                .getMessageLocator()
                .isDisplayed();
        navigationStep.navigateToDashboardFromTestSuiteOverviewPage();

    }

    @Test(priority = 3)
    public void readTestSuiteAfterCreateTest() {
        dashboardStep.openProject("testUI");
        projectOverviewStep.selectTestSuite();
        testSuitesStep.openTestSuite("testSuite1");
        testSuiteOverviewStep.selectEditTestSuite();
        editTestSuiteStep.getTestSuiteName()
                .shouldHave(value("testSuite1"));
        editTestSuiteStep.getDescription()
                .shouldHave(text("test"));
    }

    @Test(priority = 4)
    public void updateTestSuiteTest() {
        dashboardStep.openProject("testUI");
        projectOverviewStep.selectTestSuite();
        testSuitesStep.openTestSuite("testSuite1");
        testSuiteOverviewStep.selectEditTestSuite();
        editTestSuiteStep.editTestSuite("testSuite2", "test2")
                .getUpdateMessageLocator()
                .shouldHave(text("Successfully updated the test suite."));
        navigationStep.navigateToDashboardFromTestSuiteOverviewPage();
    }

    @Test(priority = 5)
    public void readTestSuiteAfterUpdateTest() {
        dashboardStep.openProject("testUI");
        projectOverviewStep.selectTestSuite();
        testSuitesStep.openTestSuite("testSuite2");
        testSuiteOverviewStep.selectEditTestSuite();
        editTestSuiteStep.getTestSuiteName()
                .shouldHave(value("testSuite2"));
        editTestSuiteStep.getDescription()
                .shouldHave(text("test2"));
        navigationStep.navigateToDashboardFromEditTestSuitePage();
    }

    @Test(priority = 6)
    public void deleteTestSuiteTest() {
        dashboardStep.openProject("testUI");
        projectOverviewStep.selectTestSuite();
        testSuitesStep.openTestSuite("testSuite2");
        testSuiteOverviewStep.selectEditTestSuite();
        editTestSuiteStep.deleteTestSuite("testSuite2")
                .getDeleteMessageLocator()
                .shouldHave(text("Successfully deleted the test suite."));
    }
}
