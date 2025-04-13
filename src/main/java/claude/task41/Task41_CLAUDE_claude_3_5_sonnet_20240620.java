package claude.task41;

import java.util.Scanner;

public class Task41_CLAUDE_claude_3_5_sonnet_20240620 {

     public static String processInput(String input) {
        if (input.length() > 100) {
            input = input.substring(0, 100);
        }
        return "Processed input: " + input;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string (max 100 characters): ");
        String userInput = scanner.nextLine();

         System.out.println(processInput(userInput));
        scanner.close();
    }
}
