package gemini.task160;

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
    public static void startServer() throws IOException {
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

        // 302 Redirect → body "Redirected" (but HttpURLConnection will follow by default)
        server.createContext("/redirect", (HttpExchange ex) -> {
            ex.getResponseHeaders().add("Location", "/success");
            byte[] resp = "Redirected".getBytes();
            ex.sendResponseHeaders(302, resp.length);
            ex.getResponseBody().write(resp);
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

        // 200 OK with zero-length body
        server.createContext("/empty", (HttpExchange ex) -> {
            ex.sendResponseHeaders(200, 0);
            ex.close();
        });

        // 500 Internal Server Error → "Error"
        server.createContext("/error", (HttpExchange ex) -> {
            byte[] resp = "Error".getBytes();
            ex.sendResponseHeaders(500, resp.length);
            ex.getResponseBody().write(resp);
            ex.close();
        });

        // Slow response (for timeout test placeholder)
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
    public static void stopServer() {
        server.stop(0);
    }

    /**
     * Feeds the given URL to your main(), captures its stdout, and returns it as a String.
     */
    private String runWithInput(String url) throws IOException {
        InputStream  origIn  = System.in;
        PrintStream  origOut = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setIn (new ByteArrayInputStream((url + "\n").getBytes()));
        System.setOut(new PrintStream(baos));

        try {
            Task160_GEMINI_gemini_1_5_pro_001.main(new String[0]);
        } finally {
            System.setIn(origIn);
            System.setOut(origOut);
        }

        return baos.toString();
    }

    @Test
    void testValidSuccess() throws IOException {
        String out = runWithInput("http://localhost:" + port + "/success");
        assertTrue(out.contains("Response Code : 200"), "Should print 200 status");
        assertTrue(out.contains("Success"), "Should print Success body");
    }

    @Test
    void testAlternateSuccess() throws IOException {
        // same as /success again
        String out = runWithInput("http://localhost:" + port + "/success");
        assertTrue(out.contains("Success"));
    }

    @Test
    void testInvalidHost() {
        // URL syntax is OK, but connect will fail
        assertThrows(UnknownHostException.class, () ->
                runWithInput("http://nonexistent.localdomain1234/")
        );
    }

    @Test
    void testHttpError() {
        // 500 → getResponseCode() returns 500, but getInputStream() throws IOException
        IOException ex = assertThrows(IOException.class, () ->
                runWithInput("http://localhost:" + port + "/error")
        );
        assertTrue(ex.getMessage().contains("Server returned HTTP response code: 500"),
                "Expected HTTP 500 IOException");
    }

    @Test
    void testConnectionRefused() {
        int deadPort = port + 100;
        assertThrows(IOException.class, () ->
                runWithInput("http://localhost:" + deadPort + "/foo")
        );
    }

    @Test
    void testRedirectFollowed() throws IOException {
        // HttpURLConnection follows 302 by default → ends up at /success
        String out = runWithInput("http://localhost:" + port + "/redirect");
        assertTrue(out.contains("Response Code : 200"), "After redirect should be 200");
        assertTrue(out.contains("Success"), "Body from /success");
    }

    @Test
    void testLargeBody() throws IOException {
        String out = runWithInput("http://localhost:" + port + "/large");
        // grab last printed line
        String[] lines = out.split("\\R");
        String body = lines[lines.length - 1];
        assertEquals(10_000, body.length(), "Expected 10 000 'A's");
    }

    @Test
    void testEmptyBody() throws IOException {
        String out = runWithInput("http://localhost:" + port + "/empty");
        assertTrue(out.contains("Response Code : 200"));
        assertTrue(out.contains("Response Body:\n"), "Should print the ‘Response Body:’ header");
        // nothing after header
        String after = out.substring(out.indexOf("Response Body:\n") + "Response Body:\n".length());
        assertEquals("", after.trim());
    }

    @Test
    void testPartialContent() throws IOException {
        String out = runWithInput("http://localhost:" + port + "/partial");
        assertTrue(out.contains("Response Code : 206"), "206 status expected");
        assertTrue(out.contains("Partial content"));
    }

    @Disabled("No read timeout set in code—cannot reliably trigger")
    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    void testTimeout() throws IOException {
        runWithInput("http://localhost:" + port + "/timeout");
    }
}
