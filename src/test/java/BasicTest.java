import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasicTest {
    public static void main(String args[]) throws MalformedURLException, InterruptedException {
        AppiumDriver<MobileElement> driver;
        //Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Moto C plus");
        caps.setCapability("udid", "ZY3223QMKH"); //Give Device ID of your mobile phone
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "8.1.0");
        caps.setCapability("autoGrantPermissions",true);
//        caps.setCapability("automationName","UiAutomator2");
        File appDir=new File("/Users/saritagidwani/Documents/testfolder");
        File app= new File(appDir,"app-universal-debug-14-08-16-36.apk");
        caps.setCapability("app",app.getAbsolutePath());
        caps.setCapability("appPackage", "com.stooltool");
        caps.setCapability("appActivity", "com.stooltool.activities.SecretKeyActivity");
        driver= new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),caps);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElementById("com.stooltool:id/language_french_haiti").click();
        driver.findElementById("com.stooltool:id/btn_confirm").click();
        Thread.sleep(5000);
        List<MobileElement> buttons=driver.findElementsByClassName("android.widget.Button");
        for (MobileElement ele:
             buttons) {
            buttons.get(0).click();
        }
        driver.quit();
    }
}
