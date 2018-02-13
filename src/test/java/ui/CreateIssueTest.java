package ui;

import org.testng.ITestResult;
import org.testng.annotations.*;
import ui.pages.*;
import utils.TestCase;

import static org.testng.Assert.assertEquals;
import org.apache.log4j.Logger;

public class CreateIssueTest {

  final static Logger logger = Logger.getLogger(BasePage.class); // initialization of logger

  // code that will be invoked before the first test method that belongs to any of these groups
  @BeforeGroups(groups = {"UI","CreateIssue"})
  public void setUp() {
    LoginPage loginPage = new LoginPage();
    loginPage
            .open();
    assertEquals(loginPage.isOnThePage(), true);
    loginPage
            .enterUsername()
            .enterPassword()
            .clickLogin();
  }

  // code that will be invoked before before each test method
  @BeforeMethod(alwaysRun = true)
  public void setUpTest() {
    NewIssuePage newIssuePage = new NewIssuePage();
    newIssuePage.clickCreateAndWaitForDialog();
  }

  // code that will be invoked after each test method
  @AfterMethod(alwaysRun = true)
  public void cleanUp(ITestResult iTestResult) {
    IssuePage issuePage = new IssuePage();
    if(iTestResult.isSuccess()) {
    logger.info("!---Gonna delete a ticket---!");
    issuePage.deleteTicket();
    }
  }


  // Alesya's test
  // TODO: figure out how to deal with the elements inside the frame; example: description field in visual mode
  @TestCase(id = "C13") // annotation that holds number of test case in TestRail
  @Test(groups = {"UI","CreateIssue", "stable"}) // annotation that helps to mark method as test and include pr exclude them by group name in testng.xml
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
    newIssuePage
            .enterProject(projectId)
            .enterIssueType(issueType)
            .fillSummary(storySummary)
            .switchDescriptionToTextMode() // this step is for Chrome - it can't focus on description if it's in visual mode
            .fillDescription(storyDescription)
            .selectPriority(issuePriority)
            .addLabel(issueLabel)
            .assignUser()
            .submitNewTicketAndOpenIt();

    // check that new issue is created successfully
    assertEquals(true, issuePage.isProjectIdCorrect(projectId));
    assertEquals(true, issuePage.isIssueSummaryCorrect(storySummary));
    assertEquals(true, issuePage.isIssueTypeCorrect(issueType));
    assertEquals(true, issuePage.isIssuePriorityCorrect(issuePriority));
    assertEquals(true, issuePage.isIssueLabelCorrect(issueLabel));
    assertEquals(true, issuePage.isIssueDescriptionCorrect(storyDescription));
    assertEquals(true, issuePage.isIssueAssigneeCorrect());
  }


    // Alex's test
    @TestCase(id = "C11")
    @Test(groups = {"UI", "CreateIssue", "stable"})
    public void createNewBug () throws InterruptedException {
      NewIssuePage newIssuePage = new NewIssuePage();
      IssuePage issuePage = new IssuePage();

      String projectId = "QAAuto5";
      String issueType = "Bug";
      String bugSummary = "Team 2 bug summary";
      String bugDescription = "Team 2 bug description";
      String issuePriority = "High";
      String issueLabel = "QAAuto5";

      newIssuePage
                .enterProject(projectId)
                .enterIssueType(issueType)
                .fillSummary(bugSummary)
                .switchDescriptionToTextMode() // this step is for Chrome - it can't focus on description if it's in visual mode
                .fillDescription(bugDescription)
                .selectPriority(issuePriority)
                .addLabel(issueLabel)
                .assignUser()
                .submitNewTicketAndOpenIt();

      // check that new issue is created successfully
      assertEquals(true, issuePage.isProjectIdCorrect(projectId));
      assertEquals(true, issuePage.isIssueSummaryCorrect(bugSummary));
      assertEquals(true, issuePage.isIssueTypeCorrect(issueType));
      assertEquals(true, issuePage.isIssuePriorityCorrect(issuePriority));
      assertEquals(true, issuePage.isIssueLabelCorrect(issueLabel));
      assertEquals(true, issuePage.isIssueDescriptionCorrect(bugDescription));
      assertEquals(true, issuePage.isIssueAssigneeCorrect());
    }

  // Marina S test
  @TestCase(id = "C9") // annotation that holds number of test case in TestRail
  @Test(groups = {"UI","CreateIssue", "stable"}) // annotation that helps to mark method as test and include pr exclude them by group name in testng.xml
  public void createNewTask() throws InterruptedException {

    NewIssuePage newIssuePage = new NewIssuePage();
    IssuePage issuePage = new IssuePage();

    String projectId = "QAAuto5";
    String issueType = "Task";
    String taskSummary = "Team 2 Task";
    String taskDescription = "Team 2 description";
    String issuePriority = "High";
    String issueLabel = "QAAuto5";

    newIssuePage
            .enterProject(projectId)
            .enterIssueType(issueType)
            .fillSummary(taskSummary)
            .switchDescriptionToTextMode() // this step is for Chrome - it can't focus on description if it's in visual mode
            .fillDescription(taskDescription)
            .selectPriority(issuePriority)
            .addLabel(issueLabel)
            .assignUser()
            .submitNewTicketAndOpenIt();

    // check that new issue is created successfully
    assertEquals(true, issuePage.isProjectIdCorrect(projectId));
    assertEquals(true, issuePage.isIssueSummaryCorrect(taskSummary));
    assertEquals(true, issuePage.isIssueTypeCorrect(issueType));
    assertEquals(true, issuePage.isIssuePriorityCorrect(issuePriority));
    assertEquals(true, issuePage.isIssueLabelCorrect(issueLabel));
    assertEquals(true, issuePage.isIssueDescriptionCorrect(taskDescription));
    assertEquals(true, issuePage.isIssueAssigneeCorrect());
  }

  // Eugene's test
  @TestCase(id = "C10") // annotation that holds number of test case in TestRail
  @Test(groups = {"UI","CreateIssue", "stable"}) // annotation that helps to mark method as test and include pr exclude them by group name in testng.xml
  public void createNewEpic() throws InterruptedException {

    NewIssuePage newIssuePage = new NewIssuePage();
    IssuePage issuePage = new IssuePage();

    String projectId = "QAAuto5";
    String issueType = "Epic";
    String epicName = "Team 2 Epic имя эпика";
    String epicSummary = "Team 2 Epic summary";
    String epicDescription = "Team 2 Epic description";
    String issuePriority = "Medium";
    String issueLabel = "QAAuto5";

    // create new issue
    newIssuePage
            .enterProject(projectId)
            .enterIssueType(issueType)
            .fillNameEpic(epicName)
            .fillSummary(epicSummary)
            .switchDescriptionToTextMode() // this step is for Chrome - it can't focus on description if it's in visual mode
            .fillDescription(epicDescription)
            .selectPriority(issuePriority)
            .addLabel(issueLabel)
            .assignUser()
            .submitNewTicketAndOpenIt();

    // check that new issue is created successfully
    assertEquals(true, issuePage.isProjectIdCorrect(projectId));
    assertEquals(true, issuePage.isIssueSummaryCorrect(epicSummary));
    assertEquals(true, issuePage.isIssueTypeCorrect(issueType));
    assertEquals(true, issuePage.isIssuePriorityCorrect(issuePriority));
    assertEquals(true, issuePage.isIssueLabelCorrect(issueLabel));
    assertEquals(true, issuePage.isIssueDescriptionCorrect(epicDescription));
    assertEquals(true, issuePage.isIssueAssigneeCorrect());

  }

}
