package ui.pages;

import org.openqa.selenium.By;
import ui.utils.RemoteDriverManager;

public class LoginPage extends BasePage {

    private String pageURL = baseURL + "/login.jsp";

    private By usernameLocator = By.id("login-form-username");
    private By passwordLocator = By.id("login-form-password");
    private By loginButtonLocator = By.id("login-form-submit");
    private By loginForm = By.id("login-form");


    public LoginPage() {
        this.driver = RemoteDriverManager.getDriver();
    }

    public LoginPage open() {
        logger.info("OPENING URL: " + pageURL);
        driver.get(pageURL);
        return this;
    }

    public LoginPage enterUsername() {
        waitToBePresentAndSendKeys(usernameLocator, "spektorius");
        return this;
    }

    public LoginPage enterPassword() {
        waitToBePresentAndSendKeys(passwordLocator, "dspektor");
        return this;
    }

    public LoginPage clickLogin() {
        waitToBePresentAndSendSubmit(loginButtonLocator);
        return this;
    }

    public boolean isOnThePage() {
        return isOnThePage(pageURL);
    }

}