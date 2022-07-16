package baseEntities;

import pages.*;

public class BaseStep {
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected AddProjectPage addProjectPage;
    protected ProjectOverviewPage projectOverviewPage;
    protected TestSuitesPage testSuitesPage;
    protected AddTestSuitePage addTestSuitePage;
    protected TestSuiteOverviewPage testSuiteOverviewPage;
    protected EditTestSuitePage editTestSuitePage;

    public BaseStep() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        addProjectPage = new AddProjectPage();
        projectOverviewPage = new ProjectOverviewPage();
        testSuitesPage = new TestSuitesPage();
        addTestSuitePage = new AddTestSuitePage();
        testSuiteOverviewPage = new TestSuiteOverviewPage();
        editTestSuitePage = new EditTestSuitePage();
    }
}
