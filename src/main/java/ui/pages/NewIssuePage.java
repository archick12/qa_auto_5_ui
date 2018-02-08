package ui.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.utils.RemoteDriverManager;
import org.openqa.selenium.NoSuchElementException;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import static org.openqa.selenium.Keys.ENTER;

public class NewIssuePage extends BasePage {

    private HeaderPage headerPage;

    //---Create a New Issue Button and dialog
    private By createLocator = By.id("create_link");
    private By createIssueDialog = By.id("create-issue-dialog");
    private By successPopUp = By.xpath("//*[contains(@class,'aui-message-success')]");
    private By newIssueLinkOnSuccessPopup = By.xpath("//a[@class='issue-created-key issue-link']");

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
    private By fieldProjectLocator = By.id("project-field");
    // Marina S test locator
    private By fieldProjectLocatorTest = By.xpath("//div[@id='project-single-select']/span");
    private By projectSelectLocator = By.id("project-suggestions");

    //---Issue Type
    private By issueTypeLocator = By.xpath("//*[@class='wrap']//*[@id='type-val']");
    // Marina S test locator
    private By issueTypeLocatorTest = By.xpath("//div[@id='issuetype-single-select']/span");

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
    private By priorityFieldDefault = By.xpath("//*[@class='wrap']//*[@id='priority-val']");
    // Marina S test locator
    private By priorityFieldDefaultTest = By.xpath("//div[@id='priority-single-select']/span");
    private By priorityFieldSelect = By.id("priority-suggestions");
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
    private By labelsSelect = By.id("labels-textarea");
    //---Issue
    private By IssuelinksSelect = By.xpath("//*[@id='issuelinks-issues-multi-select']");
    private By IssuePopup = By.xpath("//a[@class='issue-picker-popup']");

    //---Attachment
    private By browseButton = By.xpath("//*[@duitype='dndattachment/dropzones/AttachmentsDropZone']//*[@class='issue-drop-zone__button']");
    private By deleteAttachmentLocator = By.xpath("//*[@class='blender blender-delete']");
    //---Locators for IssueSelector Pop-up
    private By pageHeader = By.xpath("//*[@class='aui-page-header-main']");
    private By selectButton = By.xpath("//*[@class='aui-button']");
    private By sourceRecent = By.xpath("//*[@class='radio']//child::*[@id='issue-source-recent']");
    private By sourceSearch = By.xpath("//*[@id='issue-source-search']");
    private By searchField = By.xpath("//*[@id='searchRequestId']");
    private By viewedIssues = By.xpath("//*[text()='Issues you have recently viewed']");
    private By first50Issues = By.xpath("//*[text()='First 50 issues from your current search']");

    //---Assignee
    private By assigneeFieldLocator = By.xpath("//*[@class='people-details']//*[@id='assignee-val']");
    private By assigneeSuggestions = By.xpath("//[@id='assignee-suggestions']");

    //---Assign to me
    private By assignToMeButtonLocator = By.id("assign-to-me-trigger");

    //---Create
    private By submitButtonLocator = By.id("create-issue-submit");

    //---Create another
    private By createAnotherButtonLocator = By.xpath("//*[@id='qf-create-another']");

    //---Epic Link
    private By linktoEpicFieldLocator = By.xpath("//*[@id='customfield_10000-field']");
    private By epicLinkSuggestions = By.xpath("//[@id='customfield_10000-suggestions']");

    //---Cancel
    private By cancelButtonLocator = By.xpath("//*[@title='Press undefined+` to cancel']");
    private By descriptionFieldLocator = By.id("description");
    // Marina S test locator
    private By descriptionFieldLocatorTest = By.xpath("//*[@id='description-wiki-edit']");

    //---Additional Locators for tests
    private By workflowLocator = By.id("opsbar-transitions_more");
    private By inProgressLocator = By.xpath("//*[@class='issueaction-workflow-transition']//*[text()='In Progress']");
    private By doneLocator = By.xpath("//*[@class='issueaction-workflow-transition']//*[text()='Done']");
    private By labelsFieldLocator = By.xpath("//*[@class='labels-wrap value editable-field inactive']");
    private By descriptionLocator = By.xpath("//*[@id='descriptionmodule_heading']");
    private String addedLabelLocator = "//*[contains(@class,'labels-wrap value editable-field inactive')]//*[contains(text(),'%s')]";
    private By selectForDevelopmentLocator = By.xpath("//*[@class='toolbar-trigger issueaction-workflow-transition']//*[contains(text(),'Selected for Development')]");
    private By browseButtonLocator = By.xpath("//*[@class='issue-drop-zone__button']");
    private String fileName = "//*[@class='attachment-content js-file-attachment']//*[contains(text(),'%s')]";
    private By selectAssignFieldButton = By.xpath("//*[@id='assign-issue']//*[text()='Assign']");
    private By selectDropDownButton = By.xpath("//*[@class='icon aui-ss-icon noloading drop-menu']//*[text()='More']");
    private By selectAssignPerson = By.xpath("//*[@id='assignee-field']");
    private By addComment = By.xpath("//*[@id='assign-dialog']//*[@id='comment']");
    private By selectAssignButton = By.xpath("//*[@class='buttons-container form-footer']//*[@class='aui-button']");
    private By selectTextButton = By.xpath("//*[@id='aui-uid-5']");
    private String assignedPersonLocator = "//*[@id='assignee-val']//*[contains(@id,'%s')]";
    private By statusButtonInProgress = By.xpath("//*[@id='status-val']//*[text()='In Progress']");
    private By statusButtonDone = By.xpath("//*[@id='status-val']//*[text()='Done']");
    private By backlogButton = By.xpath("//*[@class='toolbar-item']//*[@class='toolbar-trigger issueaction-workflow-transition']//*[text()='Backlog']");
    private By statusButtonBacklog = By.xpath("//*[@id='status-val']//*[text()='Backlog']");
    private By selectedForDevelopmentLocator = By.xpath("//*[@class='toolbar-item']//*[@class='toolbar-trigger issueaction-workflow-transition']//*[text()='Selected for Development']");
    private By statusButtonSelectForDevelopment = By.xpath("//*[@id='status-val']//*[text()='Selected for Development']");

    private By unassignedButton = By.xpath("//*[normalize-space() = 'Unassigned']");
    private By assignPopUp = By.className("aui-flag");
    private By updateStatusPopUp = By.className("aui-flag");

    // Alena
    private By editIssueButtonLocator = By.xpath("//*[@id='edit-issue']");
    private By assignButtonLocator = By.xpath("//*[@id='assign-issue']");
    private By addSubTaskButtonLocator = By.xpath("//*[@class='ops']//*[@id='stqc_show']");
    private By addCommentButtonLocator = By.xpath("//*[@id='comment-issue']");
    private By moreDropDownLocator = By.xpath("//*[@id='opsbar-operations_more']");
    private By issueTypeFieldLocator = By.id("type-val");;
    private By shareBtnLocator = By.id("jira-share-trigger");
    private By exportBtnLocator = By.id("viewissue-export");




    //---Create New Issue
    public NewIssuePage() {
        this.driver = RemoteDriverManager.getDriver();
        headerPage = new HeaderPage();
    }

    public NewIssuePage clickCreateAndWaitForDialog() {
        waitToBePresentAndClick(createLocator);
        waitToBePresent(createIssueDialog);
        return this;
    }

    public NewIssuePage submitNewTicketAndOpenIt() {
        waitToBePresentAndClick(submitButtonLocator);
        waitToBePresent(successPopUp);
        waitToBePresentAndClick(newIssueLinkOnSuccessPopup);
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
    public NewIssuePage enterProject(String projectId) {
        waitTillBeAbleToClick(fieldProjectLocator);
        driver.findElement(fieldProjectLocator).clear();
        waitToBePresentAndSendKeys(fieldProjectLocator, projectId);
        driver.findElement(fieldProjectLocator).sendKeys(Keys.TAB);
        return this;
    }

    // Marina S test method
    public NewIssuePage enterProjectTest(String projectId) {
        waitTillBeAbleToClick(fieldProjectLocatorTest);
        driver.findElement(fieldProjectLocatorTest).clear();
        waitToBePresentAndSendKeys(fieldProjectLocatorTest, projectId);
        driver.findElement(fieldProjectLocatorTest).sendKeys(Keys.TAB);
        return this;
    }

    //---Select IssueType
    public NewIssuePage enterIssueType(String issueType) {
        waitTillBeAbleToClick(issueTypeLocator);
        driver.findElement(issueTypeLocator).clear();
        waitToBePresentAndSendKeys(issueTypeLocator, issueType);
        driver.findElement(issueTypeLocator).sendKeys(Keys.TAB);
        return this;
    }

    // Marina S test method
    public NewIssuePage enterIssueTypeTest(String issueType) {
        waitTillBeAbleToClick(issueTypeLocatorTest);
        driver.findElement(issueTypeLocatorTest).clear();
        waitToBePresentAndSendKeys(issueTypeLocatorTest, issueType);
        driver.findElement(issueTypeLocatorTest).sendKeys(Keys.TAB);
        return this;
    }

    //---Fill Summary
    public NewIssuePage fillSummary(String summary) {
        waitTillBeAbleToClick(summaryLocator);
        waitToBePresentAndSendKeys(summaryLocator, summary);
        return this;
    }

    //---Fill nameEpic
    public NewIssuePage fillNameEpic(String name) {
        waitTillBeAbleToClick(nameEpicLocator);
        waitToBePresentAndSendKeys(nameEpicLocator, name);
        return this;
    }

    //---Add Description
    public NewIssuePage fillDescription(String issueDescription) {
        waitToBePresentAndSendKeys(descriptionFieldLocator, issueDescription);
        return this;
    }

    // Marina S test method
    public NewIssuePage fillDescriptionTest(String issueDescription) {
        waitTillBeAbleToClick(descriptionFieldLocatorTest);
        waitToBePresentAndSendKeys(descriptionFieldLocatorTest, issueDescription);
        return this;
    }

    //Select Priority
    public NewIssuePage selectPriority(String priority) {
        waitTillBeAbleToClick(priorityFieldDefault);
        driver.findElement(priorityFieldDefault).clear();
        waitToBePresentAndSendKeys(priorityFieldDefault, priority);
        driver.findElement(priorityFieldDefault).sendKeys(Keys.TAB);
        return this;
    }

    public NewIssuePage selectPriorityTest(String priority) {
        waitTillBeAbleToClick(priorityFieldDefaultTest);
        driver.findElement(priorityFieldDefaultTest).clear();
        waitToBePresentAndSendKeys(priorityFieldDefaultTest, priority);
        driver.findElement(priorityFieldDefaultTest).sendKeys(Keys.TAB);
        return this;
    }

    //---Add Labels
    public NewIssuePage addLabel(String issueLabel) {
        waitToBePresentAndSendKeys(labelsSelect, issueLabel);
        driver.findElement(labelsSelect).sendKeys(Keys.TAB);
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


    //---Assign User
    public NewIssuePage assignUser() {
        driver.findElement(assigneeFieldLocator).clear();
        waitToBePresentAndSendKeys(assigneeFieldLocator, username);
        driver.findElement(assigneeFieldLocator).sendKeys(Keys.TAB);
        return this;
    }

    //---Assign to me
    public NewIssuePage clickAssignToMeButton() {
        waitToBePresentAndClick(assignToMeButtonLocator);
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
        waitToBePresentAndClick(submitButtonLocator);
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


    public boolean isAddedLabelPresent(String label) {
        String selector = String.format(addedLabelLocator, label);
        return waitToBePresentAndContainsText(By.xpath(selector), label);
    }

    public NewIssuePage clickBrowseButton() {
        waitToBePresentAndClick(browseButtonLocator);
        return this;
    }

    public boolean isAttachmentPresent(String file) {
        String selector = String.format(fileName, file);
        return waitToBePresentAndContainsText(By.xpath(selector), file);
    }

    public NewIssuePage setClipboardData(String string) {
        StringSelection stringSelection = new StringSelection(string);
        Toolkit.getDefaultToolkit().getSystemClipboard()
                .setContents(stringSelection, null);
        return this;
    }

    public NewIssuePage robot() throws AWTException {

        Robot rb = new Robot();
        rb.delay(1000);
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.delay(300);
        rb.keyPress(KeyEvent.VK_V);
        rb.delay(300);
        rb.keyRelease(KeyEvent.VK_V);
        rb.delay(700);
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.delay(300);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.delay(300);
        rb.keyRelease(KeyEvent.VK_ENTER);
        rb.delay(300);

        return this;
    }

    public NewIssuePage selectAssignFieldButton() {
        driver.findElement(selectAssignFieldButton).click();
        return this;
    }

    public NewIssuePage selectDropDownButton() {
        driver.findElement(selectDropDownButton).click();
        return this;
    }

    public NewIssuePage selectAssignField(String text) {

        driver.findElement(selectAssignPerson).clear();
        driver.findElement(selectAssignPerson).sendKeys(text);
        driver.findElement(selectAssignPerson).sendKeys(Keys.TAB);
        return this;
    }

    public NewIssuePage addComment() {
        driver.findElement(addComment);
        driver.findElement(addComment).sendKeys("Great");
        return this;

    }

    public NewIssuePage selectAssignButton() {
        driver.findElement(selectAssignButton).click();
        return this;
    }

    public NewIssuePage checkThatDropdownListItemIsPresent(String itemText) {
        driver.findElement(selectAssignButton).click();

        String.format(itemText, selectAssignPerson); // %s
        return this;
    }

    public NewIssuePage selectTextButton() {
        driver.findElement(selectTextButton).click();
        return this;
    }

    public Boolean assignPersonIsPresent(String assigneeName) {
        By assignedPerson = By.xpath(String.format(assignedPersonLocator.toString(), assigneeName));
        try {
            driver.findElement(assignedPerson);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

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

    public boolean isButtonWithTextPresent() {
        By buttonSelector = statusButtonInProgress;
        try {
            driver.findElement(buttonSelector);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public NewIssuePage clickLabelField() {
        waitToBePresentAndClick(labelsFieldLocator);
        return this;
    }

    public NewIssuePage clickDescriptionField() {
        waitToBePresentAndClick(descriptionLocator);
        return this;
    }

    public boolean isLabelPresent(String label) {
        String selector = String.format(addedLabelLocator, label);
        return waitToBePresentAndContainsText(By.xpath(selector), label);  }

    public NewIssuePage clickSelectForDevelopment() {
        waitToBePresentAndClick(selectForDevelopmentLocator);
        return this;
    }

    public NewIssuePage selectBacklogButton() {
        waitToBePresentAndClick(backlogButton);
        return this;
    }

    public boolean isButtonWithTextBacklogPresent() {
        By buttonBacklogSelector = statusButtonBacklog;
        try {
            driver.findElement(buttonBacklogSelector);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public NewIssuePage clickSelectedForDevelopment(){
        waitToBePresentAndClick(selectedForDevelopmentLocator);
        return this;
    }

    public boolean isButtonWithTextSelectForDevelopment(){
        By buttonSelectForDevelopment = statusButtonSelectForDevelopment;
        try {
            driver.findElement(buttonSelectForDevelopment);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }

    }

    public Boolean isSelectUnassignButtonIsPresent() {
        By unassignedButton = By.xpath("//*[normalize-space() = 'Unassigned']");
        try {
            driver.findElement(unassignedButton);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public Boolean isSelectUnassignIsPresent(String assigneeName) {
        By assignedPerson = By.xpath(String.format(assignedPersonLocator.toString(), assigneeName));
        try {
            driver.findElement(assignedPerson);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public NewIssuePage waitForAssignPopUp() {
        new WebDriverWait(RemoteDriverManager.getDriver(), 10)
                .until(ExpectedConditions.invisibilityOfElementLocated(assignPopUp));
        return this;
    }

    public NewIssuePage waitForUpdateStatusPopUp(){
        new WebDriverWait(RemoteDriverManager.getDriver(),10)
                .until(ExpectedConditions.invisibilityOfElementLocated(updateStatusPopUp));
        return this;
    }

    public NewIssuePage clickDeleteAttachment(){
        waitToBePresentAndClick(deleteAttachmentLocator);
        return this;
    }


// Method for SMOKE Test

    public static int defaultImplicitWaitInSeconds = 10;
    private int defaultExplicitWaitInSeconds = 10;

    public boolean isElementPresent(By locator) {
        logger.info("WAIT ELEMENT TO BE PRESENT: " + locator);
      try{
        (new WebDriverWait(driver, defaultExplicitWaitInSeconds))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
        return true;
    }
    catch (Exception e) {
        return false;
    }
}


    public NewIssuePage checkAreElementsPresent(){
        isElementPresent(createLocator);
        isElementPresent(editIssueButtonLocator);
        isElementPresent(addCommentButtonLocator);
        isElementPresent(assignButtonLocator);
        isElementPresent(moreDropDownLocator);
        isElementPresent(backlogButton);
        isElementPresent(selectForDevelopmentLocator);
        isElementPresent(workflowLocator);
        isElementPresent(shareBtnLocator);
        isElementPresent(exportBtnLocator);
        isElementPresent(issueTypeLocator);
        isElementPresent(priorityFieldDefault);
        isElementPresent(labelsFieldLocator);
        isElementPresent(assigneeFieldLocator);
        isElementPresent(descriptionLocator);
        isElementPresent(browseButton);
//        isElementPresent(addSubTaskButtonLocator);
        return this;
    }






}
