import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.sql.*;

public class Task49Test {

    public static void main(String[] args) throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:users.db");
        Statement stmt = conn.createStatement();
        stmt.execute("""
            CREATE TABLE IF NOT EXISTS users (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT NOT NULL,
                email TEXT NOT NULL UNIQUE
            )
        """);

        HttpServer server = HttpServer.create(new InetSocketAddress(5000), 0);
        server.createContext("/api/users", new CreateUserHandler(conn));
        server.setExecutor(null);
        server.start();
        System.out.println("Server running on http://127.0.0.1:5000/api/users");
    }

    static class CreateUserHandler implements HttpHandler {
        private final Connection conn;

        public CreateUserHandler(Connection conn) {
            this.conn = conn;
        }

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if (!"POST".equalsIgnoreCase(exchange.getRequestMethod())) {
                exchange.sendResponseHeaders(405, -1);
                return;
            }

            String body = new String(exchange.getRequestBody().readAllBytes(), StandardCharsets.UTF_8);
            String name = null, email = null;

            // Expecting application/x-www-form-urlencoded
            String[] pairs = body.split("&");
            for (String pair : pairs) {
                String[] parts = pair.split("=");
                if (parts.length == 2) {
                    String key = URLDecoder.decode(parts[0], StandardCharsets.UTF_8);
                    String value = URLDecoder.decode(parts[1], StandardCharsets.UTF_8);
                    if ("name".equals(key)) name = value;
                    if ("email".equals(key)) email = value;
                }
            }

            if (name == null || email == null) {
                String response = "Missing name or email";
                exchange.sendResponseHeaders(400, response.length());
                exchange.getResponseBody().write(response.getBytes());
                exchange.close();
                return;
            }

            try (PreparedStatement pstmt = conn.prepareStatement(
                    "INSERT INTO users (name, email) VALUES (?, ?)")) {
                pstmt.setString(1, name);
                pstmt.setString(2, email);
                pstmt.executeUpdate();

                String response = "{\"message\": \"User created successfully\"}";
                exchange.getResponseHeaders().set("Content-Type", "application/json");
                exchange.sendResponseHeaders(201, response.length());
                exchange.getResponseBody().write(response.getBytes());
            } catch (SQLException e) {
                String response = "{\"error\": \"Email already exists or DB error\"}";
                exchange.sendResponseHeaders(400, response.length());
                exchange.getResponseBody().write(response.getBytes());
            }
            exchange.close();
        }
    }
}
