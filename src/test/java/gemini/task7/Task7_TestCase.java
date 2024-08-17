package gemini.task7;

import org.junit.jupiter.api.*;
import java.io.*;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;

public class Task7_TestCase {

    private static final int PORT = 65432;
    private static Thread serverThread;

    @BeforeAll
    static void startServer() {
        serverThread = new Thread(() -> {
            Task7_GEMINI_gemini_1_5_pro_001.main(new String[]{});
        });
        serverThread.start();

        // Give server time to start
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testValidLogin() throws IOException {
        try (Socket socket = new Socket("localhost", PORT);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            // Send valid credentials
            out.println("validuser");
            out.println("validpass");

            // Expect login success
            String response = in.readLine();
            assertEquals("Login successful!", response);
        }
    }

    @Test
    void testInvalidLogin() throws IOException {
        try (Socket socket = new Socket("localhost", PORT);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            // Send invalid credentials
            out.println("invaliduser");
            out.println("invalidpass");

            // Expect invalid credentials message
            String response = in.readLine();
            assertEquals("Invalid credentials!", response);
        }
    }

    @Test
    void testBroadcastMessage() throws IOException {
        // Client 1
        try (Socket socket1 = new Socket("localhost", PORT);
             BufferedReader in1 = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
             PrintWriter out1 = new PrintWriter(socket1.getOutputStream(), true)) {

            out1.println("validuser1");
            out1.println("validpass1");

            // Client 2
            try (Socket socket2 = new Socket("localhost", PORT);
                 BufferedReader in2 = new BufferedReader(new InputStreamReader(socket2.getInputStream()));
                 PrintWriter out2 = new PrintWriter(socket2.getOutputStream(), true)) {

                out2.println("validuser2");
                out2.println("validpass2");

                // Send a message from client 1
                out1.println("Hello from user1");

                // Expect broadcast message at client 2
                String response = in2.readLine();
                assertEquals("validuser1: Hello from user1", response);
            }
        }
    }

    @Test
    void testUserDisconnects() throws IOException {
        try (Socket socket1 = new Socket("localhost", PORT);
             BufferedReader in1 = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
             PrintWriter out1 = new PrintWriter(socket1.getOutputStream(), true)) {

            out1.println("validuser1");
            out1.println("validpass1");

            // Expect login success
            String response = in1.readLine();
            assertEquals("Login successful!", response);

            // Client 2
            try (Socket socket2 = new Socket("localhost", PORT);
                 BufferedReader in2 = new BufferedReader(new InputStreamReader(socket2.getInputStream()));
                 PrintWriter out2 = new PrintWriter(socket2.getOutputStream(), true)) {

                out2.println("validuser2");
                out2.println("validpass2");

                // Send a message from client 1
                out1.println("Goodbye");

                // Expect user1 leaves message at client 2
                response = in2.readLine();
                assertEquals("User validuser1 has left the chat.", response);
            }
        }
    }

    @Test
    void testMultipleClientsLogin() throws IOException, InterruptedException {
        Thread client1 = new Thread(() -> {
            try {
                Socket socket = new Socket("localhost", PORT);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out.println("validuser1");
                out.println("validpass1");
                assertEquals("Login successful!", in.readLine());
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Thread client2 = new Thread(() -> {
            try {
                Socket socket = new Socket("localhost", PORT);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out.println("validuser2");
                out.println("validpass2");
                assertEquals("Login successful!", in.readLine());
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        client1.start();
        client2.start();
        client1.join();
        client2.join();
    }

    @Test
    void testInvalidMessageHandling() throws IOException {
        try (Socket socket = new Socket("localhost", PORT);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            out.println("validuser");
            out.println("validpass");

            // Expect login success
            String response = in.readLine();
            assertEquals("Login successful!", response);

            // Send an invalid message (e.g., an empty string or a malformed message)
            out.println("");

            // Expect no broadcast message or a specific response indicating the message was invalid
            response = in.readLine();
            assertNull(response); // Adjust based on how the server handles such messages
        }
    }

    @Test
    void testServerHandlesDisconnections() throws IOException {
        try (Socket socket1 = new Socket("localhost", PORT);
             BufferedReader in1 = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
             PrintWriter out1 = new PrintWriter(socket1.getOutputStream(), true)) {

            out1.println("validuser1");
            out1.println("validpass1");
            assertEquals("Login successful!", in1.readLine());

            // Disconnect client
            socket1.close();

            // Client 2
            try (Socket socket2 = new Socket("localhost", PORT);
                 BufferedReader in2 = new BufferedReader(new InputStreamReader(socket2.getInputStream()));
                 PrintWriter out2 = new PrintWriter(socket2.getOutputStream(), true)) {

                out2.println("validuser2");
                out2.println("validpass2");
                assertEquals("Login successful!", in2.readLine());

                // Expect user1 leaves message at client 2
                String response = in2.readLine();
                assertEquals("User validuser1 has left the chat.", response);
            }
        }
    }

    @Test
    void testServerBroadcastsMessagesCorrectly() throws IOException {
        try (Socket socket1 = new Socket("localhost", PORT);
             BufferedReader in1 = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
             PrintWriter out1 = new PrintWriter(socket1.getOutputStream(), true)) {

            out1.println("validuser1");
            out1.println("validpass1");
            assertEquals("Login successful!", in1.readLine());

            // Client 2
            try (Socket socket2 = new Socket("localhost", PORT);
                 BufferedReader in2 = new BufferedReader(new InputStreamReader(socket2.getInputStream()));
                 PrintWriter out2 = new PrintWriter(socket2.getOutputStream(), true)) {

                out2.println("validuser2");
                out2.println("validpass2");
                assertEquals("Login successful!", in2.readLine());

                // Send a message from client 1
                out1.println("Broadcast message");

                // Expect broadcast message at client 2
                String response = in2.readLine();
                assertEquals("validuser1: Broadcast message", response);
            }
        }
    }

    @Test
    void testServerErrorHandling() {
        // Simulate server failure scenario
        Exception exception = assertThrows(IOException.class, () -> {
            try (Socket socket = new Socket("localhost", 9999)) { // Invalid port
                socket.close();
            }
        });

        String expectedMessage = "Connection refused";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @AfterAll
    static void stopServer() {
        serverThread.interrupt();
    }
}
