package pom;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class UniProdDownloadPanel {

    WebDriver driver;

    public UniProdDownloadPanel(WebDriver driver) {
        this.driver = driver;
    }

    By downloadButton = By.cssSelector("#download-button");
    By format = By.cssSelector("#format");
    By goButton = By.cssSelector("#menu-go");


    public UniProdDownloadPanel download(){
        driver.findElement(downloadButton).click();


        Select sel = new Select(driver.findElement(format));
        sel.selectByValue("tab");

        driver.findElement(goButton).click();
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(60));

        return this;
    }
}
