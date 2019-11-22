package Pages;

import configurations.Base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class PatientListPage extends Base {
    public PatientListPage(){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    @AndroidFindBy(id = "android:id/action_bar_title") private MobileElement patientListHeader;
    @AndroidFindBy( xpath= "//android.widget.ImageButton[@content-desc='More options']") private MobileElement logoutMenu;
    @AndroidFindBy(id = "android:id/title") private MobileElement logoutButton;
    @AndroidFindBy(id="com.stooltool:id/new_outbreak_clicker") private MobileElement newPatientButton;
    @AndroidFindBy(id = "android:id/search_button") private MobileElement searchIcon;
    @AndroidFindBy(id = "android:id/search_src_text") private MobileElement searchText;
    public String getHeaderText(){
        return patientListHeader.getText();
    }
    public void clickNewPatientButton(){
        waitFor(newPatientButton);
        newPatientButton.click();
    }
    public void logout(){
        waitFor(logoutMenu);
        logoutMenu.click();
        waitFor(logoutButton);
        logoutButton.click();
    }
    public void searchByName(String text){
        waitFor(searchIcon);
        searchIcon.click();
        waitFor(searchText);
        searchText.sendKeys(text);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }
}
