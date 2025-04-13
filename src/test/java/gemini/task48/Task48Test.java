package gemini.task48;

import org.junit.jupiter.api.*;
import java.io.*;
import java.net.*;
import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.*;

public class Task48Test {
    private static final int PORT = 65432;
    private static Thread serverThread;

    @BeforeAll
    public static void startServer() {
        serverThread = new Thread(() -> Task48_GEMINI_gemini_1_5_pro_001.main(null));
        serverThread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {}
    }

    @Test
    public void testBroadcastToOtherClientsOnly() throws Exception {
        Socket client1 = new Socket("localhost", PORT);
        Socket client2 = new Socket("localhost", PORT);

        BufferedReader in1 = new BufferedReader(new InputStreamReader(client1.getInputStream()));
        PrintWriter out1 = new PrintWriter(client1.getOutputStream(), true);

        BufferedReader in2 = new BufferedReader(new InputStreamReader(client2.getInputStream()));
        PrintWriter out2 = new PrintWriter(client2.getOutputStream(), true);

         String testMessage = "Hello from client 1";
        out1.println(testMessage);

         ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<String> f2 = executor.submit(in2::readLine);

        String receivedByClient2 = f2.get(3, TimeUnit.SECONDS);
        assertEquals(testMessage, receivedByClient2);

         client1.setSoTimeout(1000);
        try {
            String unexpected = in1.readLine();
            fail("Client1 should not receive its own message, but got: " + unexpected);
        } catch (SocketTimeoutException expected) {
         }

        client1.close();
        client2.close();
    }
}
