package SanityTests;

import Pages.LaunchPage;
import Pages.LoginPage;
import Pages.PatientListPage;
import configurations.Base;
import configurations.Mappings;
import org.testng.Assert;
import org.testng.annotations.*;
import testData.LoginData;

import java.net.MalformedURLException;

import static Constants.Constants.*;
import static Constants.Constants.THANK_YOU_HEADER;

public class LoginTest extends Base {
    Mappings mappings;
    LaunchPage launchPage;
    LoginPage loginPage;
    PatientListPage patientListPage;
    @Parameters({"udid","systemPort"})
    @BeforeTest(alwaysRun = true)
    public void setup(String par1,String par2) throws MalformedURLException, InterruptedException {
        appLaunch(par1,par2);
    }
    @BeforeClass
    public void setLaunchMenu() throws InterruptedException {
        System.out.println("Executing login tests.....");
        launchPage= new LaunchPage();
        mappings = new Mappings();
        Assert.assertEquals(launchPage.languagePopUpDisplayed(),true);
        launchPage.clickConfirm();
        launchPage.acceptTerms();
        Assert.assertEquals(launchPage.getPopupHeader(),COUNTRY_HEADER);
        launchPage.setCountry("Bangladesh");
        Assert.assertEquals(launchPage.getPopupHeader(),DISEASE_HEADER);
        launchPage.proceed();
        Assert.assertEquals(launchPage.getPopupHeader(),PURPOSE_HEADER);
        launchPage.setValue("Electronic medical record (only)");
        Assert.assertTrue(launchPage.getSelectedOption("Electronic medical record (only)"));
        launchPage.proceed();
        launchPage.manageEMRPurpose("Data collection (only)", "Electronic medical record (only)");
        Assert.assertEquals(launchPage.getPopupHeader(),WATERY_DIARRHOEA_HEADER);
        Assert.assertTrue(launchPage.getSelectedOption(mappings.getWateryAntibiotic("Bangladesh")));
        launchPage.proceed();
        Assert.assertTrue(launchPage.getSelectedOption(mappings.getBloodyAntibiotic("Bangladesh")));
        launchPage.proceed();
        Assert.assertEquals(launchPage.getPopupHeader(),MALNUTRITION_HEADER);
        launchPage.proceed();
        Assert.assertEquals(launchPage.getPopupHeader(),THANK_YOU_HEADER);
        launchPage.proceed();
    }
    @BeforeMethod
    public void dummyMethod() throws InterruptedException {
        System.out.println("On Login Page");
        Assert.assertTrue(launchPage.verifyEmrNavigation("Electronic medical record (only)"));
    }
    @Test(dataProvider = "creds",dataProviderClass = LoginData.class)
    public void login(String username,String password){
        loginPage= new LoginPage();
        patientListPage= new PatientListPage();
        loginPage.enterUserName(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        loginPage.clickRunInBackground();
        restart();
        Assert.assertEquals(patientListPage.getHeaderText(),"Patient List");
    }
    @AfterMethod
    public void logout(){
        System.out.println("logout");
        patientListPage.logout();
        restart();
    }
    @AfterClass
    public void clearDataAndReset(){
        driver.resetApp();
    }
    @AfterTest
    public void quit(){
        tearDown();
    }
}
