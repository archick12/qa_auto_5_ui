package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ui.utils.RemoteDriverManager;

public class SearchPage extends BasePage {

  // TODO add selectors and methods
  private By layoutSwitcherButton = By.id("layout-switcher-button");
  private By listViewItem = By.id("AJS_DROPDOWN_LISTITEM__33");
  private By recentProject1Locator = By
      .xpath("(//*[contains(@id,'proj_lnk_')][@class='aui-icon-container'])[1]");
  private By feedbackSubmitLocator = By
      .xpath("//*[@id='jic-collector-form']//child::input[@type='submit']");

  public SearchPage() {
    this.driver = RemoteDriverManager.getDriver();
  }

  public SearchPage clickOnLayoutSwitcherButton() {
    waitToBePresentAndSendSubmit(layoutSwitcherButton);
    return this;
  }

  public SearchPage clickListViewItem() {
    waitToBePresentAndSendSubmit(listViewItem);
    return this;
  }

}