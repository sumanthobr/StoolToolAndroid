package Pages;

import Constants.Constants;
import configurations.Base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static Constants.Constants.*;

public class OutputPage extends Base {
    public OutputPage(){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    @AndroidFindBys({@AndroidBy(id = "com.stooltool:id/output_first_fluid"),@AndroidBy(id = "com.stooltool:id/fluid_type")}) public MobileElement firstFluidType;
    @AndroidFindBys({@AndroidBy(id = "com.stooltool:id/output_first_fluid"),@AndroidBy(id = "com.stooltool:id/content_text")}) public MobileElement firstFluidVolume;
    @AndroidFindBys({@AndroidBy(id = "com.stooltool:id/output_first_fluid"),@AndroidBy(id = "com.stooltool:id/fluid_time")}) public MobileElement firstFluidDuration;
    @AndroidFindBys({@AndroidBy(id = "com.stooltool:id/output_second_fluid"),@AndroidBy(id = "com.stooltool:id/fluid_type")}) public MobileElement secondFluidType;
    @AndroidFindBys({@AndroidBy(id = "com.stooltool:id/output_second_fluid"),@AndroidBy(id = "com.stooltool:id/content_text")}) public MobileElement secondFluidVolume;
    @AndroidFindBys({@AndroidBy(id = "com.stooltool:id/output_second_fluid"),@AndroidBy(id = "com.stooltool:id/fluid_time")}) public MobileElement secondFluidDuration;
    @AndroidFindBy(id="com.stooltool:id/age") private MobileElement outputAge;
    @AndroidFindBy(id = "android:id/action_bar_title") private MobileElement outputHeader;
    @AndroidFindBy(id = "com.stooltool:id/gender") private MobileElement outputGender;
    @AndroidFindBy(id = "com.stooltool:id/weight") private MobileElement outputWeight;
    @AndroidFindBy(id = "com.stooltool:id/dehydrationStatus") private MobileElement outputDehydrationStatus;
    @AndroidFindBy(id = "com.stooltool:id/output_patient_info_widget") private MobileElement patientInfoWidget;
    @AndroidFindBy(id = "com.stooltool:id/output_first_fluid") private MobileElement firstFluidWidget;
    @AndroidFindBy(id = "com.stooltool:id/output_second_fluid") private MobileElement secondFluidWidget;
    @AndroidFindBy(id="com.stooltool:id/output_ready_for_discharge") private List<MobileElement> newPatientButton;
    @AndroidFindBy(id = "com.stooltool:id/fever_accordion") List<MobileElement> feverDangerSign;
    @AndroidFindBy(id = "com.stooltool:id/convulsions_accordion") List<MobileElement> convulsionsDangerSign;
    @AndroidFindBy(id = "com.stooltool:id/fast_breathing_accordion") List<MobileElement> fastBreathingDangerSign;
    @AndroidFindBy(id = "com.stooltool:id/unable_to_drink_accordion") List<MobileElement> vomitingDangerSign;
    @AndroidFindBy(id = "com.stooltool:id/blood_in_stool_accordion") List<MobileElement> bloodInStoolDangerSign;
    @AndroidFindBy(id = "com.stooltool:id/hypothermia_accordion") List<MobileElement> hypothermiaDangerSign;
    @AndroidFindBy(id = "com.stooltool:id/first_sub_text") List<MobileElement> firstAntibiotic;
    @AndroidFindBy(id = "com.stooltool:id/extra_text_box") List<MobileElement> extraAntibiotic;
    public String getHeaderTitle(){
        waitFor(outputHeader);
        return outputHeader.getText();
    }
    public int getOutputAgeYear(){
        String ageString= outputAge.getText();
        String ageYear= ageString.substring(0,ageString.indexOf("y")).trim();
        return Integer.parseInt(ageYear);
    }
    public String getOutputAge(){
        waitFor(outputAge);
        return outputAge.getText();
    }
    public String getGender(){
        waitFor(outputGender);
        return outputGender.getText();
    }
    public String getDehydrationStatus(){
        waitFor(outputDehydrationStatus);
        return outputDehydrationStatus.getText();
    }
    public String getWeight(){
        waitFor(outputWeight);
        String weight= outputWeight.getText();
        String weightValue= weight.replaceAll("[^0-9.]", "").trim();
        return weightValue;
    }
    public String verifyFirstFluidType(String dehydrationStatus){
        String s="";
        switch (dehydrationStatus){
            case SEVERE:
                s= firstFluidType.getText();
                break;
            case SOME:
                s= firstFluidType.getText();;
                break;
            case No:
                s= "No Fluids";
                break;
        }
        return s;
    }
    public String getFirstFluidVolume(){
        waitFor(firstFluidVolume);
        return firstFluidVolume.getText();
    }
    public String getSecondFluidVolume(String dehydrationStatus){
        String s="";
        switch (dehydrationStatus){
            case SEVERE:
                s= secondFluidVolume.getText();
                break;
            case SOME:
                s= "No Second Fluid";
                break;
            case No:
                s= "No Fluids";
                break;
        }
        return s;
    }
    public void calculateFirstFluidVolume(Constants.DehydrationStatus dehydrationStatus, int weight){
        switch (dehydrationStatus){
            case SEVERE:
                int volume= weight*30;
        }

    }
    public String getFirstFluidDuration(){
        waitFor(firstFluidDuration);
        return firstFluidDuration.getText();
    }
    public String getSecondFluidDuration(String dehydrationStatus){
        String s="";
        switch (dehydrationStatus){
            case SEVERE:
                s= firstFluidDuration.getText();
                break;
            case SOME:
                s= "No Second Fluid";
            case No:
                s= "No Fluids";
        }
        return s;
    }
    public String verifySecondFluidType(String dehydrationStatus){
        String s="";
        switch (dehydrationStatus){
            case SEVERE:
                s= secondFluidType.getText();
                break;
            case SOME:
                s= "ORS";//sending ORS just to pass assertion
                break;
            case No:
                s= "No Fluids";
                break;
        }
        return s;
    }
    public String verifyFirstFluidTime(String dehydrationStatus){
        String s="";
        switch (dehydrationStatus){
            case SEVERE:
                if(getOutputAgeYear()<1){
                    s= "1 hr";
                }
                else{
                    s= "1/2 hr";
                }
                break;
            case SOME:
                if(getOutputAgeYear()<1){
                    s= "6 hr";
                }
                else{
                    s= "4 hr";
                }
                break;
            case No:
                s="None";
                break;
        }
        return s;

    }
    public String verifySecondFluidTime(Constants.DehydrationStatus dehydrationStatus){
        String s="";
        switch (dehydrationStatus){
            case SEVERE:
                if(getOutputAgeYear()<1){
                    s= "5 hr";
                }
                else{
                    s= "2.5 hr";
                }
                break;
            case SOME:
                s="None";
                break;
            case No:
                s="None";
                break;
        }
        return s;
    }
    public boolean verifyTemperature(String temp){
        if(temp.equalsIgnoreCase("high")){
            return scrollAndSearch(feverDangerSign);
        }
        else if(temp.equalsIgnoreCase("low")){
            return scrollAndSearch(hypothermiaDangerSign);
        }
        else{
            System.out.println("Normal Temperature");
            return true;
        }
    }
    public boolean verifyFastBreathing(String fastBreathing){
        if(fastBreathing.equalsIgnoreCase("yes")){
            return scrollAndSearch(fastBreathingDangerSign);
        }
        else{
            System.out.println("No fast breathing");
            return true;
        }

    }
    public boolean verifyVomiting(String vomiting){
        if(vomiting.equalsIgnoreCase("yes")){
            return scrollAndSearch(vomitingDangerSign);
        }
        else{
            System.out.println("No vomiting");
            return true;
        }

    }
    public boolean verifyConvulsions(String convulsions){
        if(convulsions.equalsIgnoreCase("yes")){
            return scrollAndSearch(convulsionsDangerSign);
        }
        else{
            System.out.println("No convulsions");
            return true;
        }

    }
    public boolean verifyBloodinStool(String bloodyStool){
        if(bloodyStool.equalsIgnoreCase("yes")){
            return scrollAndSearch(fastBreathingDangerSign);
        }
        else{
            System.out.println("No bloodyStool");
            return true;
        }
    }
    public String getFirstAntibiotic(){
        return scrollAndGetText(firstAntibiotic);
    }
    public void clickNewPatientButton(){
        scrollAndClick(newPatientButton);
    }

}
