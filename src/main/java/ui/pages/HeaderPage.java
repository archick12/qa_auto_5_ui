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
    private By projectsLocator = By.id("browse_link");
    private By currentProjectLocator = By.id("admin_main_proj_link_lnk");
    private By recentProject1Locator = By.xpath("(//*[contains(@id,'proj_lnk_')][@class='aui-icon-container'])[1]");
    private By recentProject2Locator = By.xpath("(//*[contains(@id,'proj_lnk_')][@class='aui-icon-container'])[2]");
    private By recentProject3Locator = By.xpath("(//*[contains(@id,'proj_lnk_')][@class='aui-icon-container'])[3]");
    private By softwareLocator = By.id("project_type_software_lnk");
    private By businessLocator = By.id("project_type_business_lnk");
    private By viewAllProjectsLocator = By.id("project_view_all_link_lnk");
    //-- Issues section
    private By issuesLocator = By.id("find_link");
    private By currentSearchLocator = By.id("jira.top.navigation.bar:issues_drop_current_lnk");
    private By searchForIssuesLocator = By.id("issues_new_search_link_lnk");
    private By recentIissue1Locator = By.xpath("(//*[contains(@id,'issue_lnk_')][contains(@class,'issue-link')])[1]");
    private By recentIissue2Locator = By.xpath("(//*[contains(@id,'issue_lnk_')][contains(@class,'issue-link')])[2]");
    private By recentIissue3Locator = By.xpath("(//*[contains(@id,'issue_lnk_')][contains(@class,'issue-link')])[3]");
    private By recentIissue4Locator = By.xpath("(//*[contains(@id,'issue_lnk_')][contains(@class,'issue-link')])[4]");
    private By recentIissue5Locator = By.xpath("(//*[contains(@id,'issue_lnk_')][contains(@class,'issue-link')])[5]");
    private By importIssuesFromCSVLocator = By.id("bulk_create_dd_link_lnk");
    private By filterMyOpenIssuesLocator = By.id("filter_lnk_my_lnk");
    private By filterReportedByMeLocator = By.id("filter_lnk_reported_lnk");
    private By manageFiltersLocator = By.id("issues_manage_filters_link_lnk");
    //-- Boards section
    private By boardsLocator = By.id("greenhopper_menu");
    private By recentBoard1Locator = By.xpath("(//*/a[contains(@id,'rapidb_lnk_')])[1]");
    private By recentBoard2Locator = By.xpath("(//*/a[contains(@id,'rapidb_lnk_')])[2]");
    private By recentBoard3Locator = By.xpath("(//*/a[contains(@id,'rapidb_lnk_')])[3]");
    private By recentBoard4Locator = By.xpath("(//*/a[contains(@id,'rapidb_lnk_')])[4]");
    private By viewAllBoardsLocator = By.id("ghx-manageviews-mlink_lnk");
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
    private By jiraInfoLocator = By.id("help_menu");
    private By jiraSoftwareHelpLocator = By.id("gh_view_help");
    private By jiraCoreHelpLocator = By.id("view_core_help");
    private By keyboardShortcutsLocator = By.id("keyshortscuthelp");
    private By aboutLocator = By.id("view_about");
    private By creditsLocator = By.id("view_credits");
    //-- User section
    private By userOptionsLocator = By.id("user-options");
    private By viewProfileLocator = By.id("view_profile");
    private By atlassianMarketplaceLocator = By.id("upm-requests-link");
    private By setHomeDashboardLocator = By.id("set_my_jira_home_default");
    private By setHomeBoardsLocator = By.id("greenhopper-my-jira-home-set");
    private By setHomeIssuesLocator = By.id("set_my_jira_home_issuenav");
    private By logOutLocator = By.id("log_out");


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