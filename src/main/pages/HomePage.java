package main.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver webDriver;
   // private By formAuthenticationLink = By.linkText("Form Authentication");

    public LoginPage clickFormAuthenticationLink(){
        clickLink("Form Authentication");
        return new LoginPage(webDriver);
    }
    public DropdownPage clickDropdownLink(){
        clickLink("Dropdown");
        return new DropdownPage(webDriver);
    }
    public ForgotPasswordPage clickForgotPasswordLink(){
        clickLink("Forgot Password");
        return new ForgotPasswordPage(webDriver);
    }

    public HoversPage clickHoversLink(){
        clickLink("Hovers");
        return new HoversPage(webDriver);
    }

    public DropdownPage2 clickDropdownLink2(){
        clickLink("Dropdown");
        return new DropdownPage2(webDriver);
    }
    public KeyPressesPage clickKeyPressesLink(){
        clickLink("Key Presses");
        return  new KeyPressesPage(webDriver);
    }

    public HorizontalSliderPage clickHorizontalSlider(){
        clickLink("Horizontal Slider");
        return new HorizontalSliderPage(webDriver);
    }
    public JavaScriptAlertPage clickJavaScriptAlerLink(){
        clickLink("JavaScript Alerts");
        return new JavaScriptAlertPage(webDriver);
    }
    public FileUploadPage clickFileUploadLink(){
        clickLink("File Upload");
        return new FileUploadPage(webDriver);
    }
    public ContextMenuPage clickContextMenuLink(){
        clickLink("Context Menu");
        return new ContextMenuPage(webDriver);
    }
    public WYSIWYGEditorPage clickWYSIWYGEditorLink(){
        clickLink("WYSIWYG Editor");
        return new WYSIWYGEditorPage(webDriver);
    }
    public FramesPage clickFramesPageLink(){
        clickLink("Frames");
        return new FramesPage(webDriver);
    }
    public DynamicLoadedPage clickDynamicLoadingPageLink(){
        clickLink("Dynamic Loading");
        return new DynamicLoadedPage(webDriver);
    }
    public LargeAndDeepDomPage clickLargeAndDeepDomPageLink(){
        clickLink("Large & Deep DOM");
        return new LargeAndDeepDomPage(webDriver);
    }

    public InfiniteScrollPage clickInfiniteScrollPageLink(){
        clickLink("Infinite Scroll");
        return new InfiniteScrollPage(webDriver);
    }

    public MultipleWindowPage clickMultipleWindowPageLink(){
        clickLink("Multiple Windows");
        return new MultipleWindowPage(webDriver);
    }

    public void clickLink(String linkText){
        webDriver.findElement(By.linkText(linkText)).click();
    }

    public HomePage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

}
