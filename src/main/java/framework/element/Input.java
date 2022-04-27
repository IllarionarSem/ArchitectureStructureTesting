package framework.element;

import framework.util.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.Arrays;

public class Input extends BaseElement {

    public Input(By by, String name) {
        super(by, name);
    }

    public void type(String text) {
        Logger.info("Type " + text);
        getElement().sendKeys(text);
    }

    public void sendKey(Keys... keys) {
        Logger.info(String.format("Send keys: %s", Arrays.stream(keys).map(Keys::toString)));
        getElement().sendKeys(keys);
    }
}
