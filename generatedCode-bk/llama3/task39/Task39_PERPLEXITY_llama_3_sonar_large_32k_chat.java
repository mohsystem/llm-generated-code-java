package llama3.task39;

import java.util.Scanner;

public class Task39_PERPLEXITY_llama_3_sonar_large_32k_chat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a filename: ");
        String filename = scanner.nextLine();
        try {
            Process process = Runtime.getRuntime().exec("cat " + filename);
            process.waitFor();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}