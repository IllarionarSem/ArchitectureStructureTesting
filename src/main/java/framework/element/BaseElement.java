package framework.element;

import framework.browser.Browser;
import framework.util.Logger;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

@RequiredArgsConstructor
public abstract class BaseElement {

    @NonNull
    @Getter
    protected By by;
    @NonNull
    @Getter
    protected String name;

    protected final Duration implicitlyDuration = Duration.ofSeconds(10);
    protected final Duration implicitlyZeroDuration = Duration.ofSeconds(0);

    public boolean isDisplayed() {
        Logger.info(String.format("Check is Element %s Displayed", name));
        return getElement().isDisplayed();
    }

    public void click() {

        Logger.info("Click element " + name);
        getElement().click();
    }

    protected WebElement getElement() {

        Browser.getInstance().setImplicitlyWait(implicitlyDuration);
        WebElement element = Browser.getInstance().getDriver().findElement(by);
        Browser.getInstance().setImplicitlyWait(implicitlyZeroDuration);
        return element;
    }

    public List<WebElement> findElements(By by) {

        return getElement().findElements(by);
    }
}
