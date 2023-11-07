package com.seleniumPractice.testClasses;

import com.seleniumPractice.testClasses.common.TestBase;
import org.testng.annotations.Test;
import pages.HomePage;
import com.seleniumPractice.utilities.JsonReader;

public class TestCasesTest extends TestBase {
    @Test
    public void verifyThatUserCanOpenTestCasesPage() {
        new HomePage(driver)
                .clickOnTestCasesButton()
                .testCasesPage()
                .assertThatTestCasesPageDisplayed(JsonReader.getValueFromJsonFile("testCasesPageLabel","ValidationMessages"));
    }
}
