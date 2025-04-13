package claude.task76;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

public class Task76Test {

    // Helper: Fake local server to serve simple HTML with title
    private static HttpServer createTestServer(String html) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(0), 0); // Random port
        server.createContext("/", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                exchange.sendResponseHeaders(200, html.length());
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(html.getBytes());
                }
            }
        });
        server.setExecutor(null); // Default executor
        server.start();
        return server;
    }

    @Test
    public void testValidTitle() throws IOException {
        String html = "<html><head><title>Test Page</title></head><body>Hello</body></html>";
        HttpServer server = createTestServer(html);
        String url = "http://localhost:" + server.getAddress().getPort();
        String result = Task76_CLAUDE_claude_3_5_sonnet_20240620.getPageTitle(url);
        server.stop(0);
        assertEquals("Test Page", result);
    }

    @Test
    public void testNoTitleFound() throws IOException {
        String html = "<html><head></head><body>No title here</body></html>";
        HttpServer server = createTestServer(html);
        String url = "http://localhost:" + server.getAddress().getPort();
        String result = Task76_CLAUDE_claude_3_5_sonnet_20240620.getPageTitle(url);
        server.stop(0);
        assertEquals("No title found", result);
    }

    @Test
    public void testInvalidURL() {
        String invalidUrl = "http://invalid.localhost.url";
        String result = Task76_CLAUDE_claude_3_5_sonnet_20240620.getPageTitle(invalidUrl);
        assertTrue(result.startsWith("Error:"));
    }

    @Test
    public void testMissingProtocol() {
        String invalidUrl = "www.example.com";
        String result = Task76_CLAUDE_claude_3_5_sonnet_20240620.getPageTitle(invalidUrl);
        assertTrue(result.startsWith("Error:"));
    }
}
