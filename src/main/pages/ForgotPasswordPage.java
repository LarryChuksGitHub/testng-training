package main.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

    private WebDriver webDriver;
    private By emailField = By.cssSelector("#email");
    private By retrievePasswordButton = By.id("form_submit");

    public ForgotPasswordPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public void sendEmailAdress(String emailAdress){
        webDriver.findElement(emailField).sendKeys(emailAdress);
    }
    public InternalServerErrorPage clickRetrievePasswordButton(){
        webDriver.findElement(retrievePasswordButton).click();
        return new InternalServerErrorPage (webDriver);

    }

}
