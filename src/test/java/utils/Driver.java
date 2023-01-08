package utils;

import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {
    private Driver() {

    }
    private static WebDriver driver;
    public static WebDriver get() {
        if (driver == null) {
            String browser = (System.getProperty("browserName") != null) ? System.getProperty("browserName") : ConfigReader.get("browserName");

            switch (browser.toLowerCase()) {
                case "chrome":
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--disable-blink-features=AutomationControlled");
                    options.addArguments("useAutomationExtension", "false");
                    options.addArguments("excludeSwitches", "enable-automation");
                    options.addArguments("--disable-infobars");
                    options.addArguments("--disable-notifications");
                    options.addArguments("--disable-default-apps");
                    options.addArguments("--disable-web-security");
                    options.addArguments("--disable-site-isolation-trials");
                    options.addArguments("--disable-logging");
                    options.addArguments("--disable-bundled-ppapi-flash");
                    options.addArguments("--disable-gpu-compositing");
                    options.addArguments("--disable-gpu-shader-disk-cache");
                    options.addArguments("--disable-extensions");
                    options.addArguments("--log-level=3");
                    options.addArguments("--disable-blink-features=AutomationControlled");
                    options.addArguments("--user-data-dir="); //needs to be added.

                    driver = new ChromeDriver(options);
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "firefox-headless":
                    driver = new FirefoxDriver(new FirefoxOptions().setHeadless(true));
                    break;
                case "ie":
                    if (!System.getProperty("os.names.txt").toLowerCase().contains("windows"))
                        throw new WebDriverException("Your OS doesn't support Internet Explorer");
                    driver = new InternetExplorerDriver();
                    break;
                case "edge":
                    if (!System.getProperty("os.names.txt").toLowerCase().contains("windows"))
                        throw new WebDriverException("Your OS doesn't support Edge");
                    driver = new EdgeDriver();
                    break;
                case "safari":
                    if (!System.getProperty("os.names.txt").toLowerCase().contains("mac"))
                        throw new WebDriverException("Your OS doesn't support Safari");
                    driver = new SafariDriver();
                    break;
                default:
                    driver = new ChromeDriver();
                    break;
            }
        }
        driver.manage().window().maximize();  // Tarayıcı tam ekran modu
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); // Driver elementlere erişim için 30 sn bekleme süresi tanınır
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60)); //Sayfaların timeouta düşme süresi tanınır

        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
