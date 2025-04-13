package codestral.task76;

import org.junit.jupiter.api.*;

import java.io.*;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import static org.junit.jupiter.api.Assertions.*;

public class Task76Test {

    private static HttpServer createServer(String html) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(0), 0);
        server.createContext("/", new HttpHandler() {
            public void handle(HttpExchange exchange) throws IOException {
                byte[] response = html.getBytes(StandardCharsets.UTF_8);
                exchange.sendResponseHeaders(200, response.length);
                OutputStream os = exchange.getResponseBody();
                os.write(response);
                os.close();
            }
        });
        server.setExecutor(null);
        server.start();
        return server;
    }

    private String runMainAndCaptureOutput(String[] args) throws Exception {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        PrintStream originalErr = System.err;
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(outContent)); // Capture errors too

        try {
            Class<?> clazz = Class.forName("codestral.task76.Task76_MISTRAL_codestral_latest");
            Method mainMethod = clazz.getMethod("main", String[].class);
            mainMethod.invoke(null, (Object) args);
        } finally {
            System.setOut(originalOut);
            System.setErr(originalErr);
        }

        return outContent.toString().trim();
    }


    @Test
    public void testWithTitle() throws Exception {
        String html = "<html><head><title>Hello World</title></head><body></body></html>";
        HttpServer server = createServer(html);
        String url = "http://localhost:" + server.getAddress().getPort();

        String output = runMainAndCaptureOutput(new String[]{url});
        server.stop(0);

        assertTrue(output.contains("Page title is: Hello World"), "Expected title not found");
    }

    @Test
    public void testNoTitle() throws Exception {
        String html = "<html><head></head><body>No title here</body></html>";
        HttpServer server = createServer(html);
        String url = "http://localhost:" + server.getAddress().getPort();

        String output = runMainAndCaptureOutput(new String[]{url});
        server.stop(0);

         assertTrue(output.trim().equals("Page title is:"), "Should print empty title exactly");
    }

    @Test
    public void testInvalidUrl() throws Exception {
        String output = runMainAndCaptureOutput(new String[]{"http://invalid.url"});
        assertTrue(output.contains("Exception") || output.contains("UnknownHostException") || output.contains("error"), "Expected error for invalid URL");

    }
}
