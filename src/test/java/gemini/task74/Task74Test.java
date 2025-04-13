package gemini.task74;

import org.junit.jupiter.api.Test;
import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

public class Task74Test {

    @Test
    public void testConnectToPostgres_Success() {
        String host = "localhost:5432";
        String database = "portal";
        String user = "postgres";
        String password = "12345";

        Connection conn = Task74_GEMINI_gemini_1_5_pro_001.connectToPostgres(host, database, user, password);

        assertNotNull(conn, "Connection should not be null");
        try {
            assertFalse(conn.isClosed(), "Connection should be open");
            conn.close();
        } catch (Exception e) {
            fail("Error during connection validation or closing: " + e.getMessage());
        }
    }
}
