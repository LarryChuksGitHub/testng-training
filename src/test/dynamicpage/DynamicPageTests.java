package test.dynamicpage;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.BaseTest;

public class DynamicPageTests extends BaseTest {
    @Test
    public void testDynamicPageExample1() throws InterruptedException {
        var dynamicLoadedPage = homePage.clickDynamicLoadingPageLink();
        var loadingPage = dynamicLoadedPage.clickLoadingPageExample1Link();
        loadingPage.clickStartButton();
        Assert.assertEquals(loadingPage.getText(),"Hello World!", "incorrect messsage");
    }
    @Test
    public void testDynamicPageExample2(){
        var dynamicLoadedPage = homePage.clickDynamicLoadingPageLink();
        dynamicLoadedPage.rightClickLoadingPageExample2Link();
        windowManager().switchToNewTab();
        var buttonName = dynamicLoadedPage.getStartButtonName();
        Assert.assertEquals(buttonName,"Start","Button name incorrect");
    }
}
