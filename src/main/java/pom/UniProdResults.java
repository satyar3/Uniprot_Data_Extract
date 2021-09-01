package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UniProdResults {

    WebDriver driver;

    public UniProdResults(WebDriver driver) {
        this.driver = driver;
    }

    By columns = By.cssSelector("#customize-columns-button");

    public UniProdResults clickOnColumns(){
        driver.findElement(columns).click();
        return this;
    }
}
