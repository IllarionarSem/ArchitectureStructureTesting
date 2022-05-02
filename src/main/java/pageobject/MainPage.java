package pageobject;

import framework.element.Button;
import org.openqa.selenium.By;

public class MainPage extends BasePage {

    public enum GroupSelection {

        HOME("Home"),
        BASS("bass"),
        DRUM("drum"),
        DJ("dj"),
        KEYBOARD_INSTRUMENTS("keyboards instruments"),
        PRO_AUDIO("pro audio"),
        GUITAR("guitar");

        private final String text;

        GroupSelection(String text) {
            this.text = text;
        }
    }

    private static final String XPATH_GROUP_SELECTION = "//div[contains(@class,'dropdown-menu')]//li//span[@class='text' and text()='%s']";

    private final Button btnHome = new Button(By.xpath("//form[contains(@id,'categories')]//button"), "Home");

    public void goToGroup(GroupSelection groupSelection) {
        btnHome.click();
        getBtnGroupSelection(groupSelection).click();
    }

    private Button getBtnGroupSelection(GroupSelection groupSelection) {
        waitUtil.waitUntilAllVisible(By.xpath(String.format(XPATH_GROUP_SELECTION, groupSelection.text)));
        return new Button(By.xpath(String.format(XPATH_GROUP_SELECTION, groupSelection.text)), String.format("%s Group Button", groupSelection.text));
    }
}
