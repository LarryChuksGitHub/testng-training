package test.forgotpassword;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.BaseTest;

public class ForgotPasswordTests extends BaseTest {


    @Test
    public void testForgotPassword() {
        var forgotPasswordPage = homePage.clickForgotPasswordLink();
        forgotPasswordPage.sendEmailAdress("TAU@example.com");
        var interServerErrorPage = forgotPasswordPage.clickRetrievePasswordButton();
        var errorMeassge = interServerErrorPage.getErrorMessage();
        Assert.assertTrue(errorMeassge.contains("Internal Server Error"));

    }
}


