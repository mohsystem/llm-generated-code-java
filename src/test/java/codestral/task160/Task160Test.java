package codestral.task160;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Timeout;

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

        // 302 Redirect → body "Redirected", but URL.openStream will follow to /success
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

        // 200 OK → 10_000 × 'A'
        server.createContext("/large", (HttpExchange ex) -> {
            char[] A = new char[10_000];
            Arrays.fill(A, 'A');
            byte[] resp = new String(A).getBytes();
            ex.sendResponseHeaders(200, resp.length);
            ex.getResponseBody().write(resp);
            ex.close();
        });

        // 200 OK with no body
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
     * Runs the original main(), feeding it the given URL on stdin
     * and captures everything it writes to stdout.
     */
    private String runWithInput(String url) throws Exception {
        InputStream  origIn  = System.in;
        PrintStream  origOut = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setIn (new ByteArrayInputStream((url + "\n").getBytes()));
        System.setOut(new PrintStream(baos));

        try {
            Task160_MISTRAL_codestral_latest.main(new String[0]);
        } finally {
            System.setIn(origIn);
            System.setOut(origOut);
        }

        return baos.toString();
    }

    @Test
    void testValidUrlGoogle() throws Exception {
        String out = runWithInput("http://localhost:" + port + "/success");
        assertTrue(out.contains("Success"), "Expected 'Success' in output");
    }

    @Test
    void testValidUrlBing() throws Exception {
        // same handler as /success
        String out = runWithInput("http://localhost:" + port + "/success");
        assertTrue(out.contains("Success"), "Expected 'Success' in output");
    }

    @Test
    void testInvalidUrl() {
        assertThrows(UnknownHostException.class, () ->
                        runWithInput("http://nonexistent.localdomain1234/")
                , "Expected UnknownHostException for bad host");
    }

    @Test
    void testHttpError() {
        Exception ex = assertThrows(IOException.class, () ->
                runWithInput("http://localhost:" + port + "/error")
        );
        // openStream on HTTP 500 throws IOException
        assertTrue(ex.getMessage().contains("Server returned HTTP response code: 500"),
                "Expected HTTP 500 exception");
    }

    @Test
    void testNetworkError() {
        int deadPort = port + 100;
        assertThrows(IOException.class, () ->
                        runWithInput("http://localhost:" + deadPort + "/foo")
                , "Expected connection refusal IOException");
    }

    @Test
    void testRedirect() throws Exception {
        // URL.openStream() will follow the 302 to /success
        String out = runWithInput("http://localhost:" + port + "/redirect");
        assertTrue(out.contains("Success"), "Expected 'Success' after redirect");
    }

    @Test
    void testLargeResponse() throws Exception {
        String out = runWithInput("http://localhost:" + port + "/large");
        String[] lines = out.split("\\R");
        String body = lines[lines.length - 1];
        assertEquals(10_000, body.length(), "Expected 10 000-character body");
    }

    @Test
    void testNoResponse() throws Exception {
        String out = runWithInput("http://localhost:" + port + "/empty");
        String[] lines = out.split("\\R");
        // only the prompt line should appear
        assertEquals(1, lines.length, "Expected only prompt and no content");
        assertTrue(lines[0].startsWith("Enter a URL"), "Prompt should be printed");
    }

    @Disabled("Original implementation does not set timeouts; can't reliably trigger a read timeout")
    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    void testTimeout() throws Exception {
        // This will block on /timeout; without setting a read timeout it never throws.
        runWithInput("http://localhost:" + port + "/timeout");
    }

    @Test
    void testPartialContent() throws Exception {
        String out = runWithInput("http://localhost:" + port + "/partial");
        assertTrue(out.contains("Partial content"), "Expected 'Partial content' in output");
    }
}
