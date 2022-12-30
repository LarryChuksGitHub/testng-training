package chapter2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import javax.swing.text.Highlighter;

public class AssertionExample {
    WebDriver webDriver;

    public void highlightElement(WebDriver webDriver, WebElement webElement){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) webDriver;
        jsExecutor.executeScript("arguments[0].style.border='2px solid red'", webElement);
    }

    @BeforeClass
    @Parameters({"browser","app"})
    public void setUp(String browser, String app){
        if (browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "/Users/hilarychukwuji/IdeaProjects/test-ng-course/src/drivers/chromedriver");
            webDriver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver","/Users/hilarychukwuji/IdeaProjects/test-ng-course/src/drivers/geckodriver");
            webDriver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("safari")){
            webDriver = new SafariDriver();
        }
        webDriver.get(app);
    }
    @Test(priority = 0)
    void testLogo() {
       // #divLogo > img:nth-child(1)
        WebElement logo = webDriver.findElement(By.cssSelector("#divLogo > img:nth-child(1)"));
        highlightElement(webDriver,logo);
        //WebElement logo = webDriver.findElement(By.xpath("//*[@id=\"divLogo\"]"));
        Assert.assertTrue(logo.isDisplayed(),"Logo is not displayed");
    }
    @Test (priority = 2)
    void testHomePageTitle(){
        webDriver.manage().window().fullscreen();
        String actualTitle = webDriver.getTitle();
        System.out.println(webDriver.getTitle());
       // String expectedTitle = "OrangeHRM";
       // Assert.assertEquals(actualTitle,expectedTitle);
    }

    @Test (priority = 0)
    void testExercise(){
        webDriver.manage().window().fullscreen();
        System.out.println(webDriver.getTitle());
        WebElement shiftingContent = webDriver.findElement(By.linkText("Shifting Content"));
        shiftingContent.click();
        //String expectedTitle = "OrangeHRM";
        String actualTitle = webDriver.getTitle();
       // Assert.assertEquals(actualTitle,expectedTitle);
    }

    @Test(dependsOnMethods = "testHomePageTitle",dataProvider = "loginData",dataProviderClass = CustomDataProvider.class)
    void testLogininHomePage(String username, String password){
       WebElement userNameLabel = webDriver.findElement(By.id("txtUsername"));
       highlightElement(webDriver,userNameLabel);
        userNameLabel.click();
        userNameLabel.sendKeys(username);

        WebElement passwordLabel = webDriver.findElement(By.id("txtPassword"));
        highlightElement(webDriver,passwordLabel);
        passwordLabel.click();
        passwordLabel.sendKeys(password);

       WebElement loginButton = webDriver.findElement(By.id("btnLogin"));
       loginButton.click();
    }

    @Test(dependsOnMethods = {"testLogininHomePage"})
    void verifLoginPassed(){
        //String passMessage = "welcome";
        WebElement foundMessage = webDriver.findElement(By.id("welcome"));
        highlightElement(webDriver,foundMessage);
        Assert.assertTrue(foundMessage.isDisplayed());
    }
    @AfterClass
    void tearDown(){
        webDriver.close();
    }
}
