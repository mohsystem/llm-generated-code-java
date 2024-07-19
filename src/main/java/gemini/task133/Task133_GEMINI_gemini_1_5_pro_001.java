package gemini.task133;

import java.util.Scanner;

public class Task133_GEMINI_gemini_1_5_pro_001 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        resetPassword(scanner);
    }

    public static void resetPassword(Scanner scanner) {
        while (true) {
            System.out.print("Enter your current password: ");
            String currentPassword = scanner.nextLine();
            if (currentPassword.equals("password123")) {
                break;
            } else {
                System.out.println("Incorrect password. Please try again.");
            }
        }

        while (true) {
            System.out.print("Enter your new password: ");
            String newPassword = scanner.nextLine();
            System.out.print("Confirm your new password: ");
            String confirmPassword = scanner.nextLine();
            if (newPassword.equals(confirmPassword)) {
                System.out.println("Password reset successful.");
                break;
            } else {
                System.out.println("Passwords don't match. Please try again.");
            }
        }
    }
}