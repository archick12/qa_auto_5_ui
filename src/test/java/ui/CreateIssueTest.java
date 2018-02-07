package ui;

import org.testng.annotations.*;
import ui.pages.*;
import utils.TestCase;

import static org.testng.Assert.assertEquals;
import static ui.SearchIssueTest.logger;

public class CreateIssueTest {

  // code that will be invoked before the first test method that belongs to any of these groups
  @BeforeGroups(groups = {"UI","CreateIssue"})
  public void setUp() {
    LoginPage loginPage = new LoginPage();
    loginPage
            .open();
    // confirm that we are on the right page
    // otherwise we can click a wrong web element
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
  public void cleanUp() {
    IssuePage issuePage = new IssuePage();
    // TODO need to delete each ticket after test
    logger.info("!---Gonna delete a ticket---!");
    issuePage.deleteTicket();
  }


  // Alesya's test
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
    newIssuePage
            .enterProject(projectId)
            .enterIssueType(issueType)
            .fillSummary(storySummary)
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
    @Test(groups = {"UI", "CreateIssue"})
    public void createNewBug () throws InterruptedException {
      NewIssuePage newIssuePage = new NewIssuePage();
      IssuePage issuePage = new IssuePage();

      String projectId = "QAAuto5 (QAAUT)";
      String issueType = "Bug";
      String bugSummary = "Team 2 bug summary";
      String bugDescription = "Team 2 bug description";
      String issuePriority = "High";
      String issueLabel = "QAAuto5";

      newIssuePage
                .enterProject(projectId)
                .enterIssueType(issueType)
                .fillSummary(bugSummary)
                .fillDescription(bugDescription)
                .selectPriority(issuePriority)
                .addLabel(issueLabel)
                .assignUser()
                .submitNewTicketAndOpenIt();

     /* issuePage.shouldSeeSuccessPopUp();
      newIssuePage.clickNewIssueLinkOnSuccessPopup(); */
    }

  // Marina S test
  @TestCase(id = "C9") // annotation that holds number of test case in TestRail
  @Test(groups = {"UI","CreateIssue"}) // annotation that helps to mark method as test and include pr exclude them by group name in testng.xml
  public void createNewTask() throws InterruptedException {

    NewIssuePage newIssuePage = new NewIssuePage();

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
            .fillDescription(taskDescription)
            .selectPriority(issuePriority)
            .addLabel(issueLabel)
            .assignUser()
            .submitNewTicketAndOpenIt();
  }

  // Eugene's test
  @TestCase(id = "C10") // annotation that holds number of test case in TestRail
  @Test(groups = {"UI","CreateIssue", "SKIP"}) // annotation that helps to mark method as test and include pr exclude them by group name in testng.xml
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
            .fillDescription(epicDescription)
            .selectPriority(issuePriority)
            .addLabel(issueLabel)
            .assignUser()
            .submitNewTicketAndOpenIt();

  }

}
