package test.loginfeature;

import main.pages.LoginPage;
import main.pages.SecureArea;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.BaseTest;

public class LoginTests extends BaseTest {

    @Test
    public void testSuccessfulLogin() throws InterruptedException {
        LoginPage loginPage = homePage.clickFormAuthenticationLink();
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        SecureArea secureArea = loginPage.clickLoginButton();
        String actualText = secureArea.getSecureAreaSuccessfulLoginMessage();
        String welcomeText = "You logged into a secure area!\n" +
                "×";
        Assert.assertTrue(actualText.contains(welcomeText),"successful login message was not displayed");
        //tearDown();

    }

}
