package main.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SecureArea {

    WebDriver webDriver;
    private By flash = By.id("flash");
    private By logoutButton = By.cssSelector("#content div a i ");

    public String getSecureAreaSuccessfulLoginMessage() throws InterruptedException {
        System.out.println(webDriver.findElement(flash).getText());
        String actualText = webDriver.findElement(flash).getText();
        return actualText;
    }

    public SecureArea(WebDriver webDriver){
        this.webDriver = webDriver;
    }

}
