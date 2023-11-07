package testClasses;

import org.testng.annotations.Test;
import pages.HomePage;
import utilities.JsonReader;

public class TestCasesTest extends TestBase {
    @Test
    public void verifyThatUserCanOpenTestCasesPage() {
        new HomePage(driver)
                .clickOnTestCasesButton()
                .testCasesPage()
                .assertThatTestCasesPageDisplayed(JsonReader.getValueFromJsonFile("testCasesPageLabel","ValidationMessages"));
    }
}
