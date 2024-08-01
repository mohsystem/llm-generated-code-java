package codestral.task110;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task110_MISTRAL_codestral_latest {
    public static boolean isValidURL(String url) {
        String urlPattern = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        Pattern pattern = Pattern.compile(urlPattern);
        Matcher matcher = pattern.matcher(url);
        return matcher.matches();
    }

    public static void main(String[] args) {
        String url = "http://www.example.com";
        if (isValidURL(url)) {
            System.out.println("URL is valid");
        } else {
            System.out.println("URL is not valid");
        }
    }
}