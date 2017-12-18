package ui;

import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
import ui.pages.*;

import static org.testng.Assert.assertEquals;

public class RefactoredIssueTest {

    @BeforeGroups // (groups = {"functional"})
    public void setUp() {
        // code that will be invoked when this test is instantiated

        // TODO put login logic here

    }


    @Test // (groups = {"functional"})
    public void subTaskCRUD() throws InterruptedException {

        String parentIssueId = "QAAUT-224";
        String subTaskSummary = "Snizhanna test";
        String subTaskNumber = "1";
        String subTaskAssignee = "Unassigned";

        //Login

        LoginPage loginPage = new LoginPage();
        NewIssuePage newIssuePage = new NewIssuePage();
        HeaderPage headerPage = new HeaderPage();
        DashBoardPage dashBoardPage = new DashBoardPage();
        IssuePage issuePage = new IssuePage();

        loginPage.open();
        assertEquals(loginPage.isOnThePage(), true);

        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickLogin();

        assertEquals(dashBoardPage.isOnThePage(), true);

        //Create new sub-task

        headerPage.search(parentIssueId);

        assertEquals(issuePage.isOnThePage(parentIssueId), true);
        issuePage.openNewSubTask();
        newIssuePage.fillSummary(subTaskSummary);
        newIssuePage.clickSubmitButton();

        assertEquals(issuePage.isSubTaskSummaryPresent(subTaskSummary), true);
        assertEquals(issuePage.isSubTaskNumberPresent(subTaskNumber), true);
        assertEquals(issuePage.isSubTaskAssigneePresent(subTaskAssignee), true);
        // TODO assert for sub-task status


        //Delete new sub-task
        issuePage.openSubtask();
        issuePage.shouldSeeSuccessPopUp();
        issuePage.clickMoreButton();
        issuePage.clickDeleteListItem();
        issuePage.deleteSubTask();
        // TODO check success popup appeared

        issuePage.openExistingIssue(parentIssueId);
        assertEquals(issuePage.isSubTaskSummaryMissing(subTaskSummary), true);

    }

    @Test(groups = {"functional"})
    public void subTaskCommentCRUD() throws InterruptedException {


        String subTaskId = "QAAUT-465";
        // String subtaskIssueId = "QAAUT-224";
        String commentText = "Test Comment";

        //Login

        LoginPage loginPage = new LoginPage();
        NewIssuePage newIssuePage = new NewIssuePage();
        HeaderPage headerPage = new HeaderPage();
        DashBoardPage dashBoardPage = new DashBoardPage();
        IssuePage issuePage = new IssuePage();

        loginPage.open();
        assertEquals(loginPage.isOnThePage(), true);

        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickLogin();

        assertEquals(dashBoardPage.isOnThePage(), true);
        issuePage.openExistingIssue(subTaskId);
        assertEquals(issuePage.isOnThePage(subTaskId), true);


        issuePage.clickOnCommentBtn();
        issuePage.enterComment(commentText);
        issuePage.clickOnAddComment();

        // TODO assert that comment is present
        assertEquals(issuePage.isCommentTextPresent(commentText), true);

        issuePage.clickOnDeleteComment();
        issuePage.confirmDeletionOfComment();

        assertEquals(issuePage.isCommentTextMissing(commentText), true);

    }
}