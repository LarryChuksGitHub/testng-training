package chapter4.listener;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

//@Listeners(CustomListener.class)
public class ListenerTest {
    SoftAssert softAssert = new SoftAssert();
    @Test
    void test1(){
        System.out.println("This is passed: test 1");
        softAssert.assertEquals("a","a");
    }
    @Test
    void test2(){
        System.out.println("This is failed: test 2");
        softAssert.assertEquals("a","8");
        System.out.println("Continued running Test after failed due to soft assert");
        softAssert.assertAll();
    }
    @Test
    void test3(){
        System.out.println("This is skipped: test 3");
        throw new SkipException("Skipping test ");
    }
}
