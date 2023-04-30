import org.testng.annotations.Test;
import pages.SignupLoginPage;

import java.time.Duration;

public class UserRegistrationTest extends TestBase{
    @Test
    public void verifyThatUserCanRegisterSuccessfully() {
        new SignupLoginPage(driver)
                .clickOnSignupLoginButton()
                .setSignupName()
                .setSignupEmailE2E()
                .clickOnSignupButton()
                .signupPage()
                .setTitleToMr()
                .setPassword()
                .setDayOfBirth()
                .setMonthOfBirth()
                .setYearOfBirth()
                .setFirstName()
                .setLastName()
                .setAddress()
                .setCountry()
                .setState()
                .setCity()
                .setZipCode()
                .setMobileNumber()
                .clickOnSignUpButton()
                .assertThatAccountCreatedSuccessfully()
                .clickOnContinueButton()
                .clickOnCloseAd()
                .homePage()
                .assertThatUserIsLoggedInSuccessfully();
    }
    @Test
    public void verifyThatUserCanRegisterSuccessfullyE2E() {
        new SignupLoginPage(driver)
                .clickOnSignupLoginButton()
                .setSignupNameE2E()
                .setSignupEmailE2E()
                .clickOnSignupButton()
                .signupPage()
                .setTitleToMr()
                .setPassword()
                .setDayOfBirth()
                .setMonthOfBirth()
                .setYearOfBirth()
                .setFirstName()
                .setLastName()
                .setAddress()
                .setCountry()
                .setState()
                .setCity()
                .setZipCode()
                .setMobileNumber()
                .clickOnSignUpButton()
                .assertThatAccountCreatedSuccessfully()
                .clickOnContinueButton()
                .clickOnCloseAd()
                .homePage()
                .assertThatUserIsLoggedInSuccessfully()
                .clickOnDeleteButton()
                .assertThatAccountDeletedSuccessfully();
    }
}
