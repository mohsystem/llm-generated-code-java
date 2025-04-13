package llama3.task41;

import java.util.Scanner;

public class Task41_PERPLEXITY_llama_3_sonar_large_32k_chat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String userInput = scanner.nextLine();
        System.out.println("You entered: " + userInput);
    }

    public static String processInput(String input) {
        if (input.length() > 100) {
            input = input.substring(0, 100);
        }
        return "Processed input: " + input;
    }
}
