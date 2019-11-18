package Pages;

import configurations.Base;
import Constants.Constants;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static Constants.Constants.*;

public class SettingsPage extends Base {
    @AndroidFindBy(id = "android:id/action_bar_title") public MobileElement sideNavIcon;
    @AndroidFindBy(id = "android:id/action_bar_title") public MobileElement sideNavTitle;
    @AndroidFindBys({@AndroidBy(id = "com.stooltool:id/navigation_drawer"),@AndroidBy(id = "android:id/text1")}) public List<MobileElement> sideNavSections;
    @AndroidFindBy(id = "com.stooltool:id/assessment_accordion") public List<MobileElement> assessmentAccordion;
    @AndroidFindBy(id = "com.stooltool:id/assessment_info") public MobileElement assessmentInfo;
    @AndroidFindBy(id = "com.stooltool:id/antibiotics_info") public MobileElement antibioticsInfo;
    @AndroidFindBy(id = "com.stooltool:id/antibiotics_accordion") public List<MobileElement> antibioticsAccordion;
    @AndroidFindBy(id = "com.stooltool:id/language_accordion") public List<MobileElement> accountAccordion;
    @AndroidFindBy(id = "com.stooltool:id/advanced_settings_accordion") public List<MobileElement> advancedAccordion;
    @AndroidFindAll(@AndroidBy(id = "com.stooltool:id/heading_text")) public List<MobileElement> settingsSections;
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='lock']") public MobileElement lockIcon;
    @AndroidFindBy(accessibility = "lock") public MobileElement lock;
    @AndroidFindBy(id = "com.stooltool:id/navigation_drawer") public MobileElement navDrawer;
    @AndroidFindAll(@AndroidBy(className = "android.widget.Spinner")) public List<MobileElement> settingsDropDowns;
    @AndroidFindAll(@AndroidBy(className = "android.widget.RadioButton")) public List<MobileElement> radioButtons;
    @AndroidFindAll(@AndroidBy(id = "android:id/text1")) public List<MobileElement> valuesOf;
    @AndroidFindBys({
            @AndroidBy(id = "com.stooltool:id/settings_weight_estimates"),
            @AndroidBy(id = "android:id/text1")
    }) public MobileElement weightDropDown;
    @AndroidFindBys({
            @AndroidBy(id = "com.stooltool:id/settings_dehy_assessment_method"),
            @AndroidBy(id = "android:id/text1")
    }) public MobileElement dehydrationAssessmentDropdown;
    @AndroidFindBys({
            @AndroidBy(id = "com.stooltool:id/settings_dehy_assessment_method"),
            @AndroidBy(id = "android:id/text1")
    }) public List<MobileElement> dehydrationAssessmentDropdownValues;
    @AndroidFindAll(@AndroidBy(id = "android:id/text1")) public List<MobileElement> settingsValues;
    @AndroidFindBy(id = "com.stooltool:id/settings_dehy_assessment_method")public MobileElement dehydrationAssessmentSpinner;
    @AndroidFindBy(id = "com.stooltool:id/dehydration_guide_cal") public MobileElement guideCalcSpinner;
    @AndroidFindBy(id = "com.stooltool:id/malnutrition_guide_cal") public MobileElement malCalcSpinner;
    @AndroidFindBys({
            @AndroidBy(id = "com.stooltool:id/dehydration_guide_cal"),
            @AndroidBy(id = "android:id/text1")
    }) public MobileElement guideCalcValue;
    @AndroidFindBys({
            @AndroidBy(id = "com.stooltool:id/dehydration_guide_full"),
            @AndroidBy(id = "android:id/text1")
    }) public MobileElement guideFullValue;
    @AndroidFindBys({
            @AndroidBy(id = "com.stooltool:id/malnutrition_guide_cal"),
            @AndroidBy(id = "android:id/text1")
    }) public MobileElement malCalcValue;
    @AndroidFindBys({
            @AndroidBy(id = "com.stooltool:id/malnutrition_guide_full"),
            @AndroidBy(id = "android:id/text1")
    }) public MobileElement malFullValue;
    @AndroidFindBys({
            @AndroidBy(id = "com.stooltool:id/drug_acute_watery_diarrhoea_choices"),
            @AndroidBy(id = "android:id/text1")
    }) public List<MobileElement> wateryAntibiotic;
    @AndroidFindBys({
            @AndroidBy(id = "com.stooltool:id/drug_bloody_diarrhoea_less_than_2_closed"),
            @AndroidBy(id = "android:id/text1")
    }) public List<MobileElement> bloodyAntibiotic;
    @AndroidFindBys({
            @AndroidBy(id = "com.stooltool:id/app_language_settings"),
            @AndroidBy(id = "android:id/text1")
    }) public MobileElement appLanguage;
    @AndroidFindBy(id = "com.stooltool:id/additional_findings_on") public MobileElement additionalFindingsOn;
    @AndroidFindBy(id = "com.stooltool:id/additional_findings_off") public MobileElement additionalFindingsOff;
    @AndroidFindBy(id = "com.stooltool:id/additional_findings_on") public MobileElement dischargeNotificationsOn;
    @AndroidFindBy(id = "com.stooltool:id/additional_findings_off") public MobileElement dischargeNotificationsOff;
    @AndroidFindBy(id = "com.stooltool:id/edu_mat_radio_1") public MobileElement dischargeEducationMaterialsOn;
    @AndroidFindBy(id = "com.stooltool:id/edu_mat_radio_2") public MobileElement dischargeEducationMaterialsOff;
    @AndroidFindBy(id = "com.stooltool:id/fingerprint_nudges_yes") public MobileElement fingerprintRecordingOn;
    @AndroidFindBy(id = "com.stooltool:id/fingerprint_nudges_no") public MobileElement fingerprintRecordingOff;
    @AndroidFindBy(id = "com.stooltool:id/inpatient_nudges_yes") public MobileElement inpatientNotificationsOn;
    @AndroidFindBy(id = "com.stooltool:id/inpatient_nudges_no") public MobileElement inpatientNotificationsOff;
    @AndroidFindBy(id = "com.stooltool:id/map_it_on") public MobileElement mapItOn;
    @AndroidFindBy(id = "com.stooltool:id/map_it_off") public MobileElement mapItOff;
    @AndroidFindBy(id = "com.stooltool:id/stock_out_radio_1") public MobileElement stockOutOn;
    @AndroidFindBy(id = "com.stooltool:id/stock_out_radio_2") public MobileElement stockOutOff;
    @AndroidFindBy(id="com.stooltool:id/sorting_style_1") public MobileElement sortById;
    @AndroidFindBy(id="com.stooltool:id/sorting_style_3") public MobileElement sortBySeverity;
    @AndroidFindBy(id="com.stooltool:id/sorting_style_2") public MobileElement sortByTime;
    @AndroidFindBy(id = "com.stooltool:id/reset_defaults") public MobileElement resetToDefaultsBtn;
    @AndroidFindBy(id = "com.stooltool:id/iv_input_header") public MobileElement resetDefaultsHeader;
    @AndroidFindBy(id = "com.stooltool:id/settings_global") public MobileElement globalRadiobutton;
    @AndroidFindBy(id = "com.stooltool:id/settings_bangladesh") public MobileElement bangladeshRadiobutton;
    @AndroidFindBy(id = "com.stooltool:id/settings_haiti") public MobileElement haitiRadiobutton;
    @AndroidFindBy(id = "com.stooltool:id/reset_button") public MobileElement saveResetDefaults;
    @AndroidFindBy(id = "com.stooltool:id/drug_acute_watery_diarrhoea_choices") public List<MobileElement> wateryDiarrhoeaSpinner;
    @AndroidFindBy(id = "com.stooltool:id/drug_bloody_diarrhoea_less_than_2_closed") public List<MobileElement> bloodyDiarrhoeaSpinner;
    @AndroidFindBys({@AndroidBy(id = "com.stooltool:id/radio_group_purpose"),@AndroidBy(id = "com.stooltool:id/purpose_radio_1")}) List<MobileElement> calcOnly;
    @AndroidFindBys({@AndroidBy(id = "com.stooltool:id/radio_group_purpose"),@AndroidBy(id = "com.stooltool:id/purpose_radio_2")}) List<MobileElement> emrOnly;
    @AndroidFindBys({@AndroidBy(id = "com.stooltool:id/radio_group_purpose"),@AndroidBy(id = "com.stooltool:id/purpose_radio_3")}) List<MobileElement> emrAndCalc;
    @AndroidFindBys({@AndroidBy(id = "com.stooltool:id/platform_mode_layout"),@AndroidBy(id = "com.stooltool:id/purpose_radio_1")}) List<MobileElement> dataAndManagement;
    @AndroidFindBys({@AndroidBy(id = "com.stooltool:id/platform_mode_layout"),@AndroidBy(id = "com.stooltool:id/purpose_radio_2")}) List<MobileElement> dataCollectionOnly;
    public SettingsPage(){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    public void openSideNav(){
        waitFor(sideNavIcon);
        sideNavIcon.click();
    }
    public void openSettings(){
        try {
            for (MobileElement ele : sideNavSections) {
                if (ele.getText().equalsIgnoreCase("Settings")) {
                    waitFor(ele);
                    ele.click();
                }
            }
        }
        catch (Exception e){
            System.out.println("Settings Exception");
        }
    }
    public String sideNavTitle(){
        waitFor(sideNavTitle);
        return sideNavTitle.getText();
    }
    public List<String> getSettingSections(){
        List<String> sectionsList=new ArrayList<>();
        for (MobileElement ele:settingsSections) {
            sectionsList.add(ele.getText());
        }
        System.out.println(sectionsList);
        return sectionsList;
    }
    public void openAssessment(){
        scrollAndClick(assessmentAccordion);
    }
    public boolean assessmentInfoDisplayed(){
        waitFor(assessmentInfo);
        return assessmentInfo.isDisplayed();
    }
    public void openAntibiotics(){
        scrollDown();
        scrollAndClick(antibioticsAccordion);
    }
    public boolean antibioticInfoDisplayed(){
        waitFor(antibioticsInfo);
        return antibioticsInfo.isDisplayed();
    }
    public void openAccount(){
        scrollAndClick(accountAccordion);
    }
    public void openAdvanced(){
        scrollDown();
        scrollAndClick(advancedAccordion);
    }
    public String settingsEnabled(String checkSettings) throws InterruptedException {
        String s= null;
        if(checkSettings.equalsIgnoreCase("normal")){
            for (MobileElement ele : settingsDropDowns) {
                Thread.sleep(3000);
                s = ele.getAttribute("enabled");
            }
        }
        else if(checkSettings.equalsIgnoreCase("advanced")){
            for (MobileElement ele : radioButtons) {
                System.out.println(ele.isEnabled());
                Thread.sleep(3000);
                s= ele.getAttribute("enabled");
            }
        }
        return s;
    }
    public void clickLockIcon() {
        try{
            lock.click();
        }
        catch (Exception e){
            System.out.println("Not working");
            waitFor(lockIcon);
            lockIcon.click();
        }
    }
    public boolean sideMenuDisplayed(){
        waitFor(navDrawer);
        return navDrawer.isDisplayed();
    }
    public String getDefaultWeightEstimate(){
        waitFor(weightDropDown);
        return weightDropDown.getText();
    }
    public String getAssessmentValue(){
        try {
            return dehydrationAssessmentDropdown.getText();
        }
        catch (Exception e){
            System.out.println("click back");
            driver.navigate().back();
            return dehydrationAssessmentDropdown.getText();
        }
    }
    public void setSettingsSpinners(String value){
        try{
            for(MobileElement element:settingsValues){
                if(element.getText().equalsIgnoreCase(value)){
                    element.click();
                    break;
                }
            }
        }
        catch (Exception e){
            System.out.println("Unable to set settings vales?");
        }
    }
    public void reopenSettings(){
        driver.navigate().back();
        openSideNav();
        openSettings();
        clickLockIcon();
        openAssessment();
    }
    public void clickAssessmentSpinner(){
        waitFor(dehydrationAssessmentSpinner);
        dehydrationAssessmentSpinner.click();
    }
    public void setAssessment(String method) {
        if(method.equalsIgnoreCase(Constants.DHAKA)){
            setSettingsSpinners(Constants.DHAKA);
        }
        else {
            setSettingsSpinners(Constants.WHO);
        }
    }

    public String getGuideCalcValue(){
        waitFor(guideCalcValue);
        return guideCalcValue.getText();
    }
    public void clickGuideCalcSpinner(){
        waitFor(guideCalcSpinner);
        guideCalcSpinner.click();
    }
    public void setGuideCalc(String guide) {
        switch (guide){
            case Constants.OPTIONAL_CALC:
                setSettingsSpinners(Constants.OPTIONAL_CALC);
                break;
            case Constants.REQUIRED_CALC:
                setSettingsSpinners(Constants.REQUIRED_CALC);
                break;
        }
    }
    public String getDefaultGuideFull(){
        waitFor(guideFullValue);
        return guideFullValue.getText();
    }
    public String getMalGuideCalcValue(){
        waitFor(malCalcValue);
        return malCalcValue.getText();
    }
    public void clickMalGuideCalSpinner(){
        waitFor(malCalcSpinner);
        malCalcSpinner.click();
    }
    public void setMalGuideCal(String guide) {
        switch (guide){
            case Constants.MAL_OFF_CALC:
                setSettingsSpinners(Constants.MAL_OFF_CALC);
                break;
            case Constants.MAL_ON_CALC:
                setSettingsSpinners(Constants.MAL_ON_CALC);
                break;
        }
    }
    public String getDefaultMalFull(){
        waitFor(malFullValue);
        return malFullValue.getText();
    }
    public String getDefaultWateryAntibiotic(){
        return scrollAndGetText(wateryAntibiotic);
    }
    public String getDefaultBloodyAntibiotic(){
        return scrollAndGetText(bloodyAntibiotic);
    }
    public String getDefaultLanguage(){
        waitFor(appLanguage);
        return appLanguage.getText();
    }
    public String verifyAdvancedSettings(MobileElement ele){
        try {
            waitFor(ele);
            return ele.getAttribute("checked");
        }
        catch (Exception e){
            System.out.print("No element found...so sliding down");
            scroll((AndroidDriver) driver,0.80,0.20,2000);
            waitFor(ele);
            return ele.getAttribute("checked");
        }
    }
    public String verifyAdditionalFindingsOn(){
       return verifyAdvancedSettings(additionalFindingsOn);
    }
    public String verifyDischargeNotificationsOn(){
       return verifyAdvancedSettings(dischargeNotificationsOn);
    }
    public String verifyDischargeEducationMaterialsOn(){
       return verifyAdvancedSettings(dischargeEducationMaterialsOn);
    }
    public String verifyInPatientNotificationsOn(){
       return verifyAdvancedSettings(inpatientNotificationsOn);
    }
    public String verifyFingerprintRecordingOn(){
       return verifyAdvancedSettings(fingerprintRecordingOn);
    }
    public String verifyMapItOn(){
       return verifyAdvancedSettings(mapItOn);
    }
    public String verifyStockOutOn() throws InterruptedException {
        Thread.sleep(200);
       return verifyAdvancedSettings(stockOutOn);
    }
    public String verifyRecordSortingMethod(){
        return verifyAdvancedSettings(sortById);
    }
    public String resetDefaultsEnabled(){
        return resetToDefaultsBtn.getAttribute("enabled");
    }
    public void clickResetDefaultsbutton(){
        resetToDefaultsBtn.click();
    }
    public boolean defaultSettingDialog(){
        waitFor(resetDefaultsHeader);
        return resetDefaultsHeader.isDisplayed();
    }
    public void setCountry(String country){
        switch (country){
            case "Bangladesh":
                waitFor(bangladeshRadiobutton);
                bangladeshRadiobutton.click();
                break;
            case "Haiti":
                waitFor(haitiRadiobutton);
                haitiRadiobutton.click();
                break;
            default:
                waitFor(globalRadiobutton);
                globalRadiobutton.click();
        }
    }
    public void setSaveResetDefaults() throws InterruptedException {
        saveResetDefaults.click();
        Thread.sleep(3000);
    }
    public void clickAcuteWateryDiarrhoeaSpinner(){
        scrollAndClick(wateryDiarrhoeaSpinner);
    }
    public void setAcuteWateryDiarrhoeaAntibiotics(String wateryDrug){
        setSettingsSpinners(wateryDrug);
    }
    public void clickBloodyDiarrhoeaSpinner(){
        scrollAndClick(bloodyDiarrhoeaSpinner);
    }
    public void setBloodyDiarrhoeaAntibiotics(String bloodyDrug){
        setSettingsSpinners(bloodyDrug);
    }
    public void verifyMalnutritionGuide(String malDec){
        openAssessment();
        if(malDec.equalsIgnoreCase("Yes: Requires experienced staff")){
            Assert.assertEquals(getMalGuideCalcValue(), "Required on calculator");
            Assert.assertEquals(getDefaultMalFull(), "Required on full platform");
        }
        else{
            Assert.assertEquals(getMalGuideCalcValue(), "Off (calculator)");
            Assert.assertEquals(getDefaultMalFull(), "Off (full platform)");
        }
    }
    public void goToSettings(){
        openSideNav();
        openSettings();
        clickLockIcon();
    }
    public void verifyLaunchAntibiotics(String type,String type2){
        openAntibiotics();
        Assert.assertEquals(getDefaultWateryAntibiotic(),type);
        Assert.assertEquals(getDefaultBloodyAntibiotic(), type2);
    }
    public boolean getPurpose(String purpose){
        boolean b=false;
        switch (purpose){
            case CALC_ONLY:
                while (calcOnly.size()==0){
                    scrollDown();
                }
                if(calcOnly.size()>0){
                    b= calcOnly.get(0).getAttribute("checked").equalsIgnoreCase("true");
                }
                break;
            case CALC_AND_EMR:
                while (emrAndCalc.size()==0){
                    scrollDown();
                }
                if(emrAndCalc.size()>0){
                    b= emrAndCalc.get(0).getAttribute("checked").equalsIgnoreCase("true");
                }
                break;
            case EMR_ONLY:
                while (emrOnly.size()==0){
                    scrollDown();
                }
                if(emrOnly.size()>0){
                    b= emrOnly.get(0).getAttribute("checked").equalsIgnoreCase("true");
                }
                break;
        }

        return b;
    }
    public boolean getEmr(String Emr){
        boolean b=false;
        switch (Emr){
            case DATACOLLECTIONONLY:
                while(dataCollectionOnly.size()==0){
                    scrollDown();
                }
                if(dataCollectionOnly.size()>0){
                    b= dataCollectionOnly.get(0).getAttribute("checked").equalsIgnoreCase("true");
                }
                break;
            case DATAANDPATIENTMANAGEMENT:
                while(dataAndManagement.size()==0){
                    scrollDown();
                }
                if(dataAndManagement.size()>0){
                    b= dataAndManagement.get(0).getText().contains("patient");

                }
                break;
        }
        return b;
    }
    public void verifyEmrPurposeFromLaunch(String EMR,String purpose) throws InterruptedException {
        openAdvanced();
        scrollDown();
        Assert.assertTrue(getPurpose(purpose));
        scrollDown();
        Thread.sleep(3000);
        Assert.assertTrue(getEmr(EMR));
    }




}
