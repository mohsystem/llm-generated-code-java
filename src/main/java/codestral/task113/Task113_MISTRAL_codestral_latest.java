package codestral.task113;

import java.util.Scanner;

public class Task113_MISTRAL_codestral_latest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        System.out.println("Enter strings to concatenate (enter 'end' to stop):");
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            sb.append(input);
            input = scanner.nextLine();
        }

        System.out.println("Concatenated string: " + sb.toString());
    }
}