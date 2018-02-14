package ui.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.utils.RemoteDriverManager;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class IssuePage extends BasePage {

    private String pageURL = baseURL + "/browse/%s";

    private HeaderPage headerPage;

    // page header buttons
    private By editIssueButton = By.id("edit-issue");
    private By commentIssueButton = By.id("comment-issue");
    private By assignIssueButton = By.id("assign-issue");
    private By moreButtonLocator = By.id("opsbar-operations_more");
    private By workflowButton = By.id("opsbar-transitions_more");
    private By backlogButton = By.xpath("//*[@id='action_id_11']/span[@class='trigger-label']");
    private By selectedForDevButton = By.xpath("//*[@id='action_id_21']/span[@class='trigger-label']");
    private By shareBtnLocator = By.id("jira-share-trigger");
    private By exportBtnLocator = By.id("viewissue-export");
    // my selectors
    private By viewWorkflow = By.id("opsbar-transitions_more");
    private By logWorkButton = By.xpath("//*[@id=\"log-work\"]");
    private By agileBoardButton = By.id("greenhopper-rapidboard-operation");
    private By rankToTopButton = By.id("greenhopper-rank-top-operation");
    private By rankToBottomButton = By.id("greenhopper-rank-bottom-operation");
    private By createZephyrTestButton = By.id("zephyr-create-test");
    private By attachFilesButton = By.id("attach-file");
    private By linkMoreButton = By.id("linkMoreButton");
    private By cloneMoreButton = By.id("clone-issue");
    private By labelsMoreButton = By.id("edit-labels");
    private By issueTypeButton = By.xpath("//*[@id=\"type-val\"]");

    //---Labels
    private By labelsSelect = By.id("labels-textarea");
    private By editAddedlabelLocator = By.xpath("//*[@class='labels-wrap value editable-field inactive']//*[@class='labels']");
    private String addedLabelLocator = "//*[contains(@class,'labels-wrap value editable-field inactive')]//*[contains(text(),'%s')]";
    // issue details
    private By projectIdLocator = By.id("project-name-val");
    private By issueSummaryLocator = By.id("summary-val");
    private By issueTypeField = By.id("type-val");
    private By issuePriorityField = By.id("priority-val");
    private By issueLabelsField = By.xpath("//a[@class='lozenge']/span");
    private By issueAssigneeField = By.id("issue_summary_assignee_" + username);
    private By issueDescriptionLocator = By.id("description-val");

    private By newSubtaskButtonLocator = By.id("stqc_show");
    private By summaryLocator = By.id("summary");
    private By submitButtonLocator = By.id("create-issue-submit");
    private By subtaskLocator = By.linkText("Snizhanna test");

    // Menu More
    private By createBtnSubtaskLocator = By.xpath("//*[@id='opsbar-operations_more_drop']//*[@id='create-subtask']");
    private By createSubtastPopUpLocator = By.id("create-subtask-dialog");

    private By deleteListItemLocator = By.id("delete-issue");
    private By deleteDialogLocator = By.id("delete-issue-dialog");
    private By deleteButtonLocator = By.id("delete-issue-submit");
    private By successPopUp = By.xpath("//*[contains(@class,'aui-message-success')]");
    private By commentBtnLocator = By.id("footer-comment-button");
    private By commentAreaLocator = By.id("comment");
    private By commentAddBtnLocator = By.id("issue-comment-add-submit");
    private By commentDeleteBtnLocator = By.xpath("//*[contains(@id,'delete_comment')]");
    private By commentDeletePopUpBtnLocator = By.id("comment-delete-submit");
    private By moreBtnSubtaskOnIssuePageLocator = By.xpath("//*[@id='view-subtasks']//*[@class='aui-icon aui-icon-small aui-iconfont-more']");
    private By deleteBtnSubtaskOnIssuePageLocator = By.xpath("//*[contains(@class,'aui-list-section aui-last')]//a[.='Delete']");
    private By deleteBtnSubtaskOnPopUpLocator = By.xpath("//*[@id='delete-issue-dialog']//*[@value='Delete']");
    // Edit Issue Pop Up
    private By updateIssueBtnPopUp = By.id("edit-issue-submit");


    private String subTaskSummary = "//*[@class='stsummary']//*[contains(text(),'%s')]";
    private String subTaskNumber = "//*[@class='stsequence']//*[contains(text(),'%s')]";
    private String subTaskAssignee = "//*[@class='assignee']//*[contains(text(),'%s')]";
    private String commentText = "//*[@id='issue_actions_container']//child::*[contains(text(),'%s')]";
    private By removeAttachmentItemLocator = By.xpath("//*[@class='attachment-delete']//span[.='Delete this attachment']");
    private By confirmationRemoveAttachment = By.xpath("//*[@id='delete-attachment-dialog']//*[@value='Delete']");

    // Comments sections

    //    private By commentTextType = By.id("aui-uid-2");
    private By commentTextType = By.id("comment");
//    private By subTaskText = By.xpath("//*[contains(text(),'%s')]");


    // Alena
    private By createLocator = By.xpath("//*[@id='create_link']");
    private By editIssueButtonLocator = By.xpath("//*[@id='edit-issue']");
    private By assignButtonLocator = By.xpath("//*[@id='assign-issue']");
    private By addSubTaskButtonLocator = By.xpath("//*[@class='ops']//*[@id='stqc_show']");
    private By addCommentButtonLocator = By.xpath("//*[@id='comment-issue']");
    private By selectForDevelopmentLocator = By.xpath("//*[@class='toolbar-trigger issueaction-workflow-transition']//*[contains(text(),'Selected for Development')]");
    private By moreDropDownLocator = By.xpath("//*[@id='opsbar-operations_more']");
    private By workflowLocator = By.id("opsbar-transitions_more");
    private By issueTypeLocator = By.xpath("//*[@class='wrap']//*[@id='type-val']");
    private By priorityFieldDefault = By.xpath("//*[@class='wrap']//*[@id='priority-val']");
    private By labelsFieldLocator = By.xpath("//*[@class='labels-wrap value editable-field inactive']");
    private By assigneeFieldLocator = By.xpath("//*[@class='people-details']//*[@id='assignee-val']");
    private By descriptionLocator = By.xpath("//*[@id='descriptionmodule_heading']");
    private By browseButton = By.xpath("//*[@duitype='dndattachment/dropzones/AttachmentsDropZone']//*[@class='issue-drop-zone__button']");
    private By deleteAttachmentLocator = By.xpath("//*[@class='blender blender-delete']");
    private String fileName = "//*[@class='attachment-content js-file-attachment']//*[contains(text(),'%s')]";


    public IssuePage() {
        this.driver = RemoteDriverManager.getDriver();
        headerPage = new HeaderPage();
    }

    public void openExistingIssue(String issueId) {
        String url = String.format(pageURL, issueId);
        super.openExistingIssue(url);
    }

    public IssuePage openNewSubTask() throws InterruptedException {
        waitToBePresentAndClick(newSubtaskButtonLocator);
        return this;
    }

    public IssuePage shouldSeeSuccessPopUp() {
        waitToBePresent(successPopUp);
        return this;
    }

    public IssuePage openSubtask() throws InterruptedException {
        waitToBePresentAndClick(subtaskLocator);
        return this;
    }

    public IssuePage clickMoreButton() {
        waitToBePresentAndClick(moreButtonLocator);
        return this;
    }

    public IssuePage clickCreateSubTask() {
        waitToBePresentAndClick(createBtnSubtaskLocator);
        return this;
    }

    public IssuePage clickDeleteListItem() {
        waitToBePresentAndClick(deleteListItemLocator);
        return this;
    }

    public IssuePage deleteSubTask() {
        waitToBePresentAndClick(deleteButtonLocator);
        return this;
    }

    public IssuePage clickOnCommentBtn() {
        waitToBePresentAndClick(commentBtnLocator);
        return this;
    }

    public IssuePage enterComment(String comment) {
        waitToBePresentAndClick(commentTextType);
        waitToBePresentAndSendKeys(commentAreaLocator, comment);
        return this;
    }

    public IssuePage clickOnAddComment() {
        waitToBePresentAndClick(commentAddBtnLocator);
        return this;
    }


    public IssuePage clickOnDeleteComment() {
        waitToBePresentAndClick(commentDeleteBtnLocator);
        return this;
    }

    public IssuePage confirmDeletionOfComment() {
        waitToBePresentAndClick(commentDeletePopUpBtnLocator);
        return this;
    }

    public IssuePage clickOnEditButton() {

        waitToBePresentAndClick(editIssueButton);

        return this;
    }

    public IssuePage clickOnHeaderCommentButton() {

        waitToBePresentAndClick(commentIssueButton);

        return this;
    }

    public IssuePage clickOnAssignButton() {

        waitToBePresentAndClick(assignIssueButton);

        return this;
    }

    public IssuePage clickOnWorkflowButton() {

        waitToBePresentAndClick(workflowButton);

        return this;
    }

    public IssuePage clickOnBacklogButton() {

        waitToBePresentAndClick(backlogButton);

        return this;
    }

    public IssuePage clickOnSelectedForDevButton() {

        waitToBePresentAndClick(selectedForDevButton);

        return this;
    }

    public IssuePage clickOnShareButton() {

        waitToBePresentAndClick(shareBtnLocator);

        return this;
    }

    public IssuePage findViewWorkflow() {

        driver.findElement(viewWorkflow);

        return this;
    }

    public IssuePage findLogWorkButton() {

        driver.findElement(logWorkButton);

        return this;
    }

    public IssuePage findAgileBoardButton() {

        driver.findElement(agileBoardButton);

        return this;
    }

    public IssuePage findRankToTopButton() {

        driver.findElement(rankToTopButton);

        return this;
    }

    public IssuePage findRankToBottomButton() {

        driver.findElement(rankToBottomButton);

        return this;
    }
    public IssuePage findCreateZephyrTestButton() {

        driver.findElement(createZephyrTestButton);

        return this;
    }
    public IssuePage findAttachFilesButton() {

        driver.findElement(attachFilesButton);

        return this;
    }
    public IssuePage findLinkMoreButton() {

        driver.findElement(linkMoreButton);

        return this;
    }
    public IssuePage findCloneMoreButton() {

        driver.findElement(cloneMoreButton);

        return this;
    }
    public IssuePage findLabelsMoreButton() {

        driver.findElement(labelsMoreButton);

        return this;
    }
    public IssuePage findIssueTypeButton() {

        driver.findElement(issueTypeButton);

        return this;
    }

    public IssuePage clickOnExportButton() {

        waitToBePresentAndClick(exportBtnLocator);

        return this;
    }

    // Checks

    public boolean isOnThePage(String issueId) {

        String url = String.format(pageURL, issueId);
        return super.isOnThePage(url);

    }

    public boolean isSubTaskSummaryPresent(String title) {
        String selector = String.format(subTaskSummary, title);
        return waitToBePresentAndContainsText(By.xpath(selector), title);
    }

    public boolean isSubTaskSummaryMissing(String title) {
        String selector = String.format(subTaskSummary, title);
        return waitToBeMissing(By.xpath(selector));
    }

    public boolean isSubTaskNumberPresent(String name) {
        String selector = String.format(subTaskNumber, name);
        return waitToBePresentAndContainsText(By.xpath(selector), name);
    }

    public boolean isSubTaskAssigneePresent(String name) {
        String selector = String.format(subTaskAssignee, name);
        return waitToBePresentAndContainsText(By.xpath(selector), name);
    }

    public boolean isCommentTextPresent(String text) {
        String selector = String.format(commentText, text);
        return waitToBePresentAndContainsText(By.xpath(selector), text);
    }

    public boolean isCommentTextMissing(String text) {
        String selector = String.format(commentText, text);
        return waitToBeMissing(By.xpath(selector));
    }

    public boolean isProjectIdCorrect(String projectId) {
        return waitToBePresentAndContainsText(projectIdLocator, projectId);
    }

    public boolean isIssueSummaryCorrect(String summary) {
        return waitToBePresentAndContainsText(issueSummaryLocator, summary);
    }

    public boolean isIssueTypeCorrect(String issueType) {
        return waitToBePresentAndContainsText(issueTypeField, issueType);
    }

    public boolean isIssuePriorityCorrect(String priority) {
        return waitToBePresentAndContainsText(issuePriorityField, priority);
    }

    public boolean isIssueLabelCorrect(String label) {
        return waitToBePresentAndContainsText(issueLabelsField, label);
    }

    public boolean isIssueDescriptionCorrect(String description) {
        return waitToBePresentAndContainsText(issueDescriptionLocator, description);
    }

    public boolean isIssueAssigneeCorrect() {
        if (driver.findElement(issueAssigneeField) == null) {
            return false;
        }
        return true;
    }

    public IssuePage clickEditButton() {
        waitTillBeAbleToClick(editIssueButton);
        return this;
    }

    public IssuePage clickUpdateButtonPopUp() {
        waitToBePresentAndClick(updateIssueBtnPopUp);
        return this;
    }

    //---Sub-task Actions on Issue Page by mmazur
    public IssuePage clickMoreBtnSubtask() {
        waitToBePresentAndClick(moreBtnSubtaskOnIssuePageLocator);
        return this;
    }

    public IssuePage clickDeleteSubTaskOnIssuePage() {
        waitToBePresentAndClick(deleteBtnSubtaskOnIssuePageLocator);
        return this;
    }

    public IssuePage clickDeleteSubTaskConfirmation() {
        waitToBePresentAndClick(deleteBtnSubtaskOnPopUpLocator);
        return this;
    }

    public IssuePage isCreatesubtaskPopUpPresent() {
        waitToBePresent(createSubtastPopUpLocator);
        return this;
    }

    public IssuePage clickRemoveAttachment() {
        waitToBePresentAndClick(removeAttachmentItemLocator);
        return this;
    }

    public IssuePage clickDeleteAttachmentConfirmationPopUp() {
        waitToBePresentAndClick(confirmationRemoveAttachment);
        return this;
    }

    public IssuePage deleteTicket() {
        waitToBePresentAndClick(moreButtonLocator);
        waitToBePresentAndClick(deleteListItemLocator);
        waitToBePresent(deleteDialogLocator);
        waitToBePresentAndClick(deleteButtonLocator);
        waitToBePresent(successPopUp);
        return this;
    }

    public IssuePage clickDeleteAttachment(){
        waitToBePresentAndClick(deleteAttachmentLocator);
        return this;
    }
    //---Add Labels
    public IssuePage clickLabelField() {
        waitToBePresentAndClick(labelsFieldLocator);
        return this;
    }
    public IssuePage addLabel(String issueLabel) {
        waitToBePresentAndSendKeys(labelsSelect, issueLabel);
        driver.findElement(labelsSelect).sendKeys(Keys.TAB);
        return this;
    }

    //---Edit/Delete Lable
    public IssuePage clickEditLabel() {
        waitToBePresentAndClick(editAddedlabelLocator);
        return this;
    }

    public IssuePage clickDescriptionField() {
        waitToBePresentAndClick(descriptionLocator);
        return this;
    }

    public boolean isLabelPresent(String label) {
        String selector = String.format(addedLabelLocator, label);
        return waitToBePresentAndContainsText(By.xpath(selector), label);  }

    //---Add Attachment

    public IssuePage clickBrowseButton() {
        waitToBePresentAndClick(browseButton);
        return this;
    }
    public boolean isAttachmentPresent(String file) {
        String selector = String.format(fileName, file);
        return waitToBePresentAndContainsText(By.xpath(selector), file);
    }

    public IssuePage setClipboardData(String string) {
        StringSelection stringSelection = new StringSelection(string);
        Toolkit.getDefaultToolkit().getSystemClipboard()
                .setContents(stringSelection, null);
        return this;
    }

    public IssuePage robot() throws AWTException {

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

    public boolean isEditIssueButtonPresent(){
        return   isElementPresent(editIssueButtonLocator);
    }
    public boolean isAssignButtonPresent(){
        return   isElementPresent(assigneeFieldLocator);
    }
    public boolean isAddCommentButtonPresent(){
        return   isElementPresent(addCommentButtonLocator);
    }
    public boolean isMoreButtonPresent(){
        return   isElementPresent(moreDropDownLocator);
    }
    public boolean isBacklogButtonPresent() {
        return isElementPresent(backlogButton);
    }
    public boolean isSelectForDevelopmentButtonPresent() {
        return isElementPresent(selectForDevelopmentLocator);
    }
    public boolean isWorkflowButtonPresent() {
        return isElementPresent(workflowLocator);
    }
    public boolean isTypeFieldPresent() {
        return isElementPresent(issueTypeLocator);
    }
    public boolean isPriorityFieldPresent() {
        return isElementPresent(priorityFieldDefault);
    }
    public boolean isLabelsFieldPresent() {
        return isElementPresent(labelsFieldLocator);
    }
    public boolean isDescriptionFieldPresent() {
        return isElementPresent(descriptionLocator);
    }
    public boolean isBrowseButtonPresent() {
        return isElementPresent(browseButton);
    }
}


