package chapter3;

import chapter2.CustomDataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class ParallelTest2 {
    WebDriver webDriver;
    @Parameters({"browser"})
    @BeforeTest
    public void setUp(String browser) throws InterruptedException{
        if (browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "/Users/hilarychukwuji/IdeaProjects/test-ng-course/src/drivers/chromedriver");
            webDriver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver","/Users/hilarychukwuji/IdeaProjects/test-ng-course/src/drivers/geckodriver");
            webDriver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("safari")){
            webDriver = new SafariDriver();
        }
        webDriver.get("https://opensource-demo.orangehrmlive.com/");
        Thread.sleep(5000);
    }

    @Test(priority = 1,dataProvider = "loginData",dataProviderClass = CustomDataProvider.class)
    void testLogininHomePage(String username, String password){
        WebElement userNameLabel = webDriver.findElement(By.id("txtUsername"));
        userNameLabel.click();
        userNameLabel.sendKeys(username);

        WebElement passwordLabel = webDriver.findElement(By.id("txtPassword"));
        passwordLabel.click();
        passwordLabel.sendKeys(password);

        WebElement loginButton = webDriver.findElement(By.id("btnLogin"));
        loginButton.click();
    }

    @Test(dependsOnMethods = {"testLogininHomePage"})
    void verifLoginPassed(){
        WebElement foundMessage = webDriver.findElement(By.id("welcome"));
        Assert.assertTrue(foundMessage.isDisplayed());
    }
    @AfterSuite
    void tearDown(){
        webDriver.close();
    }
}
