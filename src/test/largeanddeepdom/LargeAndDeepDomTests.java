package test.largeanddeepdom;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import test.BaseTest;

public class LargeAndDeepDomTests extends BaseTest {
    private WebDriver webDriver;

    @Test
    public void testScrollToTable(){
        homePage.clickLargeAndDeepDomPageLink().scrollToTable();
    }
}
