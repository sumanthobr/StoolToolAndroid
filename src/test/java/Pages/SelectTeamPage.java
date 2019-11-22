package Pages;

import configurations.Base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SelectTeamPage extends Base {
    public SelectTeamPage(){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    @AndroidFindBy(id = "android:id/action_bar") private MobileElement header;
    @AndroidFindBy(id = "com.stooltool:id/nation_layout") private MobileElement nationLayout;
    @AndroidFindBy(id = "com.stooltool:id/district_layout") private MobileElement districtLayout;
    @AndroidFindBy(id = "com.stooltool:id/hospital_layout") private MobileElement hospitalLayout;
    @AndroidFindBy(id = "com.stooltool:id/team_layout") private MobileElement teamLayout;
    @AndroidFindBy(id = "com.stooltool:id/nation_spinner") private MobileElement nationSpinner;
    @AndroidFindBy(id = "com.stooltool:id/district_spinner") private MobileElement districtSpinner;
    @AndroidFindBy(id = "com.stooltool:id/hospital_spinner") private MobileElement hospitalSpinner;
    @AndroidFindBy(id = "com.stooltool:id/team_spinner") private MobileElement teamSpinner;
    @AndroidFindAll(@AndroidBy(id="android:id/text1")) private List<MobileElement> residenceValues;
    @AndroidFindBy(id = "com.stooltool:id/team_save") private MobileElement continueButton;

    public String getHeaderText(){
        return header.getText();
    }
    public void selectNation(String residence) throws InterruptedException {
        waitFor(nationLayout);
        nationSpinner.click();
        selectResidence(residence);
        Thread.sleep(2000);
    }
    public void selectDistrict(String residence) throws InterruptedException {
        waitFor(districtLayout);
        districtSpinner.click();
        selectResidence(residence);
        Thread.sleep(2000);
    }
    public void selectHospital(String residence) throws InterruptedException {
        waitFor(hospitalLayout);
        hospitalSpinner.click();
        selectResidence(residence);
        Thread.sleep(2000);
    }
    public void selectTeam(String residence) throws InterruptedException {
        waitFor(teamLayout);
        teamSpinner.click();
        selectResidence(residence);
        Thread.sleep(2000);
    }
    public void selectResidence(String residence){
        try{
            for (MobileElement r: residenceValues) {
                if(r.getText().equalsIgnoreCase(residence)){
                    r.click();
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void clickContinue(){
        waitFor(continueButton);
        continueButton.click();
    }

}
