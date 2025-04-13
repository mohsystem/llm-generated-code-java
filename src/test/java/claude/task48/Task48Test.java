package claude.task48;

import org.junit.jupiter.api.*;
import java.io.*;
import java.net.*;
import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.*;

public class Task48Test {
    private static final int PORT = 5555;
    private static Thread serverThread;

    @BeforeAll
    public static void startServer() {
        serverThread = new Thread(() -> {
            try {
                Task48_CLAUDE_claude_3_5_sonnet_20240620.main(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        serverThread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {}
    }

    @Test
    public void testMessageBroadcastToAllClients() throws Exception {
        Socket client1 = new Socket("localhost", PORT);
        Socket client2 = new Socket("localhost", PORT);

        BufferedReader reader1 = new BufferedReader(new InputStreamReader(client1.getInputStream()));
        PrintWriter writer1 = new PrintWriter(client1.getOutputStream(), true);

        BufferedReader reader2 = new BufferedReader(new InputStreamReader(client2.getInputStream()));

         String testMessage = "Hello from client 1!";
        writer1.println(testMessage);

         ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<String> future1 = executor.submit(reader1::readLine);
        Future<String> future2 = executor.submit(reader2::readLine);

        String response1 = future1.get(3, TimeUnit.SECONDS);
        String response2 = future2.get(3, TimeUnit.SECONDS);

        assertEquals(testMessage, response1);
        assertEquals(testMessage, response2);

        client1.close();
        client2.close();
    }
}
