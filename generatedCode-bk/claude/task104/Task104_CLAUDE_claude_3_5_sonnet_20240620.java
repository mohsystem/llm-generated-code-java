package claude.task104;

import java.util.Scanner;

public class Task104_CLAUDE_claude_3_5_sonnet_20240620 {
    private static final int BUFFER_SIZE = 20;

    public static void main(String[] args) {
        char[] buffer = new char[BUFFER_SIZE];
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string (max " + BUFFER_SIZE + " characters):");
        String input = scanner.nextLine();

        int length = Math.min(input.length(), BUFFER_SIZE);
        input.getChars(0, length, buffer, 0);

        System.out.println("Buffer contents:");
        System.out.println(new String(buffer, 0, length));

        scanner.close();
    }
}
