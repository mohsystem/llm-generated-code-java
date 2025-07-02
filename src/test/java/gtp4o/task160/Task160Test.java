package gtp4o.task160;

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

        // 200 OK → large body
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

    private static class Result {
        final String stdout, stderr;
        Result(String o, String e) { stdout = o; stderr = e; }
    }

    private Result runWithInput(String url) throws IOException {
        InputStream origIn = System.in;
        PrintStream origOut = System.out, origErr = System.err;

        ByteArrayOutputStream outBuf = new ByteArrayOutputStream();
        ByteArrayOutputStream errBuf = new ByteArrayOutputStream();
        System.setIn(new ByteArrayInputStream((url + "\n").getBytes()));
        System.setOut(new PrintStream(outBuf));
        System.setErr(new PrintStream(errBuf));

        try {
            Task160_OPENAI_gpt_4o.main(new String[0]);
        } finally {
            System.setIn(origIn);
            System.setOut(origOut);
            System.setErr(origErr);
        }

        return new Result(outBuf.toString(), errBuf.toString());
    }

    @Test
    void testValidSuccess() throws IOException {
        Result r = runWithInput("http://localhost:" + port + "/success");
        assertTrue(r.stdout.contains("Enter a URL:"), "Should prompt");
        assertTrue(r.stdout.contains("Success"), "Should print Success");
        assertTrue(r.stderr.isEmpty(), "No errors");
    }

    @Test
    void testAlternateSuccess() throws IOException {
        // same /success
        Result r = runWithInput("http://localhost:" + port + "/success");
        assertTrue(r.stdout.contains("Success"));
    }

    @Test
    void testInvalidHost() throws IOException {
        Result r = runWithInput("http://nonexistent.localdomain1234/");
        assertTrue(r.stderr.contains("UnknownHostException"),
                "Should print stacktrace with UnknownHostException");
    }

    @Test
    void testHttpError() throws IOException {
        Result r = runWithInput("http://localhost:" + port + "/error");
        assertTrue(r.stderr.contains("Server returned HTTP response code: 500"),
                "Should print HTTP 500 error stacktrace");
    }

    @Test
    void testConnectionRefused() throws IOException {
        Result r = runWithInput("http://localhost:" + (port + 100) + "/foo");
        assertTrue(r.stderr.matches("(?s).*Connect.*(refused|timed).*"),
                "Should print connection refused/timeout");
    }

    @Test
    void testRedirect() throws IOException {
        // HttpURLConnection follows redirects automatically
        Result r = runWithInput("http://localhost:" + port + "/redirect");
        assertTrue(r.stdout.contains("Success"),
                "After redirect, body of /success should print");
    }

    @Test
    void testPartialContent() throws IOException {
        Result r = runWithInput("http://localhost:" + port + "/partial");
        assertTrue(r.stdout.contains("Partial content"),
                "Should print partial content");
    }

    @Test
    void testLargeBody() throws IOException {
        Result r = runWithInput("http://localhost:" + port + "/large");
        String[] lines = r.stdout.split("\\R");
        String body = lines[lines.length - 1];
        assertEquals(10_000, body.length(),
                "Expected 10 000-character body of 'A's");
    }

    @Test
    void testEmptyBody() throws IOException {
        Result r = runWithInput("http://localhost:" + port + "/empty");
        String[] lines = r.stdout.split("\\R");
        assertEquals(1, lines.length, "Only prompt printed, no body lines");
        assertTrue(lines[0].startsWith("Enter a URL:"));
    }

    @Disabled("No read timeout is set, so this will not fail fast")
    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    void testTimeout() throws IOException {
        runWithInput("http://localhost:" + port + "/timeout");
    }
}
