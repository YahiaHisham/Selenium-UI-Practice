package testClasses;

import org.testng.annotations.Test;
import pages.SignupLoginPage;
import utilities.JsonReader;

import static utilities.Generators.generateRandomNumbers;
import static utilities.Generators.generateRandomText;

public class UserRegistrationTest extends TestBase {
    @Test
    public void verifyThatUserCanRegisterSuccessfully() {
        String name = generateRandomText(8) + " " + generateRandomText(5);
        String email = generateRandomText(8) + "@email.com";
        String password = generateRandomText(5) + generateRandomNumbers(4);
        JsonReader.updateValueInJsonFile("name", name, "RegisteredUserData");
        JsonReader.updateValueInJsonFile("email", email, "RegisteredUserData");
        JsonReader.updateValueInJsonFile("password", password, "RegisteredUserData");
        new SignupLoginPage(driver)
                .clickOnSignupLoginButton()
                .setSignupName(name)
                .setSignupEmail(email)
                .clickOnSignupButton()
                .signupPage()
                .setTitleToMr()
                .setPassword(password)
                .setDayOfBirth(generateRandomNumbers(1))
                .setMonthOfBirth(generateRandomNumbers(1))
                .setYearOfBirth(generateRandomNumbers(1))
                .setFirstName(generateRandomText(6))
                .setLastName(generateRandomText(6))
                .setAddress(generateRandomText(10) + " " + generateRandomNumbers(4))
                .setCountry("Canada")
                .setState(generateRandomText(5))
                .setCity(generateRandomText(5))
                .setZipCode(generateRandomNumbers(6))
                .setMobileNumber("01" + generateRandomNumbers(9))
                .clickOnSignUpButton()
                .assertThatAccountCreatedSuccessfully(JsonReader.getValueFromJsonFile("accountCreatedPageLabel", "ValidationMessages"))
                .clickOnContinueButton()
                .clickOnCloseAd()
                .clickOnContinueButton()
                .homePage()
                .assertThatUserIsLoggedInSuccessfully(JsonReader.getValueFromJsonFile("nameE2E", "RegisteredUserData"));
    }

    @Test
    public void verifyThatUserCanRegisterSuccessfullyE2E() {
        String name = generateRandomText(8) + " " + generateRandomText(5);
        String email = generateRandomText(8) + "@email.com";
        String password = generateRandomText(5) + generateRandomNumbers(4);
        JsonReader.updateValueInJsonFile("nameE2E", name, "RegisteredUserData");
        JsonReader.updateValueInJsonFile("emailE2E", email, "RegisteredUserData");
        JsonReader.updateValueInJsonFile("password", password, "RegisteredUserData");
        new SignupLoginPage(driver)
                .clickOnSignupLoginButton()
                .setSignupNameE2E(name)
                .setSignupEmailE2E(email)
                .clickOnSignupButton()
                .signupPage()
                .setTitleToMr()
                .setPassword(password)
                .setDayOfBirth(generateRandomNumbers(1))
                .setMonthOfBirth(generateRandomNumbers(1))
                .setYearOfBirth(generateRandomNumbers(1))
                .setFirstName(generateRandomText(6))
                .setLastName(generateRandomText(6))
                .setAddress(generateRandomText(10) + " " + generateRandomNumbers(4))
                .setCountry("Canada")
                .setState(generateRandomText(5))
                .setCity(generateRandomText(5))
                .setZipCode(generateRandomNumbers(6))
                .setMobileNumber("01" + generateRandomNumbers(9))
                .clickOnSignUpButton()
                .assertThatAccountCreatedSuccessfully(JsonReader.getValueFromJsonFile("accountCreatedPageLabel", "ValidationMessages"))
                .clickOnContinueButton()
                .homePage()
                .assertThatUserIsLoggedInSuccessfully(JsonReader.getValueFromJsonFile("nameE2E", "RegisteredUserData"))
                .clickOnDeleteButton()
                .assertThatAccountDeletedSuccessfully(JsonReader.getValueFromJsonFile("accountDeletedMessage", "ValidationMessages"));
    }

    @Test
    public void verifyThatUserCantRegisterUsingExistingMail() {
        new SignupLoginPage(driver)
                .clickOnSignupLoginButton()
                .setSignupName(generateRandomText(8) + " " + generateRandomText(5))
                .setExistingSignupEmail(JsonReader.getValueFromJsonFile("email", "RegisteredUserData"))
                .clickOnSignupButton()
                .assertThatEmailAlreadyExistErrorMsgAppears(JsonReader.getValueFromJsonFile("emailAlreadyRegisteredMessage", "ValidationMessages"));
    }
}
