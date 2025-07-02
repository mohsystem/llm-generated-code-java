package claude.task108;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task108Test {

    private static RemoteObject remoteObject;

    @BeforeAll
    public static void setup() throws Exception {
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        remoteObject = (RemoteObject) registry.lookup("RemoteObject");
    }

    @Test
    public void testInitialValue() throws Exception {
        remoteObject.setValue(0);
        assertEquals(0, remoteObject.getValue(), "Initial value should be 0");
    }

    @Test
    public void testSetValue() throws Exception {
        remoteObject.setValue(0);
        remoteObject.setValue(5);
        assertEquals(5, remoteObject.getValue(), "Value should be 5 after setting to 5");
    }

    @Test
    public void testIncrement() throws Exception {
        remoteObject.setValue(5);
        remoteObject.increment();
        remoteObject.increment();
        remoteObject.increment();
        assertEquals(8, remoteObject.getValue(), "Value should be 8 after 3 increments from 5");
    }
}
