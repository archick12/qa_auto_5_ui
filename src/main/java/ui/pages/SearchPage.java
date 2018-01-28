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
}