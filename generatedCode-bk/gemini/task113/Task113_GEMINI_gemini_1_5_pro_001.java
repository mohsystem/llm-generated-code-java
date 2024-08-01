package gemini.task113;

import java.util.Scanner;

public class Task113_GEMINI_gemini_1_5_pro_001 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder concatenatedString = new StringBuilder();

        while (true) {
            System.out.print("Enter a string (or type 'quit' to exit): ");
            String inputString = scanner.nextLine();

            if (inputString.equalsIgnoreCase("quit")) {
                break;
            }

            concatenatedString.append(inputString);
        }

        System.out.println("Concatenated string: " + concatenatedString.toString());
    }
}