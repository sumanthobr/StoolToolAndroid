package SanityTests;


import Pages.InputPage;
import Pages.LaunchPage;
import Pages.SettingsPage;
import configurations.Base;
import configurations.CustomTestListener;
import configurations.Mappings;
import org.testng.Assert;
import org.testng.annotations.*;
import testData.InputDetails;

import java.net.MalformedURLException;

import static Constants.Constants.*;
import static Constants.InputTestConstants.*;

@Listeners(CustomTestListener.class)
public class InputTests extends Base {
    Mappings mappings;
    LaunchPage launchPage;
    SettingsPage settingsPage;
    InputPage inputPage;
    @Parameters({"udid","systemPort"})
    @BeforeTest(alwaysRun = true)
    public void setup(String par1,String par2) throws MalformedURLException, InterruptedException {
        appLaunch(par1,par2);
    }
    @BeforeMethod()
    public void launch() throws InterruptedException {
        launchPage= new LaunchPage();
        mappings = new Mappings();
        Assert.assertEquals(launchPage.languagePopUpDisplayed(),true);
        launchPage.clickConfirm();
        launchPage.acceptTerms();
        Assert.assertEquals(launchPage.getPopupHeader(),COUNTRY_HEADER);
        launchPage.setCountry(COUNTRY);
        Assert.assertEquals(launchPage.getPopupHeader(),DISEASE_HEADER);
        launchPage.proceed();
        Assert.assertEquals(launchPage.getPopupHeader(),PURPOSE_HEADER);
        launchPage.setValue(CALCULATOR_ONLY);
        Assert.assertTrue(launchPage.getSelectedOption(CALCULATOR_ONLY));
        launchPage.proceed();
        Assert.assertEquals(launchPage.getPopupHeader(),WATERY_DIARRHOEA_HEADER);
        Assert.assertTrue(launchPage.getSelectedOption(mappings.getWateryAntibiotic(COUNTRY)));
        launchPage.proceed();
        Assert.assertTrue(launchPage.getSelectedOption(mappings.getBloodyAntibiotic(COUNTRY)));
        launchPage.proceed();
        Assert.assertEquals(launchPage.getPopupHeader(),MALNUTRITION_HEADER);
        launchPage.proceed();
        Assert.assertEquals(launchPage.getPopupHeader(),THANK_YOU_HEADER);
        launchPage.proceed();
    }
    @Test(dataProvider = "details",dataProviderClass = InputDetails.class)
    public void input(String ageYear,String ageMonth,String gender,String isPregnant,String wateryStool,String bloodyStool,
                      String generalCondition,String eyes,String thirst,String skinPinch,String isAllergic,String allergy,String optionalAllergy,
                      String temp,String fastBreathing,String vomiting,String convulsions) throws InterruptedException {
        inputPage= new InputPage();
        inputPage.setAge(ageYear,ageMonth);
        Assert.assertEquals(inputPage.getAgeEntered(),ageYear);
        inputPage.setGender(gender);
        Assert.assertTrue(inputPage.weightDisplayed());
        Assert.assertEquals(inputPage.weightIndicator(),ESTIMATED_TEXT);
        System.out.println(inputPage.getWeightDisplayed());
        Assert.assertTrue(inputPage.pregnantPossibly());
        inputPage.setPregnant(isPregnant);
        Assert.assertTrue(inputPage.adjustWeightForPregnancy(isPregnant));
        Assert.assertTrue(inputPage.chiefComplaintTextDisplayed(ageYear));
        inputPage.setWateryStool(wateryStool);
        inputPage.setBloodyStool(bloodyStool);
        inputPage.setGeneralCondition(generalCondition);
        Assert.assertTrue(inputPage.getDehydrationAssessment(generalCondition));
        inputPage.setEyes2(eyes);
        Assert.assertTrue(inputPage.getEyeValue(eyes));
        inputPage.setThirst(thirst);
        Assert.assertTrue(inputPage.getDehydrationAssessment(thirst));
        inputPage.setSkinPinch(skinPinch);
        Assert.assertTrue(inputPage.getDehydrationAssessment(skinPinch));
        inputPage.setAllergy(isAllergic);
        Assert.assertTrue(inputPage.verifyAllergyMarked(isAllergic));
        inputPage.selectAllergy(allergy,isAllergic);
        Assert.assertTrue(inputPage.isAllergyChecked(isAllergic,allergy));
        inputPage.setOtherAllergy(optionalAllergy,allergy,isAllergic);
        inputPage.setTemperature(temp);
        inputPage.setFastBreathing(fastBreathing);
        inputPage.setVomiting(vomiting);
        inputPage.setConvulsions(convulsions);
        inputPage.clickCalcBtn();
        Assert.assertEquals(inputPage.getHeaderTitle(),OUTPUT_HEADER);
        System.out.println(inputPage.getOutputAge());
        Assert.assertEquals(inputPage.getGender(),gender);
//        Assert.assertEquals(inputPage.getWeight(),"13.1");
        System.out.println(inputPage.getDehydrationStatus());
        Assert.assertEquals(inputPage.verifyFirstFluidType(inputPage.getDehydrationStatus()),mappings.getFluidType(inputPage.getDehydrationStatus()));
        System.out.println(inputPage.getFirstFluidVolume());
        Assert.assertEquals(inputPage.getFirstFluidDuration(),inputPage.verifyFirstFluidTime(inputPage.getDehydrationStatus()));
        Assert.assertEquals(inputPage.verifySecondFluidType(inputPage.getDehydrationStatus()),mappings.getFluidType(inputPage.getDehydrationStatus()));
        System.out.println(inputPage.getSecondFluidVolume(inputPage.getDehydrationStatus()));
        Assert.assertEquals(inputPage.getSecondFluidDuration(inputPage.getDehydrationStatus()),inputPage.getSecondFluidDuration(inputPage.getDehydrationStatus()));
    }
    @Ignore
    public void verifyAntibiotics() throws InterruptedException {
        settingsPage= new SettingsPage();
        settingsPage.openSideNav();
        Thread.sleep(3000);
        settingsPage.openSettings();
        settingsPage.openAntibiotics();
        Assert.assertEquals(settingsPage.getDefaultWateryAntibiotic(), mappings.getWateryAntibiotic(COUNTRY));
        Assert.assertEquals(settingsPage.getDefaultBloodyAntibiotic(), mappings.getBloodyAntibiotic(COUNTRY));
    }
    @AfterMethod
    public void done(){
        System.out.println("Done");
        restart();
    }
    @AfterTest
    public void quit(){
        tearDown();
    }
}
