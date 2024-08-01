package llama3.task70;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task70_PERPLEXITY_llama_3_sonar_large_32k_chat {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Task70_PERPLEXITY_llama_3_sonar_large_32k_chat <file_path>");
            return;
        }
        try (Scanner scanner = new Scanner(new File(args[0]))) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}