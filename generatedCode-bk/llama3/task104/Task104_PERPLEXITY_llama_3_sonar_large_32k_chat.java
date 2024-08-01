package llama3.task104;

import java.util.Scanner;

public class Task104_PERPLEXITY_llama_3_sonar_large_32k_chat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte[] buffer = new byte[10];
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        byte[] inputBytes = input.getBytes();
        if (inputBytes.length > buffer.length) {
            System.out.println("Input too large for buffer.");
        } else {
            System.arraycopy(inputBytes, 0, buffer, 0, inputBytes.length);
            System.out.println("Buffer contents: " + new String(buffer));
        }
    }
}