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

   /* protected AllProjectsPage allProjectsPage;
    protected MilestonesPage milestonesPage;
    protected AddMilestonePage addMilestonePage;
    protected EditMilestonePage editMilestonePage;*/

    public BaseStep() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        addProjectPage = new AddProjectPage();
        projectOverviewPage = new ProjectOverviewPage();
        testSuitesPage = new TestSuitesPage();
        addTestSuitePage = new AddTestSuitePage();
        testSuiteOverviewPage = new TestSuiteOverviewPage();
        editTestSuitePage = new EditTestSuitePage();
        /*projectsPage = new ProjectsPage(driver);
        allProjectsPage = new AllProjectsPage(driver);
        milestonesPage = new MilestonesPage(driver);
        addMilestonePage = new AddMilestonePage(driver);
        editMilestonePage = new EditMilestonePage(driver);*/
    }
}
