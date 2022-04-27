package framework.browser;

import framework.util.Config;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

    public WebDriver getWebDriver() {
        switch (Config.getValue("browser")) {
            case ("chrome"): {
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver((ChromeOptions) Option.CHROME.getOptions());
            }
            case ("firefox"): {
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver((FirefoxOptions) Option.FIREFOX.getOptions());
            }
            default: {
                throw new IllegalArgumentException("unknown framework.browser, supported browsers: Chrome, Firefox");
            }
        }
    }
}
