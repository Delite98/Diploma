package steps;

import baseEntities.BaseStep;
import pages.DashboardPage;

public class NavigationStep extends BaseStep {
    public DashboardPage navigateToDashboard() {
        testSuiteOverviewPage.getReturnToDashboardButtonLocator().click();
        return dashboardPage;
    }
}
