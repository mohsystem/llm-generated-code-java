package claude.task98;

import java.util.Scanner;

public class Task98_CLAUDE_claude_3_5_sonnet_20240620 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        String input = scanner.nextLine();
        
        try {
            int number = Integer.parseInt(input);
            System.out.println("Converted integer: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Not a valid integer.");
        }
        
        scanner.close();
    }
}
