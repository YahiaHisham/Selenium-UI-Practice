package com.seleniumPractice.testClasses;

import com.seleniumPractice.testClasses.common.TestBase;
import com.seleniumPractice.utilities.Generators;
import com.seleniumPractice.utilities.JsonReader;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;

public class SubscriptionTest extends TestBase {

    @Test
    public void assertThatUserCanSubscribeForUpdatesFromHomePage() {
        new HomePage(driver)
                .enterSubscriptionEmail(Generators.generateRandomText(6) + "@mail.com")
                .clickOnSubscribeButton()
                .assertThatUserIsSubscribedSuccessfully(JsonReader
                        .getValueFromJsonFile("successSubscriptionMessage", "ValidationMessages"));
    }

    @Test
    public void assertThatUserCanSubscribeForUpdatesFromCartPage() {
        new HomePage(driver)
                .clickOnCartButton();
        new CartPage(driver)
                .enterSubscriptionEmail(Generators.generateRandomText(6) + "@mail.com")
                .clickOnSubscribeButton()
                .assertThatUserIsSubscribedSuccessfully(JsonReader.getValueFromJsonFile("successSubscriptionMessage", "ValidationMessages"));
    }

}
