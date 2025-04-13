package gtp4o.task96;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task96Test {

    @Test
    void testEchoServer() throws Exception {
        // Start the server in a separate thread
        Executors.newSingleThreadExecutor().submit(() -> {
            try {
                Task96_OPENAI_gpt_4o.main(null);
            } catch (IOException ignored) {}
        });

        // Wait a bit to ensure the server is ready
        Thread.sleep(1000);

        String host = "127.0.0.1";
        int port = 65432;
        String testMessage = "Hello GPT-4o Echo Server!";

        try (Socket socket = new Socket(host, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            out.println(testMessage);
            String response = in.readLine();

            assertEquals(testMessage, response);
        }
    }
}
