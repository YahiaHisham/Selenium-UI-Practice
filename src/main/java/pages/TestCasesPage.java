package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestCasesPage extends PageBase{

    public TestCasesPage(WebDriver driver) {
        super(driver);
    }
    public void assertThatTestCasesPageDisplayed(String message) {
        Assert.assertEquals(driver.getTitle(),message);
    }
}
