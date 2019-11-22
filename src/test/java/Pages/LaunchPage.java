package Pages;

import configurations.Base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static Constants.Constants.*;

public class LaunchPage extends Base {
    @AndroidFindBy(id = "com.stooltool:id/iv_input_header") public MobileElement chooseLanguage;
    @AndroidFindBy(id = "com.stooltool:id/language_english_global") public MobileElement engOption;
    @AndroidFindBy(id = "com.stooltool:id/language_french_haiti") public MobileElement frOption;
    @AndroidFindBy(id = "com.stooltool:id/btn_confirm") public MobileElement confirmBtn;
    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button") public WebElement allowPopup;
    @AndroidFindAll(@AndroidBy(className= "android.widget.Button")) public List<MobileElement> buttons;
    @AndroidFindBy(id = "android:id/action_bar_title") public MobileElement termsAndConditionsHeader;
    @AndroidFindBy(id = "com.stooltool:id/progress_load") public MobileElement progressBar;
    @AndroidFindBy(id = "com.stooltool:id/pager_setting_item_title") public static WebElement popUpHeader;
    @AndroidFindBy(id = "com.stooltool:id/next_button") public static MobileElement nextBtn;
    @AndroidFindBy(id="com.stooltool:id/previous_button") public MobileElement prevBtn;
    @AndroidFindAll(@AndroidBy(className = "android.widget.RadioButton")) public static List<MobileElement>  radioBtns;
    @AndroidFindBys({@AndroidBy(id = "com.stooltool:id/pager_setting_item_radio_group_1"),@AndroidBy(className = "android.widget.RadioButton")}) private List<MobileElement> countryRadioButtons;

    @AndroidFindBy(id = "com.stooltool:id/calculator_layout") public MobileElement calculatorCard;
    @AndroidFindBy(id = "com.stooltool:id/login_layout") public MobileElement loginCard;
    @AndroidFindBy(id = "android:id/action_bar_title") public MobileElement sideNavIcon;

    public LaunchPage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this );
    }
    public void chooseLanguage(String lang){
        if(lang.equalsIgnoreCase("english")){
            engOption.click();
        }
        else {
            frOption.click();
        }
    }
    public boolean languagePopUpDisplayed(){
        try{
            waitFor(chooseLanguage);
            return chooseLanguage.isDisplayed();
        }
        catch (Exception e){
            System.out.println("No internet");
            e.printStackTrace();
            return false;
        }

    }
    public void clickConfirm(){
        waitFor(confirmBtn);
        confirmBtn.click();
    }
    public boolean allowPop(){
        return allowPopup.isDisplayed();
    }
    public void acceptTerms() throws InterruptedException {
        try{
            for (WebElement ele:buttons) {
                buttons.get(0).click();
            }
        }
        catch (Exception e){
            Thread.sleep(3000);
            for (WebElement ele:buttons) {
                buttons.get(0).click();
            }
        }
    }
    public String getTermsHeaderText(){
        waitFor(termsAndConditionsHeader);
        return termsAndConditionsHeader.getText();
    }
    public boolean progress() throws InterruptedException {
        waitFor(progressBar);
        Thread.sleep(5000);
        return progressBar.isDisplayed();
    }
    public static String getPopupHeader(){
        try{
            waitFor((MobileElement) popUpHeader);
            return popUpHeader.getText();
        }
        catch (Exception e){
            System.out.println("App is too slow for me");
            waitFor((MobileElement) popUpHeader);
            return popUpHeader.getText();
        }

    }
    public void setCountry(String country){
            switch(country){
                case BANGLADESH:
                    loopAndClick(countryRadioButtons,BANGLADESH);
                    proceed();
                    break;
                case HAITI:
                    loopAndClick(countryRadioButtons,HAITI);
                    proceed();
                    break;
                case GLOBAL:
                    loopAndClick(countryRadioButtons,GLOBAL);
                    proceed();
                    break;
            }
    }
    public static void proceed(){
        waitFor(nextBtn);
        nextBtn.click();
    }
    public static boolean getSelectedOption(String defaultValue){
        boolean s=false;
        for (WebElement el:radioBtns) {
            if(el.getText().equalsIgnoreCase(defaultValue)) {
                s= Boolean.parseBoolean(el.getAttribute("checked"));
            }
        }
        return s;
    }
    public static void setValue(String value){
        for(WebElement el:radioBtns){
            if(el.getText().equalsIgnoreCase(value)){
                el.click();
            }
        }
    }
    public static void manageEMRPurpose(String EmrPurpose,String purpose){
        switch (purpose){
            case CALC_ONLY:
                System.out.println("Going with default flow");
                break;
            case EMR_ONLY:
            case CALC_AND_EMR:
                setValue(EmrPurpose);
//                Assert.assertTrue(getSelectedOption(EmrPurpose));
                proceed();
                break;
        }
    }
    public boolean verifyEmrNavigation(String purpose) throws InterruptedException {
        boolean b= false;
        switch (purpose){
            case CALC_ONLY:
                staleWaitFor(sideNavIcon);
                Thread.sleep(2000);
                b= sideNavIcon.isDisplayed();
                break;
            case CALC_AND_EMR:
                restart();//Restarting the app as unable to find elements
                waitFor(calculatorCard);
                b= calculatorCard.isDisplayed() && loginCard.isDisplayed();
                break;
            case EMR_ONLY:
                restart();
                waitFor(loginCard);
                b= loginCard.isDisplayed();
                break;
        }
        return b;
    }
}
