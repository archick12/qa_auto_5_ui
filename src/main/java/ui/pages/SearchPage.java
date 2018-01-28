package ui.pages;

        import org.openqa.selenium.By;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.ui.Select;
        import ui.utils.RemoteDriverManager;

public class SearchPage extends BasePage {

  // TODO add selectors and methods
  private By layoutSwitcherButton = By.id("layout-switcher-button");
  private By listViewItem = By.xpath("//*[contains(@id,'AJS_DROPDOWN_LISTITEM_')]//child::a[@data-layout-key='list-view']");
  private By recentProject1Locator = By
          .xpath("(//*[contains(@id,'proj_lnk_')][@class='aui-icon-container'])[1]");
  private By feedbackSubmitLocator = By
          .xpath("//*[@id='jic-collector-form']//child::input[@type='submit']");

  private By assigneeButtonLocator = By.xpath("//button[@data-id='assignee']");
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

  public SearchPage clickAssigneeButton() {
    waitToBePresentAndClick(assigneeButtonLocator);
    return this;
  }
  public SearchPage SearchBugs() throws InterruptedException {
    SelectDropDownItem(typeButtonLocator,issueTypeBugCheckbox );
    Thread.sleep(1000);
    waitToBePresentAndClick(typeButtonLocator);
    Thread.sleep(2000);
    return this;
  }
  public SearchPage SearchEpics() throws InterruptedException {
    SelectDropDownItem(typeButtonLocator,issueTypeEpicCheckbox );
    Thread.sleep(1000);
    waitToBePresentAndClick(typeButtonLocator);
    Thread.sleep(2000);
    return this;
  }
  public SearchPage SearchStories() throws InterruptedException {
    SelectDropDownItem(typeButtonLocator,issueTypeStoryCheckbox );
    Thread.sleep(1000);
    waitToBePresentAndClick(typeButtonLocator);
    Thread.sleep(2000);
    return this;
  }
  public SearchPage SearchAllSubTasks () throws InterruptedException {
    SelectDropDownItem(typeButtonLocator, issueTypeAllSubTaskCheckbox);
    Thread.sleep(1000);
    waitToBePresentAndClick(typeButtonLocator);
    Thread.sleep(2000);
    return this;
  }

  public SearchPage FindSeachType(String issueType) throws InterruptedException {
    SelectDropDownItem(typeButtonLocator,issueSearchTypeInput );
    Thread.sleep(1000);
    driver.findElement(issueSearchTypeInput).sendKeys(issueType);
    waitToBePresentAndClick(issueTypeFirstCheckbox);
    Thread.sleep(1000);
    waitToBePresentAndClick(typeButtonLocator);
    Thread.sleep(2000);
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



}