package Pages;

import configurations.Base;
import io.appium.java_client.MobileElement;
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
    public String getHeaderText(){
        return patientListHeader.getText();
    }
    public void logout(){
        waitFor(logoutMenu);
        logoutMenu.click();
        waitFor(logoutButton);
        logoutButton.click();
    }
}
