package gtp4o.task64;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.json.JSONObject;
import org.junit.jupiter.api.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

public class Task64Test {

    private MockWebServer mockWebServer;

    @BeforeEach
    public void setUp() throws Exception {
        mockWebServer = new MockWebServer();
        mockWebServer.start();
    }

    @AfterEach
    public void tearDown() throws Exception {
        mockWebServer.shutdown();
    }

    public JSONObject runFetchJson(String urlString) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        in.close();

        return new JSONObject(content.toString());
    }

    @Test
    public void testValidJson() throws Exception {
        // Arrange
        String mockJson = "{\"course\": \"COMP133\", \"instructor\": \"Abdulrahman\"}";
        mockWebServer.enqueue(new MockResponse()
                .setBody(mockJson)
                .addHeader("Content-Type", "application/json"));

        String testUrl = mockWebServer.url("/data").toString();

        // Act
        JSONObject result = runFetchJson(testUrl);

        // Assert
        JSONObject expected = new JSONObject(mockJson);
        assertEquals(expected.toString(), result.toString());
    }

    @Test
    public void testInvalidUrl() {
        // Arrange
        String badUrl = "http://invalid.url";

        // Assert
        assertThrows(Exception.class, () -> {
            runFetchJson(badUrl);
        });
    }
}
