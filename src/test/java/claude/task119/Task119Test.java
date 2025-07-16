package claude.task119;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task119Test {

    public static boolean processCSV(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            String[] header = br.readLine().split(",");
            System.out.println("CSV Header: " + String.join(", ", header));

            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                System.out.println("Row: " + String.join(", ", row));
            }
            return true; // قراءة الملف ناجحة
        } catch (IOException e) {
            System.out.println("Error processing file: " + filePath);
            e.printStackTrace();
            return false; // فشل في القراءة
        }
    }
    public static void main(String[] args) {
        String[] filePaths = {
                "C:\\Users\\1\\OneDrive\\Desktop\\llm-generated-code-java\\src\\test\\java\\claude\\task119\\tc1.csv",
                "C:\\Users\\1\\OneDrive\\Desktop\\llm-generated-code-java\\src\\test\\java\\claude\\task119\\tc2.csv",
                "C:\\Users\\1\\OneDrive\\Desktop\\llm-generated-code-java\\src\\test\\java\\claude\\task119\\tc3.csv",
                "C:\\Users\\1\\OneDrive\\Desktop\\llm-generated-code-java\\src\\test\\java\\claude\\task119\\tc4.csv",
                "C:\\Users\\1\\OneDrive\\Desktop\\llm-generated-code-java\\src\\test\\java\\claude\\task119\\tc5.csv",
                "C:\\Users\\1\\OneDrive\\Desktop\\llm-generated-code-java\\src\\test\\java\\claude\\task119\\tc6.csv",
                "C:\\Users\\1\\OneDrive\\Desktop\\llm-generated-code-java\\src\\test\\java\\claude\\task119\\tc7.csv",
                "C:\\Users\\1\\OneDrive\\Desktop\\llm-generated-code-java\\src\\test\\java\\claude\\task119\\tc8.csv",
                "C:\\Users\\1\\OneDrive\\Desktop\\llm-generated-code-java\\src\\test\\java\\claude\\task119\\tc9.csv",
                "C:\\Users\\1\\OneDrive\\Desktop\\llm-generated-code-java\\src\\test\\java\\claude\\task119\\tc10.csv"
        };

        for (String filePath : filePaths) {
            System.out.println("\nProcessing file: " + filePath);
            boolean success = processCSV(filePath);
            if (success) {
                System.out.println("Test case for " + filePath + ": PASS");
            } else {
                System.out.println("Test case for " + filePath + ": FAIL");
            }
        }
    }
}
