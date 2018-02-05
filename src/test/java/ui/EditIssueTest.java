package ui;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
import ui.pages.*;
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

    String parentIssueId = "QAAUT-228";

    @BeforeGroups(groups = {"UI"})
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

    @TestCase(id = "C7")//--------------------------------------------------Алена


    @Test(priority = 5, groups = {"UI"})
    public void addLabletoIssue() {
        String label = "My_label";

        newIssuePage
                .clickLabelField()
                .addLabel(label)
                .clickDescriptionField();
        assertEquals(newIssuePage.isAddedLabelPresent(label), true);
        //TODO delete label
        //TODO assertEquals(IssuePage.isLabelAbsent(label), true);
    }

    @TestCase(id = "C23")//--------------------------------------------------Алена
    @Test(priority = 6, groups = {"UI"})
    public void addAttachmenttoIssue() throws AWTException {
        String pathToFile = "/C:/Users/user/Desktop/Screenshot_21.png";
        String fileName = "Screenshot_21.png";
        File file = new File(pathToFile);

        newIssuePage
                .clickBrowseButton()
                .setClipboardData(file.getAbsolutePath())
                .robot();
        assertEquals(newIssuePage.isAttachmentPresent(fileName),true);
        //TODO delete attachment
        //TODO assertEquals(IssuePage.isAttachmentAbsent(fileName), true)
        /*issuePage
                .clickRemoveAttachment()
                .clickDeleteAttachmentConfirmationPopUp();
        assertFalse(newIssuePage.isAttachmentPresent(fileName));*/
    }


    @TestCase(id = "C24")//--------------------------------------------------Марина
    @Test(priority = 8, groups = {"UI", "SKIP"})
    public void changePriority() {
        String issuePriorityHigher = "High";
       // String issuePriorityLower = "Low";
        issuePage.clickEditButton();
        newIssuePage.selectPriority(issuePriorityHigher);
        issuePage.clickUpdateButtonPopUp();
        assertEquals(issuePage.isIssuePriorityCorrect(issuePriorityHigher), true);

      /*  issuePage.clickEditButton();
        newIssuePage.selectPriority(issuePriorityLower);
        issuePage.clickUpdateButtonPopUp();
        assertEquals(issuePage.isIssuePriorityCorrect(issuePriorityLower), true);*/
    }

    @TestCase(id = "C25")//--------------------------------------------------Марина
    @Test(priority = 7, groups = {"UI"})
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
        //-------------------проверяем, что sub-task создался по полю sammary
        assertEquals(issuePage.isSubTaskSummaryPresent(subTaskSummary), true);
        //assertEquals(issuePage.isSubTaskAssigneePresent(subTaskAssign), true);
        //-------------------удаляем после себя sub-ticket со страници родителя IssuePage
        issuePage
                .clickMoreBtnSubtask()
                .clickDeleteSubTaskOnIssuePage()
                .clickDeleteSubTaskConfirmation();
        //-------------------проверяем, что sub-task удален по полю sammary, которое должно отсутствовать
        assertEquals(issuePage.isSubTaskSummaryMissing(subTaskSummary), true);
    }



    @TestCase(id = "C5")//--------------------------------------------------Nata
    @Test(priority = 2, groups = {"UI"})
    public void checkAssignUser() {
        String addComment = "Great!";


        newIssuePage
                .selectAssignFieldButton()
//              .selectTextButton();
                .addComment()
                .selectAssignField("bobulan.nataliya")
                .selectAssignButton();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertTrue(newIssuePage.assignPersonIsPresent("bobulan.nataliya"));

        newIssuePage
                .selectAssignFieldButton()
                .selectAssignField("marina0937460675")
                .selectAssignButton();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertTrue(newIssuePage.selectUnassignIsPresent("marina0937460675"));
        issuePage
                .clickOnDeleteComment()
                .confirmDeletionOfComment();
        assertEquals(issuePage.isCommentTextMissing(addComment), true);
    }

//    //    --------------------------------------------------Настя
    @TestCase(id = "C3")
    @Test(priority = 3, groups = {"UI"})

    public void addComment() throws InterruptedException {
        String commentText = "Very useful comment";
        issuePage
                .clickOnCommentBtn()
                .enterComment(commentText)
                .clickOnAddComment();
        assertEquals(issuePage.isCommentTextPresent(commentText), true);
    }
    @Test(priority = 4, groups = {"UI"})
    public void DeleteComment() throws InterruptedException {
        String commentText = "Very useful comment";

        issuePage
                .clickOnDeleteComment()
                .confirmDeletionOfComment();
        assertEquals(issuePage.isCommentTextMissing(commentText), true);
    }

    @TestCase(id = "C6")//--------------------------------------------------Julia
    @Test(priority = 1, groups = {"UI"})
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
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        assertTrue(newIssuePage.isButtonWithTextPresent());

        newIssuePage
                .clickWorkflowButton()
                .selectDoneButton();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        newIssuePage.selectBacklogButton();
        assertTrue(newIssuePage.isButtonWithTextBacklogPresent());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        newIssuePage.clickSelectedForDevelopment();
        assertTrue(newIssuePage.isButtonWithTextSelectForDevelopment());


    }
        }





