package llama3.task74;

import org.junit.jupiter.api.Test;
import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

public class Task74Test  {

    @Test
    public void testCreateConnection_Success() {
         Connection conn = Task74_PERPLEXITY_llama_3_sonar_large_32k_chat.createConnection();
        assertNotNull(conn, "Connection should not be null");

        try {
            assertFalse(conn.isClosed(), "Connection should be open");
            conn.close();
        } catch (Exception e) {
            fail("Error while verifying/closing connection: " + e.getMessage());
        }
    }
}
