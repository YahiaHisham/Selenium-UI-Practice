import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignupLoginPage;

public class UserLoginTest extends TestBase {
    @Test(dependsOnMethods = {"UserRegistrationTest.verifyThatUserCanRegisterSuccessfully"})
    public void loginWithValidCredentials() {
        new SignupLoginPage(driver)
                .clickOnSignupLoginButton()
                .setLoginMail()
                .setLoginPassword()
                .clickOnLoginButton();
        new HomePage(driver)
                .assertThatUserIsLoggedInSuccessfully();
    }

}
