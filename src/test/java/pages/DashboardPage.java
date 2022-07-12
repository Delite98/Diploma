package pages;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class DashboardPage extends BasePage {
    private final static String pagePath = "/index.php?/dashboard";
    //locators
    private SelenideElement pageIdentifier = $x("//div[contains(@class, 'content-header-title') and contains(text(), 'All Projects')]");
    private SelenideElement addProjectButton = $("#sidebar-projects-add");
    private String openProjectByNameLocator = "//a[contains(@style,'padding-left: 25px') and contains(text(),'Replace')]";
    private SelenideElement iconHeaderMail = $(".icon-header-mail");
    private SelenideElement textIconHeaderMail = $(".top-social-link.link-tooltip:last-child");


    //corpuscular methods
    public SelenideElement getPageIdentifier() {
        return pageIdentifier;
    }

    public SelenideElement getAddProjectButton() {
        return addProjectButton;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public SelenideElement getOpenProjectByNameLocator(String projectName) {
        return $x(openProjectByNameLocator.replace("Replace", projectName));
    }

    public SelenideElement getIconHeaderMail() {
        return iconHeaderMail;
    }

    public SelenideElement getTextIconHeaderMail() {
        return textIconHeaderMail;
    }
}