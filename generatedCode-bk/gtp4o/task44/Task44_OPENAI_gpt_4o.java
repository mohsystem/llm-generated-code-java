package gtp4o.task44;

import java.util.Scanner;

public class Task44_OPENAI_gpt_4o {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        if (scanner.hasNextInt()) {
            int userInput = scanner.nextInt();
            int result = performOperation(userInput);
            System.out.println("The result from Java operation is: " + result);
        } else {
            System.out.println("Invalid input.");
        }
    }

    private static int performOperation(int input) {
        return input * 2;
    }
}