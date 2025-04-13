package gemini.task50;

import org.junit.jupiter.api.*;

import java.io.*;
import java.net.Socket;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.*;

public class Task50Test {

    private static final int PORT = 65432;
    private static final String HOST = "localhost";
    private static final String FILE_NAME = "testFile.txt";
    private static final String FILE_CONTENT = "This is a test file.";

    private static Thread serverThread;

    @BeforeAll
    public static void startServer() {
        serverThread = new Thread(() -> {
            try {
                Task50_GEMINI_gemini_1_5_pro_001.main(null);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        serverThread.setDaemon(true);
        serverThread.start();

        try {
            Thread.sleep(500); // Give the server time to start
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @BeforeEach
    public void cleanupBefore() {
        File file = new File(System.getProperty("user.dir"), FILE_NAME);
        if (file.exists()) file.delete();
    }

    @Test
    public void testFileUpload() throws IOException {
        byte[] fileBytes = FILE_CONTENT.getBytes();
        long fileSize = fileBytes.length;

        try (Socket socket = new Socket(HOST, PORT)) {
            OutputStream out = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(out, true);

            // Send file name and file size
            writer.println(FILE_NAME);
            writer.println(fileSize);

            // Send file content
            out.write(fileBytes);
            out.flush();
        }

        // Look for the file in the server's working directory
        File uploadedFile = new File(System.getProperty("user.dir"), FILE_NAME);
        System.out.println("Checking for uploaded file at: " + uploadedFile.getAbsolutePath());

        assertTrue(uploadedFile.exists(), "Uploaded file was not created!");

        // Verify file content
        String savedContent = new String(Files.readAllBytes(uploadedFile.toPath()));
        assertEquals(FILE_CONTENT, savedContent, "File content does not match!");
    }
}
