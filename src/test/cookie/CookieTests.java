package test.cookie;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.BaseTest;

import java.util.Set;

public class CookieTests extends BaseTest {
    private WebDriver webDriver;

    @Test
    public void testRemoveCookie(){
        Set<Cookie> cookies = webDriver.manage().getCookies();
        System.out.println("Number of cookies: " + cookies.size());
        for (Cookie cookie: cookies) {
            System.out.println(cookie);
        }
        Assert.assertFalse(cookies.contains("optimizelyBuckets"),"cookie was not removed");
        //cookies.contains("optimizelyBuckets");
    }

}
