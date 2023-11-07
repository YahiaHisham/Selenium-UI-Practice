package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage extends PageBase {

    private static final By deleteAccountButton = By.xpath("//a[text()=' Delete Account']");
    private static final By accountDeletionSuccessMessage = By.xpath("//h2[@data-qa='account-deleted']");
    private static final By loggedUserNameLabel = By.xpath("//a[.//i[@class='fa fa-user']]");
    private static final By contactUsButton = By.cssSelector("i.fa-envelope");
    private static final By testCasesButton = By.xpath("//a[contains(text(),'Test Cases')]");
    private static final By productsButton = By.cssSelector("i.card_travel");
    private static final By cartButton = By.cssSelector("fa-shopping-cart");
    private static final By logoutButton = By.cssSelector("i.fa-lock");
    private static final By emailSubscriptionField = By.id("susbscribe_email");
    private static final By subscribeButton = By.id("subscribe");
    private static final By successSubscriptionAlert = By.cssSelector("alert-success");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage clickOnProductsButton() {
        clickOnElement(productsButton);
        return this;
    }

    public HomePage clickOnDeleteButton() {
        clickOnElement(deleteAccountButton);
        return this;
    }

    public HomePage clickOnLogoutButton() {
        clickOnElement(logoutButton);
        return this;
    }

    public HomePage clickOnContactUsButton() {
        clickOnElement(contactUsButton);
        return this;
    }

    public HomePage clickOnTestCasesButton() {
        clickOnElement(testCasesButton);
        return this;
    }

    public void clickOnCartButton() {
        clickOnElement(cartButton);
    }

    public HomePage enterSubscriptionEmail(String email) {
        setElementText(emailSubscriptionField, email);
        return this;
    }

    public HomePage clickOnSubscribeButton() {
        clickOnElement(subscribeButton);
        return this;
    }

    public void assertThatAccountDeletedSuccessfully(String message) {
        Assert.assertEquals(driver.findElement(accountDeletionSuccessMessage).getText(), message);
    }

    public HomePage assertThatUserIsLoggedInSuccessfully(String loggedUserName) {
        Assert.assertEquals(driver.findElement(loggedUserNameLabel).getText(), "Logged in as " + loggedUserName);
        return this;
    }

    public void assertThatUserIsLoggedOutSuccessfully(String loginPageLabel) {
        Assert.assertEquals(driver.getTitle(), loginPageLabel);
    }

    public void assertThatUserIsSubscribedSuccessfully(String message) {
        Assert.assertEquals(driver.findElement(successSubscriptionAlert).getText(), message);
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
