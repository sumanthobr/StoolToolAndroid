package testData;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadJsonData {

    private static final List<String> inputKeys = Arrays.asList("ageYear", "ageMonth", "gender", "isPregnant", "wateryStool", "bloodyStool", "generalCondition",
            "eyes", "thirst", "skinPinch", "isAllergic", "allergy", "optionalAllergy", "temp", "fastBreathing", "vomiting", "convulsions");
    @DataProvider(name = "inputDetails")
    public Object[][] getData() throws IOException, ParseException {
        Object object= new JSONParser().parse(new FileReader("/Users/saritagidwani/IdeaProjects/AppTest/src/test/java/testData/inputDetails.json"));
        JSONObject jsonObject= (JSONObject) object;
        JSONArray jsonArray= (JSONArray)jsonObject.get("InputData");
        Object[][] objects = new Object[jsonArray.size()][];
        for(int i=0;i<jsonArray.size();i++){
            JSONObject rowEntry = (JSONObject) jsonArray.get(i);
            List<String> rowArray = new ArrayList<>();
            for(Object key: inputKeys) {
                rowArray.add(rowEntry.get(key).toString());
            }
            objects[i] = rowArray.toArray();
        }
        return objects;
    }
}
