package com.seleniumPractice.testClasses;

import com.seleniumPractice.testClasses.common.TestBase;
import com.seleniumPractice.utilities.Generators;
import com.seleniumPractice.utilities.JsonReader;
import org.testng.annotations.Test;
import pages.HomePage;

public class ContactUsTest extends TestBase {
    @Test
    public void verifyThatContactUsFormWorksCorrectly() {
        new HomePage(driver)
                .clickOnContactUsButton()
                .contactUsPage()
                .assertThatContactUsPageIsDisplayed(JsonReader.getValueFromJsonFile("contactUsPageLabel", "ValidationMessages"))
                .setNameField(Generators.generateRandomText(4) + Generators.generateRandomText(4))
                .setEmailField(Generators.generateRandomText(8) + "@mail.com")
                .setSubjectField(Generators.generateRandomText(4) + Generators.generateRandomText(4))
                .setMessageField(Generators.generateRandomText(8) + " ")
                .uploadImage("image1.jpg")
                .clickOnSubmitButton()
                .clickOnOkInsideAlert()
                .assertThatUsersMessageSubmittedSuccessfully(JsonReader.getValueFromJsonFile("messageSubmittedSuccessfullyMessage", "ValidationMessages"));
    }
}
