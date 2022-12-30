package test;

import com.google.common.io.Files;
import main.pages.HomePage;
import main.utils.WindowManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class BaseTest {

    private WebDriver webDriver;
    protected HomePage homePage;
   // WebDriverListener eventHandler = new WebDriverListener(webDriver);

   // Use EventFiringWebDriver and WebDriverListener instead

    public void highlightElement(WebDriver webDriver, WebElement webElement){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) webDriver;
        jsExecutor.executeScript("arguments[0].style.border='2px solid red'", webElement);
    }


    @BeforeTest
    public void setUp() {
            System.setProperty("webdriver.chrome.driver","/Users/hilarychukwuji/Documents/IdeaProjects/test-ng-course/src/drivers/chromedriver");
            //System.setProperty("webdriver.gecko.driver","//Users/hilarychukwuji/Documents/IdeaProjects/test-ng-course/src/drivers/geckodriver");

        //EventCapture eCapture = new EventCapture();
            webDriver = new ChromeDriver();
            //webDriver = new FirefoxDriver();
            //webDriver.register(new EventCapture());
            goHomePage();
            setCookie("Larry-Cookie","1234567");
            testRemoveCookie();
            removeCookie("optimizelyBuckets");
            testRemoveCookie();

    }
    @BeforeMethod
    public void goHomePage(){
        webDriver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(webDriver);
    }


    @Test(priority = 0)
    void testExercise(){
/*
        webDriver.manage().window().fullscreen();
        System.out.println(webDriver.getTitle());
        webDriver.findElement(By.linkText("Shifting Content")).click();
        webDriver.findElement(By.linkText("Example 1: Menu Element")).click();
        List<WebElement> menuList = webDriver.findElements(By.tagName("li"));
        System.out.println("The number of menu items: " + menuList.size());
        System.out.println("The menu items are");
        for (WebElement items : menuList){
            System.out.print(items.getText() + " | ");
        }
        //String expectedTitle = "OrangeHRM";
       // String actualTitle = webDriver.getTitle();
        // Assert.assertEquals(actualTitle,expectedTitle);
        */


    }
    @AfterMethod
    public void takeScreenshotByFailure(ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE){
            var camera = (TakesScreenshot)webDriver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            System.out.println("Path to file: " + screenshot);
            var testName = result.getName();
            try {
                Files.move(screenshot, new File("src/resources/" +testName +".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    public WindowManager windowManager(){

        return new WindowManager(webDriver);
    }
    private void setCookie(String cookieName, String cookieValue){
        Cookie cookie = new Cookie.Builder(cookieName, cookieValue )
                .domain("the-internet.herokuapp.com")
                .build();
        webDriver.manage().addCookie(cookie);

    }

    private void removeCookie(String cookieName){
        Cookie cookieToBeDeleted = webDriver.manage().getCookieNamed(cookieName);
        //"optimizelyBuckets"
        System.out.println("removing cookie with name: "+ cookieName);
        webDriver.manage().deleteCookie(cookieToBeDeleted);
    }
    private void testRemoveCookie(){
        Set<Cookie> cookies = webDriver.manage().getCookies();
        System.out.println("Number of cookies: " + cookies.size());
        for (Cookie cookie: cookies) {
            System.out.println(cookie);
        }
        Assert.assertFalse(cookies.contains("optimizelyBuckets"),"cookie was not removed");
        //cookies.contains("optimizelyBuckets");
    }

    private ChromeOptions getChromeOption(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable-infobars");
        chromeOptions.getBrowserName();
        //chromeOptions.setHeadless(true);
        return chromeOptions;
    }

    @AfterTest
    public void tearDown(){
        webDriver.quit();
    }
}
