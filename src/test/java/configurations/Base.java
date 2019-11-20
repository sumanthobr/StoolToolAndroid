package configurations;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.StartsActivity;
import io.appium.java_client.android.connection.ConnectionState;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static Constants.FilePathsAndBaseConstants.*;


public class Base {
    public static AndroidDriver<MobileElement> driver;
    Dimension size;
    private static DesiredCapabilities caps = new DesiredCapabilities();
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest test1;
    @BeforeSuite
    public void reportSetup(){
        // start reporters
        htmlReporter = new ExtentHtmlReporter("extent.html");

        // create ExtentReports and attach reporter(s)
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }
    @AfterSuite
    public void generateReport(){
        extent.flush();
    }
    public void appLaunch(String udid, String systemPort) throws MalformedURLException {
        caps.setCapability("deviceName", "Moto C");
        caps.setCapability("udid", udid); //Give Device ID of your mobile phone
        caps.setCapability("platformName", "Android");
        caps.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT,systemPort);
        caps.setCapability("simpleIsVisibleCheck","true");
//        caps.setCapability("automationName","UiAutomator2");
        File appDir=new File(APP_PATH);
        File app= new File(appDir,APK);
        caps.setCapability("app",app.getAbsolutePath());
        caps.setCapability("autoGrantPermissions",true);
        caps.setCapability("appPackage", APP_PACKAGE);
        caps.setCapability("appActivity", APP_ACTIVITY);
        driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    public void tearDown(){
        driver.quit();
    }
    public static void waitFor(WebElement ele){
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOf(ele));
    }
    public static void staleWaitFor(WebElement ele){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.stalenessOf(ele));
    }
    public static void scroll(AndroidDriver driver,double startPer,double finalPer,int duration){
        Dimension size= driver.manage().window().getSize();
        int width=(int)(size.width/2);
        int startPoint =(int)(size.getHeight()*startPer);
        int endPoint= (int)(size.getWidth()*finalPer);
        new TouchAction(driver).press(new PointOption().withCoordinates(width,startPoint)).waitAction(new WaitOptions().withDuration(Duration.ofMillis(duration))).moveTo(new PointOption().withCoordinates(width,endPoint)).release().perform();
    }
    public static void scrollDown(){
        Dimension size= driver.manage().window().getSize();
        Double scrollHeightStart= size.getHeight()*0.5;
        int scrollStart= scrollHeightStart.intValue();
        Double scrollHeightEnd= size.getHeight()*0.2;
        int scrollEnd= scrollHeightEnd.intValue();
        new TouchAction(driver).press(PointOption.point(0,scrollStart)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(0,scrollEnd)).release().perform();
    }
    public static void scrollAndClick(List<MobileElement> l){
        while (l.size()==0){
            scrollDown();
        }
        if(l.size()>0){
            l.get(0).click();
        }
    }
    public static String scrollAndGetText(List<MobileElement> l){
        String s="";
        while (l.size()==0){
            scrollDown();
        }
        if(l.size()>0){
            s= l.get(0).getText();
        }
        return s;
    }
    public boolean scrollAndSearch(List<MobileElement> l){
        boolean b= false;
        while(l.size()==0){
            scrollDown();
        }
        if(l.size()>0){
            b=l.get(0).isDisplayed();
        }
        return b;
    }
    public static void loopAndClick(List<MobileElement> mobileElements,String reqString){
        for(MobileElement element:mobileElements){
            if(element.getText().equalsIgnoreCase(reqString)){
                waitFor(element);
                element.click();
                break;
            }
        }
    }
    public void screenshot(String path_screenshot,String testCaseName) throws IOException {
        File srcFile=driver.getScreenshotAs(OutputType.FILE);
        File targetFile=new File(path_screenshot + testCaseName +".jpg");
        FileUtils.copyFile(srcFile,targetFile);
    }
    public void restart(){
        try {
            driver.runAppInBackground(Duration.ofSeconds(5));
            ((StartsActivity)driver).currentActivity();
        }
        catch (Exception e){
            System.out.println("Class Cast Exception");
        }

    }
    public static void wifiOff() throws InterruptedException {
        ConnectionState state= driver.setConnection(new ConnectionStateBuilder().withWiFiDisabled().build());
        Assert.assertFalse(state.isWiFiEnabled());
    }
    public static void wifiOn() throws InterruptedException {
        ConnectionState state= driver.setConnection(new ConnectionStateBuilder().withWiFiEnabled().build());
        Assert.assertTrue(state.isWiFiEnabled());
    }
}
