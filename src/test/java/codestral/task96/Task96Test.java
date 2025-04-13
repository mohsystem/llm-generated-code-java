package codestral.task96;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task96Test {

    @Test
    void testEchoServer() throws Exception {
        // Start the echo server in a separate thread
        Executors.newSingleThreadExecutor().submit(() -> {
            try {
                Task96_MISTRAL_codestral_latest.main(null);
            } catch (IOException ignored) {}
        });

        // Wait a bit to ensure server is up
        Thread.sleep(1000);

        String host = "127.0.0.1";
        int port = 12345;
        String message = "Hello from JUnit!";

        try (Socket socket = new Socket(host, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            out.println(message); // send message to server
            String response = in.readLine(); // receive echo

            assertEquals(message, response); // check echo
        }
    }
}
