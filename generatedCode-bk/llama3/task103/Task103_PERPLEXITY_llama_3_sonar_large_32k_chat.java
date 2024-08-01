package llama3.task103;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task103_PERPLEXITY_llama_3_sonar_large_32k_chat {
    public static void main(String[] args) {
        String password = "YourPasswordHere";
        if (isValidPassword(password)) {
            System.out.println("Strong password");
        } else {
            System.out.println("Weak password");
        }
    }

    public static boolean isValidPassword(String password) {
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$";
        Pattern pat = Pattern.compile(passwordRegex);
        Matcher matcher = pat.matcher(password);
        return matcher.find();
    }
}