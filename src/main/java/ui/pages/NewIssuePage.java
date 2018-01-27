package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import ui.utils.RemoteDriverManager;

import static org.openqa.selenium.Keys.ENTER;

public class NewIssuePage extends BasePage {

    private HeaderPage headerPage;

    //---Create a New Issue Button and dialog
    private By createLocator = By.id("create_link");
    private By createIssueDialog = By.id("create-issue-dialog");
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
    private By projectSelectLocator = By.xpath("//*[@class='icon aui-ss-icon noloading drop-menu']");

    //---Issue Type
    private By issueTypeLocator = By.id("issuetype-field");

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
    private By priorityFieldDefault = By.id("priority-field");
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
    private By labelsSelect = By.id("labels-multi-select");

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
    private By descriptionFieldLocator = By.id("description");

    //---Create New Issue
    public NewIssuePage() {
        this.driver = RemoteDriverManager.getDriver();
        headerPage = new HeaderPage();
    }

    public void clickCreateIssueButton(){
        waitToBePresentAndClick(createLocator);
    }

    public void waitForCreateIssueDialog(){
        waitToBePresent(createIssueDialog);
    }

    public void clickNewIssueLinkOnSuccessPopup(){
        waitToBePresentAndClick(newIssueLinkOnSuccessPopup);
    }


    //---Configure Fields
    public void clickConfigureFieldsButton(){
        waitToBePresentAndClick(configureFiedlsLocator);
    }

    public void clickCustomLink() {
        waitToBePresentAndClick(showFieldsCustomLocator);
    }

    public void clickAllLink(){
        waitToBePresentAndClick(showFieldsAllLocator);
    }

    public boolean isElementActive(By selector) {
        try {
            driver.findElement(selector);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickAllOrCustom(){
        if (isElementActive(showFieldsCustomLocator)==true){
            driver.findElement(showFieldsCustomLocator).click(); }
        else {
            driver.findElement(showFieldsAllLocator).click();
        }
    }

    public void selectAssignee(){
        driver.findElement(selectAssigneeLocator).click();
    }

    public void selectAttachment(){
        driver.findElement(selectAttachmentLocator).click();
    }

    public void selectComponents(){
        driver.findElement(selectComponentsLocator).click();
    }

    public void selectDescription(){
        driver.findElement(selectDescriptionLocator).click();
    }

    public void selectFixVersion(){
        driver.findElement(selectFixVersionsLocator).click();
    }

    public void selectLabels(){
        driver.findElement(selectLabelsLocator).click();
    }

    public void selectLinkedIssue(){
        driver.findElement(selectLinkedIssueLocator).click();
    }

    public void selectEpicLink(){
        driver.findElement(selectLinkToEpicLocator).click();
    }

    //---Select Project
    public void enterProject(String projectId){
        driver.findElement(fieldProjectLocator).clear();
        waitToBePresentAndSendKeys(fieldProjectLocator, projectId);
        waitToBePresentAndSendKeysTab(fieldProjectLocator);
    }

    //---Select IssueType
    public void enterIssueType(String issueType) {
        driver.findElement(issueTypeLocator).clear();
        waitToBePresentAndSendKeys(issueTypeLocator, issueType);
        waitToBePresentAndSendKeysTab(issueTypeLocator);
    }

    //---Fill Summary
    public void fillSummary(String summary) {
        waitToBePresentAndClick(summaryLocator);
        waitToBePresentAndSendKeys(summaryLocator, summary);
    }

    //---Add Description
    public void fillDescription(String issueDescription) {
        waitToBePresentAndClick(descriptionFieldLocator);
        waitToBePresentAndSendKeys(descriptionFieldLocator, issueDescription);
    }

    //Select Priority
    public void selectPriority(String priority) {
        driver.findElement(priorityFieldDefault).clear();
        waitToBePresentAndSendKeys(priorityFieldDefault, priority);
        waitToBePresentAndSendKeysTab(priorityFieldDefault);
    }

    //---Add Labels
    public void addLabel(String issueLabel){
        waitToBePresentAndSendKeys(labelsSelect, issueLabel);
        waitToBePresentAndSendKeysTab(labelsSelect);
    }

    //---Select Linked Issues
    public void selectLinkedIssuesLocator(){
        driver.findElement(linkedIssuesDefault).click();

    }

    public void selectLinkedIssueIsBlockedBy(){
        driver.findElement(linkedIssuesIsBlockedBy).click();
    }

    public void selectLinkedIssuesClones(){
        driver.findElement(linkedIssuesIsClones).click();
    }

    public void selectLinkedIssueIsClonedBy(){
        driver.findElement(linkedIssuesIsClonedBy).click();
    }

    public void selectLinkedIssuesDuplicates(){
        driver.findElement(linkedIssuesDuplicates).click();
    }

    public void selectLinkedIssuesIsDuplicatedBy(){
        driver.findElement(linkedIssuesIsDuplicatedBy).click();
    }

    public void selectLinkedIssuesRelatesTo(){
        driver.findElement(linkedIssuesRelatesTo).click();
    }

    //---Add Attachment
    public void browseButton() {
        driver.findElement(browseButton).click();
    }

    //---Add Issue (Pop up)
    public void IssuePopup() {
        driver.findElement(IssuePopup).click();
    }

    public void pageHeader() {
        driver.findElement(pageHeader).click();
    }

    public void selectButton() {
        driver.findElement(selectButton).click();
    }

    public void sourceRecent() {
        driver.findElement(sourceRecent).click();
    }

    public void sourceSearch() {
        driver.findElement(sourceSearch).click();
    }

    public void searchField() {
        driver.findElement(sourceSearch).click();
        driver.findElement(searchField).click();
    }

    public void viewedIssues() {
        driver.findElement(viewedIssues).click();
    }

    public void first50Issues() {
        driver.findElement(first50Issues).click();
    }

    //---Assignee User
    public void assigneeUser(String assignee){
        driver.findElement(assigneeFieldLocator).clear();
        driver.findElement(assigneeFieldLocator).sendKeys(assignee);
        driver.findElement(assigneeSuggestions).click();
    }

    //---Assign to me
    public void clickAssignToMeButton() {
        driver.findElement(assignToMeButtonLocator).click();
    }

    //---Add Epic Link
    public void addEpicLink(){
        driver.findElement(linktoEpicFieldLocator).clear();
        driver.findElement(linktoEpicFieldLocator).sendKeys("Epic_AQA_5_MMazur");
        driver.findElement(epicLinkSuggestions).click();
    }

    //---Create Issue
    public void clickSubmitButton() {
        driver.findElement(submitButtonLocator).click();
    }

    //---Create another Issue
    public void createAnotherIssue() {
        driver.findElement(createAnotherButtonLocator).click();
        driver.findElement(submitButtonLocator).click();
    }

    //---Cancel creation
    public void pressCancelButton() {
        driver.findElement(cancelButtonLocator).click();
    }


}