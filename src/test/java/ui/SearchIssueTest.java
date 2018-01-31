package ui;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
import ui.pages.*;
import utils.TestCase;

import java.util.List;

public class SearchIssueTest {

    LoginPage loginPage;
    HeaderPage headerPage;
    DashBoardPage dashBoardPage;
    SearchPage searchPage;
    final static Logger logger = Logger.getLogger(BasePage.class); // initialization of logger

    String issueId = "QAAUT-18";

    @BeforeGroups(groups = {"UI"})
    public void setUp() {
        loginPage = new LoginPage();
        headerPage = new HeaderPage();
        dashBoardPage = new DashBoardPage();
        searchPage = new SearchPage();

        loginPage.open();
        assertEquals(loginPage.isOnThePage(), true); // confirm that we are on the right page
        // otherwise we can click a wrong web element
        loginPage.enterUsername()
                 .enterPassword()
                 .clickLogin();
        //    assertEquals(true, dashBoardPage.isOnThePage()); //not really necessary because homepage can vary
        // Prepare for search tests:
        headerPage.issuesSearchForIssues();
        // TODO check that basic view is on
        searchPage.clickOnLayoutSwitcherButton()
                  .clickListViewItem();

    }

    @TestCase(id = "1")
    @Test(groups = {"UI"})
    public void searchByAssignee() throws InterruptedException {

        searchPage.clickAssigneeButton();
        int a = 0;
    }

    @TestCase(id = "2")
    @Test(groups = {"UI"})
    public void searchByProject() throws InterruptedException {
        String projectName = "qaauto5";
        String issuePrefix = "QAAUT-";

        searchPage.clickProjectButton()
                   .searchByProjectNameAndSubmit(projectName)
                   .clickProjectButton()
                   .waitForNotPending();
        List<WebElement> issues = searchPage.getListOfIssues();
        for (WebElement issue : issues) {
            assertTrue(issue.getAttribute("data-issuekey").contains(issuePrefix), "Assertion Failed");
            logger.info("Assertion passed: " + issue.getAttribute("data-issuekey"));
        }
    }

    @TestCase(id = "С8")
    @Test(groups = {"UI"})
    public void searchByType() throws InterruptedException {
        //__________________________________check Bug type
        searchPage.SearchBugs();
        searchPage.waitForNotPending();
        assertEquals(searchPage.CountIssuesOnPage(), searchPage.CountBugsOnPage());
        logger.info("ASSERTION PASSED: bugs");
        searchPage.SearchBugs();
        //__________________________________check Epic type
        searchPage.SearchEpics();
        searchPage.waitForNotPending();
        assertEquals(searchPage.CountIssuesOnPage(),searchPage.CountEpicsOnPage());
        logger.info("ASSERTION PASSED: epics");
        searchPage.SearchEpics();
        //__________________________________ check Story type
        searchPage.FindSeachType("Story");
        searchPage.waitForNotPending();
        assertEquals(searchPage.CountIssuesOnPage(),searchPage.CountStoriesOnPage());
        logger.info("ASSERTION PASSED: stories");
        searchPage.SearchStories();
        //_________________________________________ check Sub-task type
        searchPage.SearchAllSubTasks();
        searchPage.waitForNotPending();
        assertEquals(searchPage.CountIssuesOnPage(),searchPage.CountSubTasksOnPage()+ searchPage.CountSubDefectsOnPage());
        logger.info("ASSERTION PASSED: sub-tasks");
        searchPage.SearchAllSubTasks();
    }

    @TestCase(id = "4")
    @Test(groups = {"UI"})
    public void searchByStatus() throws InterruptedException {

    }
}