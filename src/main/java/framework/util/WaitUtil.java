package framework.util;

import framework.browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtil {

    public WebDriverWait getWait() {

        return new WebDriverWait(Browser.getInstance().getDriver(), Duration.ofSeconds(Long.parseLong(Config.getValue("timeout"))));
    }

    public void waitUntilAllVisible(By by) {
        Logger.info("Wait for all elements visible");
        getWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public void waitPageLoaded() {
        ExpectedCondition<Boolean> pageLoadCondition =
                driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        getWait().until(pageLoadCondition);
    }
}
