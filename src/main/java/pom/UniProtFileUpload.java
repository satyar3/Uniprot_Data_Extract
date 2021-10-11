package pom;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.Set;

public class UniProtFileUpload {

    WebDriver driver;

    public UniProtFileUpload(WebDriver driver) {
        this.driver = driver;
    }

    By uploadFile = By.cssSelector("#uploadfile");
    By submitButton = By.cssSelector("#upload-submit");

    public UniProtFileUpload uploadFile(String inputPath, Set<String> fileListToBeUploaded){

        driver.findElement(uploadFile).sendKeys(inputPath+"/"+fileListToBeUploaded.stream().findFirst().get());

        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(3));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", driver.findElement(submitButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", driver.findElement(submitButton));

        return this;
    }

    public UniProtFileUpload uploadFile(String inputPath, String fileListToBeUploaded){

        driver.findElement(By.cssSelector("#uploadfile")).sendKeys(inputPath+"/" + fileListToBeUploaded);

        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(3));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView", driver.findElement(By.cssSelector("#upload-submit")));
        driver.findElement(By.cssSelector("#upload-submit")).click();

        return this;
    }
}
