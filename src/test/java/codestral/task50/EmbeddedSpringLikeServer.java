package codestral.task50;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EmbeddedSpringLikeServer {
    public static final String UPLOAD_DIR = "uploads/";

    public static void start(int port) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/upload", new UploadHandler());
        server.setExecutor(null); // default executor
        server.start();
        System.out.println("Spring-like server started on port " + port);
    }

    static class UploadHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if ("POST".equalsIgnoreCase(exchange.getRequestMethod())) {
                String fileName = "testFile.txt";
                byte[] bytes = exchange.getRequestBody().readAllBytes();

                File dir = new File(UPLOAD_DIR);
                if (!dir.exists()) dir.mkdir();

                Files.write(Paths.get(UPLOAD_DIR + fileName), bytes);

                String response = "File uploaded successfully";
                exchange.sendResponseHeaders(200, response.length());
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            } else {
                exchange.sendResponseHeaders(405, -1); // Method Not Allowed
            }
        }
    }
}
