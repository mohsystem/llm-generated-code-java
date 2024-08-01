package llama3.task109;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;

public class Task109_PERPLEXITY_llama_3_sonar_large_32k_chat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your email:");
        String email = scanner.nextLine();
        String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            System.out.println("Email is valid");
        } else {
            System.out.println("Email is not valid");
        }
    }
}