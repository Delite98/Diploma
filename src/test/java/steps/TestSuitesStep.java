package steps;

import baseEntities.BaseStep;
import pages.AddTestSuitePage;

public class TestSuitesStep extends BaseStep {

    public AddTestSuitePage addTestSuite() {
        testSuite();
        return addTestSuitePage;
    }

    public void testSuite() {
        testSuitesPage.getAddTestSuiteButtonLocator().click();
    }
}
