package ui;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
import ui.pages.*;
import utils.TestCase;

import static org.testng.Assert.assertEquals;

public class CreateIssueTest {

  // code that will be invoked before each @Test
  @BeforeGroups(groups = {"UI","CreateIssue"})
  public void setUp() {
    LoginPage loginPage = new LoginPage();

    loginPage.open();
    assertEquals(loginPage.isOnThePage(), true); // confirm that we are on the right page
    // otherwise we can click a wrong web element

    loginPage.enterUsername();
    loginPage.enterPassword();
    loginPage.clickLogin();

    NewIssuePage newIssuePage = new NewIssuePage();
    newIssuePage.clickCreateIssueButton();
    newIssuePage.waitForCreateIssueDialog();

  }

  // code that will be invoked after each @Test
  @AfterTest
  public void cleanUp() {
    IssuePage issuePage = new IssuePage();
    // TODO need to delete each ticket after test
  }


  @TestCase(id = "C13") // annotation that holds number of test case in TestRail
  @Test(groups = {"UI","CreateIssue"}) // annotation that helps to mark method as test and include pr exclude them by group name in testng.xml
  public void createNewStory() throws InterruptedException {

    NewIssuePage newIssuePage = new NewIssuePage();
    IssuePage issuePage = new IssuePage();

    String projectId = "QAAuto5";
    String issueType = "Story";
    String storySummary = "Team 2 Story summary";
    String storyDescription = "Team 2 Story description";
    String issuePriority = "Lowest";
    String issueLabel = "QAAuto5";

    // create new issue
    newIssuePage.enterProject(projectId);
    newIssuePage.enterIssueType(issueType);
    newIssuePage.fillSummary(storySummary);
    newIssuePage.fillDescription(storyDescription);
    newIssuePage.selectPriority(issuePriority);
    newIssuePage.addLabel(issueLabel);
    newIssuePage.assignUser();
    newIssuePage.clickSubmitButton();

    // check that new issue is created successfully
    newIssuePage.clickNewIssueLinkOnSuccessPopup();
    assertEquals(true, issuePage.isProjectIdCorrect(projectId));
    assertEquals(true, issuePage.isIssueSummaryCorrect(storySummary));
    assertEquals(true, issuePage.isIssueTypeCorrect(issueType));
    assertEquals(true, issuePage.isIssuePriorityCorrect(issuePriority));
    assertEquals(true, issuePage.isIssueLabelCorrect(issueLabel));
    assertEquals(true, issuePage.isIssueDescriptionCorrect(storyDescription));
    assertEquals(true, issuePage.isIssueAssigneeCorrect());
  }
}