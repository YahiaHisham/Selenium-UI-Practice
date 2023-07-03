package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ContactUsPage extends PageBase {
    private static final By nameField = By.name("name");
    private static final By emailField = By.name("email");
    private static final By subjectField = By.name("subject");
    private static final By messageField = By.name("message");
    private static final By uploadBtn = By.name("upload_file");
    private static final By submitBtn = By.name("submit");
    private static final By successMsg = By.cssSelector("div.status");

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    public ContactUsPage assertThatContactUsPageIsDisplayed() {
        Assert.assertEquals(driver.getTitle(), "Automation Exercise - Contact Us");
        return this;
    }

    public ContactUsPage setNameField() {
        setElementText(nameField, generateRandomText(4) + generateRandomText(4));
        return this;
    }

    public ContactUsPage setEmailField() {
        setElementText(emailField, generateRandomText(8) + "@mail.com");
        return this;
    }

    public ContactUsPage setSubjectField() {
        setElementText(subjectField, generateRandomText(4) + generateRandomText(4));
        return this;
    }

    public ContactUsPage setMessageField() {
        StringBuilder msg = new StringBuilder();
        for (int i = 0; i <= 5; i++) {
            String randomText = generateRandomText(8) + " ";
            msg.append(randomText);
        }
        setElementText(messageField, msg.toString());
        return this;
    }

    public ContactUsPage uploadImage() {
        driver.findElement(uploadBtn).sendKeys(System.getProperty("user.dir") + "/src/main/java/data/images/" + "image1.jpg");
        return this;
    }

    public ContactUsPage clickOnSubmitButton() {
        clickOnElement(submitBtn);
        return this;
    }

    public ContactUsPage clickOnOkInsideAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
        driver.switchTo().defaultContent();
        return this;
    }

    public void assertThatUsersMessageSubmittedSuccessfully() {
        Assert.assertEquals(driver.findElement(successMsg).getText(), "Success! Your details have been submitted successfully.");
    }
}
