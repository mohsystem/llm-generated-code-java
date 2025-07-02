package gtp4o.task108;

import org.junit.jupiter.api.*;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task108Test {

    private static RemoteObjectInterface remote;

    @BeforeAll
    public static void startServer() throws Exception {
         Thread serverThread = new Thread(() -> {
            try {
                Task108_OPENAI_gpt_4o.main(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        serverThread.setDaemon(true);
        serverThread.start();

         Thread.sleep(1000);

         remote = (RemoteObjectInterface) Naming.lookup("rmi://localhost/RemoteObject");
    }
    @BeforeEach
    public void resetRemoteValue() throws Exception {
        remote.set_value(0);
    }

    @Test
    public void testInitialValue() throws Exception {
         int value = remote.get_value();
        assertEquals(0, value);
    }

    @Test
    public void testSetAndGetValue() throws Exception {
        String response = remote.set_value(42);
        assertEquals("Value set to 42", response);

        int value = remote.get_value();
        assertEquals(42, value);
    }

    @Test
    public void testOverwriteValue() throws Exception {
        remote.set_value(7);
        assertEquals(7, remote.get_value());

        remote.set_value(99);
        assertEquals(99, remote.get_value());
    }
}
