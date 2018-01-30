package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ui.utils.RemoteDriverManager;

public class HeaderPage extends BasePage {

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
    private By recentIssue1Locator = By.xpath("(//*[contains(@id,'issue_lnk_')][contains(@class,'issue-link')])[1]");
    private By recentIssue2Locator = By.xpath("(//*[contains(@id,'issue_lnk_')][contains(@class,'issue-link')])[2]");
    private By recentIssue3Locator = By.xpath("(//*[contains(@id,'issue_lnk_')][contains(@class,'issue-link')])[3]");
    private By recentIssue4Locator = By.xpath("(//*[contains(@id,'issue_lnk_')][contains(@class,'issue-link')])[4]");
    private By recentIssue5Locator = By.xpath("(//*[contains(@id,'issue_lnk_')][contains(@class,'issue-link')])[5]");
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
    private By feedbackButtonLocator = By.id("jira-header-feedback-link");
    private By feedbackSummaryLocator = By.xpath("//*[@id='jic-collector-form']//child::input[@id='summary']");
    private By feedbackDescriptionLocator = By.xpath("//*[@id='jic-collector-form']//child::textarea[@id='description']");
    private By feedbackAboutSelectorLocator = By.xpath("//*[@id='jic-collector-form']//child::select");
    private By feedbackNameLocator = By.xpath("//*[@id='jic-collector-form']//child::input[@id='fullname']");
    private By feedbackEmailLocator = By.xpath("//*[@id='jic-collector-form']//child::input[@id='email']");
    private By feedbackSubmitLocator = By.xpath("//*[@id='jic-collector-form']//child::input[@type='submit']");
    private By feedbackCloseLocator = By.xpath("//*[@id='jic-collector-form']//child::a[@class='cancel']");
    // Alesya's test variant
    private By feedbackFrameLocator = By.id("atlwdg-frame");

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
    public HeaderPage clickJiraLogo(){
        waitToBePresentAndClick(jiraLogo);
        return this;
    }
    //_________________________________________________________________Dashboard section
    public HeaderPage clickDashboard(){
        waitToBePresentAndClick(dashboardLocator);
        return this;
    }

    public HeaderPage selectDashboardViewSystemDashboard(){
        SelectDropDownItem(dashboardLocator,viewSystemDashboardLocator);
        return this;
    }

    public HeaderPage selectDashboardManageDashboards(){
        SelectDropDownItem(dashboardLocator,manageDashboardsLocator);
        return this;
    }
    //____________________________________________________________________ Project section
//    public HeaderPage clickProjects(){
//        waitToBePresentAndClick(projectsLocator);
//        return this;
//    }

    public HeaderPage selectProjectsCurrentProject(){
        SelectDropDownItem(projectsLocator,currentProjectLocator);
        return this;
    }

    public HeaderPage selectProjectsCurrent1Project() {
        SelectDropDownItem(projectsLocator,recentProject1Locator);
        return this;
    }

    public HeaderPage selectProjectsCurrent2Project() {
        SelectDropDownItem(projectsLocator,recentProject2Locator);
        return this;
    }

    public HeaderPage selectProjectsCurrent3Project() {
        SelectDropDownItem(projectsLocator,recentProject3Locator);
        return this;
    }

    public HeaderPage selectProjectsSoftware() {
        SelectDropDownItem(projectsLocator,softwareLocator);
        return this;
    }

    public HeaderPage selectProjectsBusiness() {
        SelectDropDownItem(projectsLocator,businessLocator);
        return this;
    }

    public HeaderPage selectProjectsViewAllProjects() {
        SelectDropDownItem(projectsLocator,viewAllProjectsLocator);
        return this;
    }
    //____________________________________________________________Issues section
    public HeaderPage clickIssues() {
        waitToBePresentAndClick(issuesLocator);
        return this;
    }

    public HeaderPage issuesCurrentSearch() {
        SelectDropDownItem(issuesLocator,currentSearchLocator);
        return this;
    }

    public HeaderPage issuesSearchForIssues() {
        SelectDropDownItem(issuesLocator,searchForIssuesLocator);
        return this;
    }

    public HeaderPage issuesRecentIssue1() {
        SelectDropDownItem(issuesLocator, recentIssue1Locator);
        return this;
    }

    public HeaderPage issuesRecentIssue2() {
        SelectDropDownItem(issuesLocator, recentIssue2Locator);
        return this;
    }

    public HeaderPage issuesRecentIssue3() {
        SelectDropDownItem(issuesLocator, recentIssue3Locator);
        return this;
    }

    public HeaderPage issuesRecentIssue4() {
        SelectDropDownItem(issuesLocator, recentIssue4Locator);
        return this;
    }

    public HeaderPage issuesRecentIssue5() {
        SelectDropDownItem(issuesLocator, recentIssue5Locator);
        return this;
    }

    public HeaderPage issuesImportIssuesFromCSV() {
        SelectDropDownItem(issuesLocator,importIssuesFromCSVLocator);
        return this;
    }

    public HeaderPage issuesFilterMyOpenIssues() {
        SelectDropDownItem(issuesLocator,filterMyOpenIssuesLocator);
        return this;
    }

    public HeaderPage issuesFilterReportedByMe() {
        SelectDropDownItem(issuesLocator,filterReportedByMeLocator);
        return this;
    }

    public HeaderPage issuesManageFilters() {
        SelectDropDownItem(issuesLocator,manageFiltersLocator);
        return this;
    }
    //____________________________________________________________Boards section
//    public HeaderPage clickBoards() {
//        waitToBePresentAndClick(boardsLocator);
//        return this;
//    }

    public HeaderPage boardsRecentBoard1() {
        SelectDropDownItem(boardsLocator,recentBoard1Locator);
        return this;
    }

    public HeaderPage boardsRecentBoard2() {
        SelectDropDownItem(boardsLocator,recentBoard2Locator);
        return this;
    }

    public HeaderPage boardsRecentBoard3() {
        SelectDropDownItem(boardsLocator,recentBoard3Locator);
        return this;
    }

    public HeaderPage boardsRecentBoard4() {
        SelectDropDownItem(boardsLocator,recentBoard4Locator);
        return this;
    }

    public HeaderPage boardsViewAllBoards() {
        SelectDropDownItem(boardsLocator,viewAllBoardsLocator);
        return this;
    }
//____________________________________________________________Tests section

//    public HeaderPage clickTests() {
//        waitToBePresentAndClick(testsLocator);
//        return this;
//    }

    public HeaderPage testsSearchTests() {
        SelectDropDownItem(testsLocator,searchTestsLocator);
        return this;
    }

    public HeaderPage testsCreateATest() {
        SelectDropDownItem(testsLocator,createATestLocator);
        return this;
    }

    public HeaderPage testsPlanTestCycle() {
        SelectDropDownItem(testsLocator,planTestCycleLocator);
        return this;
    }

    public HeaderPage testsSearchTestExecutions() {
        SelectDropDownItem(testsLocator,searchTestExecutionsLocator);
        return this;
    }


    public HeaderPage testsManageExecutionFilters() {
        SelectDropDownItem(testsLocator,manageExecutionFiltersLocator);
        return this;
    }


    public HeaderPage testsExecuteTests() {
        SelectDropDownItem(testsLocator,executeTestsLocator);
        return this;
    }

    public HeaderPage testsTestSummary() {
        SelectDropDownItem(testsLocator,testSummaryLocator);
        return this;
    }

    public HeaderPage testsTestMetrics() {
        SelectDropDownItem(testsLocator,testMetricsLocator);
        return this;
    }

    public HeaderPage testsTraceability() {
        SelectDropDownItem(testsLocator,traceabilityLocator);
        return this;
    }

    public HeaderPage testsWelcome() {
        SelectDropDownItem(testsLocator,welcomeLocator);
        return this;
    }

    public HeaderPage testsZephyrHelp() {
        SelectDropDownItem(testsLocator,zephyrHelpLocator);
        return this;
    }

    public HeaderPage testsZephyrSupport() {
        SelectDropDownItem(testsLocator,zephyrSupportLocator);
        return this;
    }

    public HeaderPage testsAboutZephyr() {
        SelectDropDownItem(testsLocator,aboutZephyrLocator);
        return this;
    }
    //____________________________________________________________Create button
    public HeaderPage clickCreateButton() {
        waitToBePresentAndClick(createLocator);
        return this;
    }
//____________________________________________________________Improve Jira (Feedback) section


    public HeaderPage clickFeedbackButton() {
        waitToBePresentAndClick(feedbackButtonLocator);
        return this;
    }

    public HeaderPage fillFeedbackSummary(String summary) {
        waitToBePresentAndSendKeys(feedbackSummaryLocator, summary);
        return this;
    }

    public HeaderPage fillFeedbackDescription(String description) {
        waitToBePresentAndSendKeys(feedbackDescriptionLocator, description);
        return this;
    }

    public HeaderPage selectFeedbackAbout(String optionText) {
        waitToBePresent(feedbackAboutSelectorLocator);
        new Select(driver.findElement(feedbackAboutSelectorLocator)).selectByVisibleText(optionText);
        return this;
    }

    public HeaderPage fillFeedbackName(String name) {
        waitToBePresentAndSendKeys(feedbackNameLocator, name);
        return this;
    }

    public HeaderPage fillFeedbackEmail(String email) {
        waitToBePresentAndSendKeys(feedbackEmailLocator, email);
        return this;
    }

    public HeaderPage clickSubmitFeedback() {
        waitToBePresentAndClick(feedbackSubmitLocator);
        return this;
    }

    public HeaderPage clickCloseFeedbackForm() {
        waitToBePresentAndClick(feedbackCloseLocator);
        return this;
    }

    //____________________________________________________________Help section
//    public HeaderPage clickJiraInfo() {
//        waitToBePresentAndClick(jiraInfoLocator);
//        return this;
//    }

    public HeaderPage jiraInfoJiraSoftwareHelp() {
        SelectDropDownItem(jiraInfoLocator,jiraSoftwareHelpLocator);
        return this;
    }

    public HeaderPage jiraInfoJiraCoreHelp() {
        SelectDropDownItem(jiraInfoLocator,jiraCoreHelpLocator);
        return this;
    }

    public HeaderPage jiraInfoKeyboardShortcuts() {
        SelectDropDownItem(jiraInfoLocator,keyboardShortcutsLocator);
        return this;
    }

    public HeaderPage jiraInfoAbout() {
        SelectDropDownItem(jiraInfoLocator,aboutLocator);
        return this;
    }


    public HeaderPage jiraInfoCredits() {
        SelectDropDownItem(jiraInfoLocator,creditsLocator);
        return this;
    }
//____________________________________________________________User section

//    public HeaderPage clickUserOptions() {
//        waitToBePresentAndClick(userOptionsLocator);
//        return this;
//    }

    public HeaderPage userOptionsViewProfile() {
        SelectDropDownItem(userOptionsLocator,viewProfileLocator);
        return this;
    }

    public HeaderPage userOptionsAtlassianMarketplace() {
        SelectDropDownItem(userOptionsLocator,atlassianMarketplaceLocator);
        return this;
    }

    public HeaderPage userOptionsSetHomeDashboard() {
        SelectDropDownItem(userOptionsLocator,setHomeDashboardLocator);
        return this;
    }

    public HeaderPage userOptionssetHomeBoards() {
        SelectDropDownItem(userOptionsLocator,setHomeBoardsLocator);
        return this;
    }

    public HeaderPage userOptionsSetHomeIssues() {
        SelectDropDownItem(userOptionsLocator,setHomeIssuesLocator);
        return this;
    }

    public HeaderPage userOptionslogOut() {
        SelectDropDownItem(userOptionsLocator,logOutLocator);
        return this;
    }

    // Alesya's test variant starts
    public HeaderPage switchDriverToFrame() {
        WebElement frame = driver.findElement(feedbackFrameLocator);
        driver.switchTo().frame(frame);
        return this;
    }

    public HeaderPage switchDriverToDefaultContent() {
        driver.switchTo().defaultContent();
        return this;
    }
    // Alesya's test variant ends
}