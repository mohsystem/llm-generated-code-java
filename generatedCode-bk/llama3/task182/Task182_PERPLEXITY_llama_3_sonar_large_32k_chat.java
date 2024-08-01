package llama3.task182;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task182_PERPLEXITY_llama_3_sonar_large_32k_chat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.println(cleanPhoneNumber(phoneNumber));
    }

    public static String cleanPhoneNumber(String phoneNumber) {
        String cleanNumber = phoneNumber.replaceAll("[^\\d]", "");
        if (cleanNumber.startsWith("1")) {
            cleanNumber = cleanNumber.substring(1);
        }
        return cleanNumber;
    }
}