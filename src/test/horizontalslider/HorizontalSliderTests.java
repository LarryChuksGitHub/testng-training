package test.horizontalslider;

import org.testng.annotations.Test;
import test.BaseTest;

import static org.testng.Assert.assertEquals;

public class HorizontalSliderTests extends BaseTest {

    @Test
    public void testSliderRange(){
        var value = "4";
        var horizontapSliderPage = homePage.clickHorizontalSlider();
        horizontapSliderPage.moveSliderToRange(value);
        assertEquals(horizontapSliderPage.getSliderRange(),value,"incorrect range");

    }
}
