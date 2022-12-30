package test.hovers;

import main.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.BaseTest;

public class HoversTest extends BaseTest {
    private WebDriver webDriver;

    @Test
    public void testHoversUser2(){
        var hoversPage = homePage.clickHoversLink();
        var figureCaption = hoversPage.hoverOverFigure(2);
        Assert.assertTrue(figureCaption.isCaptionDisplayed());
        Assert.assertEquals(figureCaption.getTitle(),"name: user2","Title is incorrect");
        Assert.assertEquals(figureCaption.getLinkText(),"View profile", "Link User visible text is incorrect");
        Assert.assertTrue(figureCaption.getLink().endsWith("/users/2"),"Link is incorrect");
    }
}
