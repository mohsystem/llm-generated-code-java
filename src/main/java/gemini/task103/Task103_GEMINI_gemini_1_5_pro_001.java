package gemini.task103;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task103_GEMINI_gemini_1_5_pro_001 {

    public static void main(String[] args) {
        String password = "YourPasswordHere";
        checkPasswordStrength(password);
    }

    public static void checkPasswordStrength(String password) {
        if (password.length() < 8) {
            System.out.println("Password must be at least 8 characters long.");
            return;
        }

        Pattern pattern = Pattern.compile("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).*");
        Matcher matcher = pattern.matcher(password);

        if (!matcher.matches()) {
            System.out.println("Password must contain at least one uppercase letter, one lowercase letter, and one digit.");
            return;
        }

        System.out.println("Strong password.");
    }
}