package ui.pages;

import org.openqa.selenium.By;
import ui.utils.RemoteDriverManager;

public class DashBoardPage extends BasePage {

    private String pageURL = baseURL + "/secure/Dashboard.jspa";

    private By systemDashboardLocator = By.cssSelector("div.aui-page-header-main>h1");




    public DashBoardPage() {
        this.driver = RemoteDriverManager.getDriver();
    }

    public boolean isOnThePage() {
        return isOnThePage(pageURL);

    }

}