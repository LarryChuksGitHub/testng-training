package main.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class DropdownPage2 {
    private WebDriver webDriver;
    private By dropdownField = By.id("dropdown");

    public DropdownPage2 (WebDriver webDriver){
        this.webDriver = webDriver;
    }
    public void clickDropdownfield(String option){
        findSelectedElementFromDropdown().selectByVisibleText(option);
    }

    public List<String> getElementsFromDropdownMenu(){
        List<WebElement> dropdownElements =
        findSelectedElementFromDropdown().getAllSelectedOptions();
        return dropdownElements.stream().map(e->e.getText()).collect(Collectors.toList());

    }

    private Select findSelectedElementFromDropdown(){
        Select selectedElement = new Select(webDriver.findElement(dropdownField));
        return  selectedElement;
    }
}
