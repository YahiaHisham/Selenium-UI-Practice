package pages;

import data.JsonReader;
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
    private static final By continueBtn = By.xpath("//a[@data-qa='continue-button']");

    public SignupPage(WebDriver driver) {
        super(driver);
    }

    public SignupPage setTitleToMr() {
        clickOnElement(mrTitleRadioBtn);
        return this;
    }

    public SignupPage setPassword() {
        String password = generateRandomText(5) + generateRandomNumbers(4);
        setElementText(passwordField, password);
        JsonReader.updateValueInJsonFile("password", password, "RegisteredUserData");
        return this;
    }

    public SignupPage setDayOfBirth() {
        // Create a Select object
        Select dropdown = new Select(driver.findElement(dayOfBirthDropDown));
        // Select an option by its index
        dropdown.selectByIndex(Integer.parseInt(generateRandomNumbers(1)));
        return this;
    }

    public SignupPage setMonthOfBirth() {
        // Create a Select object
        Select dropdown = new Select(driver.findElement(monthOfBirthDropDown));
        // Select an option by its index
        dropdown.selectByIndex(Integer.parseInt(generateRandomNumbers(1)));
        return this;
    }

    public SignupPage setYearOfBirth() {
        // Create a Select object
        Select dropdown = new Select(driver.findElement(yearOfBirthDropDown));
        // Select an option by its index
        dropdown.selectByIndex(Integer.parseInt(generateRandomNumbers(2)));
        return this;
    }

    public SignupPage setFirstName() {
        setElementText(firstNameField, generateRandomText(6));
        return this;
    }

    public SignupPage setLastName() {
        setElementText(lastNameField, generateRandomText(6));
        return this;
    }

    public SignupPage setAddress() {
        setElementText(addressField, generateRandomText(10) + generateRandomNumbers(4));
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
        setElementText(stateField, generateRandomText(5) + generateRandomNumbers(1));
        return this;
    }

    public SignupPage setCity() {
        setElementText(cityField, generateRandomText(8));
        return this;
    }

    public SignupPage setZipCode() {
        setElementText(zipCodeField, generateRandomNumbers(6));
        return this;
    }

    public SignupPage setMobileNumber() {
        setElementText(mobileNumberField, "01" + generateRandomNumbers(9));
        return this;
    }

    public SignupPage clickOnSignUpButton() {
        clickOnElement(createAccountBtn);
        return this;
    }

    public SignupPage assertThatAccountCreatedSuccessfully() {
        Assert.assertEquals(driver.getTitle(), "Automation Exercise - Account Created");
        return this;
    }

    public SignupPage clickOnContinueButton() {
        clickOnElement(continueBtn);
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
