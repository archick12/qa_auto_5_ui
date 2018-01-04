package utils;

import backend.utils.TestRailAPIClient;
import backend.utils.TestRailAPIException;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import ui.pages.BasePage;
import ui.utils.RemoteDriverManager;
import ui.utils.RemoteWebDriverFactory;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Listeners gives us the ability to act before and after of every Suite, Test and Methods
 * More details at - http://toolsqa.com/selenium-webdriver/testng-listeners/
 */
public class ListenerTest implements ITestListener {

    final static Logger logger = Logger.getLogger(ListenerTest.class);

    public void onTestStart(ITestResult iTestResult) {
        String[] groups = iTestResult.getMethod().getGroups();

        for (String group : groups) {
            if (group.contains("UI")) {
                String testCaseName = iTestResult.getName();
                String browserName = iTestResult.getTestContext().getCurrentXmlTest().getParameter("browserName");
                String localTestRun = iTestResult.getTestContext().getCurrentXmlTest().getParameter("local");
                String implicitWaitInSeconds = iTestResult.getTestContext().getCurrentXmlTest().getParameter("implicitWaitInSeconds");

                WebDriver driver = RemoteWebDriverFactory.createInstance(browserName);

                RemoteDriverManager.setWebDriver(driver);
                logger.info("TEST: " + testCaseName + " STARTED on browserName=" + browserName);

                changeImplicitWaitValue(driver, Integer.parseInt(implicitWaitInSeconds));

                // For slow internet and slow test suite, slower than rest of the tests

                if (group.contains("slow ")) {
                    changeImplicitWaitValue(driver, Integer.parseInt(implicitWaitInSeconds) + 50);
                }
            }
        }
    }

    public void onTestSuccess(ITestResult iTestResult) {

        String testCaseName = iTestResult.getName();
        logger.info("TEST: " + testCaseName + " PASSED");

        String testCaseId = retrieveId(iTestResult);
        updateTestRun(testCaseId, "1");

    }

    public void onTestFailure(ITestResult iTestResult) {
        logger.error("TEST: " + iTestResult.getName() + " FAILED");
        logger.error(iTestResult.getThrowable().fillInStackTrace());

        // TODO add option to enable / disable post of results

        String testCaseId = retrieveId(iTestResult);
        // updateTestRun(testCaseId, "5");
    }

    public void onTestSkipped(ITestResult iTestResult) {
        logger.info("TEST: " + iTestResult.getName() + " SKIPPED");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {
        // Invoked after the test class is instantiated and before any configuration method is called.
        int a = 0;
    }

    public void onFinish(ITestContext iTestContext) {
        // Invoked after all the tests have run and all their Configuration methods have been called.
        WebDriver driver = RemoteDriverManager.getDriver();

        if (driver != null) {
            changeImplicitWaitValue(driver, Integer.parseInt(BasePage.defaultImplicitWaitInSeconds));
            logger.info("Closing browser window");
//            RemoteDriverManager.closeDriver();
        }
    }

    private void changeImplicitWaitValue(WebDriver driver, int implicitWaitValueInSeconds) {
        driver.manage().timeouts().implicitlyWait(implicitWaitValueInSeconds, TimeUnit.SECONDS);
        logger.info("IMPLICIT WAIT WAS CHANGED TO: " + implicitWaitValueInSeconds);
    }

    private String retrieveId(ITestResult iTestResult) {

        ITestNGMethod method = iTestResult.getMethod();

        Class obj = method.getRealClass();
        Annotation annotation = null;

        try {
            annotation = obj.getDeclaredMethod(method.getMethodName()).getAnnotation(TestCase.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        TestCase testerInfo = (TestCase) annotation;
        String testCaseId = testerInfo.id();
        System.out.printf("ANNOTATION: " + testerInfo.id());
        return testCaseId;

    }


    private void updateTestRun(String testId, String statusId) {

        String testRunId = "";
        String pathTrail = "";
        String userTrail = "";
        String passwordTrail = "";

        PropertyReader propertyReader = new PropertyReader();
        Map<String, String> map = propertyReader.readProperties("testrun.properties");

        testRunId = map.get("test_run_id");
        pathTrail = map.get("path_t");
        userTrail = map.get("user_trail");
        passwordTrail = map.get("password_trail");

        TestRailAPIClient client = new TestRailAPIClient(pathTrail);
        client.setUser(userTrail);
        client.setPassword(passwordTrail);

        JSONObject response = null;

        JSONObject body = new JSONObject();
        body.put("status_id", statusId);


        try {
            response = (JSONObject) client.sendPost("add_result_for_case/" + testRunId + "/" + testId, body);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TestRailAPIException e) {
            e.printStackTrace();
        }


    }

}

