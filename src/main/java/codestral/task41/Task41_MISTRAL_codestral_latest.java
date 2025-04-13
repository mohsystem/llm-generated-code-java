package codestral.task41;

import java.util.Scanner;

public class Task41_MISTRAL_codestral_latest {
    public static String processString(String inputString) {
        return "Processed string: " + inputString;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String inputString = scanner.nextLine();
        System.out.println(processString(inputString));
    }
}
