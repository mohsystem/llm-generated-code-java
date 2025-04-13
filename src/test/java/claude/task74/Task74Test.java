package claude.task74;

import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

public class Task74Test {

    @Test
    public void testCreateConnection_NotNull() {
         Connection conn = Task74_CLAUDE_claude_3_5_sonnet_20240620.createConnection();
        assertNotNull(conn, "Connection should not be null");

         try {
            assertFalse(conn.isClosed(), "Connection should be open");
            conn.close();
        } catch (Exception e) {
            fail("Exception while checking/closing connection: " + e.getMessage());
        }
    }
}
