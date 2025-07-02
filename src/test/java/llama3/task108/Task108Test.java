package llama3.task108;

import org.junit.jupiter.api.*;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task108Test {

    private static MyInterface remote;

    @BeforeAll
    public static void connectToServer() throws Exception {
         LocateRegistry.createRegistry(1099);

         Task108_PERPLEXITY_llama_3_sonar_large_32k_chat obj = new Task108_PERPLEXITY_llama_3_sonar_large_32k_chat();
        Naming.rebind("MyService", obj);

         remote = (MyInterface) Naming.lookup("rmi://localhost/MyService");
    }

    @Test
    public void testGetData() throws Exception {
        String result = remote.getData();
        assertEquals("Hello from server!", result);
    }

    @Test
    public void testSetData() throws Exception {
         Assertions.assertDoesNotThrow(() -> remote.setData("Test from JUnit"));
    }
}
