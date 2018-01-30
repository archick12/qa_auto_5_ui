package ui;

import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
import ui.pages.*;
import utils.TestCase;

import static org.testng.Assert.assertEquals;

public class HeaderTest {

  // code that will be invoked before each @Test
  @BeforeGroups(groups = {"UI"})
  public void setUp() {
    LoginPage loginPage = new LoginPage();

    loginPage.open();
    assertEquals(loginPage.isOnThePage(), true); // confirm that we are on the right page
    // otherwise we can click a wrong web element
    loginPage.enterUsername()
            .enterPassword()
            .clickLogin();
  }

  @TestCase(id = "1")
  @Test(groups = {"UI"})
  public void feedbackTest() throws InterruptedException {
    HeaderPage headerPage = new HeaderPage();

    headerPage.clickFeedbackButton()
            // Alesya's test variant
            .switchDriverToFrame()
            //TODO make form to be visible for selenium (maybe need to change focus somehow)
            .fillFeedbackSummary("Test Summary")
            .fillFeedbackDescription("Test description")
            .fillFeedbackName("NAME")
            .fillFeedbackEmail("yes@no.com")
            .selectFeedbackAbout("Navigating JIRA")
            // Alesya's test variant
            .switchDriverToDefaultContent();
  }
}
