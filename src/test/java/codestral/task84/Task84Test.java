package codestral.task84;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class Task84Test {

    @Test
    public void testGenerateSessionId_NotNullOrEmpty() {
        String sessionId = Task84_MISTRAL_codestral_latest.generateSessionId();
        assertNotNull(sessionId, "Session ID should not be null");
        assertFalse(sessionId.isEmpty(), "Session ID should not be empty");
    }

    @Test
    public void testGenerateSessionId_ValidUUIDFormat() {
        String sessionId = Task84_MISTRAL_codestral_latest.generateSessionId();
        assertDoesNotThrow(() -> UUID.fromString(sessionId), "Session ID should be valid UUID format");
    }

    @Test
    public void testGenerateSessionId_Unique() {
        String id1 = Task84_MISTRAL_codestral_latest.generateSessionId();
        String id2 = Task84_MISTRAL_codestral_latest.generateSessionId();
        assertNotEquals(id1, id2, "Generated session IDs should be unique");
    }

    @Test
    public void testMainMethodPrintsValidUUID() throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));
        try {
            Task84_MISTRAL_codestral_latest.main(new String[]{});
        } finally {
            System.setOut(original);
        }
        String output = out.toString().trim();
        assertDoesNotThrow(() -> UUID.fromString(output), "Printed output should be valid UUID");
    }
}
