package ui;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
import ui.pages.DashBoardPage;
import ui.pages.HeaderPage;
import ui.pages.IssuePage;
import ui.pages.LoginPage;
import ui.pages.NewIssuePage;
import ui.pages.SearchPage;
import utils.TestCase;

public class SearchIssueTest {

  String test = "";

  LoginPage loginPage;
  HeaderPage headerPage;
  DashBoardPage dashBoardPage;
  SearchPage searchPage;
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

  }

  @TestCase(id = "1")
  @Test(groups = {"UI"})
  public void searchByAssignee() throws InterruptedException {
//    assertEquals(true, dashBoardPage.isOnThePage()); //not really necessary because homepage can vary

    headerPage.issuesSearchForIssues();
    // TODO check that basic view is on
    searchPage.clickOnLayoutSwitcherButton();
    searchPage.clickListViewItem();
    searchPage.clickAssigneeButton();
    int a = 0;
  }

  @TestCase(id = "С8")
  @Test(groups = {"UI"})
  public void searchByType() throws InterruptedException {
//    assertEquals(true, dashBoardPage.isOnThePage()); //not really necessary because homepage can vary

    headerPage.issuesSearchForIssues();
    // TODO check that basic view is on
    searchPage.clickOnLayoutSwitcherButton();
    searchPage.clickListViewItem();
    //    __________________________________check Bug type
    searchPage.SearchBugs();
    Assert.assertEquals(searchPage.CountIssuesOnPage(), searchPage.CountBugsOnPage());
    searchPage.SearchBugs();
    //  __________________________________check Epic type
    searchPage.SearchEpics();
    Assert.assertEquals(searchPage.CountIssuesOnPage(),searchPage.CountEpicsOnPage());
    searchPage.SearchEpics();
   //    __________________________________ check Story type
    searchPage.FindSeachType("Story");
    Assert.assertEquals(searchPage.CountIssuesOnPage(),searchPage.CountStoriesOnPage());
    searchPage.SearchStories();
//_________________________________________ check Sub-task type
    searchPage.SearchAllSubTasks();
    Assert.assertEquals(searchPage.CountIssuesOnPage(),searchPage.CountSubTasksOnPage()+ searchPage.CountSubDefectsOnPage());
    searchPage.SearchAllSubTasks();








  }
}