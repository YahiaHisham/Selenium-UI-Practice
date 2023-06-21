package pages;

import data.PropertiesFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupLoginPage extends PageBase {
    private static final By signupLoginButton = By.xpath("//a[text()=' Signup / Login']");
    private static final By signUpNameField = By.xpath("//input[@data-qa='signup-name']");
    private static final By signUpEmailField = By.xpath("//input[@data-qa='signup-email']");
    private static final By signUpBtn = By.xpath("//button[@data-qa='signup-button']");
    public static final By loginEmailField = By.xpath("//input[@data-qa='login-email']");
    public static final By loginPasswordField = By.xpath("//input[@data-qa='login-password']");
    public static final By loginBtn = By.xpath("//button[@data-qa='login-button']");

    public SignupLoginPage(WebDriver driver) {
        super(driver);
    }

    public SignupLoginPage setSignupName() {
        String name = generateRandomText(8) + " " +generateRandomText(5);
        setElementText(signUpNameField, name);
        PropertiesFileReader.updateValueInPropertiesFile("name", name, "UserRegistrationData");
        return this;
    }
    public SignupLoginPage setSignupNameE2E() {
        String name = generateRandomText(8) + " " +generateRandomText(5);
        setElementText(signUpNameField, name);
        PropertiesFileReader.updateValueInPropertiesFile("nameE2E", name, "UserRegistrationData");
        return this;
    }

    public SignupLoginPage setSignupEmail() {
        String email = generateRandomText(8) + "@m.com";
        setElementText(signUpEmailField, email);
        PropertiesFileReader.updateValueInPropertiesFile("emailE2E", email, "UserRegistrationData");
        return this;
    }
    public SignupLoginPage setSignupEmailE2E() {
        String email = generateRandomText(8) + "@m.com";
        setElementText(signUpEmailField, email);
        PropertiesFileReader.updateValueInPropertiesFile("email", email, "UserRegistrationData");
        return this;
    }

    public SignupLoginPage clickOnSignupButton() {
        clickOnElement(signUpBtn);
        return this;
    }
    public SignupLoginPage setLoginMail() {
        setElementText(loginEmailField, PropertiesFileReader.getValueFromPropertiesFile("email","UserRegistrationData"));
        return this;
    }
    public SignupLoginPage setLoginPassword() {
        setElementText(loginPasswordField, PropertiesFileReader.getValueFromPropertiesFile("password","UserRegistrationData"));
        return this;
    }
    public SignupLoginPage clickOnLoginButton() {
        clickOnElement(loginBtn);
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
