package Pages;

import Constants.Constants;
import configurations.Base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ExamPage extends Base {
    public ExamPage(){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    @AndroidFindBy(id = "com.stooltool:id/weight_text") private MobileElement inputWeight;
    @AndroidFindBy(id = "com.stooltool:id/muac_text") private MobileElement inputMuac;
    @AndroidFindBy(id = "com.stooltool:id/discharge_weight_none") private MobileElement weightNone;
    @AndroidFindBy(id = "com.stooltool:id/muac_none") private MobileElement muacNone;
    @AndroidFindBy(id = "com.stooltool:id/assessment_weight_unit_kg") private MobileElement weightUnitKg;
    @AndroidFindBy(id = "com.stooltool:id/assessment_weight_unit_lb") private MobileElement weightUnitLb;
    @AndroidFindBy(id = "com.stooltool:id/muac_unit_mm") private MobileElement muacUnitMm;
    @AndroidFindBy(id = "com.stooltool:id/muac_unit_cm") private MobileElement muacUnitCm;
    @AndroidFindAll(@AndroidBy(id = "com.stooltool:id/general_condition_spinner")) private List<MobileElement> generalConditionSpinners;
    @AndroidFindBy(id = "com.stooltool:id/eyes_spinner") private MobileElement eyeConditionSpinner;
    @AndroidFindAll(@AndroidBy(id = "com.stooltool:id/eyes_spinner")) private List<MobileElement> eyeConditionSpinners;
    @AndroidFindBy(id = "com.stooltool:id/thirst_spinner") private MobileElement thirstConditionSpinner;
    @AndroidFindAll(@AndroidBy(id = "com.stooltool:id/thirst_spinner")) private List<MobileElement> thirstConditionSpinners;
    @AndroidFindBy(id = "com.stooltool:id/skin_pinch_spinner") private MobileElement skinPinchConditionSpinner;
    @AndroidFindAll(@AndroidBy(id = "com.stooltool:id/skin_pinch_spinner")) private List<MobileElement> skinPinchConditionSpinners;
    @AndroidFindAll(@AndroidBy(id="android:id/text1")) private List<MobileElement> dehydrationDropDownValues;
    @AndroidFindAll(@AndroidBy(id="com.stooltool:id/eye_spinner_text")) private List<MobileElement> eyeDropDownValues;
    @AndroidFindBy(id = "com.stooltool:id/tears_spinner") private List<MobileElement> tearsSpinner;
    @AndroidFindBy(id = "com.stooltool:id/respiration_spinner") private List<MobileElement> respirationsSpinner;
    @AndroidFindBy(id = "com.stooltool:id/additional_findings_radial_pulse_spinner") private List<MobileElement> radialPulseSpinner;
    @AndroidFindBy(id = "com.stooltool:id/urinated_spinner") private List<MobileElement> urineSpinner;
    @AndroidFindBys({@AndroidBy(id = "com.stooltool:id/temperature_radio"),@AndroidBy(id = "com.stooltool:id/radio_layout_btn_yes")}) private List<MobileElement> lowTemp;
    @AndroidFindBys({@AndroidBy(id = "com.stooltool:id/temperature_radio"),@AndroidBy(id = "com.stooltool:id/radio_layout_btn_no")}) private List<MobileElement> normalTemp;
    @AndroidFindBys({@AndroidBy(id = "com.stooltool:id/temperature_radio"),@AndroidBy(id = "com.stooltool:id/radio_layout_btn_third")}) private List<MobileElement> highTemp;
    @AndroidFindBys({@AndroidBy(id = "com.stooltool:id/fast_breathing_radio"),@AndroidBy(id = "com.stooltool:id/radio_layout_btn_yes")}) private List<MobileElement> fastBreathingYes;
    @AndroidFindBys({@AndroidBy(id = "com.stooltool:id/fast_breathing_radio"),@AndroidBy(id = "com.stooltool:id/radio_layout_btn_no")}) private List<MobileElement> fastBreathingNo;
    @AndroidFindBys({@AndroidBy(id = "com.stooltool:id/unable_to_drink_radio"),@AndroidBy(id = "com.stooltool:id/radio_layout_btn_yes")}) private List<MobileElement> vomitingYes;
    @AndroidFindBys({@AndroidBy(id = "com.stooltool:id/unable_to_drink_radio"),@AndroidBy(id = "com.stooltool:id/radio_layout_btn_no")}) private List<MobileElement> vomitingNo;
    @AndroidFindBys({@AndroidBy(id = "com.stooltool:id/convulsions_radio"),@AndroidBy(id = "com.stooltool:id/radio_layout_btn_yes")}) private List<MobileElement> convulsionsYes;
    @AndroidFindBys({@AndroidBy(id = "com.stooltool:id/convulsions_radio"),@AndroidBy(id = "com.stooltool:id/radio_layout_btn_no")}) private List<MobileElement> convulsionsNo;

    public void setWeight(String weight,String weightUnit){
        if(weight.equalsIgnoreCase("None")){
            try {
                weightNone.click();
            }
            catch (Exception e){
                System.out.println("None weight isn't accepted");
            }
        }
        else {
            if(weightUnit.equalsIgnoreCase("kg")){
                weightUnitKg.click();
            }
            else{
                weightUnitLb.click();
            }
            inputWeight.sendKeys(weight);
        }
    }
    public void setMuac(String muac,String muacUnit,String age){
        if(Integer.parseInt(age)>4){
            if(muac.equalsIgnoreCase("None")){
                muacNone.click();
            }
            else {
                if(muacUnit.equalsIgnoreCase("mm")){
                    muacUnitMm.click();
                }
                else{
                    muacUnitCm.click();
                }
                inputWeight.sendKeys(muac);
            }
        }
        else{
            System.out.println("No MUAC for this age");
        }
    }
    public boolean getDehydrationAssessment(String condition){
        for(MobileElement val:dehydrationDropDownValues){
            System.out.println(val.getText());
            if(val.getText().equalsIgnoreCase(condition)){
                return val.isDisplayed();
            }
        }
        return false;
    }
    public boolean getEyeValue(String condition){
        for (MobileElement val:eyeDropDownValues){
            System.out.println(val.getText());
            if(val.getText().equalsIgnoreCase(condition)){
                return val.isDisplayed();
            }
        }
        return false;
    }
    public void setGeneralCondition(String condition) throws InterruptedException {
        scrollAndClick(generalConditionSpinners);
        loopAndClick(dehydrationDropDownValues,condition);
        Thread.sleep(1500);
    }
    public void setEyes(String condition) throws InterruptedException {
        scrollAndClick(eyeConditionSpinners);
        Thread.sleep(1500);
        try{
            for(MobileElement val:eyeDropDownValues){
                if(val.getText().equalsIgnoreCase(condition))
                    val.click();
            }
        }
        catch (Exception e){
            System.out.println("No EYES ?");
        }

    }
    public void setThirst(String condition) throws InterruptedException {
        scrollAndClick(thirstConditionSpinners);
        loopAndClick(dehydrationDropDownValues,condition);
        Thread.sleep(1500);
    }
    public void setSkinPinch(String condition) throws InterruptedException {
        scrollAndClick(skinPinchConditionSpinners);
        loopAndClick(dehydrationDropDownValues,condition);
    }
    public void setTemperature(String temp){
        switch (temp){
            case Constants.LOW_TEMP:
                scrollAndClick(lowTemp);
                break;
            case Constants.MED_TEMP:
                scrollAndClick(normalTemp);
                break;
            case Constants.HIGH_TEMP:
                scrollAndClick(highTemp);
                break;
        }
    }
    public void setFastBreathing(String value){
        if(value.equalsIgnoreCase("yes")){
            scrollAndClick(fastBreathingYes);
        }
        else{
            scrollAndClick(fastBreathingNo);
        }
    }
    public void setVomiting(String value){
        if(value.equalsIgnoreCase("yes")){
            scrollAndClick(vomitingYes);
        }
        else {
            scrollAndClick(vomitingNo);
        }
    }
    public void setConvulsions(String value){
        if(value.equalsIgnoreCase("yes")){
            scrollAndClick(convulsionsYes);
        }
        else {
            scrollAndClick(convulsionsNo);
        }
    }
    public void setTears(String tears,String age){
        if(Integer.parseInt(age)<5){
            scrollAndClick(tearsSpinner);
            loopAndClick(dehydrationDropDownValues,tears);
        }
        else{
            System.out.println("Not collecting data");
        }
    }
    public void setRespirations(String respirations){
        scrollAndClick(respirationsSpinner);
        loopAndClick(dehydrationDropDownValues,respirations);
    }
    public void setRadialPulse(String radialPulse){
        scrollAndClick(radialPulseSpinner);
        loopAndClick(dehydrationDropDownValues,radialPulse);
    }
    public void setUrine(String urine,String age){
        if(Integer.parseInt(age)>4){
            scrollAndClick(urineSpinner);
            loopAndClick(dehydrationDropDownValues,urine);
        }
        else {
            System.out.println("Not collecting data");
        }

    }

}
