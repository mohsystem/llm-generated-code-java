package gtp4o.task126;

import java.util.Scanner;

public class Task126_OPENAI_gpt_4o {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter user role (admin/user/guest): ");
        String input = scanner.nextLine().trim().toLowerCase();

        switch (input) {
            case "admin":
                System.out.println("Redirecting to admin page...");
                break;
            case "user":
                System.out.println("Redirecting to user page...");
                break;
            case "guest":
                System.out.println("Redirecting to guest page...");
                break;
            default:
                System.out.println("Invalid role!");
                break;
        }
        scanner.close();
    }
}