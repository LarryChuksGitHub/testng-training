package main.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DynamicLoadedPage {

    private WebDriver webDriver;
    private String linkXpath_Format = ".//a[contains(text(), '%s')]";
    private By linkExample1 = By.xpath(String.format(linkXpath_Format, "Example 1"));
    private By linkExample2 = By.linkText(String.format("Example 2: Element rendered after the fact"));
    private By startButton = By.cssSelector("#start button");
    //private String linkTextFormat = ".//a[contains(text(), '%s')";
    //private By linkExample1 = By.xpath(String.format(linkTextFormat,"Example 1"));
    public DynamicLoadedPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }
    public LoadingPage clickLoadingPageExample1Link(){
        webDriver.findElement(linkExample1).click();
        return new LoadingPage (webDriver);
    }
    public LoadingPage rightClickLoadingPageExample2Link(){
        webDriver.findElement(linkExample2).sendKeys(Keys.CONTROL, Keys.RETURN);
        return new LoadingPage (webDriver);
    }

    public void rightClick(By element){
        //Actions actions = new Actions(webDriver);
        //WebElement element = webDriver.findElement(linkExample2);
        //actions.contextClick(element).perform();
        webDriver.findElement(element).sendKeys(Keys.CONTROL, Keys.RETURN);
    }
    public String getStartButtonName(){
        return webDriver.findElement(startButton).getText();

    }
}
