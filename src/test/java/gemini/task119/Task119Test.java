package gemini.task119;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task119Test {

    public static boolean processCSV(String csvFile) {
        String line;
        String csvSplitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);
                System.out.println(String.join(", ", data));
            }
            return true; // القراءة ناجحة
        } catch (IOException e) {
            System.out.println("Error processing file: " + csvFile);
            e.printStackTrace();
            return false; // فشل القراءة
        }
    }

    public static void main(String[] args) {
        String basePath = "C:\\Users\\1\\OneDrive\\Desktop\\llm-generated-code-java\\src\\test\\java\\gemini\\task119\\";
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
            boolean success = processCSV(fullPath);
            if (success) {
                System.out.println("Test case for " + fileName + ": PASS");
            } else {
                System.out.println("Test case for " + fileName + ": FAIL");
            }
        }
    }
}
