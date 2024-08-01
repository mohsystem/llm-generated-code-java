package llama3.task98;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task98_PERPLEXITY_llama_3_sonar_large_32k_chat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter an integer: ");
            int num = scanner.nextInt();
            System.out.println("You entered: " + num);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter an integer.");
        }
    }
}