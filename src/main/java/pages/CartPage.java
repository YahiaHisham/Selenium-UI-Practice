package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartPage extends PageBase {
    private static final By emailSubscriptionField = By.id("susbscribe_email");
    private static final By subscribeButton = By.id("subscribe");
    private static final By successSubscriptionAlert = By.cssSelector("alert-success");

    public CartPage(WebDriver driver) {
        super(driver);
    }


    public CartPage enterSubscriptionEmail(String email) {
        setElementText(emailSubscriptionField, email);
        return this;
    }

    public CartPage clickOnSubscribeButton() {
        clickOnElement(subscribeButton);
        return this;
    }

    public void assertThatUserIsSubscribedSuccessfully(String successSubscriptionMessage) {
        Assert.assertEquals(driver.findElement(successSubscriptionAlert).getText(), successSubscriptionMessage);
    }
}
