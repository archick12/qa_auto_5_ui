package ui;

import static org.testng.Assert.assertEquals;

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

  }

  @TestCase(id = "1")
  @Test(groups = {"UI"})
  public void searchByAssignee() throws InterruptedException {
    loginPage.open();
    loginPage.enterUsername();
    loginPage.enterPassword();
    loginPage.clickLogin();
    assertEquals(true, dashBoardPage.isOnThePage());

    headerPage.issuesSearchForIssues();
    // TODO check that basic view is on
    searchPage.clickOnLayoutSwitcherButton();
    searchPage.clickListViewItem();
    int a = 0;
  }
}