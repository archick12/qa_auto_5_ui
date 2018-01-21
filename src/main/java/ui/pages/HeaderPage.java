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

//____________________________________________________________________Logo
    public HeaderPage jiraLogo(){
        waitToBePresentAndClick(jiraLogo);
        return this;
    }
    //_________________________________________________________________Dashboard section
    public HeaderPage dashbourd(){
        waitToBePresentAndClick(dashboardLocator);
        return this;
    }

    public HeaderPage dashbourdViewSystemDashboard(){
        waitToBePresentAndClick(dashboardLocator);
        waitToBePresentAndClick(viewSystemDashboardLocator);
        return this;
    }

    public HeaderPage dashbourdManageDashboards(){
        waitToBePresentAndClick(dashboardLocator);
        waitToBePresentAndClick(manageDashboardsLocator);
        return this;
    }
    //____________________________________________________________________ Project section
    public HeaderPage projects(){
        waitToBePresentAndClick(projectsLocator);
        return this;
    }

    public HeaderPage projectsCurrentProject(){
        waitToBePresentAndClick(projectsLocator);
        waitToBePresentAndClick(currentProjectLocator);
        return this;
    }

    public HeaderPage projectsCurrent1Project() {
        waitToBePresentAndClick(projectsLocator);
        waitToBePresentAndClick(recentProject1Locator);
        return this;
    }

    public HeaderPage projectsCurrent2Project() {
        waitToBePresentAndClick(projectsLocator);
        waitToBePresentAndClick(recentProject2Locator);
        return this;
    }

    public HeaderPage projectsCurrent3Project() {
        waitToBePresentAndClick(projectsLocator);
        waitToBePresentAndClick(recentProject3Locator);
        return this;
    }

    public HeaderPage projectsSoftware() {
        waitToBePresentAndClick(projectsLocator);
        waitToBePresentAndClick(softwareLocator);
        return this;
    }

    public HeaderPage projectsBusiness() {
        waitToBePresentAndClick(projectsLocator);
        waitToBePresentAndClick(businessLocator);
        return this;
    }

    public HeaderPage projectsViewAllProjects() {
        waitToBePresentAndClick(projectsLocator);
        waitToBePresentAndClick(viewAllProjectsLocator);
        return this;
    }
    //____________________________________________________________Issues section
    public HeaderPage issues() {
        waitToBePresentAndClick(issuesLocator);
        return this;
    }

    public HeaderPage issuesCurentSearch() {
        waitToBePresentAndClick(issuesLocator);
        waitToBePresentAndClick(currentSearchLocator);
        return this;
    }

    public HeaderPage issuesSearchForIssues() {
        waitToBePresentAndClick(issuesLocator);
        waitToBePresentAndClick(searchForIssuesLocator);
        return this;
    }

    public HeaderPage issuesRecentIissue1() {
        waitToBePresentAndClick(issuesLocator);
        waitToBePresentAndClick(recentIissue1Locator);
        return this;
    }

    public HeaderPage issuesRecentIissue2() {
        waitToBePresentAndClick(issuesLocator);
        waitToBePresentAndClick(recentIissue2Locator);
        return this;
    }

    public HeaderPage issuesRecentIissue3() {
        waitToBePresentAndClick(issuesLocator);
        waitToBePresentAndClick(recentIissue3Locator);
        return this;
    }

    public HeaderPage issuesRecentIissue4() {
        waitToBePresentAndClick(issuesLocator);
        waitToBePresentAndClick(recentIissue4Locator);
        return this;
    }

    public HeaderPage issuesRecentIissue5() {
        waitToBePresentAndClick(issuesLocator);
        waitToBePresentAndClick(recentIissue5Locator);
        return this;
    }

    public HeaderPage issuesImportIssuesFromCSV() {
        waitToBePresentAndClick(issuesLocator);
        waitToBePresentAndClick(importIssuesFromCSVLocator);
        return this;
    }

    public HeaderPage issuesFilterMyOpenIssues() {
        waitToBePresentAndClick(issuesLocator);
        waitToBePresentAndClick(filterMyOpenIssuesLocator);
        return this;
    }

    public HeaderPage issuesFilterReportedByMe() {
        waitToBePresentAndClick(issuesLocator);
        waitToBePresentAndClick(filterReportedByMeLocator);
        return this;
    }

    public HeaderPage issuesManageFilters() {
        waitToBePresentAndClick(issuesLocator);
        waitToBePresentAndClick(manageFiltersLocator);
        return this;
    }
    //____________________________________________________________Boards section
    public HeaderPage boards() {
        waitToBePresentAndClick(boardsLocator);
        return this;
    }

    public HeaderPage boardsRecentBoard1() {
        waitToBePresentAndClick(boardsLocator);
        waitToBePresentAndClick(recentBoard1Locator);
        return this;
    }

    public HeaderPage boardsRecentBoard2() {
        waitToBePresentAndClick(boardsLocator);
        waitToBePresentAndClick(recentBoard2Locator);
        return this;
    }

    public HeaderPage boardsRecentBoard3() {
        waitToBePresentAndClick(boardsLocator);
        waitToBePresentAndClick(recentBoard3Locator);
        return this;
    }

    public HeaderPage boardsRecentBoard4() {
        waitToBePresentAndClick(boardsLocator);
        waitToBePresentAndClick(recentBoard4Locator);
        return this;
    }

    public HeaderPage boardsViewAllBoards() {
        waitToBePresentAndClick(boardsLocator);
        waitToBePresentAndClick(viewAllBoardsLocator);
        return this;
    }
//____________________________________________________________Tests section

    public HeaderPage tests() {
        waitToBePresentAndClick(testsLocator);
        return this;
    }

    public HeaderPage testsSearchTests() {
        waitToBePresentAndClick(testsLocator);
        waitToBePresentAndClick(searchTestsLocator);
        return this;
    }

    public HeaderPage testsCreateATest() {
        waitToBePresentAndClick(testsLocator);
        waitToBePresentAndClick(createATestLocator);
        return this;
    }

    public HeaderPage testsPlanTestCycle() {
        waitToBePresentAndClick(testsLocator);
        waitToBePresentAndClick(planTestCycleLocator);
        return this;
    }

    public HeaderPage testsSearchTestExecutions() {
        waitToBePresentAndClick(testsLocator);
        waitToBePresentAndClick(searchTestExecutionsLocator);
        return this;
    }


    public HeaderPage testsManageExecutionFilters() {
        waitToBePresentAndClick(testsLocator);
        waitToBePresentAndClick(manageExecutionFiltersLocator);
        return this;
    }


    public HeaderPage testsExecuteTests() {
        waitToBePresentAndClick(testsLocator);
        waitToBePresentAndClick(executeTestsLocator);
        return this;
    }

    public HeaderPage testsTestSummary() {
        waitToBePresentAndClick(testsLocator);
        waitToBePresentAndClick(testSummaryLocator);
        return this;
    }

    public HeaderPage testsTestMetrics() {
        waitToBePresentAndClick(testsLocator);
        waitToBePresentAndClick(testMetricsLocator);
        return this;
    }

    public HeaderPage testsTraceability() {
        waitToBePresentAndClick(testsLocator);
        waitToBePresentAndClick(traceabilityLocator);
        return this;
    }

    public HeaderPage testsWelcome() {
        waitToBePresentAndClick(testsLocator);
        waitToBePresentAndClick(welcomeLocator);
        return this;
    }

    public HeaderPage testsZephyrHelp() {
        waitToBePresentAndClick(testsLocator);
        waitToBePresentAndClick(zephyrHelpLocator);
        return this;
    }

    public HeaderPage testsZephyrSupport() {
        waitToBePresentAndClick(testsLocator);
        waitToBePresentAndClick(zephyrSupportLocator);
        return this;
    }

    public HeaderPage testsAboutZephyr() {
        waitToBePresentAndClick(testsLocator);
        waitToBePresentAndClick(aboutZephyrLocator);
        return this;
    }
    //____________________________________________________________Create button
    public HeaderPage createButton() {
        waitToBePresentAndClick(createLocator);
        return this;
    }
//____________________________________________________________Improve Jira section


    public HeaderPage helpUsButton() {
        waitToBePresentAndClick(helpUsButtonLocator);
        return this;
    }

    //____________________________________________________________Help section
    public HeaderPage jiraInfo() {
        waitToBePresentAndClick(jiraInfoLocator);
        return this;
    }

    public HeaderPage jiraInfoJiraSoftwareHelp() {
        waitToBePresentAndClick(jiraInfoLocator);
        waitToBePresentAndClick(jiraSoftwareHelpLocator);
        return this;
    }

    public HeaderPage jiraInfoJiraCoreHelp() {
        waitToBePresentAndClick(jiraInfoLocator);
        waitToBePresentAndClick(jiraCoreHelpLocator);
        return this;
    }

    public HeaderPage jiraInfoKeyboardShortcuts() {
        waitToBePresentAndClick(jiraInfoLocator);
        waitToBePresentAndClick(keyboardShortcutsLocator);
        return this;
    }

    public HeaderPage jiraInfoAbout() {
        waitToBePresentAndClick(jiraInfoLocator);
        waitToBePresentAndClick(aboutLocator);
        return this;
    }


    public HeaderPage jiraInfoCredits() {
        waitToBePresentAndClick(jiraInfoLocator);
        waitToBePresentAndClick(creditsLocator);
        return this;
    }
//____________________________________________________________User section

    public HeaderPage userOptions() {
        waitToBePresentAndClick(userOptionsLocator);
        return this;
    }

    public HeaderPage userOptionsViewProfile() {
        waitToBePresentAndClick(userOptionsLocator);
        waitToBePresentAndClick(viewProfileLocator);
        return this;
    }

    public HeaderPage userOptionsAtlassianMarketplace() {
        waitToBePresentAndClick(userOptionsLocator);
        waitToBePresentAndClick(atlassianMarketplaceLocator);
        return this;
    }

    public HeaderPage userOptionsSetHomeDashboard() {
        waitToBePresentAndClick(userOptionsLocator);
        waitToBePresentAndClick(setHomeDashboardLocator);
        return this;
    }

    public HeaderPage userOptionssetHomeBoards() {
        waitToBePresentAndClick(userOptionsLocator);
        waitToBePresentAndClick(setHomeBoardsLocator);
        return this;
    }

    public HeaderPage userOptionsSetHomeIssues() {
        waitToBePresentAndClick(userOptionsLocator);
        waitToBePresentAndClick(setHomeIssuesLocator);
        return this;
    }

    public HeaderPage userOptionslogOut() {
        waitToBePresentAndClick(userOptionsLocator);
        waitToBePresentAndClick(logOutLocator);
        return this;
    }

}