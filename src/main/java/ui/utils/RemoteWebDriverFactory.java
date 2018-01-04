package ui.utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.ListenerTest;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteWebDriverFactory {

    final static Logger logger = Logger.getLogger(ListenerTest.class);

    public static WebDriver createInstance(String browserName) {
        logger.info("CREATING browser instance - " + browserName);

        URL hostURL = null;
        try {
            hostURL = new URL("http://127.0.0.1:4444/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        DesiredCapabilities capability = null;

        if (browserName.toLowerCase().contains("firefox")) {
            capability = DesiredCapabilities.firefox();
            capability.setBrowserName("firefox" );
            capability.setCapability("marionette", true);
          //  System.setProperty("webdriver.gecko.driver", "/Users/macbook/Downloads/qa_auto_5_initial/environment/grid/geckodriver_0_18_0");
        }
        if (browserName.toLowerCase().contains("internet")) {
            capability = DesiredCapabilities.internetExplorer();
        }
        if (browserName.toLowerCase().contains("chrome")) {
            //System.setProperty("webdriver.chrome.driver", "/Users/macbook/Downloads/qa_auto_5_initial/environment/grid/chromedriver_2_29");
            capability = DesiredCapabilities.chrome();
            capability.setBrowserName("chrome" );
        }
        if (browserName.toLowerCase().contains("safari")) {
            capability = DesiredCapabilities.safari();
            capability.setBrowserName("safari" );
        }

        WebDriver driver = new RemoteWebDriver(hostURL, capability);
        return driver;
    }
}