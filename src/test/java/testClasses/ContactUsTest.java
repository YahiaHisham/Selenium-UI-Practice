package testClasses;

import org.testng.annotations.Test;
import pages.HomePage;
import utilities.JsonReader;

import static utilities.Generators.generateRandomText;

public class ContactUsTest extends TestBase {
    @Test
    public void verifyThatContactUsFormWorksCorrectly() {
        new HomePage(driver)
                .clickOnContactUsButton()
                .contactUsPage()
                .assertThatContactUsPageIsDisplayed(JsonReader.getValueFromJsonFile("contactUsPageLabel", "ValidationMessages"))
                .setNameField(generateRandomText(4) + generateRandomText(4))
                .setEmailField(generateRandomText(8) + "@mail.com")
                .setSubjectField(generateRandomText(4) + generateRandomText(4))
                .setMessageField(generateRandomText(8) + " ")
                .uploadImage("image1.jpg")
                .clickOnSubmitButton()
                .clickOnOkInsideAlert()
                .assertThatUsersMessageSubmittedSuccessfully(JsonReader.getValueFromJsonFile("messageSubmittedSuccessfullyMessage", "ValidationMessages"));
    }
}
