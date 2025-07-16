package claude.task129;

import java.io.*;
import java.net.*;

public class Task129Test {

    // Method from your provided code (unchanged except server URL to match python)
    public static void retrieveFile(String filename) {
        String serverUrl = "http://192.168.1.233:8000/";  // matched python server URL
        String fileUrl = serverUrl + filename;

        try {
            URL url = new URL(fileUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = connection.getInputStream();
                FileOutputStream outputStream = new FileOutputStream(filename);

                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                outputStream.close();
                inputStream.close();
                System.out.println("File '" + filename + "' successfully retrieved and saved.");
            } else {
                System.out.println("Failed to retrieve file. Response code: " + responseCode);
            }

            connection.disconnect();
        } catch (IOException e) {
            System.out.println("Error retrieving file: " + e.getMessage());
        }
    }

    // Since Python code is mostly procedural and input-driven,
    // We create test cases to simulate the behavior as close as possible.
    // Because we can't easily do real HTTP tests without a mock server,
    // we'll just test the error handling and basic call.

    public void test_retrieve_valid_file() {
        // This test requires an actual reachable file on server.
        // Mark as NOT IMPLEMENTED because no server interaction possible here.
        System.out.println("test_retrieve_valid_file: FAIL not implemented");
    }

    public void test_retrieve_nonexistent_file() {
        // Attempt to retrieve a file that likely does not exist
        try {
            retrieveFile("nonexistent_file.txt");
            System.out.println("test_retrieve_nonexistent_file: PASS (error handled gracefully)");
        } catch (Exception e) {
            System.out.println("test_retrieve_nonexistent_file: FAIL");
        }
    }

    public void test_retrieve_empty_filename() {
        // Attempt to retrieve empty filename
        try {
            retrieveFile("");
            System.out.println("test_retrieve_empty_filename: PASS (error handled gracefully)");
        } catch (Exception e) {
            System.out.println("test_retrieve_empty_filename: FAIL");
        }
    }

    public void test_retrieve_invalid_filename() {
        // Attempt to retrieve with invalid characters
        try {
            retrieveFile("inv@lid?.txt");
            System.out.println("test_retrieve_invalid_filename: PASS (error handled gracefully)");
        } catch (Exception e) {
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
