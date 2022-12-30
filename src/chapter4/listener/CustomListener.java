package chapter4.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListener implements ITestListener{
    @Override
    public void onStart(ITestContext context){
        System.out.println("Start listener...");
    }
    @Override
     public void onTestFailedButWithinSuccessPercentage(ITestResult result){
        System.out.println("Test failed but the percentage of passed test is acceptable..ncalling listener");
    }
    @Override
    public void onTestFailedWithTimeout(ITestResult result){
        System.out.println("Test failed due to timeout. calling listener");

    }
   @Override
    public void onTestFailure(ITestResult result){
       System.out.println("Test failed calling listener due to the failed test");
    }
    @Override
    public void onTestSkipped(ITestResult result){
        System.out.println("Test skipped calling listener due to the skipped test");

    }
    @Override
    public void onTestStart(ITestResult result){
       // System.out.println("Start testing and calling listener due to the test start");

    }
    @Override
    public void onTestSuccess(ITestResult result){
        System.out.println("Test passed calling listener due to the passed test");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("finished testing and calling listener to close listener session");
    }
}
