package claude.task96;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task96Test {

    @Test
    void testEchoServerResponse() throws Exception {
        // Start the server in a separate thread
        Executors.newSingleThreadExecutor().submit(() -> {
            try {
                Task96_CLAUDE_claude_3_5_sonnet_20240620.main(null);
            } catch (Exception ignored) {}
        });

        // Wait for server to start
        Thread.sleep(1000);

        // Test data
        String testMessage = "Hello, Server!";
        String host = "127.0.0.1";
        int port = 12345;

        // Connect to server and send message
        try (Socket socket = new Socket(host, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            out.println(testMessage);
            String response = in.readLine();

            assertEquals(testMessage, response);
        }
    }
}
