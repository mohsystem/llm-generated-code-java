package claude.task51;

import java.util.Scanner;

public class Task51_CLAUDE_claude_3_5_sonnet_20240620 {
    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isUpperCase(character) ? 'A' : 'a';
                result.append((char) ((character - base + shift) % 26 + base));
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to encrypt: ");
        String text = scanner.nextLine();
        System.out.print("Enter the shift value: ");
        int shift = scanner.nextInt();
        String encrypted = encrypt(text, shift);
        System.out.println("Encrypted string: " + encrypted);
        scanner.close();
    }
}
