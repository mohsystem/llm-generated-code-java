package gtp4o.task74;

import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

public class Task74Test {

    @Test
    public void testGetPostgresConnection_Success() {
         Connection conn = Task74_OPENAI_gpt_4o.getPostgresConnection();
        assertNotNull(conn, "Connection should not be null");

        try {
            assertFalse(conn.isClosed(), "Connection should be open");
            conn.close();
        } catch (Exception e) {
            fail("Error while verifying or closing the connection: " + e.getMessage());
        }
    }
}
