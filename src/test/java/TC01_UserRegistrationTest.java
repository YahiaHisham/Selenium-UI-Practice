import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignupLoginPage;
import pages.SignupPage;
import resources.JSONReader;


public class TC01_UserRegistrationTest extends TestBase{

String username = JSONReader.readJSON(getTestClassName(),getMethodName(getClass().getMethod(getTestClassName())));

    public TC01_UserRegistrationTest() throws NoSuchMethodException {
    }

    @Test
    public void TC01()
    {
        System.out.println(getTestClassName());
        System.out.println(getMethodName(getClass().getEnclosingMethod()));
        System.out.println(username);
    }
    @Test
    public void verifyThatUserCanRegisterSuccessfully() {

        new SignupLoginPage(driver)
                .clickOnSignupLoginButton();

        new SignupLoginPage(driver)
                .setSignupName()
                .setSignupEmail()
                .clickOnSignupButton();

        new SignupPage(driver)
                .signUpActions()
                .assertThatAccountCreatedSuccessfully()
                .clickOnContinueButton();
               // .clickOnCloseAd()
               // .clickOnContinueButton()

        new HomePage(driver)
                .clickOnDeleteButton()
                .assertThatAccountDeletedSuccessfully();

    }


}
