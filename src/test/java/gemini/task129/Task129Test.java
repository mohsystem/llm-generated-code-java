package gemini.task129;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Task129Test {

    public static void downloadFile(String fileName) throws IOException {
        String fileUrl = "https://example.com/files/" + fileName; // Matches your code
        URL url = new URL(fileUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        try (InputStream inputStream = connection.getInputStream()) {
            Files.copy(inputStream, Paths.get(fileName));
        }
    }

    // Test cases matching Python prompt semantics

    public void test_retrieve_valid_file() {
        // Cannot implement real test without actual server and file
        System.out.println("test_retrieve_valid_file: FAIL not implemented");
    }

    public void test_retrieve_nonexistent_file() {
        try {
            downloadFile("nonexistent_file.txt");
            System.out.println("test_retrieve_nonexistent_file: FAIL"); // Should throw exception
        } catch (IOException e) {
            System.out.println("test_retrieve_nonexistent_file: PASS");
        }
    }

    public void test_retrieve_empty_filename() {
        try {
            downloadFile("");
            System.out.println("test_retrieve_empty_filename: FAIL");
        } catch (IOException e) {
            System.out.println("test_retrieve_empty_filename: PASS");
        }
    }

    public void test_retrieve_invalid_filename() {
        try {
            downloadFile("inv@lid?.txt");
            System.out.println("test_retrieve_invalid_filename: FAIL");
        } catch (IOException e) {
            System.out.println("test_retrieve_invalid_filename: PASS");
        }
    }

    public static void main(String[] args) {
        Task129Test test = new Task129Test();

        test.test_retrieve_valid_file();
        test.test_retrieve_nonexistent_file();
        test.test_retrieve_empty_filename();
        test.test_retrieve_invalid_filename();
    }
}
