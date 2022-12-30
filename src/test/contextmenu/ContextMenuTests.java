package test.contextmenu;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import test.BaseTest;

public class ContextMenuTests extends BaseTest {
    WebDriver webDriver;
    @Test
    public void testContextMenu(){
        var contextMenuPage = homePage.clickContextMenuLink();
        contextMenuPage.rightClickBox();
        var contextMenuText = "You selected a context menu";
        contextMenuPage.verifyPopUpText(contextMenuText);
        contextMenuPage.clickOkOnPopupMenu();
    }
}
