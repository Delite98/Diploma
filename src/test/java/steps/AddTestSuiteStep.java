package steps;

import baseEntities.BaseStep;
import pages.ProjectOverviewPage;

public class AddTestSuiteStep extends BaseStep {
    public ProjectOverviewPage createTestSuite(String testSuiteName, String testSuiteDescription)  {
        fillTestSuite(testSuiteName, testSuiteDescription);
        return new ProjectOverviewPage();
    }

    public void fillTestSuite(String testSuiteName, String testSuiteDescription)  {
        addTestSuitePage.getNameTestSuiteInputLocator().setValue(testSuiteName);
        addTestSuitePage.getDescriptionTestSuiteInputLocator().setValue(testSuiteDescription);
        //addTestSuitePage.getAttachmentButtonLocator().click();

        //upload file???
       /* addTestSuitePage.getAttachFileButtonLocator()
                .sendKeys("C:\\Users\\Valera\\QA18\\Diploma1\\src\\test\\resources\\download.png");
*/

        addTestSuitePage.getAddTestSuiteButtonLocator().click();
    }
}
