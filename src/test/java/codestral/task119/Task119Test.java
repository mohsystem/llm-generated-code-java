package codestral.task119;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task119Test {

    public static boolean processCSV(String filePath) {
        String line = "";
        String splitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // قراءة الهيدر (السطر الأول)
            if ((line = br.readLine()) != null) {
                String[] header = line.split(splitBy);
                System.out.println("CSV Header: " + String.join(", ", header));
            } else {
                System.out.println("File is empty: " + filePath);
                return false;
            }
            // قراءة بقية الصفوف
            while ((line = br.readLine()) != null) {
                String[] data = line.split(splitBy);
                System.out.print("Row: ");
                for (int i = 0; i < data.length; i++) {
                    System.out.print(data[i]);
                    if (i != data.length - 1) System.out.print(", ");
                }
                System.out.println();
            }
            return true; // النجاح
        } catch (IOException e) {
            System.out.println("Error processing file: " + filePath);
            e.printStackTrace();
            return false; // فشل
        }
    }

    public static void main(String[] args) {
        String[] filePaths = {
                "C:\\Users\\1\\OneDrive\\Desktop\\llm-generated-code-java\\src\\test\\java\\codestral\\task119\\tc1.csv",
                "C:\\Users\\1\\OneDrive\\Desktop\\llm-generated-code-java\\src\\test\\java\\codestral\\task119\\tc2.csv",
                "C:\\Users\\1\\OneDrive\\Desktop\\llm-generated-code-java\\src\\test\\java\\codestral\\task119\\tc3.csv",
                "C:\\Users\\1\\OneDrive\\Desktop\\llm-generated-code-java\\src\\test\\java\\codestral\\task119\\tc4.csv",
                "C:\\Users\\1\\OneDrive\\Desktop\\llm-generated-code-java\\src\\test\\java\\codestral\\task119\\tc5.csv",
                "C:\\Users\\1\\OneDrive\\Desktop\\llm-generated-code-java\\src\\test\\java\\codestral\\task119\\tc6.csv",
                "C:\\Users\\1\\OneDrive\\Desktop\\llm-generated-code-java\\src\\test\\java\\codestral\\task119\\tc7.csv",
                "C:\\Users\\1\\OneDrive\\Desktop\\llm-generated-code-java\\src\\test\\java\\codestral\\task119\\tc8.csv",
                "C:\\Users\\1\\OneDrive\\Desktop\\llm-generated-code-java\\src\\test\\java\\codestral\\task119\\tc9.csv",
                "C:\\Users\\1\\OneDrive\\Desktop\\llm-generated-code-java\\src\\test\\java\\codestral\\task119\\tc10.csv"
        };

        for (String filePath : filePaths) {
            System.out.println("\nProcessing file: " + filePath);
            boolean result = processCSV(filePath);
            if (result) {
                System.out.println("Test case for " + filePath + ": PASS");
            } else {
                System.out.println("Test case for " + filePath + ": FAIL");
            }
        }
    }
}
