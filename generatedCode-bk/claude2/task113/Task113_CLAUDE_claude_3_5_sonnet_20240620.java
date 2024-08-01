package claude2.task113;

import java.util.Scanner;

public class Task113_CLAUDE_claude_3_5_sonnet_20240620 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder result = new StringBuilder();
        
        System.out.println("Enter strings to concatenate (type \'done\' to finish):");
        
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            result.append(input);
        }
        
        System.out.println("Concatenated string: " + result.toString());
        scanner.close();
    }
}
