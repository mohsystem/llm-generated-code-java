package llama3.task49;

import org.junit.jupiter.api.*;
import java.net.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

public class Task49Test {

    private static final String BASE_URL = "http://localhost:8080/users";  // Make sure this URL matches your API path

    @BeforeAll
    public static void startServer() throws Exception {
        Thread serverThread = new Thread(() -> {
            try {
                Task49_PERPLEXITY_llama_3_sonar_large_32k_chat.main(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        serverThread.start();
        Thread.sleep(2000);  // Wait for server to start
    }

    @Test
    public void testCreateUser_returnsCorrectJsonAndStatus() throws IOException {
        // Setup connection to the API endpoint
        URL url = new URL(BASE_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Prepare POST request
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        connection.setDoOutput(true);

        // Prepare user data
        String jsonInputString = "name=John%20Doe&email=johndoe@example.com";

        // Send data
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        // Check response status and message
        int statusCode = connection.getResponseCode();
        assertEquals(201, statusCode);

        // Read response body
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        // Assert response message
        String responseBody = response.toString();
        assertTrue(responseBody.contains("\"message\":\"User created successfully\""));
    }
}
