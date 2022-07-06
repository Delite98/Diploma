package tests.ui;

import baseEntities.BaseTest;
import configurations.ReadProperties;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AddProjectTest extends BaseTest {
    @Test
    public void addProject() {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        dashboardStep.successAddProject();
        addProjectStep.createProject("test", "test", false,
                        "suite_mode_single", false)
                .getTabByName("test")
                .isDisplayed();
    }

    @Test
    public void addTestSuiteTest() {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        dashboardStep.openProject("test2");
        projectOverviewStep.selectTestSuite();
        testSuitesStep.addTestSuite();
        addTestSuiteStep.createTestSuite("testSuite1", "test")
                .getMessageLocator()
                .isDisplayed();
    }


    @Test
    public void uploadTest() throws InterruptedException {
        open("http://the-internet.herokuapp.com/upload");
        $("#file-upload").sendKeys("C:\\Users\\Valera\\QA18\\Diploma1\\src\\test\\resources\\download.png");
        $("#file-submit").click();
        Thread.sleep(5000);
    }
}
