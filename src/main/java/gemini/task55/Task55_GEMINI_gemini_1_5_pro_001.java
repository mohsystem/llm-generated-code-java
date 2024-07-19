package gemini.task55;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task55_GEMINI_gemini_1_5_pro_001 {
    public static boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static void main(String[] args) {
        String email = "user@example.com";
        if (isValidEmail(email)) {
            System.out.println("Valid Email");
        } else {
            System.out.println("Invalid Email");
        }
    }
}