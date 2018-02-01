package ui.pages;

        import org.openqa.selenium.By;
        import org.openqa.selenium.TimeoutException;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.Keys;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.Select;
        import org.openqa.selenium.support.ui.WebDriverWait;
        import ui.utils.RemoteDriverManager;

        import java.util.List;
        import java.util.concurrent.TimeUnit;

public class SearchPage extends BasePage {

  private By layoutSwitcherButton = By.id("layout-switcher-button");
  private By listViewItem = By.xpath("//*[contains(@id,'AJS_DROPDOWN_LISTITEM_')]//child::a[@data-layout-key='list-view']");
  private By recentProject1Locator = By
          .xpath("(//*[contains(@id,'proj_lnk_')][@class='aui-icon-container'])[1]");
  private By feedbackSubmitLocator = By
          .xpath("//*[@id='jic-collector-form']//child::input[@type='submit']");
  private By projectButtonLocator = By.xpath("//button[@data-id='project']");
  private By findProjectsSearchFieldLocator = By
          .xpath("//form[@id='issue-filter'][contains(@class,'project-criteria')]/descendant::input[@id='searcher-pid-input']");
  private By issueRowsLocator = By.xpath("//table[@id='issuetable']/descendant::tr[contains(@class, 'issuerow')]");
  private By pendingDivLocator = By.xpath("//div[@class='navigator-content']/child::div[@class='pending']");
//  ____________________________________________________________________________

  private By typeButtonLocator = By.xpath("//button[@data-id='issuetype']");
  private By issueTypeBugCheckbox = By.xpath("//label[@title='Bug']");
  private By issueTypeEpicCheckbox = By.xpath("//label[@title='Epic']");
  private By issueTypeStoryCheckbox = By.xpath("//label[@title='Story']");
  private By issueTypeAllSubTaskCheckbox  = By.xpath("//label[@title='All Sub-Task Issue Types']");
  private By issueTypeFirstCheckbox = By.xpath("(//label[@class='item-label'])[1]");
  private By issueTypeTotal = By.xpath("//td[@class='issuetype']");
  private By issueTypeBug = By.xpath("//td[@class='issuetype']//img[@alt='Bug']");
  private By issueTypeEpic = By.xpath("//td[@class='issuetype']//img[@alt='Epic']");
  private By issueTypeStory = By.xpath("//td[@class='issuetype']//img[@alt='Story']");
  private By issueTypeSubTask = By.xpath("//td[@class='issuetype']//img[@alt='Sub-task']");
  private By issueTypeSubDefect = By.xpath("//td[@class='issuetype']//img[@alt='Sub-Defect']");
  private By issueSearchTypeInput = By.id("searcher-type-input");
//  ____________________________________________________________________________

  private By assigneeButtonLocator = By.xpath("//button[@data-id='assignee']");
  private By assigneeFindUserFieldLocator = By.id("assignee-input");
  private By assigneeCurrentUserCheckboxLocator = By.xpath("//label[@title='Current User']");
  private By assigneeUnassignedCheckboxLocator = By.xpath("//label[@title='Unassigned']");

  public SearchPage() {
    this.driver = RemoteDriverManager.getDriver();
  }

  public SearchPage clickOnLayoutSwitcherButton() {
    waitToBePresentAndClick(layoutSwitcherButton);
    return this;
  }

  public SearchPage clickListViewItem() {
    waitToBePresentAndClick(listViewItem);
    return this;
  }
  public SearchPage clickProjectButton() {
    waitToBePresentAndClick(projectButtonLocator);
    return this;
  }
  public SearchPage clickAssigneeButton() {
    waitToBePresentAndClick(assigneeButtonLocator);
    return this;
  }
  public SearchPage searchByProjectNameAndSubmit(String projectName) {
    waitToBePresentAndSendKeys(findProjectsSearchFieldLocator, projectName + Keys.ENTER);
    return this;
  }
  public SearchPage waitForNotPending() {
    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    logger.info("WAIT FOR PENDING:");
    WebDriverWait wait = new WebDriverWait(driver, 5);
    try {
      wait.until(ExpectedConditions.presenceOfElementLocated(pendingDivLocator));
      logger.info("--- Pending started");
      wait.until(ExpectedConditions.invisibilityOfElementLocated(pendingDivLocator));
      logger.info("--- Pending ended");
    } catch (TimeoutException ignored) {
      logger.info("--- Pending too fast or not ended");
    }
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    return this;
  }

  public List<WebElement> getListOfIssues() {
    return driver.findElements(issueRowsLocator);
  }

  public SearchPage SearchBugs() throws InterruptedException {
    SelectDropDownItem(typeButtonLocator,issueTypeBugCheckbox );
    waitToBePresentAndClick(typeButtonLocator);
    return this;
  }
  public SearchPage SearchEpics() throws InterruptedException {
    SelectDropDownItem(typeButtonLocator,issueTypeEpicCheckbox );
    waitToBePresentAndClick(typeButtonLocator);
    return this;
  }
  public SearchPage SearchStories() throws InterruptedException {
    SelectDropDownItem(typeButtonLocator,issueTypeStoryCheckbox );
    waitToBePresentAndClick(typeButtonLocator);
    return this;
  }
  public SearchPage SearchAllSubTasks () throws InterruptedException {
    SelectDropDownItem(typeButtonLocator, issueTypeAllSubTaskCheckbox);
    waitToBePresentAndClick(typeButtonLocator);
    return this;
  }

  public SearchPage FindSeachType(String issueType) throws InterruptedException {
    SelectDropDownItem(typeButtonLocator,issueSearchTypeInput );
    driver.findElement(issueSearchTypeInput).sendKeys(issueType);
    waitToBePresentAndClick(issueTypeFirstCheckbox);
    waitToBePresentAndClick(typeButtonLocator);
    return this;
  }

  public int CountIssuesOnPage(){
    return driver.findElements(issueTypeTotal).size();
  }
  public int CountBugsOnPage(){
    return driver.findElements(issueTypeBug).size();
  }
  public int CountEpicsOnPage(){
    return driver.findElements(issueTypeEpic).size();
  }
  public int CountStoriesOnPage(){
    return driver.findElements(issueTypeStory).size();
  }
  public int CountSubTasksOnPage(){
    return driver.findElements(issueTypeSubTask).size();
  }
  public int CountSubDefectsOnPage(){
    return driver.findElements(issueTypeSubDefect).size();
  }
        
  //  ____________________________________________________________________________
        
    public SearchPage clickAssigneeCurrentUserCheckbox() throws InterruptedException {
    waitToBePresentAndClick(assigneeCurrentUserCheckboxLocator);
    return this;
  }

  public SearchPage clickAssigneeUnassignedCheckbox() throws InterruptedException {
    waitToBePresentAndClick(assigneeUnassignedCheckboxLocator);
    return this;
  }

  public SearchPage clickAssigneeFindUserField() throws InterruptedException {
    waitToBePresentAndClick(assigneeInputFieldLocator);
    return this;
  }


}
