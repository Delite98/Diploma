package steps;

import baseEntities.BaseStep;
import pages.EditTestSuitePage;
import pages.TestSuitesPage;

public class TestSuiteOverviewStep extends BaseStep {
    public EditTestSuitePage selectEditTestSuite() {
        testSuite();
        return editTestSuitePage;
    }

    public void testSuite() {
        testSuiteOverviewPage.getEditButtonLocator().click();
    }
}

