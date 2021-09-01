package Service;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.HashMap;

public class DriverService {

    public WebDriver initDriver(String downloadFilepath){
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("download.default_directory", downloadFilepath);
        chromePrefs.put("profile.default_content_settings.popups", 0);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        //options.addArguments("--headless", "--window-size=1536,722");
        options.addArguments("start-maximized");
        options.addArguments("--silent");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }

    public void goTo(WebDriver driver){
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(200));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
        driver.get("https://www.uniprot.org/");
    }
}
