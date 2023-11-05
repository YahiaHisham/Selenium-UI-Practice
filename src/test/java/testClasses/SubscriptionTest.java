package testClasses;

import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import utilities.JsonReader;

import static utilities.Generators.generateRandomText;

public class SubscriptionTest extends TestBase {

    @Test
    public void assertThatUserCanSubscribeForUpdatesFromHomePage() {
        new HomePage(driver)
                .enterSubscriptionEmail(generateRandomText(6) + "@mail.com")
                .clickOnSubscribeButton()
                .assertThatUserIsSubscribedSuccessfully(JsonReader
                        .getValueFromJsonFile("successSubscriptionMessage", "ValidationMessages"));
    }

    @Test
    public void assertThatUserCanSubscribeForUpdatesFromCartPage() {
        new HomePage(driver)
                .clickOnCartButton();
        new CartPage(driver)
                .enterSubscriptionEmail(generateRandomText(6) + "@mail.com")
                .clickOnSubscribeButton()
                .assertThatUserIsSubscribedSuccessfully(JsonReader.getValueFromJsonFile("successSubscriptionMessage", "ValidationMessages"));
    }

}
