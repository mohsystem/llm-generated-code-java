package llama3.task64;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.json.JSONObject;

public class Task64_PERPLEXITY_llama_3_sonar_large_32k_chat {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Usage: java Task64_PERPLEXITY_llama_3_sonar_large_32k_chat <url>");
            return;
        }
        String url = args[0];
        URL obj = new URL(url);
        URLConnection con = obj.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        JSONObject jsonObject = new JSONObject(response.toString());
        System.out.println(jsonObject);
    }
}