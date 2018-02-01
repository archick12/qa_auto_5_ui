package ui;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
import ui.pages.*;
import utils.TestCase;

import static org.testng.Assert.assertEquals;

public class CreateIssueEpicTest {

    // code that will be invoked before each @Test
    @BeforeGroups(groups = {"UI","CreateIssue"})
    public void setUp() {
        LoginPage loginPage = new LoginPage();

        loginPage.open();
        assertEquals(loginPage.isOnThePage(), true); // confirm that we are on the right page
        // otherwise we can click a wrong web element

        loginPage
                .enterUsername()
                .enterPassword()
                .clickLogin();

        NewIssuePage newIssuePage = new NewIssuePage();
        newIssuePage
                .clickCreateIssueButton()
                .waitForCreateIssueDialog();

    }

    // code that will be invoked after each @Test
    @AfterTest
    public void cleanUp() {
        IssuePage issuePage = new IssuePage();
        // TODO need to delete each ticket after test
    }


    @TestCase(id = "C10") // annotation that holds number of test case in TestRail
    @Test(groups = {"UI","CreateIssue"}) // annotation that helps to mark method as test and include pr exclude them by group name in testng.xml
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
                .clickSubmitButton();

          }
}