package test.dropdown;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.BaseTest;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DropdownTests extends BaseTest {

    @Test
    public void testDropdownOption(){
       var dropDownPage = homePage.clickDropdownLink2();
       var option = "Option 1";
       dropDownPage.clickDropdownfield(option);
       dropDownPage.getElementsFromDropdownMenu();
       //dropDownPage.selectFromDropdown("Option 1");
       //dropDownPage.getSelectedElements();
        assertEquals(dropDownPage.getElementsFromDropdownMenu().size(),1);
        assertTrue(dropDownPage.getElementsFromDropdownMenu().contains(option));

    }
    @Test
    public void testAddMultipleAttributeToDropDown(){
        var dropDownPage= homePage.clickDropdownLink();
        dropDownPage.showDropdowmElementsWithjs();
        var optionsToSelect = List.of("Options 1", "Option 2");
        optionsToSelect.forEach(dropDownPage :: selectElementFromDropdown);

        var selectedOptions = dropDownPage.getSelectedElementsFromDropdown();
        assertTrue(selectedOptions.contains(optionsToSelect), "All options were not selected");
        assertEquals(selectedOptions.size(),optionsToSelect.size(), "Number of selected items");


    }
}
