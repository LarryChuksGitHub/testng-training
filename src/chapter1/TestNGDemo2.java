package chapter1;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGDemo2 {

    @BeforeTest
    public void setUp() {
        System.out.println("Setting up the test...");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Running before method");
        System.out.println("Landing Page is opened");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Running after method");
    }

    @Test(priority = 1)
    public void searchProduct() {
        System.out.println("The product sock ist search");
    }

    @Test(priority = 3)
    public void addProductToCart() {
        System.out.println("The product socks is added to the cart");
    }

    @Test(priority = 2)
    public void isSearchProductFound() {
        System.out.println("The search Product socks is found");
    }

    @Test(priority = 4)
    public void verifyAddedProductInTheCart() {
        System.out.println("The added Product socks is in the cart");
    }

    @Test(priority = 4)
    public void failVerifyAddedProductInTheCart() {
        Assert.assertEquals("Noke", "Nike");
        System.out.println("The added Product socks is in the cart");
    }

    @AfterTest
    public void tearDown() {
        System.out.println("Ending the test ...");
    }
    @BeforeSuite
    public void beforeSuiteStart() {
        System.out.println("Running before starting the suite");
    }

    @AfterSuite
    public void afterSuiteStart() {
        System.out.println("Running to end the suite");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Running before class");
    }
    @AfterClass
    public void afterClass() {
        System.out.println("Running after class");
    }

    @BeforeGroups
    public void beforeGroup() {
        System.out.println("Running before group");
    }

    @AfterGroups
    public void afterGroup() {
        System.out.println("Running after group");
    }

}
