package pages;

import data.JsonReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage extends PageBase {
    //TODO replace Btn with Button in locators names
    private static final By deleteAccountButton = By.xpath("//a[text()=' Delete Account']");
    private static final By accountDeletionSuccessMsg = By.xpath("//h2[@data-qa='account-deleted']");
    private static final By loggedUserName = By.xpath("//a[.//i[@class='fa fa-user']]");
    private static final By contactUsBtn = By.cssSelector("i.fa-envelope");
    private static final By testCasesBtn = By.xpath("//a[contains(text(),'Test Cases')]");
    private static final By productsBtn = By.cssSelector("i.card_travel");
    private static final By cartBtn = By.cssSelector("fa-shopping-cart");
    private static final By logoutBtn = By.cssSelector("i.fa-lock");
    private static final By emailSubscriptionField = By.id("susbscribe_email");
    private static final By subscribeButton = By.id("subscribe");
    private static final By successSubscriptionAlert = By.cssSelector("alert-success");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage clickOnProductsButton() {
        clickOnElement(productsBtn);
        return this;
    }

    public HomePage clickOnDeleteButton() {
        clickOnElement(deleteAccountButton);
        return this;
    }

    public HomePage clickOnLogoutButton() {
        clickOnElement(logoutBtn);
        return this;
    }

    public HomePage clickOnContactUsButton() {
        clickOnElement(contactUsBtn);
        return this;
    }

    public HomePage clickOnTestCasesButton() {
        clickOnElement(testCasesBtn);
        return this;
    }
    public HomePage clickOnCartButton() {
        clickOnElement(cartBtn);
        return this;
    }

    public HomePage enterSubscriptionEmail() {
        setElementText(emailSubscriptionField, generateRandomText(6) + "@mail.com");
        return this;
    }

    public HomePage clickOnSubscribeButton() {
        clickOnElement(subscribeButton);
        return this;
    }

    public void assertThatAccountDeletedSuccessfully() {
        Assert.assertEquals(driver.findElement(accountDeletionSuccessMsg).getText(), "ACCOUNT DELETED!");
    }

    public HomePage assertThatUserIsLoggedInSuccessfully() {
        Assert.assertEquals(driver.findElement(loggedUserName).getText(), "Logged in as " + JsonReader.getValueFromJsonFile("nameE2E", "RegisteredUserData"));
        return this;
    }

    public void assertThatUserIsLoggedOutSuccessfully() {
        Assert.assertEquals(driver.getTitle(), "Automation Exercise - Signup / Login");
    }

    public void assertThatUserIsSubscribedSuccessfully() {
        Assert.assertEquals(driver.findElement(successSubscriptionAlert).getText(), "You have been successfully subscribed");
    }

    public ContactUsPage contactUsPage() {
        return new ContactUsPage(driver);
    }

    public TestCasesPage testCasesPage() {
        return new TestCasesPage(driver);
    }

    public ProductsListingPage productsListingPage() {
        return new ProductsListingPage(driver);
    }
}
