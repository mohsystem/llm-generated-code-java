package claude.task52;

import java.io.*;
import java.util.Scanner;

public class Task52_CLAUDE_claude_3_5_sonnet_20240620 {
    private static final byte KEY = 0x42;

    public static void encryptDecrypt(String inputFile, String outputFile) throws IOException {
        try (FileInputStream fis = new FileInputStream(inputFile);
             FileOutputStream fos = new FileOutputStream(outputFile)) {
            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data ^ KEY);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter \'e\' to encrypt or \'d\' to decrypt: ");
        String choice = scanner.nextLine();
        System.out.print("Enter input file name: ");
        String inputFile = scanner.nextLine();
        System.out.print("Enter output file name: ");
        String outputFile = scanner.nextLine();

        try {
            encryptDecrypt(inputFile, outputFile);
            System.out.println("Operation completed successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
