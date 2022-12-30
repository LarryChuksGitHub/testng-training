package main.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InternalServerErrorPage {

    private WebDriver webDriver;
    private By errorMessage = By.name("Internal Server Error");
    public InternalServerErrorPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getErrorMessage(){
       return webDriver.findElement(errorMessage).getText();
    }
}
