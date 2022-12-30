package chapter3;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class ParallelTest1 {
    WebDriver webDriver;
    @Parameters("browser")
    @BeforeTest
    public void setUp(String browser) throws InterruptedException{
        if (browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "/Users/hilarychukwuji/IdeaProjects/test-ng-course/src/drivers/chromedriver");
            webDriver = new ChromeDriver();
            webDriver.manage().window().setSize(new Dimension(375,812));
        } else if (browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver","/Users/hilarychukwuji/IdeaProjects/test-ng-course/src/drivers/geckodriver");
            webDriver = new FirefoxDriver();
            webDriver.manage().window().fullscreen();
        } else if (browser.equalsIgnoreCase("safari")){
            webDriver = new SafariDriver();
        }
            webDriver.get("https://opensource-demo.orangehrmlive.com/");
            Thread.sleep(5000);
    }
    @Test(priority = 2)
    void testLogo() {
        WebElement logo = webDriver.findElement(By.cssSelector("#divLogo > img:nth-child(1)"));
        Assert.assertTrue(logo.isDisplayed(),"Logo is not displayed");
    }
    @Test (priority = 1)
    void testHomePageTitle(){
        System.out.println(webDriver.getTitle());
        String actualTitle = webDriver.getTitle();
        String expectedTitle = "OrangeHRM";
        Assert.assertEquals(actualTitle,expectedTitle);
    }
    @AfterSuite
    void tearDown(){
        webDriver.close();
    }
}
