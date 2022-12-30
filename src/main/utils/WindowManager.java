package main.utils;

import org.openqa.selenium.WebDriver;

public class WindowManager {
    private WebDriver webDriver;
    private WebDriver.Navigation navigate;
    public WindowManager(WebDriver webDriver){
        this.webDriver = webDriver;
        navigate = webDriver.navigate();
    }
    public void goBack(){
        navigate.back();
    }
    public  void goForward(){
        navigate.forward();
    }
    public  void refresh(){
        navigate.refresh();
    }
    public  void goTo(String url){
        navigate.to(url);
    }

    public void switchToTab(String tabTitle){
       var windows = webDriver.getWindowHandles();

       System.out.println("The number of windows is: "+  windows.size());
       //System.out.println("The windows availables are: ");
       //windows.forEach(System.out::println);
        for (String window: windows){
            System.out.println("The windows availables are: " +window);
        }
        for (String window: windows){
            System.out.println("Switching to window: " + window);
            webDriver.switchTo().window(window);
            System.out.println("The current window title " + webDriver.getTitle());
            if (webDriver.getTitle().equalsIgnoreCase(tabTitle)){
                break;
            }
        }

    }

    public void switchToNewTab(){
       var windows = webDriver.getWindowHandles();
        for (String window: windows) {
            webDriver.switchTo().window(window);

        }
    }

}
