package codestral.task90;

import org.junit.jupiter.api.*;

import java.io.*;
import java.net.*;
import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.*;

public class Task90Test {

    private static final int PORT = 12345;
    private static ExecutorService serverExecutor;

    @BeforeAll
    static void startServer() {
        serverExecutor = Executors.newSingleThreadExecutor();
        serverExecutor.submit(() -> {
            try {
                Task90_MISTRAL_codestral_latest.main(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {}
    }

    @AfterAll
    static void stopServer() {
        serverExecutor.shutdownNow();
    }

    private Socket connectClient(String name) throws IOException {
        Socket socket = new Socket("localhost", PORT);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        assertEquals("SUBMITNAME", in.readLine());
        out.println(name);
        assertEquals("NAMEACCEPTED", in.readLine());

        return socket;
    }

    @Test
    void testSingleClientReceivesMessage() throws Exception {
        Socket client1 = connectClient("Alice");
        PrintWriter out1 = new PrintWriter(client1.getOutputStream(), true);
        BufferedReader in1 = new BufferedReader(new InputStreamReader(client1.getInputStream()));

         String joinMessage = in1.readLine();
        assertTrue(joinMessage.contains("Alice has joined"));

        out1.println("Hello, world!");

         String message = in1.readLine();
        assertEquals("MESSAGE Alice: Hello, world!", message);

        client1.close();
    }

    @Test
    void testBroadcastToMultipleClients() throws Exception {
        Socket client1 = connectClient("Bob");
        Socket client2 = connectClient("Charlie");

        PrintWriter out1 = new PrintWriter(client1.getOutputStream(), true);
        BufferedReader in2 = new BufferedReader(new InputStreamReader(client2.getInputStream()));

         in2.readLine(); // Charlie sees "Bob has joined"
        in2.readLine(); // Charlie sees "Charlie has joined"

        out1.println("Hello everyone!");

        String msg = in2.readLine();
        assertEquals("MESSAGE Bob: Hello everyone!", msg);

        client1.close();
        client2.close();
    }

    @Test
    void testDuplicateNameRejected() throws Exception {
        Socket client1 = connectClient("Zoe");

        Socket client2 = new Socket("localhost", PORT);
        BufferedReader in2 = new BufferedReader(new InputStreamReader(client2.getInputStream()));
        PrintWriter out2 = new PrintWriter(client2.getOutputStream(), true);

        assertEquals("SUBMITNAME", in2.readLine());
        out2.println("Zoe");

         assertEquals("SUBMITNAME", in2.readLine());

        client1.close();
        client2.close();
    }
}
