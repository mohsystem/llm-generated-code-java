package gtp4o.task48;

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
        serverThread = new Thread(() -> Task48_OPENAI_gpt_4o.main(null));
        serverThread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {}
    }

    @Test
    public void testBroadcastToOthersOnly_strict() throws Exception {
        Socket client1 = new Socket("localhost", PORT);
        Socket client2 = new Socket("localhost", PORT);

        BufferedReader in1 = new BufferedReader(new InputStreamReader(client1.getInputStream()));
        PrintWriter out1 = new PrintWriter(client1.getOutputStream(), true);

        BufferedReader in2 = new BufferedReader(new InputStreamReader(client2.getInputStream()));
        PrintWriter out2 = new PrintWriter(client2.getOutputStream(), true);

        String message = "Test message from client1";
        out1.println(message);

         ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<String> future = executor.submit(in2::readLine);
        String received = future.get(3, TimeUnit.SECONDS);
        assertEquals(message, received);

         client1.setSoTimeout(1000);
        try {
            String shouldNotReceive = in1.readLine();
            fail("Client1 should not receive its own message, but got: " + shouldNotReceive);
        } catch (SocketTimeoutException expected) {
         }

        client1.close();
        client2.close();
    }
}
