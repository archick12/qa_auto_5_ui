package ui;

import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
import ui.pages.*;
import utils.TestCase;

import static org.testng.Assert.assertEquals;

public class  EditIssueTest {
    @BeforeGroups(groups = {"UI"})
    public void setUp() {
        LoginPage loginPage = new LoginPage();

        loginPage.open();
        assertEquals(loginPage.isOnThePage(), true); // confirm that we are on the right page
        // otherwise we can click a wrong web element

        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickLogin();

    }

    @TestCase(id = "1")//--------------------------------------------------Алена
    @Test(groups = {"UI, SKIPP"})
     public void checkTestWork(){
    NewIssuePage newIssuePage = new NewIssuePage();
    HeaderPage headerPage = new HeaderPage();
    DashBoardPage dashBoardPage = new DashBoardPage();
    IssuePage issuePage = new IssuePage();

    String parentIssueId = "Your Issue ID";

    // TO DO steps and asserts

         newIssuePage.clickCreateIssueButton();//////это я проверяла, запускается ли тест


    }
























































































    //    @TestCase(id = "1")--------------------------------------------------Марина
//    @Test(groups = {"UI"})
//    // public void .........(){
//    NewIssuePage newIssuePage = new NewIssuePage();
//    HeaderPage headerPage = new HeaderPage();
//    DashBoardPage dashBoardPage = new DashBoardPage();
//    IssuePage issuePage = new IssuePage();
//
//    String parentIssueId = "Your Issue";

    // TO DO steps and asserts
    //}
























































































    //    @TestCase(id = "1")--------------------------------------------------Наташа
//    @Test(groups = {"UI"})
//    // public void .........(){
//    NewIssuePage newIssuePage = new NewIssuePage();
//    HeaderPage headerPage = new HeaderPage();
//    DashBoardPage dashBoardPage = new DashBoardPage();
//    IssuePage issuePage = new IssuePage();
//
//    String parentIssueId = "Your Issue";

    // TO DO steps and asserts
    //}
























































































    //    --------------------------------------------------Настя
    @TestCase(id = "4")
    @Test(groups = {"UI"})

    public void AddComment() {
        NewIssuePage newIssuePage = new NewIssuePage();
        HeaderPage headerPage = new HeaderPage();
        DashBoardPage dashBoardPage = new DashBoardPage();
        IssuePage issuePage = new IssuePage();
        String parentIssueId = "QAAUT-10";
        String commentText = "Very useful comment";

        // TO DO steps and asserts

        issuePage.openExistingIssue(parentIssueId);
        assertEquals(issuePage.isOnThePage(parentIssueId), true);
        issuePage.clickOnCommentBtn();
        issuePage.enterComment(commentText);
        issuePage.clickOnAddComment();

        assertEquals(issuePage.isCommentTextPresent(commentText),true);
        issuePage.clickOnDeleteComment();
        issuePage.confirmDeletionOfComment();
        assertEquals(issuePage.isCommentTextMissing(commentText), true);

    }
























































































        @TestCase(id = "1")//--------------------------------------------------Julia
    @Test(groups = {"UI, SKIPP"})
     public void checkButtonWork() {
            NewIssuePage newIssuePage = new NewIssuePage();
            HeaderPage headerPage = new HeaderPage();
            DashBoardPage dashBoardPage = new DashBoardPage();
            IssuePage issuePage = new IssuePage();

            String parentIssueId = "QAAUT-19";

            // TO DO steps and asserts
            assertEquals(dashBoardPage.isOnThePage(), true);

            issuePage.openExistingIssue(parentIssueId);
            assertEquals(issuePage.isOnThePage(parentIssueId), true);

            newIssuePage.clickWorkflowButton();
            newIssuePage.selectInProgressButton();




           // newIssuePage.clickWorkflowButton();
          //  newIssuePage.selectDoneButton();


            }

    @TestCase(id = "1")//--------------------------------------------------Julia
    @Test(groups = {"UI"})
    public void checkButtonDoneWork() {
        NewIssuePage newIssuePage = new NewIssuePage();
        HeaderPage headerPage = new HeaderPage();
        DashBoardPage dashBoardPage = new DashBoardPage();
        IssuePage issuePage = new IssuePage();

        String parentIssueId = "QAAUT-19";

        // TO DO steps and asserts
        assertEquals(dashBoardPage.isOnThePage(), true);

        issuePage.openExistingIssue(parentIssueId);
        assertEquals(issuePage.isOnThePage(parentIssueId), true);



         newIssuePage.clickWorkflowButton();
         newIssuePage.selectDoneButton();


    }


        }
