package codestral.task49;

import org.junit.jupiter.api.*;

import java.io.*;
import java.net.*;
import static org.junit.jupiter.api.Assertions.*;

public class Task49Test {
    private static Thread serverThread;

    @BeforeAll
    public static void startServer() {
        serverThread = new Thread(() -> {
            Task49_MISTRAL_codestral_latest.main(null);
        });
        serverThread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {}
    }

    @Test
    public void testCreateUser_returnsCorrectJsonAndStatus() throws IOException {
         URL url = new URL("http://localhost:8080/user");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

         connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        String jsonInput = "{\"name\":\"John Doe\", \"email\":\"john.doe2@example.com\"}";

        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonInput.getBytes();
            os.write(input);
        }

         int statusCode = connection.getResponseCode();
        assertEquals(200, statusCode);

         BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder responseBody = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            responseBody.append(line);
        }
        reader.close();

        String response = responseBody.toString();

         assertTrue(response.contains("\"name\":\"John Doe\""));
        assertTrue(response.contains("\"email\":\"john.doe2@example.com\""));
        assertTrue(response.contains("\"id\""));

        connection.disconnect();
    }
}
