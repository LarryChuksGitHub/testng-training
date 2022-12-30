package test.javascriptalert;

import org.testng.annotations.Test;
import test.BaseTest;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class JavaScriptAlertTests extends BaseTest {
    @Test
    public void testJSAlert(){
        var javaScriptAlertPage = homePage.clickJavaScriptAlerLink();
        javaScriptAlertPage.clickJSAlert();
        javaScriptAlertPage.acceptAlert();
        var result = "You successfully clicked an alert";
        assertTrue(javaScriptAlertPage.getResult().contains(result));
    }
    @Test
    public void testJSConfirm(){
        var javaScriptAlertPage = homePage.clickJavaScriptAlerLink();
        javaScriptAlertPage.clickJSConfirm();
        javaScriptAlertPage.cancelAlert();
        var cancelResult = "You clicked: Cancel";
        assertTrue(javaScriptAlertPage.getCancelAlertText().contains(cancelResult));
    }
    @Test
    public void testJSPrompt(){
        var javaScriptAlertPage = homePage.clickJavaScriptAlerLink();
        javaScriptAlertPage.clickJSPrompt();
        var enteredText= "js is super";
        javaScriptAlertPage.enterTextIntoPrompt(enteredText);
        javaScriptAlertPage.acceptPrompt();
        assertTrue(javaScriptAlertPage.getResult().contains(enteredText));
    }

}
