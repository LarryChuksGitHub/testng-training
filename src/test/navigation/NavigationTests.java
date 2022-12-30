package test.navigation;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import test.BaseTest;

public class NavigationTests extends BaseTest {
    private WebDriver webDriver;
    @Test
    public void testNavigation(){
       var dynamicPage = homePage.clickDynamicLoadingPageLink();
       dynamicPage.clickLoadingPageExample1Link().clickStartButton();
       windowManager().goBack();
       windowManager().goForward();
       windowManager().refresh();
       windowManager().goTo("https://google.com");
    }
}
