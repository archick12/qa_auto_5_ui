package ui.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.utils.RemoteDriverManager;

public class BasePage {

    final static Logger logger = Logger.getLogger(BasePage.class); // initialization of logger

    // protected String baseURL = "http://soft.it-hillel.com.ua:8080";
    protected String baseURL = "http://jira.hillel.it:8080";
    protected WebDriver driver;
    private int defaultExplicitWaitInSeconds = 10;
    public static String defaultImplicitWaitInSeconds = "10";

    protected BasePage() {
        this.driver = RemoteDriverManager.getDriver();
    }

    protected void waitToBePresent(By locator) {
        logger.info("WAIT ELEMENT TO BE PRESENT: " + locator);
        (new WebDriverWait(driver, defaultExplicitWaitInSeconds))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected boolean waitToBeMissing(By locator) {
        logger.info("WAIT ELEMENT TO BE MISSING: " + locator);
        (new WebDriverWait(driver, defaultExplicitWaitInSeconds))
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));

        return true;
    }

    /**
     * @param locator
     * @param timeOutInSeconds
     */
    protected void waitToBePresentIn(By locator, int timeOutInSeconds) {
        logger.info("WAIT ELEMENT TO BE PRESENT: " + locator + " in " + timeOutInSeconds + " seconds");
        (new WebDriverWait(driver, timeOutInSeconds))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    /**
     * @param locator
     */

    protected void waitToBePresentAndClick(By locator) {
        logger.info("WAIT ELEMENT TO BE PRESENT AND CLICK: " + locator);
        WebElement element = null;

        try {
            element = (new WebDriverWait(driver, defaultExplicitWaitInSeconds)).
                    until(ExpectedConditions.presenceOfElementLocated(locator));
            element.click();
        } catch (StaleElementReferenceException ignored) {
            element = (new WebDriverWait(driver, defaultExplicitWaitInSeconds)).
                    until(ExpectedConditions.presenceOfElementLocated(locator));
            element.click();
        }

    }

    protected void waitToBePresentAndSendKeys(By locator, String keys) {
        logger.info("WAIT ELEMENT TO BE PRESENT AND SEND KEYS: " + locator);

        WebElement element = null;

        try {
            element = (new WebDriverWait(driver, defaultExplicitWaitInSeconds)).
                    until(ExpectedConditions.presenceOfElementLocated(locator));
            element.sendKeys(keys);
        } catch (StaleElementReferenceException ignored) {
            element = (new WebDriverWait(driver, defaultExplicitWaitInSeconds)).
                    until(ExpectedConditions.presenceOfElementLocated(locator));
            element.sendKeys(keys);
        }

    }

    protected void waitToBePresentAndSendSubmit(By locator) {
        logger.info("WAIT ELEMENT TO BE PRESENT AND SUBMIT: " + locator);
        WebElement element = null;

        try {
            element = (new WebDriverWait(driver, defaultExplicitWaitInSeconds)).
                    until(ExpectedConditions.presenceOfElementLocated(locator));
            element.click();
        } catch (StaleElementReferenceException ignored) {
            element = (new WebDriverWait(driver, defaultExplicitWaitInSeconds)).
                    until(ExpectedConditions.presenceOfElementLocated(locator));
            element.click();
        }

    }

    protected boolean waitToBePresentAndContainsText(By locator, String text) {
        logger.info("WAIT ELEMENT TO BE PRESENT AND CONTAINS TEXT: " + locator);
        WebElement element = null;

        try {
            element = (new WebDriverWait(driver, defaultExplicitWaitInSeconds)).
                    until(ExpectedConditions.presenceOfElementLocated(locator));

            String result = element.getText();

            // TODO doe we really need to check text if we alredy found element using xpath and contains?

            if (result.contains(text)) {
                return true;
            } else {
                return false;
            }

        } catch (StaleElementReferenceException ignored) {
            element = (new WebDriverWait(driver, defaultExplicitWaitInSeconds)).
                    until(ExpectedConditions.presenceOfElementLocated(locator));
            String result = element.getText();

            if (result.contains(text)) {
                return true;
            } else {
                return false;
            }
        }

    }


    protected void scrollDown() {

    }

    protected void scrollUp() {

    }

    protected void scrollUpOn(int x) {
        logger.info("SCROLL UP ON: " + x + " pixels");
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-" + x + ")", "");
    }

    protected void scrollDownOn(int x) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + x + ")", "");
    }

//    protected WebElement findElement(By locator) {
//        return driver.findElement(locator);
//    }


    protected boolean isOnThePage(String expectedURL) {
// added timer to wait for page loading.
        boolean result;
        result = (new WebDriverWait(driver, defaultExplicitWaitInSeconds)).
                    until(ExpectedConditions.urlToBe(expectedURL));

        // -- old realization
//        String currentURL = driver.getCurrentUrl();
//        boolean result = expectedURL.equals(currentURL);
        if (result == true) {
            logger.info("IS ON THE PAGE: " + expectedURL);
        } else {
            logger.info("YOU ARE NOT ON THE PAGE: " + expectedURL);
            logger.info("YOU ARE ON THE PAGE: " + driver.getCurrentUrl());
        }
        return result;

    }

    protected void openExistingIssue(String url){
        driver.get(url);
    }

}
