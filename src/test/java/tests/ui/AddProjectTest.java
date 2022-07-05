package tests.ui;

import baseEntities.BaseTest;
import configurations.ReadProperties;
import org.testng.annotations.Test;

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
}
