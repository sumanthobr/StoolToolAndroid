package Pages;

import configurations.Base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class InfoPage extends Base {
    public InfoPage(){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    @AndroidFindBy(id = "com.stooltool:id/admission_time_text") private MobileElement admissionTime;
    @AndroidFindBy(id = "com.stooltool:id/set_current_time_btn") private MobileElement currentTimeButton;
    @AndroidFindBy(id = "com.stooltool:id/name") private MobileElement nameInput;
    @AndroidFindBy(id = "com.stooltool:id/nameNoneCheckbox") private MobileElement nameNone;
    @AndroidFindBy(id = "com.stooltool:id/phone_number") private MobileElement phoneNumber;
    @AndroidFindBy(id = "com.stooltool:id/phoneNoneCheckbox") private MobileElement phoneNone;
    @AndroidFindBy(id = "com.stooltool:id/patient_id") private MobileElement id;
    @AndroidFindBy(id = "com.stooltool:id/age_text") private MobileElement ageDialog;
    @AndroidFindBy(id = "com.stooltool:id/age_year") private MobileElement ageYear;
    @AndroidFindBy(id = "com.stooltool:id/age_month") private MobileElement ageMonth;
    @AndroidFindBy(id = "com.stooltool:id/done_btn") private MobileElement doneButton;
    @AndroidFindBys({
            @AndroidBy(id = "com.stooltool:id/input_gender_radio"),
            @AndroidBy(id = "com.stooltool:id/radio_layout_btn_yes")
    }) private MobileElement genderMaleBtn;
    @AndroidFindBys({
            @AndroidBy(id = "com.stooltool:id/input_gender_radio"),
            @AndroidBy(id = "com.stooltool:id/radio_layout_btn_no")
    }) private MobileElement genderFemaleBtn;
    @AndroidFindBys({
            @AndroidBy(id = "com.stooltool:id/map_district_spinner"),
            @AndroidBy(id = "android:id/text1")
    }) private MobileElement districtSpinner;
    @AndroidFindBy(id="com.stooltool:id/treatment_location_details_text") private MobileElement treatmentLocationText;
    @AndroidFindBy(id = "com.stooltool:id/next_illness_history") private MobileElement goToHistoryPAge;

    public void setCurrentAdmissionTime(){
        waitFor(admissionTime);
        admissionTime.click();
        waitFor(currentTimeButton);
        currentTimeButton.click();
    }
    public void enterName(String name){
        if(name.equalsIgnoreCase("none")){
            nameNone.click();
        }
        else{
            nameInput.sendKeys(name);
        }
    }
    public void enterPhoneNumber(String number){
        if(number.equalsIgnoreCase("none")){
            phoneNone.click();
        }
        else{
            phoneNumber.sendKeys(number);
        }
    }
    public void setAge(String ageYr,String ageMo) throws InterruptedException {
        waitFor(ageDialog);
        ageDialog.click();
        int age = Integer.parseInt(ageYr);
        if(age<5){
            ageMonth.sendKeys(ageMo);
        }
        else {
            System.out.println("No Months");
        }
        ageYear.sendKeys(ageYr);
        Thread.sleep(3000);
        doneButton.click();
    }
    public String getAgeEntered(){
        String ageString= ageDialog.getText();
        String ageYear= ageString.substring(0,ageString.indexOf("y"));
        return ageYear.trim();
    }
    public String getTreatmentLocation(){
        return treatmentLocationText.getText();
    }
    public void navToHistoryPage(){
        waitFor(goToHistoryPAge);
        goToHistoryPAge.click();
    }


}
