package main.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MultipleWindowPage {
    private WebDriver webDriver;
    private By clickHereButton = By.linkText("Click Here");
    public MultipleWindowPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }
    public void clickHere(){
        webDriver.findElement(clickHereButton).click();
    }
}
