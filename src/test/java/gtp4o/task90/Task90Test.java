package gtp4o.task90;

import org.junit.jupiter.api.*;

import java.io.*;
import java.net.Socket;
import java.time.Duration;
import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.*;

public class Task90Test {

    private static final int PORT = 5555;
    private static ExecutorService serverExecutor;

    @BeforeAll
    static void startServer() {
        serverExecutor = Executors.newSingleThreadExecutor();
        serverExecutor.submit(() -> Task90_OPENAI_gpt_4o.main(null));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {}
    }

    @AfterAll
    static void stopServer() {
        serverExecutor.shutdownNow();
    }

    private static class ClientConnection {
        Socket socket;
        DataInputStream in;
        DataOutputStream out;

        ClientConnection() throws IOException {
            socket = new Socket("localhost", PORT);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        }

        void send(String message) throws IOException {
            out.writeUTF(message);
        }

        String receive() throws IOException {
            return in.readUTF();
        }

        void close() throws IOException {
            in.close();
            out.close();
            socket.close();
        }
    }

    @Test
    void testClientBroadcastsToOthers() throws Exception {
        ClientConnection client1 = new ClientConnection();
        ClientConnection client2 = new ClientConnection();

        client1.send("Hello from client1");

          String receivedByClient2 = client2.receive();
        assertEquals("Hello from client1", receivedByClient2);

        client1.close();
        client2.close();
    }

    @Test
    void testNoEchoToSender() throws Exception {
        ClientConnection client = new ClientConnection();
        client.send("Test message");

         Thread.sleep(300);

        assertEquals(0, client.in.available(), "Sender should not receive their own message");

        client.close();
    }

}
