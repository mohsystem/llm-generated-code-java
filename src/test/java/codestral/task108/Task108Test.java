package codestral.task108;

import org.junit.jupiter.api.*;

import java.io.ObjectOutputStream;
import java.net.Socket;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class Task108Test {
    @BeforeAll
    public static void startServer() {
        Thread serverThread = new Thread(() -> {
            try {
                Task108_MISTRAL_codestral_latest server = new Task108_MISTRAL_codestral_latest(9000);
                server.run();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        serverThread.setDaemon(true);
        serverThread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {}
    }

    private static final int PORT = 9000;

    static class Request implements java.io.Serializable {
        String action;
        Integer value;

        public Request(String action, Integer value) {
            this.action = action;
            this.value = value;
        }
    }

    private void send(Request request) throws Exception {
        try (Socket socket = new Socket("localhost", PORT)) {
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(request);
        }
    }

    @Test
    public void testSetValue() {
        assertDoesNotThrow(() -> send(new Request("set", 5)));
    }

    @Test
    public void testIncrementValue() {
        assertDoesNotThrow(() -> send(new Request("increment", null)));
    }

    @Test
    public void testUnknownCommand() {
        assertDoesNotThrow(() -> send(new Request("nonsense", null)));
    }
}
