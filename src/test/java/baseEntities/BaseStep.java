package baseEntities;

import pages.AddProjectPage;
import pages.DashboardPage;
import pages.LoginPage;

public class BaseStep {
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected AddProjectPage addProjectPage;

   /* protected AllProjectsPage allProjectsPage;
    protected MilestonesPage milestonesPage;
    protected AddMilestonePage addMilestonePage;
    protected EditMilestonePage editMilestonePage;*/

    public BaseStep() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        addProjectPage = new AddProjectPage();
        /*projectsPage = new ProjectsPage(driver);
        allProjectsPage = new AllProjectsPage(driver);
        milestonesPage = new MilestonesPage(driver);
        addMilestonePage = new AddMilestonePage(driver);
        editMilestonePage = new EditMilestonePage(driver);*/
    }
}
