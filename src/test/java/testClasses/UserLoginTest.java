package testClasses;

import org.testng.annotations.Test;
import pages.SignupLoginPage;
import utilities.JsonReader;

import static utilities.Generators.generateRandomText;

public class UserLoginTest extends TestBase {
    @Test(dependsOnMethods = {"UserRegistrationTest.verifyThatUserCanRegisterSuccessfullyE2E"})
    public void verifyThatUserCanLoginWithValidCredentials() {
        new SignupLoginPage(driver)
                .clickOnSignupLoginButton()
                .setLoginMail(JsonReader.getValueFromJsonFile("email", "RegisteredUserData"))
                .setLoginPassword(JsonReader.getValueFromJsonFile("password", "RegisteredUserData"))
                .clickOnLoginButton()
                .homePage()
                .assertThatUserIsLoggedInSuccessfully(JsonReader.getValueFromJsonFile("nameE2E", "RegisteredUserData"));
    }

    @Test
    public void verifyThatUserCantLoginWithInvalidCredentials() {
        new SignupLoginPage(driver)
                .clickOnSignupLoginButton()
                .setInvalidLoginMail(generateRandomText(8) + "@mail.com")
                .setLoginPassword(JsonReader.getValueFromJsonFile("password", "RegisteredUserData"))
                .clickOnLoginButton()
                .assertThatInvalidLoginCredentialsErrorMsgAppears(JsonReader.getValueFromJsonFile("invalidCredentialsMessage","ValidationMessages"));
    }

    @Test(dependsOnMethods = {"UserRegistrationTest.verifyThatUserCanRegisterSuccessfully"})
    public void verifyThatUserCanLogoutSuccessfully() {
        new SignupLoginPage(driver)
                .clickOnSignupLoginButton()
                .setLoginMail(JsonReader.getValueFromJsonFile("email", "RegisteredUserData"))
                .setLoginPassword(JsonReader.getValueFromJsonFile("password", "RegisteredUserData"))
                .clickOnLoginButton()
                .homePage()
                .assertThatUserIsLoggedInSuccessfully(JsonReader.getValueFromJsonFile("nameE2E", "RegisteredUserData"))
                .clickOnLogoutButton()
                .assertThatUserIsLoggedOutSuccessfully(JsonReader.getValueFromJsonFile("loginPageLabel","ValidationMessages"));
    }
}
