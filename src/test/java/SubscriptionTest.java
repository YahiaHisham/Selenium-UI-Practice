import org.testng.annotations.Test;
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

    }
}
