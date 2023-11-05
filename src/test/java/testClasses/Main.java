package testClasses;

import utilities.JsonReader;

public class Main {
    public static void main(String[] args) {
         String classLocation = "/src/test/java/data/jsonFiles";
         String fileExtension = ".json";
         String projectLocation = "user.dir";
        System.out.println(System.getProperty(projectLocation) + classLocation + "..fileName.." + fileExtension);
        System.out.println(JsonReader.getValueFromJsonFile("accountCreatedPageLabel", "ValidationMessages"));
    }
}
