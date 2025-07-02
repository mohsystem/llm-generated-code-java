package claude.task160;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.net.*;
import java.util.Arrays;
import java.util.concurrent.Executors;

public class Task160Test {

    private static HttpServer server;
    private static int port;

    @BeforeAll
    public static void startServer() throws IOException {
        server = HttpServer.create(new InetSocketAddress(0), 0);
        port = server.getAddress().getPort();

        // 200 OK → "Success"
        server.createContext("/success", exchange -> {
            byte[] resp = "Success".getBytes();
            exchange.sendResponseHeaders(200, resp.length);
            exchange.getResponseBody().write(resp);
            exchange.close();
        });

        // 302 Redirect → body "Redirected"
        server.createContext("/redirect", exchange -> {
            exchange.getResponseHeaders().add("Location", "/success");
            byte[] resp = "Redirected".getBytes();
            exchange.sendResponseHeaders(302, resp.length);
            exchange.getResponseBody().write(resp);
            exchange.close();
        });

        // 206 Partial Content → "Partial content"
        server.createContext("/partial", exchange -> {
            byte[] resp = "Partial content".getBytes();
            exchange.sendResponseHeaders(206, resp.length);
            exchange.getResponseBody().write(resp);
            exchange.close();
        });

        // 200 OK → 10 000 × 'A'
        server.createContext("/large", exchange -> {
            char[] A = new char[10_000];
            Arrays.fill(A, 'A');
            byte[] resp = new String(A).getBytes();
            exchange.sendResponseHeaders(200, resp.length);
            exchange.getResponseBody().write(resp);
            exchange.close();
        });

        // 200 OK → no body
        server.createContext("/empty", exchange -> {
            exchange.sendResponseHeaders(200, -1);
            exchange.close();
        });

        // 500 Internal Server Error → "Error"
        server.createContext("/error", exchange -> {
            byte[] resp = "Error".getBytes();
            exchange.sendResponseHeaders(500, resp.length);
            exchange.getResponseBody().write(resp);
            exchange.close();
        });

        server.setExecutor(Executors.newSingleThreadExecutor());
        server.start();
    }

    @AfterAll
    public static void stopServer() {
        server.stop(0);
    }

    /**
     * Runs the original main(), feeding it the given URL on stdin
     * and returns everything printed to stdout.
     */
    private String runWithInput(String url) {
        InputStream  origIn  = System.in;
        PrintStream  origOut = System.out;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setIn (new ByteArrayInputStream((url + "\n").getBytes()));
        System.setOut(new PrintStream(baos));

        try {
            Task160_CLAUDE_claude_3_5_sonnet_20240620.main(new String[0]);
        } finally {
            System.setIn(origIn);
            System.setOut(origOut);
        }

        return baos.toString();
    }

    @Test
    void testValidUrlGoogle() {
        String out = runWithInput("http://localhost:" + port + "/success");
        assertTrue(out.contains("Success"), "Expected 'Success' in response text");
    }

    @Test
    void testValidUrlBing() {
        String out = runWithInput("http://localhost:" + port + "/success");
        assertTrue(out.contains("Success"), "Expected 'Success' in response text");
    }

    @Test
    void testInvalidUrl() {
        // No such host
        String out = runWithInput("http://nonexistent.localdomain1234/");
        assertTrue(out.contains("An error occurred"), "Expected error message for invalid URL");
    }

    @Test
    void testHttpError() {
        String out = runWithInput("http://localhost:" + port + "/error");
        assertTrue(out.contains("An error occurred"), "Expected error handling on HTTP 500");
    }

    @Test
    void testNetworkError() {
        // Port where no server is listening
        int deadPort = port + 10;
        String out = runWithInput("http://localhost:" + deadPort + "/foo");
        assertTrue(out.contains("An error occurred"), "Expected error message for connection refusal");
    }

    @Test
    void testRedirect() {
        String out = runWithInput("http://localhost:" + port + "/redirect");
        assertTrue(out.contains("Redirected"), "Expected 'Redirected' in response body");
    }

    @Test
    void testLargeResponse() {
        String out = runWithInput("http://localhost:" + port + "/large");
        // Extract only the body (it’s the last line printed)
        String[] lines = out.split("\\R");
        String body = lines[lines.length - 1];
        assertEquals(10_000, body.length(), "Expected 10 000-character ‘A’ string");
    }

    @Test
    void testNoResponse() {
        String out = runWithInput("http://localhost:" + port + "/empty");
        assertTrue(out.contains("Response content:"), "Should still print the ‘Response content:’ label");
        // and nothing after it
        String content = out.substring(out.indexOf("Response content:") + "Response content:".length()).trim();
        assertEquals("", content, "Expected empty response body");
    }

    @Test
    void testPartialContent() {
        String out = runWithInput("http://localhost:" + port + "/partial");
        assertTrue(out.contains("Partial content"), "Expected 'Partial content' in response text");
    }
}
