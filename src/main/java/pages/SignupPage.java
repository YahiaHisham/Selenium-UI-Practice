package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SignupPage extends PageBase {
    private static final By mrTitleRadioButton = By.id("id_gender1");
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
    private static final By createAccountButton = By.xpath("//button[text()='Create Account']");
    private static final By continueButton = By.xpath("//a[@data-qa='continue-button']");

    public SignupPage(WebDriver driver) {
        super(driver);
    }

    public SignupPage setTitleToMr() {
        clickOnElement(mrTitleRadioButton);
        return this;
    }

    public SignupPage setPassword(String password) {
        setElementText(passwordField, password);
        return this;
    }

    public SignupPage setDayOfBirth(String day) {
        // Create a Select object
        Select dropdown = new Select(driver.findElement(dayOfBirthDropDown));
        // Select an option by its index
        dropdown.selectByIndex(Integer.parseInt(day));
        return this;
    }

    public SignupPage setMonthOfBirth(String month) {
        // Create a Select object
        Select dropdown = new Select(driver.findElement(monthOfBirthDropDown));
        // Select an option by its index
        dropdown.selectByIndex(Integer.parseInt(month));
        return this;
    }

    public SignupPage setYearOfBirth(String year) {
        // Create a Select object
        Select dropdown = new Select(driver.findElement(yearOfBirthDropDown));
        // Select an option by its index
        dropdown.selectByIndex(Integer.parseInt(year));
        return this;
    }

    public SignupPage setFirstName(String name) {
        setElementText(firstNameField, name);
        return this;
    }

    public SignupPage setLastName(String name) {
        setElementText(lastNameField, name);
        return this;
    }

    public SignupPage setAddress(String address) {
        setElementText(addressField, address);
        return this;
    }

    public SignupPage setCountry(String country) {
        // Create a Select object
        Select dropdown = new Select(driver.findElement(countryDropDown));
        // Select an option by its value
        dropdown.selectByValue(country);
        return this;
    }

    public SignupPage setState(String state) {
        setElementText(stateField, state);
        return this;
    }

    public SignupPage setCity(String city) {
        setElementText(cityField, city);
        return this;
    }

    public SignupPage setZipCode(String zipCode) {
        setElementText(zipCodeField, zipCode);
        return this;
    }

    public SignupPage setMobileNumber(String mobileNumber) {
        setElementText(mobileNumberField, mobileNumber);
        return this;
    }

    public SignupPage clickOnSignUpButton() {
        clickOnElement(createAccountButton);
        return this;
    }

    public SignupPage assertThatAccountCreatedSuccessfully(String message) {
        Assert.assertEquals(driver.getTitle(), message);
        return this;
    }

    public SignupPage clickOnContinueButton() {
        clickOnElement(continueButton);
        return this;
    }

    public SignupPage clickOnCloseAd() {
/*
        I have tried to switch to the AD iFrame, but it sometimes fails because the add design and locators changes
        every run, so I decided to just avoid the AD by refreshing the page and commenting the code that switches to iFrame
        driver.switchTo().frame("ad_iframe");
        clickOnElement(closeAdButton);
        driver.switchTo().defaultContent();
*/
        driver.navigate().refresh();
        return this;
    }

    public HomePage homePage() {
        return new HomePage(driver);
    }
}
