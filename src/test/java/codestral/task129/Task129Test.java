package codestral.task129;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class Task129Test {

    // Method from your provided code (download file)
    public static void downloadFile(String urlStr, String fileName) throws IOException {
        URL url = new URL(urlStr);
        ReadableByteChannel rbc = Channels.newChannel(url.openStream());
        FileOutputStream fos = new FileOutputStream(fileName);
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        fos.close();
        rbc.close();
    }

    // Simulate retrieval using downloadFile and test error handling
    public void test_retrieve_valid_file() {
        // Not implemented, requires actual reachable URL and file
        System.out.println("test_retrieve_valid_file: FAIL not implemented");
    }

    public void test_retrieve_nonexistent_file() {
        try {
            downloadFile("http://example.com/nonexistent_file.txt", "nonexistent_file.txt");
            System.out.println("test_retrieve_nonexistent_file: FAIL"); // Should fail and throw IOException
        } catch (IOException e) {
            System.out.println("test_retrieve_nonexistent_file: PASS");
        }
    }

    public void test_retrieve_empty_filename() {
        try {
            downloadFile("http://example.com/", "");
            System.out.println("test_retrieve_empty_filename: FAIL");
        } catch (IOException e) {
            System.out.println("test_retrieve_empty_filename: PASS");
        }
    }

    public void test_retrieve_invalid_filename() {
        try {
            downloadFile("http://example.com/inv@lid?.txt", "inv@lid?.txt");
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
