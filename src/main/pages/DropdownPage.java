package main.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class DropdownPage {

    private WebDriver webDriver;
    private By dropdown = By.id("dropdown");
    private By options = By.tagName("option");

    public DropdownPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void selectElementFromDropdown(String option){
        findDropdownElement()
        .selectByVisibleText(option);
    }

    public List <String> getSelectedElementsFromDropdown(){
        List <WebElement> selectedElement = findDropdownElement().getAllSelectedOptions();
       return selectedElement.stream().map(e->e.getText()).collect(Collectors.toList());
    }

    private Select findDropdownElement(){

        return new Select(webDriver.findElement(dropdown));
    }

    public void showDropdowmElementsWithjs(){
        WebElement optionElement = webDriver.findElement(options);
        var jsExecutor = (JavascriptExecutor)webDriver;
        String script = "arguments[0].setAttribute('multiple', '')";
        jsExecutor.executeScript(script, findDropdownElement());
    }

    public void verySelectedItemsWithjs(){
        getSelectedElementsFromDropdown();
        getDropdownItemsListjs().iterator();
        Assert.assertEquals(getSelectedElementsFromDropdown(),"Option 1 " + "Option 2", "Incorrect Text");
        }

    public List getDropdownItemsListjs(){
        List  itemList = webDriver.findElements(options);
        return itemList;
    }
}
