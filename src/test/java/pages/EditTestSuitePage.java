package pages;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class EditTestSuitePage extends BasePage {
    //locators
    private SelenideElement pageIdentifier = $x("//div[contains(@class,'content-header-title')]");
    private SelenideElement nameTestSuiteInputLocator = $x("//input[@id='name']");
    private SelenideElement descriptionTestSuiteLocator = $x("//div[@id='description_display']");
    private SelenideElement saveTestSuiteButtonLocator = $x("//button[@id='accept']");
    private SelenideElement cancelButtonLocator = $x("//div//button[@id='accept']/following-sibling::a");
    private SelenideElement deleteTestSuiteButtonLocator = $x("//a[contains(text(),'Delete this test suite')]");
    private SelenideElement dialogFormLocator = $x("//div[@class='dialog-body']/p[text()='Really delete this test suite and all ']");
    private SelenideElement checkBoxButtonLocator = $x("//span[@class='dialog-confirm-busy']/following::input[@name='deleteCheckbox']");
    private SelenideElement confirmationOkButtonLocator = $x("//div[contains(@class,'delete-confirm-container')]/following::a[contains(text(),'OK')]");
    private SelenideElement confirmationCancelButtonLocator = $x("//a[contains(@class,'dialog-action-secondary')]/following-sibling::a[contains(text(),'Cancel')]");
    private SelenideElement returnToDashboardPageButtonLocator = $("#navigation-dashboard-top");

    //corpuscular methods
    @Override
    protected SelenideElement getPageIdentifier() {
        return pageIdentifier;
    }

    public SelenideElement getNameTestSuiteInputLocator() {
        return nameTestSuiteInputLocator;
    }

    public SelenideElement getDescriptionTestSuiteLocator() {
        return descriptionTestSuiteLocator;
    }

    public SelenideElement getSaveTestSuiteButtonLocator() {
        return saveTestSuiteButtonLocator;
    }

    public SelenideElement getCancelButtonLocator() {
        return deleteTestSuiteButtonLocator;
    }

    public SelenideElement getDeleteTestSuiteButtonLocator(String nameTestSuite) {
        return deleteTestSuiteButtonLocator;
    }

    public SelenideElement getDialogFormLocator() {
        return dialogFormLocator;
    }

    public SelenideElement getCheckBoxButtonLocator() {
        return checkBoxButtonLocator;
    }

    public SelenideElement getConfirmationOkButtonLocator() {
        return confirmationOkButtonLocator;
    }

    public SelenideElement getConfirmationCancelButtonLocator() {
        return confirmationCancelButtonLocator;
    }

    public SelenideElement getReturnToDashboardPageButtonLocator() {
        return returnToDashboardPageButtonLocator;
    }
}
