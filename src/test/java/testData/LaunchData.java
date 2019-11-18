package testData;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

public class LaunchData {
    @DataProvider(name = "launchData")
    public Object[][] launchDetails() throws Exception {
        String filePath="/Users/saritagidwani/IdeaProjects/AppTest/src/test/java/testData/LaunchData.xlsx";
        File file= new File(filePath);
        FileInputStream fis= new FileInputStream(file);
        XSSFWorkbook wb= new XSSFWorkbook(fis);
        wb.close();
        XSSFSheet sheet= wb.getSheet("sheet1");
        int rowCount= sheet.getLastRowNum();
        int colCount= sheet.getRow(0).getLastCellNum();
        Object[][] obj= new Object[rowCount][1];
        for(int i=0;i<rowCount;i++){
            Map<Object,Object> launchData= new HashMap<Object, Object>();
            for(int j=0;j<colCount;j++){
                launchData.put(sheet.getRow(0).getCell(j).toString(),sheet.getRow(i+1).getCell(j).toString());
            }
            obj[i][0]=launchData;
        }
        return obj;
    }
}
