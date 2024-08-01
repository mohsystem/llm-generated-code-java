package gtp4o.task73;

import java.util.Scanner;

public class Task73_OPENAI_gpt_4o {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter admin password: ");
        String adminPassword = scanner.nextLine();
        if (isValidPassword(adminPassword)) {
            System.out.println("Java: Password is valid.");
        } else {
            System.out.println("Java: Password is invalid.");
        }

        runCPasswordCheck(adminPassword);
        runCPPPasswordCheck(adminPassword);
        runPythonPasswordCheck(adminPassword);
    }

    public static boolean isValidPassword(String password) {
        return "admin123".equals(password);
    }

    public static native void runCPasswordCheck(String password);
    public static native void runCPPPasswordCheck(String password);
    public static native void runPythonPasswordCheck(String password);

    static {
        System.loadLibrary("passwordcheck");
    }
}