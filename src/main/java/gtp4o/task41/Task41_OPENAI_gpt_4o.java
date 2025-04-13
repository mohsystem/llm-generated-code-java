package gtp4o.task41;

import java.util.Scanner;

public class Task41_OPENAI_gpt_4o {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string (Java): ");
        String inputJava = scanner.nextLine();
        System.out.println("You entered (Java): " + inputJava);
        Task41_OPENAI_gpt_4o.runCpp();
    }

    // Simulate the call to the C++ part
    public static void runCpp() {
        System.out.println("\nTransitioning to C++ part...\n");
        String[] args = {};
        CppPart.main(args);
    }
    public static String processInput(String input) {
        if (input.length() > 100) {
            input = input.substring(0, 100);
        }
        return "Processed input: " + input;
    }
}

class CppPart {
    public static void main(String[] args) {
        // Invoking C++ like behavior from Java
        System.out.println("Enter a string (Cpp): ");
        Scanner scanner = new Scanner(System.in);
        String inputCpp = scanner.nextLine();
        System.out.println("You entered (Cpp): " + inputCpp);

        // Simulate the call to the C part
        System.out.println("\nTransitioning to C part...\n");
        Task41_OPENAI_gpt_4o.main(args);
    }
}