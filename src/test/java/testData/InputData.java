package testData;

import org.testng.annotations.DataProvider;

public class InputData {
    @DataProvider(name = "inputDetails")
    public Object[][] inputDetails(){
        return new Object[][]{
                {"2","2","Male","no","yes","no","Well / Alert","Sunken","Normal","Very Slow(> 3 sec)","no","no","n","High","yes","no","no"},
                {"12","2","Female","yes","yes","no","Well / Alert","Sunken","Normal","Very Slow(> 3 sec)","no","no","n","Low","yes","yes","no"}
        };
    }
}
