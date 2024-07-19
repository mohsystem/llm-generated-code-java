package codestral.task55;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Task55_MISTRAL_codestral_latest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your email: ");
        String email = scanner.nextLine();
        scanner.close();

        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";

        Pattern pattern = Pattern.compile(emailRegex);
        if (pattern.matcher(email).matches()) {
            System.out.println("Valid email address");
        } else {
            System.out.println("Invalid email address");
        }
    }
}