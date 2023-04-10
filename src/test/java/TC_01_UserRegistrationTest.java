import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.SignupLoginPage;

import java.time.Duration;

public class TC_01_UserRegistrationTest {
    public static WebDriver driver;

    @Test
    public void verifyThatUserCanRegisterSuccessfully() {
        new SignupLoginPage(driver)
                .clickOnSignupLoginButton();
        new SignupLoginPage(driver)
                .setSignupName()
                .setSignupEmail()
                .clickOnSignupButton();
    }

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
}
