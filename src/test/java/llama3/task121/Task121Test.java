package llama3.task121;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Task121Test {

    public static boolean uploadFile(String filename) {
        String basePath = "C:\\Users\\1\\OneDrive\\Desktop\\llm-generated-code-java\\src\\test\\java\\llama3\\task121\\";
        File file = new File(basePath + filename);

        if (!file.exists()) {
            System.out.println("File '" + filename + "' not found.");
            return false;
        }

        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] content = fis.readAllBytes();
            System.out.println("File '" + filename + "' uploaded successfully.");
            System.out.println("File size: " + content.length + " bytes");
            return true;
        } catch (IOException e) {
            System.out.println("Error reading file '" + filename + "': " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        String[] filenames = {
                "test_file_1.txt",
                "large_file.txt",
                "file_with_!@#$%^&*()_+[]{};,.txt",
                "file_no_extension",
                "empty_file.txt",
                "non_existent_file.txt",
                "file with spaces.txt",
                "a_very_long_filename_that_exceeds_normal_length_limits_for_filenames.txt",
                "image_file.png",
                "file_with_newlines.txt",
                "file_not_found.txt"
        };

        for (String filename : filenames) {
            System.out.println("\nUploading file: " + filename);
            boolean result = uploadFile(filename);
            if (result) {
                System.out.println("Test case for '" + filename + "': PASS");
            } else {
                System.out.println("Test case for '" + filename + "': FAIL");
            }
        }
    }
}
