package Pages;

import configurations.Base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static Constants.Constants.*;

public class HistoryPage extends Base {
    public HistoryPage(){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    @AndroidFindBy(accessibility = "History, Navigate up")private MobileElement historyHeader;
    @AndroidFindBys({
            @AndroidBy(id = "com.stooltool:id/watery_stool"),
            @AndroidBy(id = "com.stooltool:id/radio_layout_btn_yes")
    }) private List<MobileElement> wateryStoolYesBtn;
    @AndroidFindBys({
            @AndroidBy(id = "com.stooltool:id/watery_stool"),
            @AndroidBy(id = "com.stooltool:id/radio_layout_btn_no")
    }) private List<MobileElement> wateryStoolNoBtn;
    @AndroidFindBys({
            @AndroidBy(id = "com.stooltool:id/bloody_stool"),
            @AndroidBy(id = "com.stooltool:id/radio_layout_btn_yes")
    })
    private List<MobileElement>bloodyStoolYesBtn;
    @AndroidFindBys({
            @AndroidBy(id = "com.stooltool:id/bloody_stool"),
            @AndroidBy(id = "com.stooltool:id/radio_layout_btn_no")
    })
    private List<MobileElement> bloodyStoolNoBtn;
    @AndroidFindBy(id = "com.stooltool:id/diarrhea_onset_time") private MobileElement timeOfOnsetDialog;
    @AndroidFindBy(id = "com.stooltool:id/radio_time_group") private List<MobileElement> timeGroupsList;
    @AndroidFindBy(id = "com.stooltool:id/time_text_this_afternoon") private MobileElement thisAfternoon;
    @AndroidFindBy(id = "com.stooltool:id/time_text_this_morning") private MobileElement thisMorning;
    @AndroidFindBy(id = "com.stooltool:id/time_text_yesterday_evening") private MobileElement yesterdayEvening;
    @AndroidFindBy(id = "com.stooltool:id/loose_stools_spinner") private MobileElement looseStoolsSpinner;
    @AndroidFindBy(id = "android:id/text1") private List<MobileElement> nunberOfStools;
    @AndroidFindBys({
            @AndroidBy(id = "com.stooltool:id/fluids_at_home"),
            @AndroidBy(id = "com.stooltool:id/radio_layout_btn_yes")
    }) private List<MobileElement>  fluidsYesButton;
    @AndroidFindBys({
            @AndroidBy(id = "com.stooltool:id/fluids_at_home"),
            @AndroidBy(id = "com.stooltool:id/radio_layout_btn_no")
    }) private List<MobileElement>  fluidsNoButton;
    @AndroidFindBys({
            @AndroidBy(id = "com.stooltool:id/medications_at_home"),
            @AndroidBy(id = "com.stooltool:id/radio_layout_btn_yes")
    }) private List<MobileElement>  medicationYesBtn;
    @AndroidFindBys({
            @AndroidBy(id = "com.stooltool:id/medications_at_home"),
            @AndroidBy(id = "com.stooltool:id/radio_layout_btn_no")
    }) private List<MobileElement>  medicationNoBtn;
    @AndroidFindBys({
            @AndroidBy(id = "com.stooltool:id/allergies_known"),
            @AndroidBy(id = "com.stooltool:id/radio_layout_btn_yes")
    }) private List<MobileElement>  allergiesYesButton;
    @AndroidFindBys({
            @AndroidBy(id = "com.stooltool:id/allergies_known"),
            @AndroidBy(id = "com.stooltool:id/radio_layout_btn_no")
    }) private List<MobileElement>  allergiesNoButton;
    @AndroidFindBy(id="com.stooltool:id/ors_checkbox") private MobileElement orsCheckBox;
    @AndroidFindBy(id="com.stooltool:id/iv_fluids_checkbox") private MobileElement ivCheckBox;
    @AndroidFindBy(id="com.stooltool:id/qi_ordered_ors_given_text") private MobileElement orsGiven;
    @AndroidFindBy(id="com.stooltool:id/qi_ordered_ors_unit_lt") private MobileElement orsUnitLitre;
    @AndroidFindBy(id="com.stooltool:id/qi_ordered_ors_unit_packets") private MobileElement orsUnitPacket;
    @AndroidFindBy(id="com.stooltool:id/medications_layout") private List<MobileElement> medicationsLayout;
    @AndroidFindBy(id="com.stooltool:id/ceftriaxone") private List<MobileElement> medicationCeftriaxone;
    @AndroidFindBy(id="com.stooltool:id/amoxicillin") private List<MobileElement> medicationAmoxicillin;
    @AndroidFindBy(id="com.stooltool:id/metronidazole") private List<MobileElement> medicationMetronidazole;
    @AndroidFindBy(id="com.stooltool:id/ciprofloxacin") private List<MobileElement> medicationCiprofloxacin;
    @AndroidFindBy(id="com.stooltool:id/azithromycin") private List<MobileElement> medicationAzithromycin;
    @AndroidFindBy(id="com.stooltool:id/paracetamol") private List<MobileElement> medicationTetracycyline;
    @AndroidFindBy(id="com.stooltool:id/other_medicine") private List<MobileElement> medicationOther;
    @AndroidFindBy(id="com.stooltool:id/medications_optional_name") private List<MobileElement> medicationOtherName;
    @AndroidFindBy(id = "com.stooltool:id/allergies_layout") private List<MobileElement> allergyLayout;
    @AndroidFindBys({
            @AndroidBy(id = "com.stooltool:id/allergies_layout"),
            @AndroidBy(id = "com.stooltool:id/aminoglycosides")
    }) private List<MobileElement> aminoCheckBox;
    @AndroidFindBys({
            @AndroidBy(id = "com.stooltool:id/allergies_layout"),
            @AndroidBy(id = "com.stooltool:id/cephalosporins")
    }) private List<MobileElement> cephaCheckBox;
    @AndroidFindBys({
            @AndroidBy(id = "com.stooltool:id/allergies_layout"),
            @AndroidBy(id = "com.stooltool:id/fluoroquinolones")
    }) private List<MobileElement> fluoroCheckBox;
    @AndroidFindBys({
            @AndroidBy(id = "com.stooltool:id/allergies_layout"),
            @AndroidBy(id = "com.stooltool:id/macrolides")
    }) private List<MobileElement> macroCheckBox;
    @AndroidFindBys({
            @AndroidBy(id = "com.stooltool:id/allergies_layout"),
            @AndroidBy(id = "com.stooltool:id/penicillin")
    }) private List<MobileElement> pencillinCheckBox;
    @AndroidFindBys({
            @AndroidBy(id = "com.stooltool:id/allergies_layout"),
            @AndroidBy(id = "com.stooltool:id/sulfonamides")
    }) private List<MobileElement> sulfCheckBox;
    @AndroidFindBys({
            @AndroidBy(id = "com.stooltool:id/allergies_layout"),
            @AndroidBy(id = "com.stooltool:id/tetracyclines")
    }) private List<MobileElement> tetraCheckBox;
    @AndroidFindBys({
            @AndroidBy(id = "com.stooltool:id/allergies_layout"),
            @AndroidBy(id = "com.stooltool:id/other_allergy")
    }) private List<MobileElement> otherCheckBox;
    @AndroidFindAll(@AndroidBy(id="com.stooltool:id/allergies_optional_name")) private List<MobileElement> otherAllergiesText;
    @AndroidFindBy(id = "com.stooltool:id/next_assessment") private MobileElement goToExamButton;

    public void setWateryStool(String input) {
        if (input.equalsIgnoreCase("yes")) {
            scrollAndClick(wateryStoolYesBtn);
        }
        else {
            scrollAndClick(wateryStoolNoBtn);
        }
    }
    public void setBloodyStool(String input){
        if(input.equalsIgnoreCase("yes")){
            scrollAndClick(bloodyStoolYesBtn);
        }
        else {
            scrollAndClick(bloodyStoolNoBtn);
        }
    }
    public void setTimeOfOnset(){
        try{
            waitFor(timeOfOnsetDialog);
            timeOfOnsetDialog.click();
            thisMorning.click();
        }
        catch (Exception e){
            driver.pressKey(new KeyEvent(AndroidKey.BACK));
        }
    }
    public void setLooseStools(String number){
        waitFor(looseStoolsSpinner);
        looseStoolsSpinner.click();
        for(MobileElement l:nunberOfStools){
            if(l.getText().equalsIgnoreCase(number)){
                l.click();
            }
        }
    }
    public void setFluids(String fluidsTaken,String ors,String orsAmount,String iv){
        if(fluidsTaken.equalsIgnoreCase("yes")){
            scrollAndClick(fluidsYesButton);
            waitFor(orsGiven);
            if(ors.equalsIgnoreCase("yes")){
                orsCheckBox.click();
                orsGiven.sendKeys(orsAmount);
            }
            if(iv.equalsIgnoreCase("yes")){
                ivCheckBox.click();
            }
        }
        else{
            scrollAndClick(fluidsNoButton);
        }
    }
    public void setMedications(String medicationsTaken,String medicationGiven){
        if(medicationsTaken.equalsIgnoreCase("yes")){
            scrollAndClick(medicationYesBtn);
            switch(medicationGiven){
                case CEFTRIAXONE:
                    scrollAndClick(medicationCeftriaxone);
                    break;
                case AMOXICILLIN:
                    scrollAndClick(medicationAmoxicillin);
                    break;
                case METRONIDAZOLE:
                    scrollAndClick(medicationMetronidazole);
                    break;
                case CIPROFLOXACIN:
                    scrollAndClick(medicationCiprofloxacin);
                    break;
                case AZITHROMYCIN:
                    scrollAndClick(medicationAzithromycin);
                    break;
                case TETRACYCLINE:
                    scrollAndClick(medicationTetracycyline);
                    break;
                case OTHERMED:
                    scrollAndClick(medicationOther);
                    break;
            }
        }
        else{
            scrollAndClick(medicationNoBtn);
        }
    }
    public void setMedicationOtherName(String otherName){
        scrollAndClick(medicationOtherName);
        medicationOtherName.get(0).sendKeys(otherName);
    }
    public void setAllergy(String isAllergic){
        if(isAllergic.equalsIgnoreCase("yes")){
            scrollAndClick(allergiesYesButton);
        }
        else {
            scrollAndClick(allergiesNoButton);
        }
    }
    public boolean verifyAllergyMarked(String marked){
        if(marked.equalsIgnoreCase("yes")){
            scrollAndClick(allergyLayout);
            System.out.println("Searching for allergy layout");
            return allergyLayout.get(0).isDisplayed();
        }
        else{
            System.out.println("No medication allergies");
            return true;
        }
    }
    public void selectAllergy(String allergy, String isAllergic){
        if(isAllergic.equalsIgnoreCase("yes")){
            switch (allergy){
                case AMINOGLYOCIDES:
                    scrollAndClick(aminoCheckBox);
                    break;
                case CEPHALOSPORINS:
                    scrollAndClick(cephaCheckBox);
                    break;
                case FLUOROQUINOLONES:
                    scrollAndClick(fluoroCheckBox);
                    break;
                case MACROLIDES:
                    scrollAndClick(macroCheckBox);
                    break;
                case PENICILIINS:
                    scrollAndClick(pencillinCheckBox);
                    break;
                case SULFONAMIDES:
                    scrollAndClick(sulfCheckBox);
                    break;
                case TETRACYCLINES:
                    scrollDown();
                    scrollAndClick(tetraCheckBox);
                    break;
                case OTHER:
                    scrollDown();
                    scrollAndClick(otherCheckBox);
                    break;
            }
        }
        else{
            System.out.println("Not selecting any as allergies is marked NO");
        }
    }
    public boolean isAllergyChecked(String isAllergic, String allergy){
        boolean s= false;
        if (isAllergic.equalsIgnoreCase("yes")) {
            switch (allergy){
                case AMINOGLYOCIDES:
                    s= aminoCheckBox.get(0).isEnabled();
                    break;
                case CEPHALOSPORINS:
                    s= cephaCheckBox.get(0).isEnabled();
                    break;
                case FLUOROQUINOLONES:
                    s= fluoroCheckBox.get(0).isEnabled();
                    break;
                case MACROLIDES:
                    s= macroCheckBox.get(0).isEnabled();
                    break;
                case PENICILIINS:
                    s= pencillinCheckBox.get(0).isEnabled();
                    break;
                case SULFONAMIDES:
                    s= sulfCheckBox.get(0).isEnabled();
                    break;
                case OTHER:
                    s= otherCheckBox.get(0).isEnabled();
                    break;
                case TETRACYCLINES:
                    s= tetraCheckBox.get(0).isEnabled();
                    break;
            }
            return s;
        }
        else {
            return true;
        }
    }
    public void setOtherAllergy(String otherAllergyName,String otherIsMarked,String isAllergic){
        if(otherIsMarked.equalsIgnoreCase("other")&& isAllergic.equalsIgnoreCase("yes")){
            while (otherAllergiesText.size()==0){
                scrollDown();
            }
            if(otherAllergiesText.size()>0){
                otherAllergiesText.get(0).click();
                otherAllergiesText.get(0).sendKeys(otherAllergyName);
                driver.hideKeyboard();
            }
        }
        else {
            System.out.println("No other allergies");
        }
    }
    public void navToExam(){
        goToExamButton.click();
    }

}
