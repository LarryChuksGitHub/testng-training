package main.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HorizontalSliderPage {
    private WebDriver webDriver;
    private By sliderValue = By.id("range");
    private By sliderButton = By.cssSelector(".sliderContainer input");
    public HorizontalSliderPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }
    public void moveSliderToRange(String range){
       while (!getSliderRange().equals(range)){
           webDriver.findElement(sliderButton).sendKeys(Keys.ARROW_RIGHT);
       }
    }

    public String getSliderRange(){
       return webDriver.findElement(sliderValue).getText();
    }
}
