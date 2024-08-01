package llama3.task54;

import java.util.Random;
import java.util.Scanner;

public class Task54_PERPLEXITY_llama_3_sonar_large_32k_chat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Enter username:");
        String username = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();

        if (username.equals("admin") && password.equals("password")) {
            int otp = random.nextInt(900000) + 100000;
            System.out.println("One Time Password (OTP) is: " + otp);
            System.out.println("Enter OTP:");
            int userOtp = scanner.nextInt();

            if (userOtp == otp) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Invalid OTP. Login failed.");
            }
        } else {
            System.out.println("Invalid username or password. Login failed.");
        }
    }
}