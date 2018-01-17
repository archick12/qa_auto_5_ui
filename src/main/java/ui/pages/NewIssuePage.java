package ui.pages;

import org.openqa.selenium.By;
import ui.utils.RemoteDriverManager;

public class NewIssuePage extends BasePage {

    private HeaderPage headerPage;

    private By configureFiedlsLocator = By.id("qf-field-picker-trigger");
// Locators for all check-boxes in PopUp Configure Fields
    private By showFieldsAllLocator = By.xpath("//*[contains(@class,'qf-unconfigurable')]//a[.='All']");
    private By showFieldsCustomLocator = By.xpath("//*[contains(@class,'qf-unconfigurable')]//a[.='Custom']");
    private By selectAssigneeLocator = By.xpath("//*[contains(@class,'qf-picker-button')]//a[.='Assignee']");
    private By selectAttachmentLocator = By.xpath("//*[contains(@class,'qf-picker-button')]//a[.='Attachment']");
    private By selectComponentsLocator = By.xpath("//*[contains(@class,'qf-picker-button')]//a[.='Component/s']");
    private By selectDescriptionLocator = By.xpath("//*[contains(@class,'qf-picker-button')]//a[.='Description']");
    private By selectFixVersionsLocator = By.xpath("//*[contains(@class,'qf-picker-button')]//a[.='Fix Version/s']");
    private By selectLabelsLocator = By.xpath("//*[contains(@class,'qf-picker-button')]//a[.='Labels']");
    private By selectPriorityLocator = By.xpath("//*[contains(@class,'qf-picker-button')]//a[.='Priority']");
    private By selectLinkToEpicLocator = By.xpath("//*[contains(@class,'qf-picker-button')]//a[.='Ссылка на эпик']");

    //Locators for create Issue
    private By fieldProjectLocator = By.xpath("//*[@id='project-field']");
    private By issueTypeLocator = By.xpath("//*[@id='issuetype-field']");
    private By nameEpicLocator = By.xpath("//*[@id='customfield_10002']");
    private By summaryFieldLocator = By.xpath("//*[@id='summary']");

    private By assigneeFieldLocator = By.xpath("//*[@id='assignee-field']");
    private By assignToMeButtonLocator = By.xpath("(//*[@id='assign-to-me-trigger']");
    private By createButtonLocator = By.xpath("//*[@id='create-issue-submit']");
    private By createAnotherButtonLocator = By.xpath("//*[@id='qf-create-another']");
    private By linktoEpicFieldLocator = By.xpath("//*[@id='customfield_10000-field']");
    private By cancelButtonLocator = By.xpath("//*[@title='Press undefined+` to cancel']");
    private By dropAssigneeFieldLocator = By.xpath("//*[@id='assignee-field']//a[text()='unassigned-2']");
    private By dropCustomFieldArtefacts = By.xpath("//*[@id='customfield_10000']//a[text()='artefacts']");
    private By getDropCustomFieldBonusshop = By.xpath("//*[@id='customfield_10000']//a[text()='bonusshop']");
    private By getDropCustomFieldExtraapps = By.xpath("//*[@id='customfield_10000']//a[text()='extraaps']");








    private By newSubtaskButtonLocator = By.id("stqc_show");
    private By summaryLocator = By.id("summary");
    private By submitButtonLocator = By.id("create-issue-submit");
    private By subtaskLocator = By.linkText("Snizhanna test");
    private By moreButtonLocator = By.id("opsbar-operations_more");
    private By deleteListItemLocator = By.id("delete-issue");
    private By deleteButtonLocator = By.id("delete-issue-submit");
    private By successPopUp = By.xpath("//*[contains(@class,'aui-message-success')]");


    // Locators for CreateIssue
    private By localHelp = By.xpath("//*[@id='priority-single-select']//following::span[contains(@class,'aui-iconfont-help')]");
    private By priorityFieldDefault = By.xpath("//*[@id='priority-field']");
    private By prioritySelectHighest = By.xpath("//*[@id='priority-single-select']//a[text()='Highest']");
    private By prioritySelectHigh = By.xpath("//*[@id='priority-single-select']//a[text()='High']");
    private By prioritySelectLow = By.xpath("//*[@id='priority-single-select']//a[text()='Low']");
    private By prioritySelectLowest = By.xpath("//*[@id='priority-single-select']//a[text()='Lowest']");
    private By linkedIssuesDefault = By.xpath("//*[@id='issuelinks-linktype']");
    private By linkedIssuesIsBlockedBy = By.xpath("//*[@id='issuelinks-linktype'] //*[@value='is blocked by']");
    private By linkedIssuesIsClones = By.xpath("//*[@id='issuelinks-linktype'] //*[@value='clones']");
    private By linkedIssuesIsClonedBy = By.xpath("//*[@id='issuelinks-linktype'] //*[@value='is cloned by']");
    private By linkedIssuesDuplicates = By.xpath("//*[@id='issuelinks-linktype'] //*[@value='duplicates']");
    private By linkedIssuesIsDuplicatedBy = By.xpath("//*[@id='issuelinks-linktype'] //*[@value='is duplicated by']");
    private By linkedIssuesRelatesTo = By.xpath("//*[@id='issuelinks-linktype'] //*[@value='relates to']");
    private By labelsSelect = By.xpath("//*[@id='labels-multi-select']");
    private By IssuelinksSelect = By.xpath("//*[@id='issuelinks-issues-multi-select']");
    private By IssuePopup = By.xpath("//a[@class='issue-picker-popup']");
    private By browseButton = By.xpath("//*[@class='form-body']//*[@class='issue-drop-zone__button']");


   //Locators for IssueSelector
    private By pageHeader = By.xpath("//*[@class='aui-page-header-main']");
    private By selectButton = By.xpath("//*[@class='aui-button']");
    private By sourceRecent = By.xpath("//*[@id='issue-source-recent']");
    private By sourceSearch = By.xpath("//*[@id='issue-source-search']");
    private By searchField = By.xpath("//*[@id='searchRequestId']");
    private By viewedIssues = By.xpath("//*[text()='Issues you have recently viewed']");
    private By first50Issues = By.xpath("//*[text()='First 50 issues from your current search']");


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

