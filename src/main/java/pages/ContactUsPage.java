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
    private static final By uploadButton = By.name("upload_file");
    private static final By submitButton = By.name("submit");
    private static final By successMessageField = By.cssSelector("div.status");

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    public ContactUsPage assertThatContactUsPageIsDisplayed(String successMessage) {
        Assert.assertEquals(driver.getTitle(), successMessage);
        return this;
    }

    public ContactUsPage setNameField(String name) {
        setElementText(nameField, name);
        return this;
    }

    public ContactUsPage setEmailField(String email) {
        setElementText(emailField, email);
        return this;
    }

    public ContactUsPage setSubjectField(String subject) {
        setElementText(subjectField, subject);
        return this;
    }

    /**
     * this method purpose is to create a full message consists of more than one word
     *
     * @param message the message to be duplicated
     */
    public ContactUsPage setMessageField(String message) {
        StringBuilder msg = new StringBuilder();
        for (int i = 0; i <= 5; i++) {
            msg.append(message);
        }
        setElementText(messageField, msg.toString());
        return this;
    }

    public ContactUsPage uploadImage(String fileName) {
        uploadFile(uploadButton, "/images/" + fileName);
        return this;
    }

    public ContactUsPage clickOnSubmitButton() {
        clickOnElement(submitButton);
        return this;
    }

    public ContactUsPage clickOnOkInsideAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
        driver.switchTo().defaultContent();
        return this;
    }

    public void assertThatUsersMessageSubmittedSuccessfully(String successMessage) {
        Assert.assertEquals(driver.findElement(successMessageField).getText(), successMessage);
    }
}
