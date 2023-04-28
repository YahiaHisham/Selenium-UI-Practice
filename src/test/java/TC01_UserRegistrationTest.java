import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SignupLoginPage;
import pages.SignupPage;
import resources.JSONReader;

import java.lang.reflect.Method;

public class TC01_UserRegistrationTest extends TestBase{

public static String email;
public static String password;

@BeforeMethod
public void setup(Method method)
{
    email = JSONReader.readJSON(getTestClassName(),method.getName(),"email");
    password = JSONReader.readJSON(getTestClassName(),method.getName(),"password");
}
    @Test
    public void verifySignInSuccessfully()
    {
        System.out.println(getTestClassName());
        System.out.println(email);
        new LoginPage(driver)
                .signInAction(email , password)
                .verifySuccessfulLogin();
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
