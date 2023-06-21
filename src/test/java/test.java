import data.JsonReader;

public class test {
    public static void main(String[] args) {
        // Get the value of a key
        JsonReader.updateValueInJsonFile2("RegisteredUserData", "name", "yahia yahia");
        JsonReader.updateValueInJsonFile2("RegisteredUserData", "email", "yahia @yahia");
        JsonReader.updateValueInJsonFile2("RegisteredUserData", "password", "yahia @@@@@@yahia");

        System.out.println(JsonReader.getValueFromJsonFile2("RegisteredUserData", "name"));
        System.out.println(JsonReader.getValueFromJsonFile2("RegisteredUserData", "email"));
        System.out.println(JsonReader.getValueFromJsonFile2("RegisteredUserData", "password"));
    }
}
