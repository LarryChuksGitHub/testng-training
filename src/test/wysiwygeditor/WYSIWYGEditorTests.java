package test.wysiwygeditor;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.BaseTest;

public class WYSIWYGEditorTests extends BaseTest {
    WebDriver webDriver;
    @Test
    public void testWYSIWYGEditor(){
        var wYSIWYGEditorPage = homePage.clickWYSIWYGEditorLink();
        wYSIWYGEditorPage.clearTextInEdior();
        var text1 = "Hello";
        wYSIWYGEditorPage.writeTextInEditor(text1);
        wYSIWYGEditorPage.clickIncreaseIdentKey();
        var text2 = "World";
        wYSIWYGEditorPage.writeTextInEditor(text2);
        Assert.assertEquals(wYSIWYGEditorPage.getTextInEditor(),text1 + text2, "Incorrect text in Editor");
    }
}
