package testData;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;

public class InputDetails {
    @DataProvider(name = "details")
    public Object[][] inputTestData() throws Exception {
        String filePath="/Users/saritagidwani/IdeaProjects/AppTest/src/test/java/testData/TestngData.xlsx";
        File file= new File(filePath);
        FileInputStream fis= new FileInputStream(file);
        XSSFWorkbook wb= new XSSFWorkbook(fis);
        wb.close();
        XSSFSheet sheet= wb.getSheet("sheet3");
        int rowCount= sheet.getLastRowNum();
        int colCount= sheet.getRow(0).getLastCellNum();
        Object[][] data= new Object[rowCount][colCount];
        for(int i=0;i<rowCount;i++){
            for(int j=0;j<colCount;j++){
                data[i][j]=sheet.getRow(i+1).getCell(j).toString();
            }
        }
        return data;
    }
}
