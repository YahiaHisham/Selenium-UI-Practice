package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartPage extends PageBase{
    private static final By emailSubscriptionField = By.id("susbscribe_email");
    private static final By subscribeButton = By.id("subscribe");
    private static final By successSubscriptionAlert = By.cssSelector("alert-success");
    public CartPage(WebDriver driver) {
        super(driver);
    }
    public CartPage enterSubscriptionEmail() {
        setElementText(emailSubscriptionField, generateRandomText(6) + "@mail.com");
        return this;
    }

    public CartPage clickOnSubscribeButton() {
        clickOnElement(subscribeButton);
        return this;
    }
    public void assertThatUserIsSubscribedSuccessfully() {
        Assert.assertEquals(driver.findElement(successSubscriptionAlert).getText(), "You have been successfully subscribed");
    }
}
