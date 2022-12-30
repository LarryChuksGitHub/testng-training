package chapter1;

import org.testng.annotations.Test;

public class GroupTestExample {

    @Test(groups = "sanity")
    void test1(){
        System.out.println("Running test  1");
    }
    @Test(groups = {"sanity", "regression"})
    void test2(){
        System.out.println("Running test  2");
    }
    @Test(groups = {"regression"})
    void test3(){
        System.out.println("Running test  3");
    }
    @Test(groups = {"regression"})
    void test4(){
        System.out.println("Running test  4");
    }
    @Test(groups = {"sanity"})
    void test5(){
        System.out.println("Running test  5");
    }
    @Test(groups = {"regression"})
    void test6(){
        System.out.println("Running test  6");
    }
}
