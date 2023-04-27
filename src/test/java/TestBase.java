import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.lang.reflect.Method;
import java.time.Duration;

public class TestBase {
    public static WebDriver driver;
    @BeforeTest
    public void startBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    public String getTestClassName()
    {
        return this.getClass().getSimpleName();

    }

    public String getMethodName(Method method) {
        System.out.println("Test name: " + method.getName());
        return method.getName();
    }
}
