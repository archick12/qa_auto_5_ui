package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.utils.RemoteDriverManager;

import static org.openqa.selenium.Keys.ENTER;

public class NewIssuePage extends BasePage {

    private HeaderPage headerPage;
    //---Old Locators
    //---Creating Sub-Task inside ticket
    //private By newSubtaskButtonLocator = By.id("stqc_show");
    //private By subtaskLocator = By.linkText("Snizhanna test"); - should be changed for a specific test
    //private By moreButtonLocator = By.id("opsbar-operations_more");
    //private By deleteListItemLocator = By.id("delete-issue"); - not found
    //private By deleteButtonLocator = By.id("delete-issue-submit"); - not found
    //private By successPopUp = By.xpath("//*[contains(@class,'aui-message-success')]");
    //---Create a New Issue Button
    private By createLocator = By.id("create_link");
    //---Configure Fields
    private By configureFiedlsLocator = By.id("qf-field-picker-trigger");
    private By showFieldsAllLocator = By.xpath("//a[@class='qf-unconfigurable']");
    private By showFieldsCustomLocator = By.xpath("//a[@class='qf-configurable']");
    private By selectAssigneeLocator = By.xpath("//*[contains(@class,'qf-picker-button')]//a[.='Assignee']");
    private By selectAttachmentLocator = By.xpath("//*[contains(@class,'qf-picker-button')]//a[.='Attachment']");
    private By selectComponentsLocator = By.xpath("//*[contains(@class,'qf-picker-button')]//a[.='Component/s']");
    private By selectDescriptionLocator = By.xpath("//*[contains(@class,'qf-picker-button')]//a[.='Description']");
    private By selectFixVersionsLocator = By.xpath("//*[contains(@class,'qf-picker-button')]//a[.='Fix Version/s']");
    private By selectLabelsLocator = By.xpath("//*[contains(@class,'qf-picker-button')]//a[.='Labels']");
    private By selectLinkedIssueLocator = By.xpath("//*[@data-field-id='issuelinks']");
    private By selectPriorityLocator = By.xpath("//*[contains(@class,'qf-picker-button')]//a[.='Priority']");
    private By selectLinkToEpicLocator = By.xpath("//*[contains(@class,'qf-picker-button')]//a[.='Ссылка на эпик']");
    //---Project
    private By fieldProjectLocator = By.xpath("//*[@id='project-field']");
    private By projectSelectLocator = By.xpath("//*[@class='icon aui-ss-icon noloading drop-menu']");
    //---Issue Type
    private By issueTypeLocator = By.xpath("//*[@id='issuetype-field']");
    //---Epic Name
    private By nameEpicLocator = By.xpath("//*[@id='customfield_10002']");
    //---Issue Select
    private By issueSelectLocator = By.xpath("//*[@id='issuetype-suggestions']");
    //---Summary
    private By summaryLocator = By.id("summary");
    //---Description
    private By menuStyle = By.xpath("//*[@field-id='description']//child::*[text()='Style']");
    private By iconBold = By.xpath("//*[@field-id='description']//ancestor::*[@data-operation='bold']");
    private By iconItalic = By.xpath("//*[@field-id='description']//following::*[@data-operation='italic']");
    private By iconUnderline = By.xpath("//*[@field-id='description']//child::*[@data-operation='underline']");
    private By iconTextColor = By.xpath("//*[@field-id='description']//*[@original-title='Text color']");
    private By moreColors = By.xpath("//*[@field-id='description']//descendant::*[@data-operation='color-parameter']");
    private By menuMore = By.xpath("//*[@field-id='description']//parent::*[@original-title='More' ]");
    private By menuLink = By.xpath("//*[@field-id='description']//following::*[@original-title='Link (Ctrl+K)']");
    private By menuAttachment = By.xpath("//*[@class='aui-buttons']//child::*[@original-title='Attachment']");
    private By iconBulletList = By.xpath("//*[@field-id='description']//following::*[@original-title='Bullet list (Ctrl+Shift+B)']");
    private By iconNumberedList = By.xpath("//*[@field-id='description']//following::*[@original-title='Numbered list (Ctrl+Shift+N)']");
    private By menuIcons = By.xpath("//*[@field-id='description']//following::*[@original-title='Icons']");
    private By menuOther = By.xpath("//*[@field-id='description']//following::*[@original-title='Other']");
    private By iconCollapseExpand = By.xpath("//*[@field-id='description']//following::*[@original-title='Toggle visibility']");
    private By editDescription = By.id("description-wiki-edit");
    private By tabVisual = By.xpath("//*[@data-mode='wysiwyg']//child::*[@id='aui-uid-0']");
    private By tabText = By.xpath("//*[@data-mode='source']");
    private By iconUndo = By.xpath("//*[@title='Undo']//child::span[@class='aui-icon aui-icon-small aui-iconfont-undo']");
    private By iconRedo = By.xpath("//*[@title='Redo']");
    //---Priority
    private By localHelp = By.xpath("//*[@id='priority-single-select']//following::span[contains(@class,'aui-iconfont-help')]");
    private By priorityFieldDefault = By.xpath("//*[@id='priority-field']");
    private By prioritySelectHighest = By.xpath("//*[@id='priority-single-select']//following::*[a[text()='Highest']]");
    private By prioritySelectHigh = By.xpath("//*[@id='priority-single-select']//a[text()='High']");
    private By prioritySelectLow = By.xpath("//*[@id='priority-single-select']//a[text()='Low']");
    private By prioritySelectLowest = By.xpath("//*[@id='priority-single-select']//a[text()='Lowest']");
    //---Linked Issue
    private By linkedIssuesDefault = By.xpath("//*[@id='issuelinks-linktype'] //child::*[@value='blocks']");
    private By linkedIssuesIsBlockedBy = By.xpath("/*[@id='issuelinks-linktype'] //child::*[@value='is blocked by']");
    private By linkedIssuesIsClones = By.xpath("//*[@id='issuelinks-linktype'] //child::*[@value='clones']");
    private By linkedIssuesIsClonedBy = By.xpath("//*[@id='issuelinks-linktype'] //descendant::*[@value='is cloned by']");
    private By linkedIssuesDuplicates = By.xpath("//*[@id='issuelinks-linktype'] //descendant-or-self::*[@value='duplicates']");
    private By linkedIssuesIsDuplicatedBy = By.xpath("//*[@id='issuelinks-linktype'] //child::*[@value='is duplicated by']");
    private By linkedIssuesRelatesTo = By.xpath("//*[@id='issuelinks-linktype'] //child::*[@value='relates to']");
    //---Labels
    private By labelsSelect = By.xpath("//*[@class='jira-multi-select long-field']//*[@id='labels-textarea']");
    //---Issue
    private By IssuelinksSelect = By.xpath("//*[@id='issuelinks-issues-multi-select']");
    private By IssuePopup = By.xpath("//a[@class='issue-picker-popup']");
    //---Attachment
    private By browseButton = By.xpath("//*[@class='form-body']//child::*[@class='issue-drop-zone__button']");
    //---Locators for IssueSelector Pop-up
    private By pageHeader = By.xpath("//*[@class='aui-page-header-main']");
    private By selectButton = By.xpath("//*[@class='aui-button']");
    private By sourceRecent = By.xpath("//*[@class='radio']//child::*[@id='issue-source-recent']");
    private By sourceSearch = By.xpath("//*[@id='issue-source-search']");
    private By searchField = By.xpath("//*[@id='searchRequestId']");
    private By viewedIssues = By.xpath("//*[text()='Issues you have recently viewed']");
    private By first50Issues = By.xpath("//*[text()='First 50 issues from your current search']");
    //---Assignee
    private By assigneeFieldLocator = By.xpath("//*//child::*[@id='assignee-field']");
    private By assigneeSuggestions = By.xpath("//[@id='assignee-suggestions']");
    //---Assign to me
    private By assignToMeButtonLocator = By.xpath("//*[@id='assign-to-me-trigger']");
    //---Create
    private By submitButtonLocator = By.id("create-issue-submit");
    //---Create another
    private By createAnotherButtonLocator = By.xpath("//*[@id='qf-create-another']");
    //---Epic Link
    private By linktoEpicFieldLocator = By.xpath("//*[@id='customfield_10000-field']");
    private By epicLinkSuggestions = By.xpath("//[@id='customfield_10000-suggestions']");
    //---Cancel
    private By cancelButtonLocator = By.xpath("//*[@title='Press undefined+` to cancel']");
    private By descriptionFieldLocator = By.xpath("//*[@id='description']");

    //---Create New Issue
    public NewIssuePage() {
        this.driver = RemoteDriverManager.getDriver();
        headerPage = new HeaderPage();
    }

    public NewIssuePage clickCreateIssueButton() {
        waitToBePresentAndClick(createLocator);
        return this;
    }


    //---Configure Fields
    public NewIssuePage clickConfigureFieldsButton() {
        waitToBePresentAndClick(configureFiedlsLocator);
        return this;
    }

    public NewIssuePage clickCustomLink() {
        waitToBePresentAndClick(showFieldsCustomLocator);
        return this;
    }

    public NewIssuePage clickAllLink() {
        waitToBePresentAndClick(showFieldsAllLocator);
        return this;
    }

    public boolean isElementActive(By selector) {
        try {
            driver.findElement(selector);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public NewIssuePage clickAllOrCustom() {
        if (isElementActive(showFieldsCustomLocator) == true) {
            driver.findElement(showFieldsCustomLocator).click();
        } else {
            driver.findElement(showFieldsAllLocator).click();
        }
        return this;
    }

    public NewIssuePage selectAssignee() {
        driver.findElement(selectAssigneeLocator).click();
        return this;
    }

    public NewIssuePage selectAttachment() {
        driver.findElement(selectAttachmentLocator).click();
        return this;
    }

    public NewIssuePage selectComponents() {
        driver.findElement(selectComponentsLocator).click();
        return this;
    }

    public NewIssuePage selectDescription() {
        driver.findElement(selectDescriptionLocator).click();
        return this;
    }

    public NewIssuePage selectFixVersion() {
        driver.findElement(selectFixVersionsLocator).click();
        return this;
    }

    public NewIssuePage selectLabels() {
        driver.findElement(selectLabelsLocator).click();
        return this;
    }

    public NewIssuePage selectLinkedIssue() {
        driver.findElement(selectLinkedIssueLocator).click();
        return this;
    }

    public NewIssuePage selectPriority() {
        driver.findElement(selectPriorityLocator).click();
        return this;
    }

    public NewIssuePage selectEpicLink() {
        driver.findElement(selectLinkToEpicLocator).click();
        return this;
    }

    //---Select Project
    String projectId = "QAAuto5 (QAAUT)";

    public NewIssuePage enterProject(String projectId) {
        driver.findElement(fieldProjectLocator).clear();
        driver.findElement(fieldProjectLocator).sendKeys(projectId);
        driver.findElement(projectSelectLocator).click();
        return this;
    }

    //---Select IssueType
    String issueType = "Epic";

    //---Bug,Task or Story
    public NewIssuePage enterIssueType(String issueType) {
        driver.findElement(issueTypeLocator).clear();
        driver.findElement(issueTypeLocator).sendKeys(issueType);
        driver.findElement(issueSelectLocator).click();
        return this;
    }

    //---Methods for each Issue Type
    public NewIssuePage selectTypeStoryLocator() {
        driver.findElement(issueTypeLocator).clear();
        driver.findElement(issueTypeLocator).sendKeys("Story");
        driver.findElement(issueSelectLocator).click();
        return this;
    }

    public NewIssuePage selectTypeBugLocator() {
        driver.findElement(issueTypeLocator).click();
        driver.findElement(issueTypeLocator).sendKeys("Bug");
        driver.findElement(issueSelectLocator).click();
        return this;
    }

    public NewIssuePage selectTypeEpicLocator() {
        driver.findElement(issueTypeLocator).click();
        driver.findElement(issueTypeLocator).sendKeys("Epic");
        driver.findElement(issueSelectLocator).click();
        return this;
    }

    public NewIssuePage selectTypeTaskLocator() {
        driver.findElement(issueTypeLocator).click();
        driver.findElement(issueTypeLocator).sendKeys("Task");
        driver.findElement(issueSelectLocator).click();
        return this;
    }

    //---Fill Summury
    public NewIssuePage fillSummary(String summary) {
        waitToBePresent(summaryLocator);
        driver.findElement(summaryLocator).sendKeys(summary);
        return this;
    }

    //---Add Description
    public NewIssuePage fillDescription() {
        driver.findElement(descriptionFieldLocator).sendKeys("Important text");
        return this;
    }

    //Select Priority
    public NewIssuePage selectHighestPriority() {
        driver.findElement(priorityFieldDefault).clear();
        driver.findElement(priorityFieldDefault).sendKeys("Highest");
        driver.findElement(priorityFieldDefault).click();
        driver.findElement(labelsSelect).click();
        return this;
    }

    public NewIssuePage selectHighPriority() {
        driver.findElement(priorityFieldDefault).clear();
        driver.findElement(priorityFieldDefault).sendKeys("High");
        driver.findElement(priorityFieldDefault).click();
        driver.findElement(labelsSelect).click();
        return this;
    }

    public NewIssuePage selectLowPriority() {
        driver.findElement(priorityFieldDefault).clear();
        driver.findElement(priorityFieldDefault).sendKeys("Low");
        driver.findElement(priorityFieldDefault).click();
        driver.findElement(labelsSelect).click();
        return this;
    }

    public NewIssuePage selectLowestPriority() {
        driver.findElement(priorityFieldDefault).clear();
        driver.findElement(priorityFieldDefault).sendKeys("Lowest");
        driver.findElement(priorityFieldDefault).click();
        driver.findElement(labelsSelect).click();
        return this;
    }


    //---Add Labels
    public NewIssuePage addLabel(String label) {
        waitToBePresentAndSendKeys(labelsSelect, label);
        return this;
    }

    //---Select Linked Issues
    public NewIssuePage selectLinkedIssuesLocator() {
        driver.findElement(linkedIssuesDefault).click();
        return this;

    }

    public NewIssuePage selectLinkedIssueIsBlockedBy() {
        driver.findElement(linkedIssuesIsBlockedBy).click();
        return this;
    }

    public NewIssuePage selectLinkedIssuesClones() {
        driver.findElement(linkedIssuesIsClones).click();
        return this;
    }

    public NewIssuePage selectLinkedIssueIsClonedBy() {
        driver.findElement(linkedIssuesIsClonedBy).click();
        return this;
    }

    public NewIssuePage selectLinkedIssuesDuplicates() {
        driver.findElement(linkedIssuesDuplicates).click();
        return this;
    }

    public NewIssuePage selectLinkedIssuesIsDuplicatedBy() {
        driver.findElement(linkedIssuesIsDuplicatedBy).click();
        return this;
    }

    public NewIssuePage selectLinkedIssuesRelatesTo() {
        driver.findElement(linkedIssuesRelatesTo).click();
        return this;
    }

    //---Add Attachment
    public NewIssuePage browseButton() {
        driver.findElement(browseButton).click();
        return this;
    }

    //---Add Issue (Pop up)
    public NewIssuePage IssuePopup() {
        driver.findElement(IssuePopup).click();
        return this;
    }

    public NewIssuePage pageHeader() {
        driver.findElement(pageHeader).click();
        return this;
    }

    public NewIssuePage selectButton() {
        driver.findElement(selectButton).click();
        return this;
    }

    public NewIssuePage sourceRecent() {
        driver.findElement(sourceRecent).click();
        return this;
    }

    public NewIssuePage sourceSearch() {
        driver.findElement(sourceSearch).click();
        return this;
    }

    public NewIssuePage searchField() {
        driver.findElement(sourceSearch).click();
        driver.findElement(searchField).click();
        return this;
    }

    public NewIssuePage viewedIssues() {
        driver.findElement(viewedIssues).click();
        return this;
    }

    public NewIssuePage first50Issues() {
        driver.findElement(first50Issues).click();
        return this;
    }

    //---Assignee User
    public NewIssuePage assigneeUser() {
        driver.findElement(assigneeFieldLocator).clear();
        driver.findElement(assigneeFieldLocator).sendKeys("Marina Kuzmina");
        driver.findElement(assigneeSuggestions).click();
        return this;
    }

    //---Assign to me
    public NewIssuePage clickAssignToMeButton() {
        driver.findElement(assignToMeButtonLocator).click();
        return this;
    }

    //---Add Epic Link
    public NewIssuePage addEpicLink() {
        driver.findElement(linktoEpicFieldLocator).clear();
        driver.findElement(linktoEpicFieldLocator).sendKeys("Epic_AQA_5_MMazur");
        driver.findElement(epicLinkSuggestions).click();
        return this;
    }

    //---Create Issue
    public NewIssuePage clickSubmitButton() {
        driver.findElement(submitButtonLocator).click();
        return this;
    }

    //---Create another Issue
    public NewIssuePage createAnotherIssue() {
        driver.findElement(createAnotherButtonLocator).click();
        driver.findElement(submitButtonLocator).click();
        return this;
    }

    //---Cancel creation
    public NewIssuePage pressCancelButton() {
        driver.findElement(cancelButtonLocator).click();
        return this;
    }

    private By workflowLocator = By.id("opsbar-transitions_more");
    private By inProgressLocator = By.xpath("//*[@class='issueaction-workflow-transition']//*[text()='In Progress']");
    private By doneLocator = By.xpath("//*[@class='issueaction-workflow-transition']//*[text()='Done']");

    public NewIssuePage clickWorkflowButton() {
        driver.findElement(workflowLocator).click();
        return this;
    }


    public NewIssuePage selectInProgressButton() {
        waitToBePresentAndClick(inProgressLocator);

        return this;
    }

    public NewIssuePage selectDoneButton() {
        waitToBePresentAndClick(doneLocator);
        return this;
    }

    private By labelsFieldLocator = By.xpath("//*[@class='labels-wrap value editable-field inactive']");
    private By descriptionLocator = By.xpath("//*[@id='descriptionmodule_heading']");
    private By addedLabelLocator = By.xpath("//*[contains(@class,'labels-wrap value editable-field inactive')]//*[@title='My_label']");
    private By selectForDevelopmentLocator = By.xpath("//*[@id='action_id_21']//*[@class='toolbar-trigger issueaction-workflow-transition']");

    public NewIssuePage clickLabelField() {
        waitToBePresentAndClick(labelsFieldLocator);
        return this;
    }

    public NewIssuePage clickDescriptionField() {
        waitToBePresentAndClick(descriptionLocator);
        return this;
    }

    public boolean isAddedLabelPresent() {
        waitToBePresent(addedLabelLocator);
        return true;
    }

    public NewIssuePage clickSelectForDevelopment() {
        waitToBePresentAndClick(selectForDevelopmentLocator);
        return this;
    }
}
