package chapter1;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGDemo1 {

    @BeforeTest
    public void beforeAnnotation(){
        System.out.println("This is test NG before the test starts");
    }


    @Test
    public void testAnnotation(){
        System.out.println("This is test NG");
    }
    @AfterTest
    public void afterAnnotation(){
        System.out.println("This is test NG after the test has ended");
    }
}
