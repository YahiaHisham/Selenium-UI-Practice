package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageBase {
    WebDriver driver;
    private final By signupLoginButton = By.xpath("//a[text()=' Signup / Login']");

    public PageBase(WebDriver driver) {
        this.driver = driver;
    }

    public PageBase clickOnElement(By elementLocator) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(elementLocator));
        driver.findElement(elementLocator).click();
        return this;
    }

    public PageBase setElementText(By elementLocator, String text) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(elementLocator));
        driver.findElement(elementLocator).sendKeys(text);
        return this;
    }

    public PageBase clickOnSignupLoginButton() {
        clickOnElement(signupLoginButton);
        return this;
    }
}
