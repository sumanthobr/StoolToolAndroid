package configurations;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

import static Constants.FilePathsAndBaseConstants.SCREENSHOTS_PATH;

public class CustomTestListener extends Base implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        try {
            System.out.println("Failed at "+iTestResult.getName());
            screenshot(SCREENSHOTS_PATH,composeTestName(iTestResult));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    private String composeTestName(ITestResult iTestResult) {
        StringBuffer completeFileName = new StringBuffer();
        completeFileName.append(iTestResult.getTestClass().getRealClass().getSimpleName()); // simplified class name
        completeFileName.append("_");
        completeFileName.append(iTestResult.getName()); // method name

        // all the parameters information
//        Object[] parameters = iTestResult.getParameters();
//        for(Object parameter : parameters) {
//            completeFileName.append("_");
//            completeFileName.append(parameter);
//        }

        // return the complete name and replace : by - (in the case the emulator have port as device name)
        return completeFileName.toString().replace(":", "-");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

}