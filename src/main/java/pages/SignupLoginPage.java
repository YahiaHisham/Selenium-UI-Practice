package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SignupLoginPage extends PageBase {
    public static final By loginEmailField = By.xpath("//input[@data-qa='login-email']");
    public static final By loginPasswordField = By.xpath("//input[@data-qa='login-password']");
    public static final By loginButton = By.xpath("//button[@data-qa='login-button']");
    public static final By invalidCredentialsErrorMessage = By.xpath("//p[@style='color: red;']");
    private static final By signupLoginButton = By.xpath("//a[text()=' Signup / Login']");
    private static final By signUpNameField = By.xpath("//input[@data-qa='signup-name']");
    private static final By signUpEmailField = By.xpath("//input[@data-qa='signup-email']");
    private static final By signUpButton = By.xpath("//button[@data-qa='signup-button']");


    public SignupLoginPage(WebDriver driver) {
        super(driver);
    }

    public SignupLoginPage setSignupEmailE2E(String email) {
        setElementText(signUpEmailField, email);
        return this;
    }

    public SignupLoginPage setSignupName(String name) {
        setElementText(signUpNameField, name);
        return this;
    }

    public SignupLoginPage setSignupNameE2E(String name) {
        setElementText(signUpNameField, name);
        return this;
    }

    public SignupLoginPage setSignupEmail(String email) {
        setElementText(signUpEmailField, email);
        return this;
    }

    public SignupLoginPage setExistingSignupEmail(String email) {
        setElementText(signUpEmailField, email);
        return this;
    }

    public SignupLoginPage clickOnSignupButton() {
        clickOnElement(signUpButton);
        return this;
    }

    public SignupLoginPage setLoginMail(String email) {
        setElementText(loginEmailField, email);
        return this;
    }

    public SignupLoginPage setInvalidLoginMail(String email) {
        setElementText(loginEmailField, email);
        return this;
    }

    public SignupLoginPage setLoginPassword(String password) {
        setElementText(loginPasswordField, password);
        return this;
    }

    public SignupLoginPage clickOnLoginButton() {
        clickOnElement(loginButton);
        return this;
    }

    public void assertThatInvalidLoginCredentialsErrorMsgAppears(String message) {
        Assert.assertEquals(driver.findElement(invalidCredentialsErrorMessage).getText(), message);
    }

    public void assertThatEmailAlreadyExistErrorMsgAppears(String message) {
        Assert.assertEquals(driver.findElement(invalidCredentialsErrorMessage).getText(), message);
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
