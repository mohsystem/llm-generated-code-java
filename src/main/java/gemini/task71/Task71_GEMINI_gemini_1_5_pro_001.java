package gemini.task71;

import java.lang.NumberFormatException;
public class Task71_GEMINI_gemini_1_5_pro_001 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide an argument.");
            return;
        }
        try {
            int intValue = Integer.parseInt(args[0]);
            System.out.println("The integer value is: " + intValue);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
        }
    }
}