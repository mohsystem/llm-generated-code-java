package gtp4o.task64;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Task64_OPENAI_gpt_4o {
    public static JsonObject fetchJsonFromUrl(String urlString) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder jsonStringBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            jsonStringBuilder.append(line);
        }
        reader.close();

        return JsonParser.parseString(jsonStringBuilder.toString()).getAsJsonObject();
    }

    public static void main(String[] args) throws Exception {
        String url = args[0];
        JsonObject jsonObject = fetchJsonFromUrl(url);
        System.out.println(jsonObject);
    }
}