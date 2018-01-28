package ui.pages;

        import org.openqa.selenium.By;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.Keys;
        import org.openqa.selenium.support.ui.Select;
        import ui.utils.RemoteDriverManager;

        import java.util.List;

public class SearchPage extends BasePage {

  // TODO add selectors and methods
  private By layoutSwitcherButton = By.id("layout-switcher-button");
  private By listViewItem = By.xpath("//*[contains(@id,'AJS_DROPDOWN_LISTITEM_')]//child::a[@data-layout-key='list-view']");
  private By recentProject1Locator = By
          .xpath("(//*[contains(@id,'proj_lnk_')][@class='aui-icon-container'])[1]");
  private By feedbackSubmitLocator = By
          .xpath("//*[@id='jic-collector-form']//child::input[@type='submit']");
  private By projectButtonLocator = By.xpath("//button[@data-id='project']");
  private By assigneeButtonLocator = By.xpath("//button[@data-id='assignee']");
  private By findProjectsSearchFieldLocator = By
          .xpath("//form[@id='issue-filter'][contains(@class,'project-criteria')]/descendant::input[@id='searcher-pid-input']");
  private By issueRowsLocator = By.xpath("//table[@id='issuetable']/descendant::tr[contains(@class, 'issuerow')]");

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
  public List<WebElement> getListOfIssues() {
    return driver.findElements(issueRowsLocator);
  }

}