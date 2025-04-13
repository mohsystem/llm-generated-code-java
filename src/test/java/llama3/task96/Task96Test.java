package llama3.task96;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task96Test {

    @Test
    void testEchoServer() throws Exception {
        // Start the server in a background thread
        Executors.newSingleThreadExecutor().submit(() -> {
            try {
                Task96_PERPLEXITY_llama_3_sonar_large_32k_chat.main(null);
            } catch (IOException ignored) {}
        });

        // Allow server to start
        Thread.sleep(1000);

        String host = "127.0.0.1";
        int port = 12345;
        String testMessage = "Testing from JUnit";

        try (Socket socket = new Socket(host, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            out.println(testMessage);
            String response = in.readLine();

            assertEquals(testMessage, response);
        }
    }
}
