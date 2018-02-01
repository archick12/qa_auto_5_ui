package ui;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
import ui.pages.*;
import utils.TestCase;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.io.File;

import static org.testng.Assert.assertEquals;

import static org.testng.Assert.assertTrue;

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

    @TestCase(id = "C7")//--------------------------------------------------Алена

    @Test(groups = {"UI"})
    public void addLabletoIssue() {
        NewIssuePage newIssuePage = new NewIssuePage();
        HeaderPage headerPage = new HeaderPage();
        IssuePage issuePage = new IssuePage();
        String parentIssueId = "QAAUT-4";
        String label = "My_label";
        headerPage.search(parentIssueId);
        assertEquals(issuePage.isOnThePage(parentIssueId), true);
        newIssuePage.clickLabelField();
        newIssuePage.addLabel(label);
        newIssuePage.clickDescriptionField();
        assertEquals(newIssuePage.isAddedLabelPresent(label), true);
    }

    @TestCase(id = "C23")//--------------------------------------------------Алена
    @Test(groups = {"UI", "SKIP"})
    public void addAttachmenttoIssue() throws AWTException {
        NewIssuePage newIssuePage = new NewIssuePage();
        HeaderPage headerPage = new HeaderPage();
        IssuePage issuePage = new IssuePage();
        String parentIssueId = "QAAUT-4";
        String pathToFile = "/home/alena/Документы/Lightshot/Screenshot_21.jpg";
        String fileName = "Screenshot_21.jpg";
        File file = new File(pathToFile);
        headerPage.search(parentIssueId);
        assertEquals(issuePage.isOnThePage(parentIssueId), true);
        newIssuePage.clickBrowseButton();
        newIssuePage.setClipboardData(file.getAbsolutePath());
        newIssuePage.robot();
        assertEquals(newIssuePage.isAttachmentPresent(fileName),true);

    }


    @TestCase(id = "C24")//--------------------------------------------------Марина
    @Test(groups = {"UI"})
    public void selectPriority() {
        NewIssuePage newIssuePage = new NewIssuePage();
        HeaderPage headerPage = new HeaderPage();
        IssuePage issuePage = new IssuePage();
        String parentIssueId = "QAAUT-1";
        String issuePriority = "High";
        headerPage.search(parentIssueId);
        assertEquals(issuePage.isOnThePage(parentIssueId), true);
        issuePage.clickEditButton();
        newIssuePage.selectPriority(issuePriority);
        issuePage.clickUpdateButtonPopUp();
        assertEquals(issuePage.isIssuePriorityCorrect(issuePriority), true);
    }

    @TestCase(id = "C25")//--------------------------------------------------Марина
    @Test(groups = {"UI"})
    public void createSubTask() throws InterruptedException {
        NewIssuePage newIssuePage = new NewIssuePage();
        HeaderPage headerPage = new HeaderPage();
        IssuePage issuePage = new IssuePage();
        String parentIssueId = "QAAUT-1";
        String subTaskSummary = "New sub-task created";
        String addLabel = "olafff";

        headerPage.search(parentIssueId);
        assertEquals(issuePage.isOnThePage(parentIssueId), true);
        issuePage.openNewSubTask();
        newIssuePage
                .fillSummary(subTaskSummary)
                .addLabel(addLabel)
                .clickAssignToMeButton()
                .clickSubmitButton();
        assertEquals(issuePage.isSubTaskSummaryPresent(subTaskSummary), true);
    }


    @TestCase(id = "C5")//--------------------------------------------------Nata
    @Test(groups = {"UI"})
    public void checkAssignUser() {
        NewIssuePage newIssuePage = new NewIssuePage();
        HeaderPage headerPage = new HeaderPage();
        DashBoardPage dashBoardPage = new DashBoardPage();
        IssuePage issuePage = new IssuePage();

        String parentIssueId = "QAAUT-19";
        String addComment = "Great!";

        // TO DO steps and asserts
        assertEquals(dashBoardPage.isOnThePage(), true);

        issuePage.openExistingIssue(parentIssueId);
        assertEquals(issuePage.isOnThePage(parentIssueId), true);

        newIssuePage.selectAssignFieldButton();
//        newIssuePage.selectTextButton();
        newIssuePage.addComment();
        newIssuePage.selectAssignPerson();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertTrue(newIssuePage.assignPersonIsPresent("bobulan.nataliya"));
//        newIssuePage.selectAssignButton();

    }

    //    --------------------------------------------------Настя
    @TestCase(id = "C3")
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

    @TestCase(id = "C6")//--------------------------------------------------Julia
    @Test(groups = {"UI"})
    public void checkButtonWork() throws InterruptedException {
        NewIssuePage newIssuePage = new NewIssuePage();
        HeaderPage headerPage = new HeaderPage();
        DashBoardPage dashBoardPage = new DashBoardPage();
        IssuePage issuePage = new IssuePage();

        String parentIssueId = "QAAUT-19";
        String statusOfTheIssue = "In Progress";

        // TO DO steps and asserts
        assertEquals(dashBoardPage.isOnThePage(), true);

        issuePage.openExistingIssue(parentIssueId);
        assertEquals(issuePage.isOnThePage(parentIssueId), true);

        if(newIssuePage.isButtonWithTextPresent()){
            newIssuePage.clickWorkflowButton();
            newIssuePage.selectDoneButton();
                return;
        }else{
            newIssuePage.clickWorkflowButton();
            newIssuePage.selectInProgressButton();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        assertTrue(newIssuePage.isButtonWithTextPresent());

        newIssuePage.clickWorkflowButton();
        newIssuePage.selectDoneButton();
        }
    }