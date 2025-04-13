package gtp4o.task76;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class Task76Test {

    private static HttpServer createServer(String html) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(0), 0);
        server.createContext("/", new HttpHandler() {
            public void handle(HttpExchange exchange) throws java.io.IOException {
                exchange.sendResponseHeaders(200, html.length());
                OutputStream os = exchange.getResponseBody();
                os.write(html.getBytes());
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
        System.setErr(new PrintStream(outContent));

        try {
            Class<?> clazz = Class.forName("gtp4o.task76.Task76_OPENAI_gpt_4o");
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
        String html = "<html><head><title>Hello GPT</title></head><body></body></html>";
        HttpServer server = createServer(html);
        String url = "http://localhost:" + server.getAddress().getPort();

        String output = runMainAndCaptureOutput(new String[]{url});
        server.stop(0);

        assertEquals("Hello GPT", output);
    }

    @Test
    public void testNoTitle() throws Exception {
        String html = "<html><head></head><body>No title here</body></html>";
        HttpServer server = createServer(html);
        String url = "http://localhost:" + server.getAddress().getPort();

        String output = runMainAndCaptureOutput(new String[]{url});
        server.stop(0);

        assertEquals("", output, "Expected empty output when no title exists");
    }

    @Test
    public void testInvalidUrl() throws Exception {
        String output = runMainAndCaptureOutput(new String[]{"http://invalid.url"});
        assertTrue(output.toLowerCase().contains("exception"), "Expected exception for invalid URL");
    }
}
