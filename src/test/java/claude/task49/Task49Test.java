package claude.task49;

import org.junit.jupiter.api.*;
import java.io.*;
import java.net.*;
import static org.junit.jupiter.api.Assertions.*;

public class Task49Test {
    private static Thread serverThread;

    @BeforeAll
    public static void startServer() {
        serverThread = new Thread(() -> {
            try {
                Task49_CLAUDE_claude_3_5_sonnet_20240620.main(null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        serverThread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {}
    }

    @Test
    public void testCreateUser_returns201AndCorrectMessage() throws Exception {
        URL url = new URL("http://127.0.0.1:8000/api/users");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);

        String postData = "name=John+Doe&email=john.doe2%40example.com";
        byte[] out = postData.getBytes();

        connection.setFixedLengthStreamingMode(out.length);
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        connection.connect();

        try (OutputStream os = connection.getOutputStream()) {
            os.write(out);
        }

        int statusCode = connection.getResponseCode();
        assertEquals(201, statusCode);

        StringBuilder response = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(connection.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        }

        assertEquals("User created successfully", response.toString());
    }
}
