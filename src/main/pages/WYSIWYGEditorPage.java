package main.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WYSIWYGEditorPage {
    private WebDriver webDriver;
    private String mceiFrameEditor = "mce_0_ifr";
    private By tinymceEditor = By.id("tinymce");
    private By indenTbuttonIncrease = By.cssSelector("div.tox-toolbar__group:nth-child(5) > button:nth-child(2)");
    public WYSIWYGEditorPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }
    private void switchToMCEiFrame (){
        webDriver.switchTo().frame(mceiFrameEditor);
    }
    private void switchToTinymceEditor(){
        switchToMCEiFrame();
        clearTextInEdior();
    }
    public void clearTextInEdior(){
        switchToMCEiFrame();
        webDriver.findElement(tinymceEditor).clear();
        moveToParentPage();
    }
    public void writeTextInEditor(String text){
        switchToMCEiFrame();
        webDriver.findElement(tinymceEditor).sendKeys(text);
        moveToParentPage();
    }
    public void clickIncreaseIdentKey(){
        webDriver.findElement(indenTbuttonIncrease).click();
    }
    private void moveToParentPage(){
        webDriver.switchTo().parentFrame();
    }
    public String getTextInEditor(){
        switchToMCEiFrame();
       String text = webDriver.findElement(tinymceEditor).getText();
        moveToParentPage();
        return text;
    }
}
