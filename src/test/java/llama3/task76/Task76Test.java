package llama3.task76;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

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
            Class<?> clazz = Class.forName("llama3.task76.Task76_PERPLEXITY_llama_3_sonar_large_32k_chat");
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
        String html = "<html><head><title>Llama Page</title></head><body>Hi</body></html>";
        HttpServer server = createServer(html);
        String url = "http://localhost:" + server.getAddress().getPort();

        String output = runMainAndCaptureOutput(new String[]{url});
        server.stop(0);

        assertEquals("Llama Page", output);
    }

    @Test
    public void testNoTitle() throws Exception {
        String html = "<html><head></head><body>No title tag</body></html>";
        HttpServer server = createServer(html);
        String url = "http://localhost:" + server.getAddress().getPort();

        String output = runMainAndCaptureOutput(new String[]{url});
        server.stop(0);

         assertTrue(output.toLowerCase().contains("exception"), "Expected exception due to missing <title>");
    }

    @Test
    public void testInvalidUrl() throws Exception {
        String output = runMainAndCaptureOutput(new String[]{"http://invalid.url"});
        assertTrue(output.toLowerCase().contains("exception"), "Expected exception for invalid URL");
    }
}
