package baseEntities;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import configurations.ReadProperties;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeSuite;
import steps.AddProjectStep;
import steps.DashboardStep;
import steps.LoginStep;

public class BaseTest {
    protected LoginStep loginStep;
    protected DashboardStep dashboardStep;
    protected AddProjectStep addProjectStep;

    @BeforeSuite
    public void setupBrowser() {
        Configuration.baseUrl = ReadProperties.getUrl();
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.browserPosition = "0x0";
        SelenideLogger.addListener("Selenide", new AllureSelenide());

        loginStep = new LoginStep();
        dashboardStep = new DashboardStep();
        addProjectStep = new AddProjectStep();
    }
}
