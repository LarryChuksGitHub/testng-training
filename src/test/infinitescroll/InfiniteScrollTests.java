package test.infinitescroll;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import test.BaseTest;

public class InfiniteScrollTests extends BaseTest {
    private WebDriver webDriver;

    @Test
    public void scrollToParagraph5(){
        homePage.clickInfiniteScrollPageLink().scrollToParagraph(5);
    }
}
