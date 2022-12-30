package test.frames;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.BaseTest;

public class FrameTests extends BaseTest {
    private WebDriver webDriver;

    @Test
    public void testFrames(){
        var framePages = homePage.clickFramesPageLink();
        var nestedFrame = framePages.clickNestedFrames();
        Assert.assertEquals(nestedFrame.getleftFrameText(),"LEFT", "text incorrect");
        Assert.assertEquals(nestedFrame.getBottomFrameText(),"BOTTOM", "text incorrect");
    }
}
