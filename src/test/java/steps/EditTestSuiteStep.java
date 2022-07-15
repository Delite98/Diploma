package steps;

import baseEntities.BaseStep;
import com.codeborne.selenide.SelenideElement;
import pages.TestSuiteOverviewPage;

public class EditTestSuiteStep extends BaseStep {

    public TestSuiteOverviewPage editTestSuite(String testSuiteName, String testSuiteDescription) {
        fillTestSuite(testSuiteName, testSuiteDescription);
        return testSuiteOverviewPage;
    }

    public TestSuiteOverviewPage deleteTestSuite(String nameTestSuite) {
        editTestSuitePage.getDeleteTestSuiteButtonLocator(nameTestSuite).click();
        editTestSuitePage.getCheckBoxButtonLocator().click();
        editTestSuitePage.getConfirmationOkButtonLocator().click();
        return testSuiteOverviewPage;
    }

    public void deleteSuite(String nameTestSuite) {
        editTestSuitePage.getDeleteTestSuiteButtonLocator(nameTestSuite).click();
    }

    public void fillTestSuite(String testSuiteName, String testSuiteDescription) {
        editTestSuitePage.getDescriptionTestSuiteLocator().click();
        editTestSuitePage.getNameTestSuiteInputLocator().setValue(testSuiteName);
        editTestSuitePage.getDescriptionTestSuiteLocator().setValue(testSuiteDescription);
        editTestSuitePage.getSaveTestSuiteButtonLocator().click();
    }

    public SelenideElement getTestSuiteName() {
        return editTestSuitePage.getNameTestSuiteInputLocator();
    }

    public SelenideElement getDescription() {
        return editTestSuitePage.getDescriptionTestSuiteLocator();
    }
}
