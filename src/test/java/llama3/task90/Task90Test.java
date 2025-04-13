package llama3.task90;

import org.junit.jupiter.api.*;

import java.io.*;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.*;

public class Task90Test {

    private static final int PORT = 9090;
    private static ExecutorService serverExecutor;

    @BeforeAll
    static void startServer() {
        serverExecutor = Executors.newSingleThreadExecutor();
        serverExecutor.submit(() -> {
            try {
                Task90_PERPLEXITY_llama_3_sonar_large_32k_chat.main(null);
            } catch (IOException e) {
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

    private static class ChatClient {
        Socket socket;
        BufferedReader in;
        PrintWriter out;

        ChatClient(String nickname) throws IOException {
            socket = new Socket("127.0.0.1", PORT);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            assertEquals("NICK", in.readLine());
            out.println(nickname);
        }

        void send(String message) {
            out.println(message);
        }

        String receive() throws IOException {
            return in.readLine();
        }

        List<String> receiveMultiple(int count, int timeoutMillis) throws IOException {
            List<String> messages = new ArrayList<>();
            long deadline = System.currentTimeMillis() + timeoutMillis;
            while (messages.size() < count && System.currentTimeMillis() < deadline) {
                if (in.ready()) {
                    messages.add(in.readLine());
                }
            }
            return messages;
        }

        void close() throws IOException {
            socket.close();
        }
    }

    @Test
    void testBroadcastBetweenTwoClients() throws Exception {
        ChatClient client1 = new ChatClient("Ali");
        ChatClient client2 = new ChatClient("Omar");

        List<String> initial = client2.receiveMultiple(2, 1000); // join messages

        client1.send("Hello from Ali");

        List<String> finalMessages = client2.receiveMultiple(2, 1000);
        initial.addAll(finalMessages);

        boolean hasJoin = initial.contains("Ali joined the chat!");
        boolean hasMessage = initial.contains("Hello from Ali");

        assertTrue(hasJoin, "Expected 'Ali joined the chat!'");
        assertTrue(hasMessage, "Expected 'Hello from Ali'");

        client1.close();
        client2.close();
    }


    @Test
    void testLeaveMessageOnDisconnect() throws Exception {
        ChatClient client1 = new ChatClient("Yousef");
        ChatClient client2 = new ChatClient("Rami");

        client2.receive(); // "Yousef joined the chat!"

        client1.close();

        List<String> messages = client2.receiveMultiple(5, 1000);
        boolean foundLeave = messages.contains("Yousef left the chat!");

        assertTrue(foundLeave, "Expected 'Yousef left the chat!' but it was not received.");
        client2.close();
    }

}
