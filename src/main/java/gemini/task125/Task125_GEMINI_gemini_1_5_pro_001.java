package gemini.task125;

import java.util.Scanner;

public class Task125_GEMINI_gemini_1_5_pro_001 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        String userInput = scanner.nextLine();

        if (userInput.equals("option1")) {
            System.out.println("Accessing resource 1...");
        } else if (userInput.equals("option2")) {
            System.out.println("Accessing resource 2...");
        } else {
            System.out.println("Invalid choice.");
        }
    }
}