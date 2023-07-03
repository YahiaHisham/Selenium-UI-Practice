import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignupLoginPage;

public class UserLoginTest extends TestBase {
    @Test(dependsOnMethods = {"UserRegistrationTest.verifyThatUserCanRegisterSuccessfully"})
    public void verifyThatUserCanLoginWithValidCredentials() {
        new SignupLoginPage(driver)
                .clickOnSignupLoginButton()
                .setLoginMail()
                .setLoginPassword()
                .clickOnLoginButton();
        new HomePage(driver)
                .assertThatUserIsLoggedInSuccessfully();
    }

    @Test
    public void verifyThatUserCantLoginWithInvalidCredentials() {
        new SignupLoginPage(driver)
                .clickOnSignupLoginButton()
                .setInvalidLoginMail()
                .setLoginPassword()
                .clickOnLoginButton()
                .assertThatInvalidLoginCredentialsErrorMsgAppears();
    }
    @Test(dependsOnMethods = {"UserRegistrationTest.verifyThatUserCanRegisterSuccessfully"})
    public void verifyThatUserCanLogoutSuccessfully() {
        new SignupLoginPage(driver)
                .clickOnSignupLoginButton()
                .setLoginMail()
                .setLoginPassword()
                .clickOnLoginButton();
        new HomePage(driver)
                .assertThatUserIsLoggedInSuccessfully()
                .clickOnLogoutButton()
                .assertThatUserIsLoggedOutSuccessfully();
    }
}
