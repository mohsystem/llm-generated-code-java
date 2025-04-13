package llama3.task64;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.json.JSONObject;
import org.junit.jupiter.api.*;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class Task64Test {

    private MockWebServer mockWebServer;

    @BeforeEach
    public void setup() throws IOException {
        mockWebServer = new MockWebServer();
        mockWebServer.start();
    }

    @AfterEach
    public void tearDown() throws IOException {
        mockWebServer.shutdown();
    }

    @Test
    public void testReadJsonFromValidUrl() throws IOException {
        // Arrange
        String jsonBody = "{\"student\": \"Abdulrahman\", \"course\": \"COMP133\"}";
        mockWebServer.enqueue(new MockResponse()
                .setBody(jsonBody)
                .addHeader("Content-Type", "application/json"));

        String mockUrl = mockWebServer.url("/json").toString();

        // Act
        JSONObject result = Task64_PERPLEXITY_llama_3_sonar_large_32k_chat.readJsonFromUrl(mockUrl);

        // Assert
        JSONObject expected = new JSONObject(jsonBody);
        assertEquals(expected.toString(), result.toString());
    }

    @Test
    public void testInvalidUrlThrowsIOException() {
        assertThrows(IOException.class, () -> {
            Task64_PERPLEXITY_llama_3_sonar_large_32k_chat.readJsonFromUrl("http://invalid.invalid");
        });
    }
}
