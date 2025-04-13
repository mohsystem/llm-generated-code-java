package gemini.task96;

import org.junit.jupiter.api.Test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task96Test {

    @Test
    void testEchoServer() throws Exception {
        // Start the server in a background thread
        Executors.newSingleThreadExecutor().submit(() -> {
            try {
                Task96_GEMINI_gemini_1_5_pro_001.main(null);
            } catch (Exception ignored) {}
        });

        // Wait for the server to start
        Thread.sleep(1000);

        String host = "127.0.0.1";
        int port = 5000;
        String message = "Echo using UTF";

        try (Socket socket = new Socket(host, port);
             DataOutputStream output = new DataOutputStream(socket.getOutputStream());
             DataInputStream input = new DataInputStream(socket.getInputStream())) {

            output.writeUTF(message);         // Send message
            String response = input.readUTF(); // Receive echoed message

            assertEquals(message, response); // Validate echo
        }
    }
}
