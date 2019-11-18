package Pages;

        import configurations.Base;
        import io.appium.java_client.MobileElement;
        import io.appium.java_client.pagefactory.AndroidFindBy;
        import io.appium.java_client.pagefactory.AppiumFieldDecorator;
        import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Base {
    public LoginPage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this );
    }
    @AndroidFindBy(id = "com.stooltool:id/set_username") private MobileElement username;
    @AndroidFindBy(id = "com.stooltool:id/set_password") private MobileElement password;
    @AndroidFindBy(id = "com.stooltool:id/btn_login") private MobileElement loginBtn;
    @AndroidFindBy(id = "android:id/button3") private MobileElement runInBackground;
    public void enterUserName(String uname){
        waitFor(username);
        username.setValue(uname);
    }
    public void enterPassword(String pword){
        waitFor(password);
        password.setValue(pword);
    }
    public void clickLogin(){
        waitFor(loginBtn);
        loginBtn.click();
    }
    public void clickRunInBackground(){
        try{
            runInBackground.click();
        }
        catch (Exception e){
            System.out.println("No problemo");
        }
    }
}
