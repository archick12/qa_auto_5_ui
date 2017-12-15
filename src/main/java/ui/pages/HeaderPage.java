package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.utils.RemoteDriverManager;

public class HeaderPage extends BasePage {


    private By systemDashboardLocator = By.cssSelector("div.aui-page-header-main>h1");
    private By createLocator = By.id("create-menu");
    private By searchLocator = By.id("quickSearchInput");


    public HeaderPage() {
        this.driver = RemoteDriverManager.getDriver();
    }

    public HeaderPage search(String searchWord) {

        WebElement element = driver.findElement(searchLocator);
        element.sendKeys(searchWord);
        element.submit();
        return this;
    }


}