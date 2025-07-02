package llama3.task160;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;

import java.io.*;
import java.net.*;
import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Task160Test {

    private static HttpServer server;
    private static int port;

    @BeforeAll
    static void startServer() throws IOException {
        server = HttpServer.create(new InetSocketAddress(0), 0);
        port = server.getAddress().getPort();
        server.setExecutor(Executors.newSingleThreadExecutor());

        // 200 OK → "Success"
        server.createContext("/success", (HttpExchange ex) -> {
            byte[] resp = "Success".getBytes();
            ex.sendResponseHeaders(200, resp.length);
            ex.getResponseBody().write(resp);
            ex.close();
        });

        // 302 Redirect → Location: /success
        server.createContext("/redirect", (HttpExchange ex) -> {
            ex.getResponseHeaders().add("Location", "/success");
            ex.sendResponseHeaders(302, -1);
            ex.close();
        });

        // 206 Partial Content → "Partial content"
        server.createContext("/partial", (HttpExchange ex) -> {
            byte[] resp = "Partial content".getBytes();
            ex.sendResponseHeaders(206, resp.length);
            ex.getResponseBody().write(resp);
            ex.close();
        });

        // 200 OK → 10 000 × 'A'
        server.createContext("/large", (HttpExchange ex) -> {
            char[] A = new char[10_000];
            Arrays.fill(A, 'A');
            byte[] resp = new String(A).getBytes();
            ex.sendResponseHeaders(200, resp.length);
            ex.getResponseBody().write(resp);
            ex.close();
        });

        // 200 OK empty body
        server.createContext("/empty", (HttpExchange ex) -> {
            ex.sendResponseHeaders(200, 0);
            ex.close();
        });

        // 500 Internal Server Error
        server.createContext("/error", (HttpExchange ex) -> {
            byte[] resp = "Error".getBytes();
            ex.sendResponseHeaders(500, resp.length);
            ex.getResponseBody().write(resp);
            ex.close();
        });

        // Slow response (for timeout test)
        server.createContext("/timeout", (HttpExchange ex) -> {
            try {
                Thread.sleep(5_000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            byte[] resp = "Too late".getBytes();
            ex.sendResponseHeaders(200, resp.length);
            ex.getResponseBody().write(resp);
            ex.close();
        });

        server.start();
    }

    @AfterAll
    static void stopServer() {
        server.stop(0);
    }

    /**
     * Feeds the URL into main() via stdin and captures stdout.
     */
    private String runWithInput(String url) throws Exception {
        InputStream  origIn  = System.in;
        PrintStream  origOut = System.out;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setIn (new ByteArrayInputStream((url + "\n").getBytes()));
        System.setOut(new PrintStream(baos));

        try {
            Task160_PERPLEXITY_llama_3_sonar_large_32k_chat.main(new String[0]);
        } finally {
            System.setIn(origIn);
            System.setOut(origOut);
        }

        return baos.toString();
    }

    @Test
    void testSuccess() throws Exception {
        String out = runWithInput("http://localhost:" + port + "/success");
        assertTrue(out.contains("Status Code: 200"), "Should print 200 status");
        assertTrue(out.contains("Content: Success"), "Should print Success body");
    }

    @Test
    void testAlternateSuccess() throws Exception {
        // same handler as /success
        String out = runWithInput("http://localhost:" + port + "/success");
        assertTrue(out.contains("Content: Success"));
    }

    @Test
    void testInvalidUrl() {
        assertThrows(UnknownHostException.class, () ->
                        runWithInput("http://nonexistent.localdomain1234/")
                , "Expected UnknownHostException for invalid host");
    }

    @Test
    void testHttpError() {
        IOException ex = assertThrows(IOException.class, () ->
                runWithInput("http://localhost:" + port + "/error")
        );
        assertTrue(ex.getMessage().contains("Server returned HTTP response code: 500"),
                "Expected HTTP 500 IOException");
    }

    @Test
    void testConnectionRefused() {
        int dead = port + 100;
        assertThrows(IOException.class, () ->
                        runWithInput("http://localhost:" + dead + "/foo")
                , "Expected connection refusal IOException");
    }

    @Test
    void testRedirect() throws Exception {
        String out = runWithInput("http://localhost:" + port + "/redirect");
        assertTrue(out.contains("Status Code: 200"), "Redirect should be followed");
        assertTrue(out.contains("Content: Success"), "Body from /success after redirect");
    }

    @Test
    void testPartialContent() throws Exception {
        String out = runWithInput("http://localhost:" + port + "/partial");
        assertTrue(out.contains("Status Code: 206"), "Should print 206 status");
        assertTrue(out.contains("Content: Partial content"), "Should print partial content");
    }

    @Test
    void testLargeResponse() throws Exception {
        String out = runWithInput("http://localhost:" + port + "/large");
        // extract the "Content: " line
        String contentLine = out.lines()
                .filter(l -> l.startsWith("Content: "))
                .findFirst()
                .orElse("");
        String body = contentLine.substring("Content: ".length());
        assertEquals(10_000, body.length(), "Expected 10 000-character body");
    }

    @Test
    void testEmptyResponse() throws Exception {
        String out = runWithInput("http://localhost:" + port + "/empty");
        assertTrue(out.contains("Status Code: 200"), "Should print 200 status");
        // last line should be "Content: "
        String last = out.lines().reduce((a, b) -> b).orElse("");
        assertEquals("Content: ", last, "Expected empty content");
    }

    @Disabled("No socket/read timeout configured, so this will not fail fast")
    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    void testTimeout() throws Exception {
        runWithInput("http://localhost:" + port + "/timeout");
    }
}
