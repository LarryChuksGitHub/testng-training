package main.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage {
    private WebDriver webDriver;
    private By filePathButton = By.id("file-upload");
    private By fileSubmitButton = By.id("file-submit");
    private By uploadResult = By.tagName("h3");
    public FileUploadPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }
    public void clickToSubmitFile(){
        webDriver.findElement(fileSubmitButton).click();
    }

    public void clickToChooseFile(String absolutePathToFile){
        webDriver.findElement(filePathButton).sendKeys(absolutePathToFile);
        clickToSubmitFile();
    }
    public String getUploadResult(){
        System.out.println(webDriver.getTitle());
        //return webDriver.getTitle();
        return webDriver.findElement(uploadResult).getText();
    }

}
