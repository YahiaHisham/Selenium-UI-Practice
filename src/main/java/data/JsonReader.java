package data;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JsonReader {
    static String classLocation = "/src/main/java/data/";
    static String fileExtension = ".JSON";
    static String projectLocation = "user.dir";

    private static String filePath;
    private static JSONObject jsonObject;

    private static void loadJson() {
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(filePath)) {
            jsonObject = (JSONObject) parser.parse(reader);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public static Object getValueFromJsonFile2(String fileName, String key) {
        setFilePath(fileName);
        loadJson();
        return jsonObject.get(key);
    }

    public static void updateValueInJsonFile2(String fileName, String key, Object value) {
        setFilePath(fileName);
        loadJson();
        jsonObject.put(key, value);
        saveChanges();
    }

    private static void saveChanges() {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(jsonObject.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setFilePath(String fileName) {
        JsonReader.filePath = System.getProperty(projectLocation) + classLocation + fileName + fileExtension;
    }
}
