package main.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FramesPage {
    private WebDriver webDriver;
    private By nestedFramesLink = By.linkText("Nested Frames");
    public FramesPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }
    public NestedFrames clickNestedFrames(){
        webDriver.findElement(nestedFramesLink).click();
        return new NestedFrames(webDriver);
    }
}
