package main.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JavaScriptAlertPage {
    private WebDriver webDriver;
    //private By triggerAlert = By.xpath("/html/body/div[2]/div/div/ul/li[1]/button");
    private By triggerAlert = By.xpath(".//button[text()='Click for JS Alert']");
    private By triggerConfirm = By.xpath(".//button[text()='Click for JS Confirm']");
    private By triggerPrompt = By.xpath(".//button[text()='Click for JS Prompt']");
    private By cancelResult = By.id("result");
    private By result = By.id("result");
    public JavaScriptAlertPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }
    public void clickJSAlert(){
        webDriver.findElement(triggerAlert).click();
    }

    public void clickJSConfirm(){
        webDriver.findElement(triggerConfirm).click();
    }
    public void clickJSPrompt(){
        webDriver.findElement(triggerPrompt).click();
    }

    public void acceptAlert(){
        webDriver.switchTo().alert().accept();
    }

    public void cancelAlert(){
        webDriver.switchTo().alert().dismiss();
    }
    public void enterTextIntoPrompt(String text){
        webDriver.switchTo().alert().sendKeys(text);
        //webDriver.switchTo().alert().accept();
    }
    public void acceptPrompt(){
        webDriver.switchTo().alert().accept();
    }

    public String getCancelAlertText(){
        return webDriver.findElement(cancelResult).getText();
    }
    public String getResult(){
        return webDriver.findElement(result).getText();
    }
    public String getPromptResult(){
        return webDriver.findElement(result).getText();
    }

}
