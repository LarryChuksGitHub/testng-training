package main.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver webDriver;
    private By userName = By.id("username");
    private By passWord = By.id("password");
    private By loginButton = By.cssSelector("#login button");

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void setUsername(String username){
        System.out.println("This is Webdriver: "+ webDriver);
        webDriver.findElement(userName).sendKeys(username);
    }
    public void setPassword(String password){
        webDriver.findElement(passWord).sendKeys(password);
    }

    public SecureArea clickLoginButton(){
        webDriver.findElement(loginButton).click();
        return new SecureArea(webDriver);
    }

}
