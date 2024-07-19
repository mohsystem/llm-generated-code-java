package codestral.task131;

import com.google.gson.Gson;
import java.lang.*;

public class Task131_MISTRAL_codestral_latest {
    public static Object deserializeJson(String jsonData) {
        Gson gson = new Gson();
        return gson.fromJson(jsonData, Object.class);
    }
}