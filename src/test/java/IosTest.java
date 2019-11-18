import io.appium.java_client.ios.IOSDriver;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class IosTest {
    private IOSDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        File dir = new File("/Users/saritagidwani/Documents/testfolder");
        File app = new File(dir,"OutbreakResponder.ipa");
        capabilities.setCapability("app",app.getAbsolutePath());
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", "12.4.1");
        capabilities.setCapability("deviceName", "iPhone 6");
        capabilities.setCapability("udid", "b0a4c2e67561e530b63aa7968802f63c7ab701c4");
        capabilities.setCapability("bundleId", "com.stooltool.OutbreakResponder");
        capabilities.setCapability("xcodeOrgId", "7N24A8GXPA");
        capabilities.setCapability("xcodeSigningId", "iPhone Developer");
        capabilities.setCapability("automationName","XCUITest");
        driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testFindingAnElement() {
        System.out.println("hyshkj");
    }
}
