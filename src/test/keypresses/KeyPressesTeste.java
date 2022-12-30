package test.keypresses;

import org.openqa.selenium.Keys;
import org.openqa.selenium.devtools.v100.indexeddb.model.Key;
import org.testng.Assert.*;
import org.testng.annotations.Test;
import test.BaseTest;

import static org.testng.Assert.*;

public class KeyPressesTeste extends BaseTest {

    @Test
    public void testBackSpace(){
        var keyPressesPage = homePage.clickKeyPressesLink();
        keyPressesPage.enterText("A" + Keys.BACK_SPACE);
        //keyPressesPage.getResult();
        assertEquals(keyPressesPage.getResult(),"You entered: BACK_SPACE?","incorrect text");
    }
    @Test
    public void testPi(){
        var keyPressesPage = homePage.clickKeyPressesLink();
        keyPressesPage.enterPi();
        keyPressesPage.getResult();
        //You entered: 4
        assertEquals(keyPressesPage.getResult(),"You entered: 5","incorrect text");
    }

}
