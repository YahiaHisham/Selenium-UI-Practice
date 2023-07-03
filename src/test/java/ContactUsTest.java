import org.testng.annotations.Test;
import pages.HomePage;

public class ContactUsTest extends TestBase {
    @Test
    public void verifyThatContactUsFormWorksCorrectly() {
        new HomePage(driver)
                .clickOnContactUsButton()
                .contactUsPage()
                .assertThatContactUsPageIsDisplayed()
                .setNameField()
                .setEmailField()
                .setSubjectField()
                .setMessageField()
                .uploadImage()
                .clickOnSubmitButton()
                .clickOnOkInsideAlert()
                .assertThatUsersMessageSubmittedSuccessfully();
    }
}
