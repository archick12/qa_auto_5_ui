package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
import ui.pages.*;
import ui.utils.RemoteDriverManager;
import utils.TestCase;

import java.awt.*;
import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class  EditIssueTest {
    LoginPage loginPage;
    HeaderPage headerPage;
    DashBoardPage dashBoardPage;
    IssuePage issuePage;
    NewIssuePage newIssuePage;

    String parentIssueId = "QAAUT-374";

    @BeforeGroups("Smoke, UI, EditTest, Stable")
    public void setUp() {
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


    @Test(groups={"Smoke"})
    public void smokeTestForEditIssuePage(){
        assertTrue(issuePage.isEditIssueButtonPresent());
        assertTrue(issuePage.isAssignButtonPresent());
        assertTrue(issuePage.isAddCommentButtonPresent());
        assertTrue(issuePage.isMoreButtonPresent());
        assertTrue(issuePage.isBacklogButtonPresent());
        assertTrue(issuePage.isSelectForDevelopmentButtonPresent());
        assertTrue(issuePage.isWorkflowButtonPresent());
        assertTrue(issuePage.isTypeFieldPresent());
        assertTrue(issuePage.isPriorityFieldPresent());
        assertTrue(issuePage.isLablesFieldPresent());
        assertTrue(issuePage.isDescriptionFieldPresent());
        assertTrue(issuePage.isBrowseButtonPresent());
        System.out.println("Smoke");
    }

    @TestCase(id = "C25")//--------------------------------------------------Марина
    @Test(groups = {"UI", "Stable", "EditIssue"}, dependsOnGroups = {"Smoke"})
    public void createAndDeleteSubTask() throws InterruptedException {
        String subTaskSummary = "New sub-task created";
        String addLabel = "olafff";
        //String subTaskAssign = "username";

        issuePage
                .clickMoreButton()                              //нажимаем 'More' кнопку в заголовке тикета на IssuePage
                .clickCreateSubTask();                          //нажимаем на кнопку 'Create sub-task'
        //------------------заполняем поля для создания sub-task и применяем изменения
        newIssuePage
                .fillSummary(subTaskSummary)
                .addLabel(addLabel)
                .clickAssignToMeButton()
                .clickSubmitButton();
        //-------------------проверяем, что sub-task создался по полю summary
        assertEquals(issuePage.isSubTaskSummaryPresent(subTaskSummary), true);
        //assertEquals(issuePage.isSubTaskAssigneePresent(subTaskAssign), true);
        //-------------------удаляем после себя sub-ticket со страници родителя IssuePage
        issuePage
                .clickMoreBtnSubtask()
                .clickDeleteSubTaskOnIssuePage()
                .clickDeleteSubTaskConfirmation();
        //-------------------проверяем, что sub-task удален по полю summary, которое должно отсутствовать
        assertEquals(issuePage.isSubTaskSummaryMissing(subTaskSummary), true);
        System.out.println("EditIssue");
    }

    @TestCase(id = "C5")//--------------------------------------------------Nata
    @Test(groups = {"UI", "Stable", "EditIssue"}, dependsOnGroups = {"Smoke"})
    public void checkAssignUser() {
        String addComment = "Great!";
        newIssuePage
                .selectAssignFieldButton()
//              .selectTextButton();
                .addComment()
                .selectAssignField("bobulan.nataliya")
                .selectAssignButton()
                .waitForAssignPopUp();

        assertTrue(newIssuePage.isSelectUnassignIsPresent("bobulan.nataliya"));

        newIssuePage
                .selectAssignFieldButton()
                .selectAssignField("Unassigned")
                .selectAssignButton()
                .waitForAssignPopUp();

        assertTrue(newIssuePage.isSelectUnassignButtonIsPresent());

        issuePage
                .clickOnDeleteComment()
                .confirmDeletionOfComment();
        assertEquals(issuePage.isCommentTextMissing(addComment), true);
        System.out.println("EditIssue");
    }


    @TestCase(id = "C3")//    --------------------------------------------------Настя
    @Test(groups = {"UI", "Stable", "EditIssue"}, dependsOnGroups = {"Smoke"})

    public void addComment() throws InterruptedException {
        String commentText = "Very useful comment";
        issuePage
                .clickOnCommentBtn()
                .enterComment(commentText)
                .clickOnAddComment();
        assertEquals(issuePage.isCommentTextPresent(commentText), true);

        issuePage
                .clickOnDeleteComment()
                .confirmDeletionOfComment();
        assertEquals(issuePage.isCommentTextMissing(commentText), true);
        System.out.println("EditIssue");
    }

    @TestCase(id = "C6")//--------------------------------------------------Julia
    @Test(groups = {"UI", "Stable", "EditIssue"}, dependsOnGroups = {"Smoke"})
    public void checkButtonWork() throws InterruptedException {
        String statusOfTheIssue = "In Progress";

        if(newIssuePage.isButtonWithTextPresent()){
            newIssuePage
                    .clickWorkflowButton()
                    .selectDoneButton();
                return;
        }else{
            newIssuePage
                    .clickWorkflowButton()
                    .selectInProgressButton();
        }
        assertTrue(newIssuePage.isButtonWithTextPresent());

        newIssuePage
                .clickWorkflowButton()
                .selectDoneButton()
                .waitForUpdateStatusPopUp();

        newIssuePage
                .selectBacklogButton();

        assertTrue(newIssuePage.isButtonWithTextBacklogPresent());
        newIssuePage.waitForUpdateStatusPopUp();

        newIssuePage
                .clickSelectedForDevelopment();
        assertTrue(newIssuePage.isButtonWithTextSelectForDevelopment());
        System.out.println("EditIssue");
    }

    @TestCase(id = "C7")//--------------------------------------------------Алена
    @Test(groups = {"UI", "EditIssue", "SKIP"}, dependsOnGroups = {"Smoke"}) //Skipped - because test does not return the ticket to its original state
    public void addLabletoIssue() {
        String label = "My_label";

        issuePage
                .clickLabelField()
                .addLabel(label)
                .clickDescriptionField();
        assertEquals(issuePage.isLabelPresent(label), true);
        //TODO delete label
        //TODO assertEquals(issuePage.isLabelAbsent(label), true);
        /*issuePage
                .clickEditLabel(); <<----не получается кликнуть на элемент редактировния lable (т.к. он скрыт)
        assertFalse(issuePage.isAddedLabelPresent(label));*/
        System.out.println("EditIssue");
    }

    @TestCase(id = "C23")//--------------------------------------------------Алена
    @Test(groups = {"UI", "EditIssue", "SKIP"}, dependsOnGroups = {"Smoke"})//Skipped - because test does not return the ticket to its original state
    public void addAttachmenttoIssue() throws AWTException {
        String pathToFile = "/C:/Users/user/Desktop/Screenshot_21.png";
        String fileName = "Screenshot_21.png";
        File file = new File(pathToFile);

        issuePage
                .clickBrowseButton()
                .setClipboardData(file.getAbsolutePath())
                .robot();
        assertEquals(issuePage.isAttachmentPresent(fileName),true);
        //TODO delete attachment
        //TODO assertEquals(issuePage.isAttachmentAbsent(fileName), true)
        /*issuePage
                .clickDeleteAttachment(); <<----не получается кликнуть на элемент удаления аттача, т.к он скрыт
        assertFalse(newIssuePage.isAttachmentPresent(fileName));*/
        System.out.println("EditIssue");
    }

    @TestCase(id = "C24")//--------------------------------------------------Марина
    @Test(groups = {"UI", "EditIssue", "SKIP"}, dependsOnGroups = {"Smoke"})//Skipped - because test is failed all time
    public void changePriority() {
        String issuePriorityHigher = "High";
       // String issuePriorityLower = "Low";
        issuePage.clickEditButton();
        newIssuePage.selectPriority(issuePriorityHigher);
        issuePage.clickUpdateButtonPopUp();
        //TODO Test is failed - java.lang.AssertionError: expected [true] but found [false]
        //TODO need to add waiting before assert
        assertEquals(issuePage.isIssuePriorityCorrect(issuePriorityHigher), true);

        /*issuePage.clickEditButton();
        newIssuePage.selectPriority(issuePriorityLower);
        issuePage.clickUpdateButtonPopUp();
        assertEquals(issuePage.isIssuePriorityCorrect(issuePriorityLower), true);*/
        System.out.println("EditIssue");
    }
}





