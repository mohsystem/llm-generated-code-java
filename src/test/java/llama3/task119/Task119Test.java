package llama3.task119;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Task119Test {

    public static boolean parseCSV(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                for (String value : values) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
            return true; // نجاح القراءة
        } catch (IOException e) {
            System.out.println("Error processing file: " + fileName);
            e.printStackTrace();
            return false; // فشل القراءة
        }
    }

    public static void main(String[] args) {
        String basePath = "C:\\Users\\1\\OneDrive\\Desktop\\llm-generated-code-java\\src\\test\\java\\llama3\\task119\\";
        String[] filePaths = {
                "tc1.csv",
                "tc2.csv",
                "tc3.csv",
                "tc4.csv",
                "tc5.csv",
                "tc6.csv",
                "tc7.csv",
                "tc8.csv",
                "tc9.csv",
                "tc10.csv"
        };

        for (String fileName : filePaths) {
            String fullPath = basePath + fileName;
            System.out.println("\nProcessing file: " + fileName);
            boolean success = parseCSV(fullPath);
            if (success) {
                System.out.println("Test case for " + fileName + ": PASS");
            } else {
                System.out.println("Test case for " + fileName + ": FAIL");
            }
        }
    }
}
