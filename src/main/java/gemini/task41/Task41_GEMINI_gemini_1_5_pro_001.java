package gemini.task41;

import java.util.Scanner;

public class Task41_GEMINI_gemini_1_5_pro_001 {

    public static String processInput(String input) {
        // Simulate safe processing (limit to 100 chars for consistency with Python test)
        if (input.length() > 100) {
            input = input.substring(0, 100);
        }
        return "Processed input: " + input;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(processInput(input));
    }
}
