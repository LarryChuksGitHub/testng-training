package main.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class ContextMenuPage {
    private WebDriver webDriver;
    private By boxArea = By.id("hot-spot");
    public ContextMenuPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }
    public void rightClickBox(){
        WebElement box = webDriver.findElement(boxArea);
        Actions action = new Actions(webDriver);
        action.contextClick(box).perform();
    }
    public String getPopUpMenuText(){
        return webDriver.switchTo().alert().getText();
    }
    public void verifyPopUpText(String text){
        System.out.println(getPopUpMenuText());
        getPopUpMenuText().equalsIgnoreCase(text);
    }
    public void clickOkOnPopupMenu(){
        webDriver.switchTo().alert().accept();

    }

}
