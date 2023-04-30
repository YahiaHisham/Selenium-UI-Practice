package pages;

import data.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage extends PageBase {
    private static final By deleteAccountBtn = By.xpath("//a[text()=' Delete Account']");
    private static final By accountDeletionSuccessMsg = By.xpath("//h2[@data-qa='account-deleted']");
    private static final By loggedUserName = By.xpath("//a[.//i[@class='fa fa-user']]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage clickOnDeleteButton() {
        clickOnElement(deleteAccountBtn);
        return this;
    }

    public void assertThatAccountDeletedSuccessfully() {
        Assert.assertEquals(driver.findElement(accountDeletionSuccessMsg).getText(), "ACCOUNT DELETED!");
    }

    public HomePage assertThatUserIsLoggedInSuccessfully() {
        Assert.assertEquals(driver.findElement(loggedUserName).getText(),"Logged in as " + Helper.getValueFromPropertiesFile("name", "UserRegistrationData"));
        return this;
    }
}
