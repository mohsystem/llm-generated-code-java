package codestral.task50;

import org.junit.jupiter.api.*;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.*;

public class Task50Test {

    private static final String HOST = "http://localhost";
    private static final int PORT = 8080;
    private static final String ENDPOINT = "/upload";
    private static final String FILE_CONTENT = "This is a test file.";
    private static final String FILE_NAME = "testFile.txt";
    private static final String UPLOAD_DIR = "uploads/";

    private static Thread serverThread;

    @BeforeAll
    public static void startServer() {
        serverThread = new Thread(() -> {
            try {
                EmbeddedSpringLikeServer.start(PORT);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        serverThread.setDaemon(true);
        serverThread.start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @BeforeEach
    public void setup() {
        File uploadedFile = new File(UPLOAD_DIR + FILE_NAME);
        if (uploadedFile.exists()) {
            uploadedFile.delete();
        }
    }

    @Test
    public void testUploadFile() throws IOException {
        URL url = new URL(HOST + ":" + PORT + ENDPOINT);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/octet-stream");

        try (OutputStream os = conn.getOutputStream()) {
            os.write(FILE_CONTENT.getBytes());
            os.flush();
        }

        assertEquals(200, conn.getResponseCode());

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String response = in.readLine();
        in.close();

        assertEquals("File uploaded successfully", response);

         File uploadedFile = new File(UPLOAD_DIR + FILE_NAME);
        assertTrue(uploadedFile.exists());
        String savedContent = new String(Files.readAllBytes(uploadedFile.toPath()));
        assertEquals(FILE_CONTENT, savedContent);
    }
}
