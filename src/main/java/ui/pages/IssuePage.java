package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import ui.utils.RemoteDriverManager;

public class IssuePage extends BasePage {

    private String pageURL = baseURL + "/browse/%s";

    private HeaderPage headerPage;

    // page header buttons
    private By editIssueButton = By.id("edit-issue");
    private By commentIssueButton = By.id("comment-issue");
    private By assignIssueButton = By.id("assign-issue");
    private By moreButton = By.id("opsbar-operations_more");
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
    private By moreButtonLocator = By.id("opsbar-operations_more");
    private By createBtnSubtaskLocator = By.xpath("//*[@id='opsbar-operations_more_drop']//*[@id='create-subtask']");
    private By createSubtastPopUpLocator = By.id("create-subtask-dialog");

    private By deleteListItemLocator = By.id("delete-issue");
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
        if (driver.findElement(issueAssigneeField) == null) {return false;}
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
}


