import framework.browser.Browser;
import framework.browser.DriverFactory;
import framework.util.Config;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    private Browser browser;

    @BeforeMethod
    public void startUp() {

        browser = Browser.getInstance();
        browser.setDriver(new DriverFactory().getWebDriver());
        browser.fullScreen();
        browser.goToURL(Config.getValue("url"));
    }

    @AfterMethod(alwaysRun = true)
    public void terminate() {

        browser.quit();
    }
}
