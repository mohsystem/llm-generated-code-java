package claude.task130;

import org.junit.jupiter.api.*;

import com.sun.net.httpserver.*;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.*;

class Task130Test {

    static HttpServer server;
    static int port = 8234;

    @BeforeAll
    static void startServer() throws IOException {
        server = HttpServer.create(new InetSocketAddress(port), 0);

        HttpContext context = server.createContext("/api/data", exchange -> {
            String response = "{\"message\":\"This is CORS-enabled data\"}";
            exchange.getResponseHeaders().add("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, response.getBytes().length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response.getBytes());
            }
        });

        // إضافة فلتر CORS
        context.getFilters().add(new CorsFilter());

        server.start();
    }

    @AfterAll
    static void stopServer() {
        if (server != null) {
            server.stop(0);
        }
    }

    @Test
    void testCorsHeaders() throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:" + port + "/api/data"))
                .header("Origin", "http://example.com")
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        assertEquals(200, response.statusCode());
        assertTrue(response.headers().firstValue("Access-Control-Allow-Origin").isPresent());
        assertEquals("*", response.headers().firstValue("Access-Control-Allow-Origin").get());
    }

    // كلاس فلتر CORS
    static class CorsFilter extends Filter {
        @Override
        public void doFilter(HttpExchange exchange, Chain chain) throws IOException {
            exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
            exchange.getResponseHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
            exchange.getResponseHeaders().add("Access-Control-Max-Age", "3600");
            exchange.getResponseHeaders().add("Access-Control-Allow-Headers", "Content-Type, Authorization, Content-Length, X-Requested-With");
            chain.doFilter(exchange);
        }

        @Override
        public String description() {
            return "Adds CORS headers to the response";
        }
    }
}
