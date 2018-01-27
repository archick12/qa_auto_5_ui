package ui.utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.ListenerTest;

public class LocalWebDriverFactory {

    final static Logger logger = Logger.getLogger(ListenerTest.class);

    public static WebDriver createInstance(String browserName) {
        logger.info("CREATING local browser instance - " + browserName);
        WebDriver driver = null;
        DesiredCapabilities capability = null;

        if (browserName.toLowerCase().contains("firefox")) {
            capability = DesiredCapabilities.firefox();
            capability.setCapability("marionette", true);
            System.setProperty("webdriver.gecko.driver", ".\\environment\\grid\\drivers\\geckodriver-v0.18.0-win64.exe");
            driver = new FirefoxDriver(capability);
        }
        if (browserName.toLowerCase().contains("chrome")) {
            capability = DesiredCapabilities.chrome();
            System.setProperty("webdriver.chrome.driver", ".\\environment\\grid\\drivers\\chromedriver_win32_v2.34.exe");
            driver = new ChromeDriver(capability);
        }
        if (browserName.toLowerCase().contains("safari")) {
            capability = DesiredCapabilities.safari();
            driver = new SafariDriver(capability);
        }
        if (browserName.toLowerCase().contains("internet")) {
            capability = DesiredCapabilities.internetExplorer();
            System.setProperty("webdriver.ie.driver", ".\\environment\\grid\\drivers\\IEDriverServer_x64_3.4.0.exe");
            driver = new InternetExplorerDriver(capability);
        }
        return driver;
    }
}