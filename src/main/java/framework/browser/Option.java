package framework.browser;

import framework.util.Config;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.AbstractDriverOptions;

import java.util.HashMap;

public enum Option {

    CHROME {
        @Override
        public AbstractDriverOptions getOptions() {
            HashMap<String, Object> chromePrefs = new HashMap<>();
            chromePrefs.put("profile.default_content_settings.popups", 0);
            chromePrefs.put("safebrowsing.enabled", "true");
            chromePrefs.put("intl.accept_languages", Config.getValue("locale"));
            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--incognito");
            options.setExperimentalOption("prefs", chromePrefs);
            return options;
        }
    },
    FIREFOX {
        @Override
        public AbstractDriverOptions getOptions() {
            FirefoxProfile profile = new FirefoxProfile();
            profile.setPreference("intl.accept_languages", Config.getValue("locale"));
            profile.setPreference("framework.browser.download.folderList", 2);
            profile.setPreference("browser.download.useDownloadDir", true);
            profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/x-debian-package");
            profile.setPreference("pdfjs.disabled", true);
            FirefoxOptions options = new FirefoxOptions();
            options.setProfile(profile);
            options.addArguments("--private");
            return options;
        }
    };

    public abstract AbstractDriverOptions getOptions();
}
