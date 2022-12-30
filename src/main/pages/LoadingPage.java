package main.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class LoadingPage {
    private WebDriver webDriver;
    private By startButton = By.cssSelector("#start button");
    private By loading = By.id("loading");
    private By finish = By.id("finish");
    private By resultText = By.tagName("h4");
    private By result = By.cssSelector("#finish > h4:nth-child(1)");
    public LoadingPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public void clickStartButton() {
        webDriver.findElement(startButton).click();
        //webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000000));
        //WebDriverWait webDriverWait = new WebDriverWait(webDriver,Duration.ofSeconds(10000000));
        //webDriverWait.until(ExpectedConditions.presenceOfElementLocated(result));
        FluentWait fluentWait = new FluentWait(webDriver)
                .withTimeout(Duration.ofSeconds(500))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

    }
    public String getText(){
        return webDriver.findElement(result).getText();
    }
}
