package steps;

import baseEntities.BaseStep;
import pages.ProjectOverviewPage;
import pages.TestSuiteOverviewPage;

public class EditTestSuiteStep extends BaseStep {

    public ProjectOverviewPage editTestSuite(String testSuiteName, String testSuiteDescription) {
        fillTestSuite(testSuiteName, testSuiteDescription);
        return new ProjectOverviewPage();
    }

    public TestSuiteOverviewPage deleteTestSuite(String nameTestSuite) {
        editTestSuitePage.getDeleteTestSuiteButtonLocator(nameTestSuite).click();
        editTestSuitePage.getCheckBoxButtonLocator().click();
        editTestSuitePage.getConfirmationOkButtonLocator().click();
        return testSuiteOverviewPage;
    }

    public void fillTestSuite(String testSuiteName, String testSuiteDescription) {
        addTestSuitePage.getNameTestSuiteInputLocator().setValue(testSuiteName);
        addTestSuitePage.getDescriptionTestSuiteInputLocator().setValue(testSuiteDescription);
    }

    public String getTestSuiteName() {
        return editTestSuitePage.getNameTestSuiteInputLocator().getText();
    }

    public String getDescription() {
        return editTestSuitePage.getDescriptionTestSuiteLocator().getText();
    }
}
