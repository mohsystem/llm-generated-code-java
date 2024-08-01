package llama3.task45;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task45_PERPLEXITY_llama_3_sonar_large_32k_chat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter a number: ");
            int num = scanner.nextInt();
            System.out.println("You entered: " + num);
            System.out.print("Enter another number: ");
            int num2 = scanner.nextInt();
            System.out.println("You entered: " + num2);
            int result = num / num2;
            System.out.println("Result: " + result);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero.");
        } finally {
            scanner.close();
        }
    }
}