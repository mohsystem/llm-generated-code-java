package codestral.task74;

import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

public class Task74Test {

    @Test
    public void testCreateDBConnection() {
        Connection conn = Task74_MISTRAL_codestral_latest.createDBConnection();
        assertNotNull(conn, "Connection should not be null");

        try {
            assertFalse(conn.isClosed(), "Connection should be open");
            conn.close();
        } catch (Exception e) {
            fail("Error while checking/closing connection: " + e.getMessage());
        }
    }
}
