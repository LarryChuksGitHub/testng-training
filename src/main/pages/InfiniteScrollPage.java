package main.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class InfiniteScrollPage {
    private WebDriver webDriver;
    private By paragraph = By.className("jscroll-added");
    public InfiniteScrollPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }
    // scroll to paragraph n (index)

    /**
     *
     * @param index base
     *  Index is the paragraph to be scrolled to
     */
    public void scrollToParagraph(int index){
        String script = "window.scrollTo(0, document.body.scrollHeight)";
        var jsExecutor = (JavascriptExecutor)webDriver;
        while (getParagrapSize() < index){
            jsExecutor.executeScript(script);
        }
    }
    private int getParagrapSize(){
        int number = 0;
        number = webDriver.findElements(paragraph).size();
        System.out.println("The number of paragraph in view: " + number);
        return number;
    }
}
