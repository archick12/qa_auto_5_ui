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
    private static String OS = System.getProperty("os.name").toLowerCase();
    private static String arch = System.getProperty("os.arch").toLowerCase();
    private static String chromeDriverPath = null;
    private static String geckoDriverPath = null;
    private static String ieDriverPath = null;


    public static boolean isWindows() {
        return OS.contains("win");
    }
    public static boolean isMac() {
        return OS.contains("mac");
    }
    public static boolean isUnix() {
        return OS.contains("nix") || OS.contains("nux") || OS.contains("aix");
    }

    public static void setOsSpecificPaths() {
        logger.info(OS + " " + arch);

        if (isWindows()) {
            logger.info("This is Windows");
            geckoDriverPath = ".\\environment\\grid\\drivers_win\\geckodriver_win64_v0180.exe";
            chromeDriverPath = ".\\environment\\grid\\drivers_win\\chromedriver_win32_v235.exe";
            ieDriverPath = ".\\environment\\grid\\drivers_win\\IEDriverServer_x64_3.4.0.exe";
            if (arch.contains("86") && !(arch.contains("64"))) {
                geckoDriverPath = ".\\environment\\grid\\drivers_win\\geckodriver_win32_v0180.exe";
                ieDriverPath = ".\\environment\\grid\\drivers_win\\IEDriverServer_Win32_3.4.0.exe";
            }
        } else if (isUnix()) {
            logger.info("This is Unix or Linux");
            geckoDriverPath = "./environment/grid/drivers_nix/geckodriver_nix64_v0180";
            chromeDriverPath = "./environment/grid/drivers_nix/chromedriver_nix64_v235";
            if (arch.contains("86") && !(arch.contains("64"))) {
                geckoDriverPath = "./environment/grid/drivers_nix/geckodriver_nix32_v0180";
            }
        } else if (isMac()) {
            logger.info("This is Mac");
            geckoDriverPath = "./environment/grid/drivers_mac/geckodriver_mac_v0180";
            chromeDriverPath = "./environment/grid/drivers/chromedriver_mac64_v235";
        } else {
            logger.info("Your OS is not supported!!");
        }
    }

    public static WebDriver createInstance(String browserName) {
        logger.info("CREATING local browser instance - " + browserName);
        WebDriver driver = null;
        DesiredCapabilities capabilities;
        setOsSpecificPaths();

        if (browserName.toLowerCase().contains("firefox")) {
            capabilities = DesiredCapabilities.firefox();
            capabilities.setCapability("marionette", true);
            System.setProperty("webdriver.gecko.driver", geckoDriverPath);
            driver = new FirefoxDriver(capabilities);
        }
        if (browserName.toLowerCase().contains("chrome")) {
            capabilities = DesiredCapabilities.chrome();
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
            driver = new ChromeDriver(capabilities);
        }
        if (browserName.toLowerCase().contains("safari")) {
            capabilities = DesiredCapabilities.safari();
            driver = new SafariDriver(capabilities);
        }
        if (browserName.toLowerCase().contains("internet")) {
            capabilities = DesiredCapabilities.internetExplorer();
            System.setProperty("webdriver.ie.driver", ieDriverPath);
            driver = new InternetExplorerDriver(capabilities);
        }
        return driver;
    }
}