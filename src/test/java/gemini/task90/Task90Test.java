package gemini.task90;

import org.junit.jupiter.api.*;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.*;

public class Task90Test {

    private static final int PORT = 65432;
    private static ExecutorService serverExecutor;

    @BeforeAll
    static void startServer() {
        serverExecutor = Executors.newSingleThreadExecutor();
        serverExecutor.submit(() -> {
            Task90_GEMINI_gemini_1_5_pro_001.main(null);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {}
    }

    @AfterAll
    static void stopServer() {
        serverExecutor.shutdownNow();
    }

    private Socket connectClient(String username) throws IOException {
        Socket socket = new Socket("localhost", PORT);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        assertEquals("Enter your username:", in.readLine());
        out.println(username);

         String joinMsg = in.readLine();
        assertTrue(joinMsg.contains(username + " has joined the chat."));

        return socket;
    }

    @Test
    void testClientReceivesOwnBroadcastedMessage() throws Exception {
        Socket client = connectClient("Ahmed");

        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

        out.println("Hello everyone!");
        String message = in.readLine();

        assertEquals("Ahmed: Hello everyone!", message);
        client.close();
    }

    @Test
    void testMessageIsBroadcastToOtherClients() throws Exception {
        Socket client1 = connectClient("Sara");
        Socket client2 = connectClient("Tariq");

        PrintWriter out1 = new PrintWriter(client1.getOutputStream(), true);
        BufferedReader in2 = new BufferedReader(new InputStreamReader(client2.getInputStream()));

         in2.readLine(); // Sara has joined
        in2.readLine(); // Tariq has joined

        out1.println("Hi Tariq!");

        String received = in2.readLine();
        assertEquals("Sara: Hi Tariq!", received);

        client1.close();
        client2.close();
    }

    @Test
    void testClientDisconnectsGracefully() throws Exception {
        Socket client = connectClient("Omar");

        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        client.close();

        Thread.sleep(500);

     }
}
