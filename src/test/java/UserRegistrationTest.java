import org.testng.annotations.Test;
import pages.SignupLoginPage;

import java.time.Duration;

public class UserRegistrationTest extends TestBase{
    @Test
    public void verifyThatUserCanRegisterSuccessfully() {
        new SignupLoginPage(driver)
                .clickOnSignupLoginButton();
        new SignupLoginPage(driver)
                .setSignupName()
                .setSignupEmail()
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
                .clickOnDeleteButton()
                .assertThatAccountDeletedSuccessfully();
    }
}
