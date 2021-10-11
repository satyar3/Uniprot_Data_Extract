package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UniProtResults {

    WebDriver driver;

    public UniProtResults(WebDriver driver) {
        this.driver = driver;
    }

    By columns = By.cssSelector("#customize-columns-button");

    public UniProtResults clickOnColumns(){
        driver.findElement(columns).click();
        return this;
    }
}
