import org.testng.annotations.Test;
import pages.HomePage;

public class TestCasesTest extends TestBase {
    @Test
    public void verifyThatUserCanOpenTestCasesPage() {
        new HomePage(driver)
                .clickOnTestCasesButton()
                .testCasesPage()
                .assertThatTestCasesPageDisplayed();
    }
}
