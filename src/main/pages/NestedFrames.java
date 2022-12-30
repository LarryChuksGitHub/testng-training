package main.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFrames{
    private WebDriver webDriver;
    private String topFrame = "frame-top";
    private String leftFrame = "frame-left";
    private String bottomFrame = "frame-bottom";
    //private By body = By.tagName("body");
    private By frameText = By.tagName("body");

    public NestedFrames(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    private void moveToFrame(String frameName){
        System.out.println(topFrame);
        System.out.println(leftFrame);
        System.out.println(bottomFrame);
        webDriver.switchTo().frame(frameName);
    }
    public String getleftFrameText(){
        moveToFrame(topFrame);
        moveToFrame(leftFrame);
        String text = getFrameText();
        moveToFrame(topFrame);
        moveToParentFrame();
        return text;
    }

    public String getBottomFrameText(){
        moveToFrame(bottomFrame);
        String text = getFrameText();
        moveToParentFrame();
        return text;
    }
    public void moveToParentFrame(){
        webDriver.switchTo().parentFrame();
    }
    private String getFrameText(){
        String text = webDriver.findElement(frameText).getText();
        return text;
    }
    /*
    private By frame = By.tagName("frame");
    private String top = webDriver.findElement(frame).getAttribute("frame-top");
    private String left = webDriver.findElement(frame).getAttribute("frame-left");
    private String bottom = webDriver.findElement(frame).getAttribute("frame-bottom");
    //private String topFrame = "frame-top";
    //private WebElement topFrame = webDriver .findElement(By.cssSelector("html > frameset:nth-child(2) > frame:nth-child(1)"));
    //private WebElement leftFrame = webDriver .findElement(By.cssSelector("html > frameset:nth-child(2) > frame:nth-child(1)"));
    //private String leftFrame = "frame-left";
    // private String bottomFrame = "frame-bottom";
    private By frameText = By.tagName("body");
    //private By bottomFrameText = By.tagName("body");

     */
}