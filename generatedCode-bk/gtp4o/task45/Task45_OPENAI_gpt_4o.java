package gtp4o.task45;

import java.util.Scanner;

public class Task45_OPENAI_gpt_4o {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        try {
            int number = scanner.nextInt();
            System.out.println("The entered integer is: " + number);
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter an integer.");
        }
    }
}