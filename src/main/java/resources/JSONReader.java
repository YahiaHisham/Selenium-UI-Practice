package resources;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JSONReader {
    public static String username;
    JSONParser jsonParser = new JSONParser();
    static String dataFilePath = "src/test/resources/JSONFiles/";
    public static String readJSON(String className , String TCName) {
        try {
            FileReader reader = new FileReader(dataFilePath+className+".JSON");
        JSONParser jsonParser = new JSONParser();
        Object obj =  jsonParser.parse(reader);
        JSONArray valuesArray = (JSONArray) obj;

        for (int i = 0; i < valuesArray.size(); i++) {
            JSONObject cases = (JSONObject) valuesArray.get(i);
            JSONObject caseNo = (JSONObject) cases.get(TCName);
            System.out.println(TCName+" jsonReader");
            username = (String) caseNo.get("username");
        }
            }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return username;
    }
}
