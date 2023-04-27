package pages;

import data.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupLoginPage extends PageBase {
    private static final By signupLoginButton = By.xpath("//a[text()=' Signup / Login']");
    private static final By signUpNameField = By.xpath("//input[@data-qa='signup-name']");
    private static final By signUpEmailField = By.xpath("//input[@data-qa='signup-email']");
    private static final By signUpBtn = By.xpath("//button[@data-qa='signup-button']");

    public SignupLoginPage(WebDriver driver) {
        super(driver);
    }

    public SignupLoginPage setSignupName() {
        String name = generateRandomText(8) + " " +generateRandomText(5);
        setElementText(signUpNameField, name);
        Helper.updateValueInPropertiesFile("name", name, "UserRegistrationData");
        return this;
    }

    public SignupLoginPage setSignupEmail() {
        String email = generateRandomText(8) + "@m.com";
        setElementText(signUpEmailField, email);
        Helper.updateValueInPropertiesFile("email", email, "UserRegistrationData");
        return this;
    }

    public SignupLoginPage clickOnSignupButton() {
        clickOnElement(signUpBtn);
        return this;
    }

    public SignupPage signupPage() {
        return new SignupPage(driver);
    }

    public SignupLoginPage clickOnSignupLoginButton() {
        clickOnElement(signupLoginButton);
        return this;
    }
}
