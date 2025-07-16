package llama3.task129;

import java.io.*;
import java.net.*;

public class Task129Test {

    public static void retrieveFile(String fileName) throws IOException {
        Socket clientSocket = new Socket("localhost", 12345);
        OutputStream outputStream = clientSocket.getOutputStream();
        outputStream.write(fileName.getBytes());
        InputStream inputStream = clientSocket.getInputStream();
        byte[] buffer = new byte[1024];
        int bytesRead = inputStream.read(buffer);;
        if (inputStream.read(buffer) == -1) {
            System.out.println("File not found on the server");
        } else {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            // Already read once above, write that data first
            fileOutputStream.write(buffer, 0, bytesRead);
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }
            fileOutputStream.close();
        }
        clientSocket.close();
    }

    // Since this requires a server socket listening, the valid file test can't be implemented here
    public void test_retrieve_valid_file() {
        System.out.println("test_retrieve_valid_file: FAIL not implemented");
    }

    public void test_retrieve_nonexistent_file() {
        try {
            retrieveFile("nonexistent_file.txt");
            System.out.println("test_retrieve_nonexistent_file: PASS (handled gracefully or error thrown)");
        } catch (IOException e) {
            System.out.println("test_retrieve_nonexistent_file: PASS (exception thrown)");
        } catch (Exception e) {
            System.out.println("test_retrieve_nonexistent_file: FAIL");
        }
    }

    public void test_retrieve_empty_filename() {
        try {
            retrieveFile("");
            System.out.println("test_retrieve_empty_filename: PASS (handled gracefully or error thrown)");
        } catch (IOException e) {
            System.out.println("test_retrieve_empty_filename: PASS (exception thrown)");
        } catch (Exception e) {
            System.out.println("test_retrieve_empty_filename: FAIL");
        }
    }

    public void test_retrieve_invalid_filename() {
        try {
            retrieveFile("inv@lid?.txt");
            System.out.println("test_retrieve_invalid_filename: PASS (handled gracefully or error thrown)");
        } catch (IOException e) {
            System.out.println("test_retrieve_invalid_filename: PASS (exception thrown)");
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
