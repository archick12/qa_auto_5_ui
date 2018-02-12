package ui;

import org.testng.Assert;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
import ui.pages.*;
import utils.TestCase;

import java.awt.*;
import java.io.File;

import static java.lang.Thread.sleep;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MyTest extends IssuePage{
    LoginPage loginPage;
    HeaderPage headerPage;
    DashBoardPage dashBoardPage;
    IssuePage issuePage;
    NewIssuePage newIssuePage;

    String parentIssueId = "QAAUT-3";

    @BeforeGroups(groups={"UI","Smoke Test","Regression"})
    public void setUp() throws InterruptedException {
        loginPage = new LoginPage();
        headerPage = new HeaderPage();
        dashBoardPage = new DashBoardPage();
        issuePage = new IssuePage();
        newIssuePage = new NewIssuePage();

        loginPage.open();
        assertEquals(loginPage.isOnThePage(), true); // confirm that we are on the right page
        // otherwise we can click a wrong web element

        loginPage
                .enterUsername()
                .enterPassword()
                .clickLogin();

        headerPage.search(parentIssueId);               //поиск тестируюемого Issue в Jira
        assertEquals(issuePage.isOnThePage(parentIssueId), true); //проверка на ожидаемой ли мы странице "QAAUT-1"

    }

    @Test(groups={"UI","Smoke Test"})
    public void smokeTestForEditIssuePage()  {
        assertEquals(true, String.valueOf((isElementPresent(createLocator))));
        assertEquals(true, String.valueOf((isElementPresent(editIssueButtonLocator))));
        assertEquals(true, String.valueOf((isElementPresent(addCommentButtonLocator))));
        System.out.println("Smoke");

    }

}
