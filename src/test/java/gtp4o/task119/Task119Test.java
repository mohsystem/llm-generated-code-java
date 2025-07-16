package gtp4o.task119;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Task119Test {

    public static boolean readCSV(String filePath) {
        String line = "";
        String splitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                String[] row = line.split(splitBy);
                for (String data : row) {
                    System.out.print(data + " ");
                }
                System.out.println();
            }
            return true;
        } catch (IOException e) {
            System.out.println("Error processing file: " + filePath);
            e.printStackTrace();
            return false;
        }
    }

    public static void writeCSV(String filePath, String[][] data) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (String[] row : data) {
                writer.append(String.join(",", row));
                writer.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // البيانات للكتابة فقط في المثال (يمكن تجاهلها أو استخدامها كما هي)
        String[][] data = {
                {"Name", "Age", "City"},
                {"Alice", "30", "New York"},
                {"Bob", "25", "Los Angeles"},
                {"Charlie", "35", "Chicago"}
        };

        // لم يتم التعديل على الكتابة (غير مطلوبة بالتست كيسز)
        // String filePath = "example.csv";
        // writeCSV(filePath, data);
        // readCSV(filePath);

        // الآن تنفيذ التست كيسز من tc1.csv إلى tc10.csv
        String basePath = "C:\\Users\\1\\OneDrive\\Desktop\\llm-generated-code-java\\src\\test\\java\\gtp4o\\task119\\";
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
            boolean success = readCSV(fullPath);
            if (success) {
                System.out.println("Test case for " + fileName + ": PASS");
            } else {
                System.out.println("Test case for " + fileName + ": FAIL");
            }
        }
    }
}
