package testClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;

public class TestBase {
    public WebDriver driver;

    /**
     * this method is to start browser session and adds AdBlocker Chrome extension
     * before redirecting to the webpage and then
     * closes the new tab that it's automatically opened from
     * AdBlock extension and continues the execution flow normally
     */
    @BeforeMethod
    public void startBrowser() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("./src/test/resources/chromeExtensions/AdBlock.crx"));
        driver = new ChromeDriver(options);
        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(tabs.get(1));
        Thread.sleep(9000);
//        driver.close();
        driver.switchTo().window(tabs.get(0));
    }

    @AfterMethod
    public void tearDown() {
//        driver.quit();
    }
}
