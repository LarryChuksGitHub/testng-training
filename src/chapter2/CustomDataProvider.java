package chapter2;

import org.testng.annotations.DataProvider;

public class CustomDataProvider {

    @DataProvider(name = "loginData")
    public Object [][] dataProvider(){
        Object [][] data = { {"Admin","admin123"}};
        return data;
    }
}
