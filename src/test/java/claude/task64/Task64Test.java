package claude.task64;

import static org.junit.jupiter.api.Assertions.*;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.json.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Task64Test {

    private MockWebServer mockWebServer;

    @BeforeEach
    public void setup() throws IOException {
        mockWebServer = new MockWebServer();
        mockWebServer.start();
    }

    @AfterEach
    public void teardown() throws IOException {
        mockWebServer.shutdown();
    }

    @Test
    public void testFetchJSON() throws Exception {
        // Arrange: prepare expected JSON and response
        String mockJson = "{\"name\": \"Abdulrahman\", \"age\": 25}";
        mockWebServer.enqueue(new MockResponse()
                .setBody(mockJson)
                .addHeader("Content-Type", "application/json"));

        String testUrl = mockWebServer.url("/data").toString();

        // Act: call the method
        JSONObject result = Task64_CLAUDE_claude_3_5_sonnet_20240620.fetchJSON(testUrl);

        // Assert: check the result matches the expected JSON
        JSONObject expected = new JSONObject(mockJson);
        assertEquals(expected.toString(), result.toString());
    }

    @Test
    public void testInvalidURLThrowsException() {
        assertThrows(Exception.class, () -> {
            Task64_CLAUDE_claude_3_5_sonnet_20240620.fetchJSON("http://invalid-url.invalid");
        });
    }
}
