package gtp4o.task129;

import java.io.*;
import java.net.*;

public class Task129Test {

    // Method from your code: fetchFile returns content or error string
    public static String fetchFile(String fileName) {
        StringBuilder result = new StringBuilder();
        try {
            URL url = new URL("http://example.com/" + fileName);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null)
                result.append(inputLine).append("\n");
            in.close();
        } catch (Exception e) {
            return "Failed to retrieve file: " + e.getMessage();
        }
        return result.toString();
    }

    // Test cases corresponding to python prompt intent
    public void test_retrieve_valid_file() {
        // Cannot implement actual test without server; mark not implemented
        System.out.println("test_retrieve_valid_file: FAIL not implemented");
    }

    public void test_retrieve_nonexistent_file() {
        String content = fetchFile("nonexistent_file.txt");
        if (content.startsWith("Failed to retrieve file:")) {
            System.out.println("test_retrieve_nonexistent_file: PASS");
        } else {
            System.out.println("test_retrieve_nonexistent_file: FAIL");
        }
    }

    public void test_retrieve_empty_filename() {
        String content = fetchFile("");
        if (content.startsWith("Failed to retrieve file:")) {
            System.out.println("test_retrieve_empty_filename: PASS");
        } else {
            System.out.println("test_retrieve_empty_filename: FAIL");
        }
    }

    public void test_retrieve_invalid_filename() {
        String content = fetchFile("inv@lid?.txt");
        if (content.startsWith("Failed to retrieve file:")) {
            System.out.println("test_retrieve_invalid_filename: PASS");
        } else {
            System.out.println("test_retrieve_invalid_filename: FAIL");
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
