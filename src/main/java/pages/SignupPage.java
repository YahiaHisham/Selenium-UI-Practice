package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SignupPage extends PageBase {
    private static final By mrTitleRadioBtn = By.id("id_gender1");
    private static final By passwordField = By.id("password");
    private static final By dayOfBirthDropDown = By.id("days");
    private static final By monthOfBirthDropDown = By.id("months");
    private static final By yearOfBirthDropDown = By.id("years");
    private static final By firstNameField = By.id("first_name");
    private static final By lastNameField = By.id("last_name");
    private static final By addressField = By.id("address1");
    private static final By countryDropDown = By.id("country");
    private static final By stateField = By.id("state");
    private static final By cityField = By.id("city");
    private static final By zipCodeField = By.id("zipcode");
    private static final By mobileNumberField = By.id("mobile_number");
    private static final By createAccountBtn = By.xpath("//button[text()='Create Account']");
    private static final By accountCreationStatus = By.xpath("//h2[@data-qa='account-created']");

    public SignupPage(WebDriver driver) {
        super(driver);
    }

    public SignupPage setTitleToMr() {
        clickOnElement(mrTitleRadioBtn);
        return this;
    }

    public SignupPage setPassword() {
        setElementText(passwordField, "123456789@Aa");
        return this;
    }

    public SignupPage setDayOfBirth() {
        // Create a Select object
        Select dropdown = new Select(driver.findElement(dayOfBirthDropDown));
        // Select an option by its index
        dropdown.selectByIndex(1);
        return this;
    }

    public SignupPage setMonthOfBirth() {
        // Create a Select object
        Select dropdown = new Select(driver.findElement(monthOfBirthDropDown));
        // Select an option by its index
        dropdown.selectByIndex(1);
        return this;
    }

    public SignupPage setYearOfBirth() {
        // Create a Select object
        Select dropdown = new Select(driver.findElement(yearOfBirthDropDown));
        // Select an option by its index
        dropdown.selectByIndex(1);
        return this;
    }

    public SignupPage setFirstName() {
        setElementText(firstNameField, "Yahia");
        return this;
    }

    public SignupPage setLastName() {
        setElementText(lastNameField, "Hisham");
        return this;
    }

    public SignupPage setAddress() {
        setElementText(addressField, "Address @ city 1234");
        return this;
    }

    public SignupPage setCountry() {
        // Create a Select object
        Select dropdown = new Select(driver.findElement(countryDropDown));
        // Select an option by its index
        dropdown.selectByIndex(1);
        return this;
    }

    public SignupPage setState() {
        setElementText(stateField, "State 2");
        return this;
    }

    public SignupPage setCity() {
        setElementText(cityField, "Cairo");
        return this;
    }

    public SignupPage setZipCode() {
        setElementText(zipCodeField, "123456");
        return this;
    }

    public SignupPage setMobileNumber() {
        setElementText(mobileNumberField, "01111556666");
        return this;
    }

    public SignupPage clickOnSignUpButton() {
        clickOnElement(createAccountBtn);
        return this;
    }

    public void assertThatAccountCreatedSuccessfully() {
        Assert.assertEquals(driver.findElement(accountCreationStatus).getText(), "ACCOUNT CREATED!");
    }
}
