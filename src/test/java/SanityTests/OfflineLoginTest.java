package SanityTests;

import Pages.LaunchPage;
import Pages.LoginPage;
import Pages.PatientListPage;
import configurations.Base;
import configurations.Mappings;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Constants.Constants.*;

public class OfflineLoginTest extends Base {
    Mappings mappings;
    LaunchPage launchPage;
    LoginPage loginPage;
    PatientListPage patientListPage;
    @BeforeClass(alwaysRun = true)
    public void setup() throws InterruptedException {
        launchPage= new LaunchPage();
        mappings = new Mappings();
        Assert.assertEquals(launchPage.languagePopUpDisplayed(),true);
        launchPage.clickConfirm();
        launchPage.acceptTerms();
        Assert.assertEquals(launchPage.getPopupHeader(),COUNTRY_HEADER);
        launchPage.setCountry(COUNTRY);
        Assert.assertEquals(launchPage.getPopupHeader(),DISEASE_HEADER);
        launchPage.proceed();
        Assert.assertEquals(launchPage.getPopupHeader(),PURPOSE_HEADER);
        launchPage.setValue(EMR_ONLY);
        Assert.assertTrue(launchPage.getSelectedOption(PURPOSE));
        launchPage.proceed();
        launchPage.manageEMRPurpose(EMR_PURPOSE, PURPOSE);
        Assert.assertEquals(launchPage.getPopupHeader(),WATERY_DIARRHOEA_HEADER);
        Assert.assertTrue(launchPage.getSelectedOption(mappings.getWateryAntibiotic(COUNTRY)));
        launchPage.proceed();
        Assert.assertEquals(launchPage.getPopupHeader(),BLOODY_DIARRHOEA_HEADER);
        Assert.assertTrue(launchPage.getSelectedOption(mappings.getBloodyAntibiotic(COUNTRY)));
        launchPage.proceed();
        Assert.assertEquals(launchPage.getPopupHeader(),MALNUTRITION_HEADER);
        launchPage.proceed();
        Assert.assertEquals(launchPage.getPopupHeader(),THANK_YOU_HEADER);
        launchPage.proceed();
    }
    @BeforeMethod
    public void firstTimeLogin() throws InterruptedException {
        System.out.println("On Login Page");
        Assert.assertTrue(launchPage.verifyEmrNavigation(PURPOSE));
        loginPage= new LoginPage();
        patientListPage= new PatientListPage();
        loginPage.enterUserName(UNAME);
        loginPage.enterPassword(PASSWORD);
        loginPage.clickLogin();
        loginPage.clickRunInBackground();
        restart();
        Assert.assertEquals(patientListPage.getHeaderText(),PATIENT_LIST_HEADER);
        patientListPage.logout();
        restart();
    }
    @Test
    public void offlineLogin() throws InterruptedException {
        wifiOff();
        loginPage.enterUserName(UNAME);
        loginPage.enterPassword(PASSWORD);
        loginPage.clickLogin();
        loginPage.clickRunInBackground();
        restart();
        Assert.assertEquals(patientListPage.getHeaderText(),PATIENT_LIST_HEADER);
    }
    @AfterClass
    public void quit() throws InterruptedException {
        wifiOn();
        driver.resetApp();
    }
}
