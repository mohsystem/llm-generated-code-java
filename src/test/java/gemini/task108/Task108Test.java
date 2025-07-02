package gemini.task108;

import org.junit.jupiter.api.*;

import java.io.*;
import java.net.Socket;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task108Test {

    private static final int PORT = 5000;
    private static final String OBJECT_ID = "remote1";

    public static class RemoteObject implements Serializable {
        public int value = 0;

        public void increment() {
            value++;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int newValue) {
            this.value = newValue;
        }
    }

    private Object send(Object[] request, boolean expectResponse) throws Exception {
        try (Socket socket = new Socket("localhost", PORT);
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {

            out.writeObject(request);
            if (expectResponse) {
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                return in.readObject();
            }
        }
        return null;
    }

    private Object send(Object[] request) throws Exception {
        return send(request, true);
    }

    @BeforeAll
    public static void startServer() {
        Thread serverThread = new Thread(() -> {
            try {
                Task108_GEMINI_gemini_1_5_pro_001 server = new Task108_GEMINI_gemini_1_5_pro_001(PORT);
                server.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        serverThread.setDaemon(true);
        serverThread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {}
    }

    @BeforeEach
    public void setup() throws Exception {
        send(new Object[]{"CREATE", OBJECT_ID, new RemoteObject()}, false);
    }

    @Test
    public void testInitialValue() throws Exception {
        Object result = send(new Object[]{"CALL", OBJECT_ID, "getValue", new Object[]{new Object[0]}});
        assertEquals(0, result);
    }

    @Test
    public void testSetValue() throws Exception {
        send(new Object[]{"CALL", OBJECT_ID, "setValue", new Object[]{new Object[]{5}}});
        Object result = send(new Object[]{"CALL", OBJECT_ID, "getValue", new Object[]{new Object[0]}});
        assertEquals(5, result);
    }

    @Test
    public void testIncrement() throws Exception {
        send(new Object[]{"CALL", OBJECT_ID, "setValue", new Object[]{new Object[]{3}}});
        send(new Object[]{"CALL", OBJECT_ID, "increment", new Object[]{new Object[0]}});
        send(new Object[]{"CALL", OBJECT_ID, "increment", new Object[]{new Object[0]}});
        Object result = send(new Object[]{"CALL", OBJECT_ID, "getValue", new Object[]{new Object[0]}});
        assertEquals(5, result);
    }
}
