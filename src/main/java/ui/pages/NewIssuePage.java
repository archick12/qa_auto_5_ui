package ui.pages;

import org.openqa.selenium.By;
import ui.utils.RemoteDriverManager;

public class NewIssuePage extends BasePage {

    private HeaderPage headerPage;

    private By newSubtaskButtonLocator = By.id("stqc_show");
    private By summaryLocator = By.id("summary");
    private By submitButtonLocator = By.id("create-issue-submit");
    private By subtaskLocator = By.linkText("Bobulan test");
    private By moreButtonLocator = By.id("opsbar-operations_more");
    private By deleteListItemLocator = By.id("delete-issue");
    private By deleteButtonLocator = By.id("delete-issue-submit");
    private By successPopUp = By.xpath("//*[contains(@class,'aui-message-success')]");


    public NewIssuePage() {

        this.driver = RemoteDriverManager.getDriver();
        headerPage = new HeaderPage();

    }

    public NewIssuePage fillSummary(String summary) {

        waitToBePresent(summaryLocator);
        driver.findElement(summaryLocator).sendKeys(summary);

        return this;
    }

    public NewIssuePage clickSubmitButton() {

        driver.findElement(submitButtonLocator).click();

        return this;
    }

}

