package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class PageBase {
    WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnElement(By elementLocator) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(elementLocator));
        scrollToElementView(elementLocator);
        driver.findElement(elementLocator).click();
    }

    public void scrollToElementView(By elementLocator) {
        WebElement element = driver.findElement(elementLocator);
//        to scroll until the element view is in the middle of the screen
        int elementPositionY = element.getLocation().getY();
        int viewportHeight = ((Long) ((JavascriptExecutor) driver).executeScript("return window.innerHeight || document.documentElement.clientHeight || document.body.clientHeight;")).intValue();

        int scrollPositionY = elementPositionY - (viewportHeight / 2);
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, arguments[0]);", scrollPositionY);
    }

    public void setElementText(By elementLocator, String text) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(elementLocator));
        scrollToElementView(elementLocator);
        driver.findElement(elementLocator).sendKeys(text);
    }

    public static String generateRandomText(int length) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            char c = alphabet.charAt(random.nextInt(alphabet.length()));
            sb.append(c);
        }
        return sb.toString();
    }
    public static String generateRandomNumbers(int length) {
        String digits = "0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            char c = digits.charAt(random.nextInt(digits.length()));
            sb.append(c);
        }
        return sb.toString();
    }
}
