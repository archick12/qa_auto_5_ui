package ui;

import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
import ui.pages.*;
import utils.TestCase;

import static org.testng.Assert.assertEquals;

public class RefactoredIssueTest {

  // code that will be invoked before each @Test
  @BeforeGroups(groups = {"UI"})
  public void setUp() {

  }


  @TestCase(id = "1") // annotation that holds number of test case in TestRail
  @Test(groups = {"UI", "SKIPP"}) // annotation that helps to mark method as test and include pr exclude them by group name in testng.xml
  public void subTaskCRUD() throws InterruptedException {

    LoginPage loginPage = new LoginPage();
    NewIssuePage newIssuePage = new NewIssuePage();
    HeaderPage headerPage = new HeaderPage();
    DashBoardPage dashBoardPage = new DashBoardPage();
    IssuePage issuePage = new IssuePage();

    String parentIssueId = "QAAUT-8";
    String subTaskSummary = "subTaskCommentCRUD";
    String subTaskNumber = "1";
    String subTaskAssignee = "Unassigned";

    loginPage.open();
    assertEquals(loginPage.isOnThePage(), true); // confirm that we are on the right page
    // otherwise we can click a wrong web element

    loginPage.enterUsername();
    loginPage.enterPassword();
    loginPage.clickLogin();

    assertEquals(dashBoardPage.isOnThePage(), true);

    // Navigate to a parent task
    headerPage.search(parentIssueId);
    assertEquals(issuePage.isOnThePage(parentIssueId), true);

    //Create new sub-task
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

  @TestCase(id = "1") // TODO without this framework fails with NullPointer at String testCaseId = testerInfo.id();
  @Test(groups = {"UI"})
  public void subTaskCommentCRUD() throws InterruptedException {

    LoginPage loginPage = new LoginPage();
    NewIssuePage newIssuePage = new NewIssuePage();
    HeaderPage headerPage = new HeaderPage();
    DashBoardPage dashBoardPage = new DashBoardPage();
    IssuePage issuePage = new IssuePage();

    String subTaskId = "QAAUT-8";
    String commentText = "Test Comment";

    loginPage.open();
    assertEquals(loginPage.isOnThePage(), true); // confirm that we are on the right page
    // otherwise we can click a wrong web element

    loginPage.enterUsername();
    loginPage.enterPassword();
    loginPage.clickLogin();

    Thread.sleep(5000);
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