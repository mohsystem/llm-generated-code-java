package codestral.task133;// Java
import java.util.Scanner;

public class Task133_MISTRAL_codestral_latest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your current password: ");
        String currentPassword = scanner.nextLine();

        System.out.print("Enter your new password: ");
        String newPassword = scanner.nextLine();

        System.out.print("Confirm your new password: ");
        String confirmPassword = scanner.nextLine();

        if (newPassword.equals(confirmPassword)) {
            System.out.println("Password reset successful.");
        } else {
            System.out.println("Passwords do not match. Password reset failed.");
        }
    }
}