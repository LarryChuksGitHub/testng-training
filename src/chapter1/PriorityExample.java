package chapter1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PriorityExample {

    @Test(priority = 1)
    public void testOne(){
        System.out.println("This is test 1");
    }
    @Test(priority = 2)
    public void testTwo(){
        System.out.println("This is test 2");
        Assert.fail();
    }
    @Test(priority = 3, enabled = true)
    public void testThree(){
        System.out.println("This is test 3");
    }
    @Test(priority = 4, dependsOnMethods = {"testTwo", "testThree"}, alwaysRun = true)
    public void testFour(){
        System.out.println("This is test 4");
    }
}
