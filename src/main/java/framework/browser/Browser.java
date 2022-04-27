package framework.browser;

import framework.util.Logger;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Browser {

    @Getter
    private static final Browser Instance = new Browser();

    private final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public WebDriver getDriver() {
        return driver.get();
    }

    public void setDriver(WebDriver driver) {
        this.driver.set(driver);
    }

    public void quit() {
        Logger.info("QUIT DRIVER");
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }

    public void goToURL(String url) {
        Logger.info("Go to URL: " + url);
        driver.get().get(url);
    }

    public void fullScreen() {
        Logger.info("Maximize window");
        driver.get().manage().window().maximize();
    }

    public void setImplicitlyWait(Duration implicitlyDuration) {
        driver.get().manage().timeouts().implicitlyWait(implicitlyDuration);
    }
}
