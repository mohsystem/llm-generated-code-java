package codestral.task158;

import java.util.Scanner;
import java.io.IOException;

public class Task158_MISTRAL_codestral_latest {
    public static void main(String[] args) throws IOException {
        // Create a Scanner object for reading user input
        Scanner scanner = new Scanner(System.in);

        // Get user input
        System.out.println("Enter data for OS command: ");
        String userInput = scanner.nextLine();

        // Run OS command with user input
        Runtime.getRuntime().exec("your_command " + userInput);
    }
}