package baseEntities;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import configurations.ReadProperties;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeSuite;
import pages.DashboardPage;
import steps.*;

public class BaseTest {
    protected LoginStep loginStep;
    protected NavigationStep navigationStep;
    protected DashboardStep dashboardStep;
    protected AddProjectStep addProjectStep;
    protected ProjectOverviewStep projectOverviewStep;
    protected TestSuitesStep testSuitesStep;
    protected AddTestSuiteStep addTestSuiteStep;
    protected TestSuiteOverviewStep testSuiteOverviewStep;
    protected EditTestSuiteStep editTestSuiteStep;
    protected DashboardPage dashboardPage;

    @BeforeSuite
    public void setupBrowser() {
        Configuration.baseUrl = ReadProperties.getUrl();
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.browserPosition = "0x0";
        SelenideLogger.addListener("Selenide", new AllureSelenide());

        loginStep = new LoginStep();
        navigationStep = new NavigationStep();
        dashboardStep = new DashboardStep();
        addProjectStep = new AddProjectStep();
        projectOverviewStep = new ProjectOverviewStep();
        testSuitesStep = new TestSuitesStep();
        addTestSuiteStep = new AddTestSuiteStep();
        testSuiteOverviewStep = new TestSuiteOverviewStep();
        editTestSuiteStep = new EditTestSuiteStep();
        dashboardPage = new DashboardPage();
    }
}
