package Tests;

import Pages.LaunchPage;
import Pages.SettingsPage;
import configurations.Base;
import configurations.Mappings;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SettingsTest extends Base {
    Mappings mappings;
    LaunchPage launchPage;
    SettingsPage settingsPage;
    List<String> settingsSections= new ArrayList<>(Arrays.asList( "Assessment", "Antibiotics", "Account","Advanced"));

    @BeforeMethod
    public void setup() throws IOException, InterruptedException {
//        setUp();
        launchPage= new LaunchPage();
        mappings = new Mappings();
        Assert.assertEquals(launchPage.languagePopUpDisplayed(),true);
        launchPage.chooseLanguage("english");
        launchPage.clickConfirm();
        launchPage.acceptTerms();
        Assert.assertTrue(launchPage.progress());
        Assert.assertEquals(launchPage.getPopupHeader(),"Country");
        launchPage.setCountry("Other");
        launchPage.proceed();
        Assert.assertEquals(launchPage.getPopupHeader(),"Disease");
        launchPage.proceed();
        Assert.assertEquals(launchPage.getPopupHeader(),"Purpose");
        Assert.assertEquals(launchPage.getSelectedOption("Rehydration calculator (only)"),"true");
        launchPage.setValue("Rehydration calculator (only)");
        Assert.assertEquals(launchPage.getSelectedOption("Rehydration calculator (only)"),"true");
        launchPage.proceed();
        launchPage.manageEMRPurpose("Data collection (only)","");
        Assert.assertEquals(launchPage.getPopupHeader(),"Antibiotics for Acute Watery Diarrhoea");
        Assert.assertEquals(launchPage.getSelectedOption(mappings.getWateryAntibiotic("Other")),"true");
        launchPage.proceed();
        Assert.assertEquals(launchPage.getPopupHeader(),"Confirm the antibiotic for \n" +
                " bloody diarrhoea");
        Assert.assertEquals(launchPage.getSelectedOption(mappings.getBloodyAntibiotic("Other")),"true");
        launchPage.proceed();
        Assert.assertEquals(launchPage.getPopupHeader(),"Will you treat Diarrhoea with Severe Malnutrition");
        Assert.assertEquals(launchPage.getSelectedOption("No: Requires referral to specialist"),"true");
        launchPage.proceed();
        Assert.assertEquals(launchPage.getPopupHeader(),"Thank you");
        launchPage.proceed();
        Assert.assertTrue(launchPage.verifyEmrNavigation("Rehydration calculator (only)"));
        settingsPage= new SettingsPage();
        settingsPage.openSideNav();
        settingsPage.openSettings();
    }
    @Ignore
    public void verifyLockFeature() throws InterruptedException {
        settingsPage.openAssessment();
        Assert.assertEquals(settingsPage.settingsEnabled("normal"),"false");
        settingsPage.clickLockIcon();
        Assert.assertEquals(settingsPage.settingsEnabled("normal"),"true");
    }
    @Test(priority = 1)
    public void verifyDefaultValues() throws InterruptedException {
        settingsPage.clickLockIcon();
        settingsPage.openAssessment();
        Assert.assertEquals(settingsPage.getDefaultWeightEstimate(), mappings.getCountryWeightEstimate("Other"));
//        Assert.assertEquals(settingsPage.getAssessmentValue(), "WHO Method");
        Assert.assertEquals(settingsPage.getGuideCalcValue(), "Required on calculator");
        Assert.assertEquals(settingsPage.getDefaultGuideFull(), "Required on full platform");
        Assert.assertEquals(settingsPage.getMalGuideCalcValue(), "Off (calculator)");
        Assert.assertEquals(settingsPage.getDefaultMalFull(), "Off (full platform)");
        settingsPage.openAntibiotics();
        scroll((AndroidDriver) driver, 0.80, 0.20, 2000);
        Assert.assertEquals(settingsPage.getDefaultWateryAntibiotic(), mappings.getWateryAntibiotic("Other"));
        Assert.assertEquals(settingsPage.getDefaultBloodyAntibiotic(), mappings.getBloodyAntibiotic("Other"));
        scroll((AndroidDriver) driver, 0.80, 0.20, 2000);
        settingsPage.openAccount();
        Assert.assertEquals(settingsPage.getDefaultLanguage(), "English");
        scroll((AndroidDriver) driver, 0.80, 0.20, 2000);
        settingsPage.openAdvanced();
        scroll((AndroidDriver) driver, 0.80, 0.20, 2000);
        Assert.assertEquals(settingsPage.verifyAdditionalFindingsOn(), "true");
        Assert.assertEquals(settingsPage.verifyDischargeNotificationsOn(), "true");
        Assert.assertEquals(settingsPage.verifyDischargeEducationMaterialsOn(), "false");
        Assert.assertEquals(settingsPage.verifyInPatientNotificationsOn(), "false");
        Assert.assertEquals(settingsPage.verifyFingerprintRecordingOn(), "false");
        Assert.assertEquals(settingsPage.verifyMapItOn(), "false");
        Assert.assertEquals(settingsPage.verifyRecordSortingMethod(), "true");
        Assert.assertEquals(settingsPage.verifyStockOutOn(), "false");
    }
    @Test(priority = 2)
    public void verifyResetDefaultsFeature() throws InterruptedException {
        Assert.assertEquals(settingsPage.resetDefaultsEnabled(),"false");
        settingsPage.clickLockIcon();
        Assert.assertEquals(settingsPage.resetDefaultsEnabled(),"true");
        settingsPage.clickResetDefaultsbutton();
        Assert.assertTrue(settingsPage.defaultSettingDialog());
        settingsPage.setCountry("Bangladesh");
        settingsPage.setSaveResetDefaults();
        settingsPage.openAntibiotics();
        Assert.assertEquals(settingsPage.getDefaultWateryAntibiotic(), mappings.getWateryAntibiotic("Bangladesh"));
        Assert.assertEquals(settingsPage.getDefaultBloodyAntibiotic(), mappings.getBloodyAntibiotic("Bangladesh"));
    }
    @AfterMethod
    public void quit(){
        tearDown();
    }
}
