package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage extends PageBase {
    private static final By mrTitleRadioBtn = By.id("");
    private static final By mrsTitleRadioBtn = By.id("");
    private static final By passwordField = By.id("");
    private static final By dayOfBirthDropDown = By.id("");
    private static final By monthOfBirthDropDown = By.id("");
    private static final By yearOfBirthDropDown = By.id("");
    private static final By firstNameField = By.id("");
    private static final By lastNameField = By.id("");
    private static final By addressField = By.id("");
    private static final By countryDropDown = By.id("");
    private static final By stateField = By.id("");
    private static final By cityField = By.id("");
    private static final By zipCodeField = By.id("");
    private static final By mobileNumberField = By.id("");

    public SignupPage(WebDriver driver) {
        super(driver);
    }

    public SignupPage setTitleToMr() {
        clickOnElement(mrTitleRadioBtn);
        return this;
    }

    public SignupPage setPassword() {
        setElementText(passwordField,"");
        return this;
    }
    public SignupPage setFirstName() {
        setElementText(firstNameField,"");
        return this;
    }
    public SignupPage setLastName() {
        setElementText(lastNameField,"");
        return this;
    }
    public SignupPage setAddress() {
        setElementText(addressField,"");
        return this;
    }
    public SignupPage setState() {
        setElementText(stateField,"");
        return this;
    }
    public SignupPage setCity() {
        setElementText(cityField,"");
        return this;
    }
    public SignupPage setZipCode() {
        setElementText(zipCodeField,"");
        return this;
    }
    public SignupPage setMobileNumber() {
        setElementText(mobileNumberField,"");
        return this;
    }

}
