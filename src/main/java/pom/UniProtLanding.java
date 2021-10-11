package pom;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class UniProtLanding {

    WebDriver driver;

    public UniProtLanding(WebDriver driver) {
        this.driver = driver;
    }

    By privacyPanel = By.cssSelector("#privacy-panel-accept");
    By mappingPanel = By.cssSelector("#upload-lists-nav");

    public UniProtLanding closePrivacy(){
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(2));
        driver.findElement(privacyPanel).click();

        return this;
    }

    public UniProtLanding selectMapping(){
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(2));
        driver.findElement(mappingPanel).click();
        return this;
    }
}
