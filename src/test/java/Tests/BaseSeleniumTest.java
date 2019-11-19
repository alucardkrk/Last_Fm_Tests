package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;

public abstract class BaseSeleniumTest {
    protected WebDriver driver;

    @BeforeMethod
    protected void setup() {
        File chromeDriverExe = new File("src\\test\\resources\\drivers\\chromedriver.exe");
        ChromeDriverService chromeDriverService = new ChromeDriverService.Builder()
                .usingDriverExecutable(chromeDriverExe)
                .usingAnyFreePort()
                .build();
        driver = new ChromeDriver(chromeDriverService);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

    }
    @AfterMethod
    protected void end(){
        driver.quit();

    }
}