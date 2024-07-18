package claude.task41;

import java.util.Scanner;

public class Task41_CLAUDE_claude_3_5_sonnet_20240620 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        scanner.close();

        // Process the input string
        String processed = processString(input);
        System.out.println("Processed string: " + processed);
    }

    private static String processString(String input) {
        // Example processing: convert to uppercase
        return input.toUpperCase();
    }
}
