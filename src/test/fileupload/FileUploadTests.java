package test.fileupload;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.BaseTest;

public class FileUploadTests extends BaseTest {
    private WebDriver webDriver;
    @Test
    public void testFileUpload(){
        var fileUploadPage = homePage.clickFileUploadLink();
        fileUploadPage.clickToChooseFile("/Users/hilarychukwuji/IdeaProjects/test-ng-course/src/drivers/$_57.jpeg");
        var result = "File Uploaded!";
        Assert.assertTrue(fileUploadPage.getUploadResult().contains(result),"Upload was not successful");


    }
}
