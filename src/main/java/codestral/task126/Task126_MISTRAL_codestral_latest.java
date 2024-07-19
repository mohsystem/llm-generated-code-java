package codestral.task126;

import java.util.Scanner;

public class Task126_MISTRAL_codestral_latest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a page: ");
        String input = scanner.nextLine();

        if (input.equals("home")) {
            System.out.println("Redirecting to home page...");
        } else if (input.equals("about")) {
            System.out.println("Redirecting to about page...");
        } else if (input.equals("contact")) {
            System.out.println("Redirecting to contact page...");
        } else {
            System.out.println("Invalid input. Staying on current page.");
        }
    }
}