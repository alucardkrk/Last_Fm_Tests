package Helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.time.LocalTime;

public class SeleniumHelper {
    private WebDriver driver;
    private FluentWait<WebDriver> wait;

    public SeleniumHelper(WebDriver driver) {
        this.driver = driver;
        wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(1000))
                .ignoring(NoSuchElementException.class);
    }
    public void waitForEelement(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void waitForEelement(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static void takeScreenshot (WebDriver driver) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShot = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File("src/main/resources/screenshots/" + LocalTime.now().getNano() + ".png");
        Files.copy(screenShot.toPath(),destinationFile.toPath());
    }

}