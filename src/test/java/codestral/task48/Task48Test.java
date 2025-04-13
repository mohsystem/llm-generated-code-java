package codestral.task48;

import org.junit.jupiter.api.*;
import java.io.*;
import java.net.*;
import java.util.concurrent.*;
import static org.junit.jupiter.api.Assertions.*;

public class Task48Test {
    private static final int PORT = 12345;
    private static Thread serverThread;

    @BeforeAll
    public static void startServer() {
        serverThread = new Thread(() -> {
            try {
                Task48_MISTRAL_codestral_latest.main(null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        serverThread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {}
    }

    @Test
    public void testClientMessageBroadcastStrictly() throws Exception {
        Socket client1 = new Socket("localhost", PORT);
        Socket client2 = new Socket("localhost", PORT);

        BufferedReader in1 = new BufferedReader(new InputStreamReader(client1.getInputStream()));
        PrintWriter out1 = new PrintWriter(client1.getOutputStream(), true);

        BufferedReader in2 = new BufferedReader(new InputStreamReader(client2.getInputStream()));
        PrintWriter out2 = new PrintWriter(client2.getOutputStream(), true);

         assertEquals("SUBMITNAME", in1.readLine());
        out1.println("Alice");

        assertEquals("SUBMITNAME", in2.readLine());
        out2.println("Bob");

         assertEquals("NAMEACCEPTED", in1.readLine());
        assertEquals("NAMEACCEPTED", in2.readLine());

         String joinMsg = in2.readLine();
        assertTrue(joinMsg.startsWith("MESSAGE Alice has joined"));

         out1.println("Hello from Alice!");

        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<String> f1 = executor.submit(in1::readLine);
        Future<String> f2 = executor.submit(in2::readLine);

        String msg1 = f1.get(3, TimeUnit.SECONDS);
        String msg2 = f2.get(3, TimeUnit.SECONDS);

        assertEquals("MESSAGE Alice: Hello from Alice!", msg1);
        assertEquals("MESSAGE Alice: Hello from Alice!", msg2);

        client1.close();
        client2.close();
    }
}
