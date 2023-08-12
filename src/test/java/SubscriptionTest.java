import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;

public class SubscriptionTest extends TestBase {
    @Test
    public void assertThatUserCanSubscribeForUpdatesFromHomePage() {
        new HomePage(driver)
                .enterSubscriptionEmail()
                .clickOnSubscribeButton()
                .assertThatUserIsSubscribedSuccessfully();
    }
    @Test
    public void assertThatUserCanSubscribeForUpdatesFromCartPage() {
        new HomePage(driver)
                .clickOnCartButton();
        new CartPage(driver)
                .enterSubscriptionEmail()
                .clickOnSubscribeButton()
                .assertThatUserIsSubscribedSuccessfully();
    }
}
