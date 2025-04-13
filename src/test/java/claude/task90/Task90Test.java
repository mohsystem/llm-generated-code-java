package claude.task90;

import org.junit.jupiter.api.*;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.*;

public class Task90Test {

    private static final int PORT = 5555;
    private static ExecutorService executor;

    @BeforeAll
    static void startServer() {
        executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            try {
                Task90_CLAUDE_claude_3_5_sonnet_20240620.main(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

         try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {}
    }

    @AfterAll
    static void shutdownServer() {
        executor.shutdownNow(); // نوقف السيرفر
    }

    @Test
    void testClientToClientBroadcast() throws IOException, InterruptedException {
        Socket client1 = new Socket("localhost", PORT);
        Socket client2 = new Socket("localhost", PORT);

        PrintWriter out1 = new PrintWriter(client1.getOutputStream(), true);
        BufferedReader in2 = new BufferedReader(new InputStreamReader(client2.getInputStream()));

        String testMessage = "Hello from client 1!";
        out1.println(testMessage);

         String received = in2.readLine();

        assertEquals(testMessage, received);

        client1.close();
        client2.close();
    }

    @Test
    void testMultipleClientsReceivingSameMessage() throws IOException, InterruptedException {
        Socket client1 = new Socket("localhost", PORT);
        Socket client2 = new Socket("localhost", PORT);
        Socket client3 = new Socket("localhost", PORT);

        PrintWriter out1 = new PrintWriter(client1.getOutputStream(), true);
        BufferedReader in2 = new BufferedReader(new InputStreamReader(client2.getInputStream()));
        BufferedReader in3 = new BufferedReader(new InputStreamReader(client3.getInputStream()));

        String msg = "Message from client 1!";
        out1.println(msg);

        String received2 = in2.readLine();
        String received3 = in3.readLine();

        assertEquals(msg, received2);
        assertEquals(msg, received3);

        client1.close();
        client2.close();
        client3.close();
    }
}
