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
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickLogin();
        //    assertEquals(true, dashBoardPage.isOnThePage()); //not really necessary because homepage can vary
        // Prepare for search tests:
        headerPage.issuesSearchForIssues();
        // TODO check that basic view is on
        searchPage.clickOnLayoutSwitcherButton();
        searchPage.clickListViewItem();

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

        searchPage.clickProjectButton();
        searchPage.searchByProjectNameAndSubmit(projectName);
        searchPage.clickProjectButton();
        //TODO Wait until all issue table is fully reloaded
        List<WebElement> issues = searchPage.getListOfIssues();
        for (WebElement issue : issues) {
            assertTrue(issue.getAttribute("data-issuekey").contains("QAAUT-"), "Assertion Failed");
            logger.info("Assertion passed: " + issue.getAttribute("data-issuekey"));
        }
    }

    @TestCase(id = "3")
    @Test(groups = {"UI"})
    public void searchByType() throws InterruptedException {

    }

    @TestCase(id = "4")
    @Test(groups = {"UI"})
    public void searchByStatus() throws InterruptedException {

    }
}