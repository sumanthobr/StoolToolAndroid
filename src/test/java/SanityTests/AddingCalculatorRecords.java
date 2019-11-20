package SanityTests;


import Pages.InputPage;
import Pages.LaunchPage;
import Pages.OutputPage;
import Pages.SettingsPage;
import configurations.Base;
import configurations.CustomTestListener;
import configurations.Mappings;
import org.testng.Assert;
import org.testng.annotations.*;
import testData.ReadJsonData;

import java.net.MalformedURLException;

import static Constants.Constants.*;
import static Constants.InputTestConstants.*;
import static Constants.InputTestConstants.INPUT_COUNTRY;

@Listeners(CustomTestListener.class)
public class AddingCalculatorRecords extends Base {
    Mappings mappings;
    LaunchPage launchPage;
    SettingsPage settingsPage;
    InputPage inputPage;
    OutputPage outputPage;
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
        launchPage.setCountry(INPUT_COUNTRY);
        Assert.assertEquals(launchPage.getPopupHeader(),DISEASE_HEADER);
        launchPage.proceed();
        Assert.assertEquals(launchPage.getPopupHeader(),PURPOSE_HEADER);
        launchPage.setValue(CALCULATOR_ONLY);
        Assert.assertTrue(launchPage.getSelectedOption(CALCULATOR_ONLY));
        launchPage.proceed();
        Assert.assertEquals(launchPage.getPopupHeader(),WATERY_DIARRHOEA_HEADER);
        Assert.assertTrue(launchPage.getSelectedOption(mappings.getWateryAntibiotic(INPUT_COUNTRY)));
        launchPage.proceed();
        Assert.assertTrue(launchPage.getSelectedOption(mappings.getBloodyAntibiotic(INPUT_COUNTRY)));
        launchPage.proceed();
        Assert.assertEquals(launchPage.getPopupHeader(),MALNUTRITION_HEADER);
        launchPage.proceed();
        Assert.assertEquals(launchPage.getPopupHeader(),THANK_YOU_HEADER);
        launchPage.proceed();
    }
    @Test(dataProvider = "inputDetails",dataProviderClass = ReadJsonData.class)
    public void input(String ageYear, String ageMonth, String gender, String isPregnant, String wateryStool, String bloodyStool,
                      String generalCondition, String eyes, String thirst, String skinPinch, String isAllergic, String allergy, String optionalAllergy,
                      String temp, String fastBreathing, String vomiting, String convulsions) throws InterruptedException {
        inputPage= new InputPage();
        outputPage= new OutputPage();
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
        Assert.assertEquals(outputPage.getHeaderTitle(),OUTPUT_HEADER);
        System.out.println(outputPage.getOutputAge());
        Assert.assertEquals(outputPage.getGender(),gender);
        System.out.println(inputPage.getWeight());
        String dehydrationStatus=outputPage.getDehydrationStatus();
        Assert.assertEquals(outputPage.verifyFirstFluidType(outputPage.getDehydrationStatus()),mappings.getFluidType(outputPage.getDehydrationStatus()));
        System.out.println(outputPage.getFirstFluidVolume());
        Assert.assertEquals(outputPage.getFirstFluidDuration(),outputPage.verifyFirstFluidTime(outputPage.getDehydrationStatus()));
        Assert.assertEquals(outputPage.verifySecondFluidType(outputPage.getDehydrationStatus()),mappings.getFluidType(outputPage.getDehydrationStatus()));
        System.out.println(outputPage.getSecondFluidVolume(outputPage.getDehydrationStatus()));
        Assert.assertEquals(outputPage.getSecondFluidDuration(outputPage.getDehydrationStatus()),outputPage.getSecondFluidDuration(outputPage.getDehydrationStatus()));
        Assert.assertTrue(outputPage.verifyTemperature(temp));
        Assert.assertTrue(outputPage.verifyConvulsions(convulsions));
        Assert.assertTrue(outputPage.verifyFastBreathing(fastBreathing));
        Assert.assertTrue(outputPage.verifyBloodinStool(bloodyStool));
        Assert.assertEquals(outputPage.getFirstAntibiotic(),mappings.verifyPrimaryAntibiotic(ageYear,dehydrationStatus,wateryStool,bloodyStool,INPUT_COUNTRY));
    }
    @AfterMethod
    public void done(){
        System.out.println("Done");
        driver.resetApp();
    }
    @AfterTest
    public void quit(){
        tearDown();
    }
}
