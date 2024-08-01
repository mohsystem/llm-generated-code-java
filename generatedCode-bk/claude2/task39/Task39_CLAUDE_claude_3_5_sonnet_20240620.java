package claude2.task39;

import java.util.Scanner;

public class Task39_CLAUDE_claude_3_5_sonnet_20240620 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the filename: ");
        String filename = scanner.nextLine();
        scanner.close();

        try {
            Process process = Runtime.getRuntime().exec("cat " + filename);
            Scanner outputScanner = new Scanner(process.getInputStream());
            while (outputScanner.hasNextLine()) {
                System.out.println(outputScanner.nextLine());
            }
            outputScanner.close();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
