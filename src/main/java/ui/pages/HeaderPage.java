package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.utils.RemoteDriverManager;

public class HeaderPage extends BasePage {

/* old locators
    private By systemDashboardLocator = By.cssSelector("div.aui-page-header-main>h1");
    private By createLocator = By.id("create-menu");
    private By searchLocator = By.id("quickSearchInput");
*/
    //-- Logo
    private By jiraLogo = By.id("logo");
    //-- Dashboards section
    private By dashboardLocator = By.id("home_link");
    private By viewSystemDashboardLocator = By.id("dash_lnk_system_lnk");
    private By manageDashboardsLocator = By.id("manage_dash_link_lnk");
    //-- Projects section
//    private By projectsLocator = By.("");
    //-- Issues section
//    private By issuesLocator = By.("");
    //-- Boards section
//    private By boardsLocator = By.("");
    //-- Tests section
    private By testsLocator = By.id("zephyr_je.topnav.tests");
    private By searchTestsLocator = By.id("zephyr-je.topnav.tests.test.search_lnk");
    private By createATestLocator = By.id("zephyr-je.topnav.tests.create_lnk");
    private By planTestCycleLocator = By.id("zephyr-je.topnav.tests.plan.cycle_lnk");
    private By searchTestExecutionsLocator = By.id("zephyr-je.topnav.tests.execution.search_lnk");
    private By manageExecutionFiltersLocator = By.id("manage_zql_filters_link_lnk");
    private By executeTestsLocator = By.id("zephyr-je.topnav.tests.plan.execute_lnk");
    private By testSummaryLocator = By.id("zephyr-je.topnav.tests.test.plan.summary_lnk");
    private By testMetricsLocator = By.id("zephyr-je.topnav.tests.test.plan.metrics_lnk");
    private By traceabilityLocator = By.id("zephyr-je.topnav.tests.test.plan.traceability_lnk");
    private By welcomeLocator = By.id("zfj_welcome_lnk");
    private By zephyrHelpLocator = By.id("com.thed.zephyr.je:zephyr-je.topnav.tests.help_lnk");
    private By zephyrSupportLocator = By.id("support_link_lnk");
    private By aboutZephyrLocator = By.id("add-about_lnk");
    //-- Create button
    private By createLocator = By.id("create_link");
    //-- Search field
    private By searchFieldLocator = By.id("quickSearchInput");
    //-- Improve Jira section
    private By helpUsButtonLocator = By.id("jira-header-feedback-link");
    //-- Help section
//    private By jiraInfoLocator = By.id("");
    private By jiraSoftwareHelpLocator = By.id("gh_view_help");
    private By jiraCoreHelpLocator = By.id("view_core_help");
    private By keyboardShortcutsLocator = By.id("keyshortscuthelp");
    private By aboutLocator = By.id("view_about");
    private By creditsLocator = By.id("view_credits");
    //-- User section
//    private By userOptionsLocator = By.("");
    private By viewProfileLocator = By.id("view_profile");
    private By atlassianMarketplaceLocator = By.id("upm-requests-link");
    private By setHomeDashboardLocator = By.id("set_my_jira_home_default");
    private By setHomeBoardsLocator = By.id("greenhopper-my-jira-home-set");
    private By setHomeIssuesLocator = By.id("set_my_jira_home_issuenav");


    public HeaderPage() {
        this.driver = RemoteDriverManager.getDriver();
    }

    public HeaderPage search(String searchWord) {

        WebElement element = driver.findElement(searchFieldLocator);
        element.sendKeys(searchWord);
        element.submit();
        return this;
    }


}