package llama3.task84;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class Task84Test {

    private String captureMainOutput() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));
        try {
            Task84_PERPLEXITY_llama_3_sonar_large_32k_chat.main(new String[]{});
        } finally {
            System.setOut(original);
        }
        return out.toString().trim();
    }

    @Test
    public void testMain_PrintsValidUUID() {
        String output = captureMainOutput();
        assertNotNull(output, "Output should not be null");
        assertFalse(output.isEmpty(), "Output should not be empty");
        assertDoesNotThrow(() -> UUID.fromString(output), "Output should be valid UUID format");
    }

    @Test
    public void testMain_ProducesDifferentUUIDs() {
        String uuid1 = captureMainOutput();
        String uuid2 = captureMainOutput();
        assertNotEquals(uuid1, uuid2, "Each call to main should produce a unique UUID");
    }
}
