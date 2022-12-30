package test.multiplewindow;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import test.BaseTest;

import static org.testng.Assert.assertTrue;

public class MultipleWindowTests extends BaseTest {
    WebDriver webDriver;
    @Test
    public void testMultipleWindows(){
        var multipleWindow = homePage.clickMultipleWindowPageLink();
        multipleWindow.clickHere();
        var currentWindowTitle = "New Window";
        windowManager().switchToTab(currentWindowTitle);
        //assertTrue(webDriver.getTitle().equalsIgnoreCase("New Window"));
    }
}
