package gemini.task64;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.json.JSONObject;
import org.junit.jupiter.api.*;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class Task64Test {

    private MockWebServer mockWebServer;

    @BeforeEach
    public void startServer() throws IOException {
        mockWebServer = new MockWebServer();
        mockWebServer.start();
    }

    @AfterEach
    public void shutdownServer() throws IOException {
        mockWebServer.shutdown();
    }

    @Test
    public void testValidJsonResponse() {
        // Arrange
        String expectedJson = "{\"message\": \"Hello, Abdulrahman!\", \"success\": true}";
        mockWebServer.enqueue(new MockResponse()
                .setBody(expectedJson)
                .addHeader("Content-Type", "application/json"));

        String mockUrl = mockWebServer.url("/test").toString();

        // Act
        JSONObject result = Task64_GEMINI_gemini_1_5_pro_001.getJsonFromUrl(mockUrl);

        // Assert
        assertNotNull(result);
        assertEquals(new JSONObject(expectedJson).toString(), result.toString());
    }

    @Test
    public void testInvalidUrlReturnsNull() {
        // Arrange
        String invalidUrl = "http://invalid-url";

        // Act
        JSONObject result = Task64_GEMINI_gemini_1_5_pro_001.getJsonFromUrl(invalidUrl);

        // Assert
        assertNull(result);
    }
}
