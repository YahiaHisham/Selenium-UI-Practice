package pages;

import data.JsonReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SignupLoginPage extends PageBase {
    private static final By signupLoginButton = By.xpath("//a[text()=' Signup / Login']");
    private static final By signUpNameField = By.xpath("//input[@data-qa='signup-name']");
    private static final By signUpEmailField = By.xpath("//input[@data-qa='signup-email']");
    private static final By signUpBtn = By.xpath("//button[@data-qa='signup-button']");
    public static final By loginEmailField = By.xpath("//input[@data-qa='login-email']");
    public static final By loginPasswordField = By.xpath("//input[@data-qa='login-password']");
    public static final By loginBtn = By.xpath("//button[@data-qa='login-button']");
    public static final By invalidCredentialsErrorMsg = By.xpath("//p[@style='color: red;']");

    public SignupLoginPage(WebDriver driver) {
        super(driver);
    }

    public SignupLoginPage setSignupName() {
        String name = generateRandomText(8) + " " +generateRandomText(5);
        setElementText(signUpNameField, name);
        JsonReader.updateValueInJsonFile("name", name, "RegisteredUserData");
        return this;
    }
    public SignupLoginPage setSignupNameE2E() {
        String name = generateRandomText(8) + " " +generateRandomText(5);
        setElementText(signUpNameField, name);
        JsonReader.updateValueInJsonFile("nameE2E", name, "RegisteredUserData");
        return this;
    }

    public SignupLoginPage setSignupEmail() {
        String email = generateRandomText(8) + "@email.com";
        setElementText(signUpEmailField, email);
        JsonReader.updateValueInJsonFile("email", email, "RegisteredUserData");
        return this;
    }
    public SignupLoginPage setExistingSignupEmail() {
        setElementText(signUpEmailField, JsonReader.getValueFromJsonFile("email", "RegisteredUserData"));
        return this;
    }
    public SignupLoginPage setSignupEmailE2E() {
        String email = generateRandomText(8) + "@email.com";
        setElementText(signUpEmailField, email);
        JsonReader.updateValueInJsonFile("emailE2E", email, "RegisteredUserData");
        return this;
    }

    public SignupLoginPage clickOnSignupButton() {
        clickOnElement(signUpBtn);
        return this;
    }
    public SignupLoginPage setLoginMail() {
        setElementText(loginEmailField, JsonReader.getValueFromJsonFile("email","RegisteredUserData"));
        return this;
    }
    public SignupLoginPage setInvalidLoginMail() {
        setElementText(loginEmailField, generateRandomText(8) + "@mail.com");
        return this;
    }

    public SignupLoginPage setLoginPassword() {
        setElementText(loginPasswordField, JsonReader.getValueFromJsonFile("password","RegisteredUserData"));
        return this;
    }
    public SignupLoginPage clickOnLoginButton() {
        clickOnElement(loginBtn);
        return this;
    }
    public void  assertThatInvalidLoginCredentialsErrorMsgAppears() {
        Assert.assertEquals(driver.findElement(invalidCredentialsErrorMsg).getText(),"Your email or password is incorrect!");
    }
    public void  assertThatEmailAlreadyExistErrorMsgAppears() {
        Assert.assertEquals(driver.findElement(invalidCredentialsErrorMsg).getText(),"Email Address already exist!");
    }

    public SignupPage signupPage() {
        return new SignupPage(driver);
    }

    public SignupLoginPage clickOnSignupLoginButton() {
        clickOnElement(signupLoginButton);
        return this;
    }
    public HomePage homePage() {
        return new HomePage(driver);
    }
}
