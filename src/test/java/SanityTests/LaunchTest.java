package SanityTests;

import Pages.LaunchPage;
import Pages.SettingsPage;
import com.aventstack.extentreports.Status;
import configurations.Base;
import configurations.CustomTestListener;
import configurations.Mappings;
import org.testng.Assert;
import org.testng.annotations.*;
import testData.LaunchData;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;

import static Constants.Constants.*;

@Listeners(CustomTestListener.class)
public class LaunchTest extends Base {
    Mappings mappings;
    LaunchPage launchPage;
    SettingsPage settingsPage;
    @Parameters({"udid","systemPort"})
    @BeforeMethod
    public void setup(String par1,String par2) throws MalformedURLException {
        System.out.println("Launching the app");
    }

    @Test(dataProvider = "launchData",dataProviderClass = LaunchData.class)
    public void test1(Map<Object,Object> launchData) throws InterruptedException, IOException {
        launchPage= new LaunchPage();
        mappings = new Mappings();
        settingsPage= new SettingsPage();
        test1 = extent.createTest("MyFirstTest", "Sample description");
        Assert.assertEquals(launchPage.languagePopUpDisplayed(),true);
        launchPage.chooseLanguage((String) launchData.get("Language"));
        test1.log(Status.INFO, "This step shows app has launched)");
        launchPage.clickConfirm();
        launchPage.acceptTerms();
        Assert.assertTrue(launchPage.progress());
        Assert.assertEquals(launchPage.getPopupHeader(),COUNTRY_HEADER);
        test1.log(Status.INFO, "This step shows we're at launch menu)");
        launchPage.setCountry((String) launchData.get("Country"));
        Assert.assertEquals(launchPage.getPopupHeader(),DISEASE_HEADER);
        test1.log(Status.FAIL,"Disease Header");
        launchPage.proceed();
        Assert.assertEquals(launchPage.getPopupHeader(),PURPOSE_HEADER);
        launchPage.setValue((String) launchData.get("Purpose"));
        Assert.assertTrue(launchPage.getSelectedOption((String) launchData.get("Purpose")));
        launchPage.proceed();
        launchPage.manageEMRPurpose((String) launchData.get("EMR"), (String) launchData.get("Purpose"));
        Assert.assertEquals(launchPage.getPopupHeader(),WATERY_DIARRHOEA_HEADER);
        Assert.assertTrue(launchPage.getSelectedOption(mappings.getWateryAntibiotic((String) launchData.get("Country"))));
        launchPage.proceed();
        Assert.assertEquals(launchPage.getPopupHeader(),BLOODY_DIARRHOEA_HEADER);
        Assert.assertTrue(launchPage.getSelectedOption(mappings.getBloodyAntibiotic((String) launchData.get("Country"))));
        launchPage.proceed();
        Assert.assertEquals(launchPage.getPopupHeader(),MALNUTRITION_HEADER);
        launchPage.setValue((String) launchData.get("Malnutrition_Decision"));
        launchPage.proceed();
        Assert.assertEquals(launchPage.getPopupHeader(),THANK_YOU_HEADER);
        launchPage.proceed();
        Assert.assertTrue(launchPage.verifyEmrNavigation((String) launchData.get("Purpose")));
        //Issues with finding the right element,"Reset to defaults" button is clicked instead of other elements as it stays in focus and is overshadowing other elements.
//        settingsPage.goToSettings();
//        settingsPage.verifyMalnutritionGuide((String) launchData.get("Malnutrition_Decision"));
//        settingsPage.verifyLaunchAntibiotics(mappings.getWateryAntibiotic((String) launchData.get("Country")),mappings.getBloodyAntibiotic((String) launchData.get("Country")));
//        settingsPage.verifyEmrPurposeFromLaunch((String) launchData.get("EMR"),(String) launchData.get("Purpose"));
    }
    @AfterMethod
    public void quit(){
        driver.resetApp();
    }
}
