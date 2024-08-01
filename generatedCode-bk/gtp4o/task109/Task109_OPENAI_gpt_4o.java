package gtp4o.task109;

import java.util.Scanner;
import java.util.regex.*;

public class Task109_OPENAI_gpt_4o {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string in Java:");
        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9]*$");
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            System.out.println("Valid Java Input");
        } else {
            System.out.println("Invalid Java Input");
        }
    }
}