package codestral.task62;

import org.json.JSONObject;

public class Task62_MISTRAL_codestral_latest {
    public static void main(String[] args) {
        String jsonString = "{\"key1\":\"value1\",\"key2\":\"value2\"}";
        JSONObject jsonObject = new JSONObject(jsonString);
        System.out.println("Root element: " + jsonObject.keys().next());
    }
}