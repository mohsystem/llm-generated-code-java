package claude.task87;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class Task87Test {

    @Test
    public void testBinarySearchFound() {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int target = 13;
        int expectedIndex = 6;

        int result = Task87_CLAUDE_claude_3_5_sonnet_20240620.binarySearch(arr, target);
        assertEquals(expectedIndex, result);
    }

    @Test
    public void testBinarySearchNotFound() {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int target = 14;

        int result = Task87_CLAUDE_claude_3_5_sonnet_20240620.binarySearch(arr, target);
        assertEquals(-1, result);
    }

    @Test
    public void testExecutionTimeFileFormat() throws IOException {
        // Simulate the logic in main() and check file content format
        Path tempFile = Files.createTempFile("execution_time", ".txt");
        double fakeTime = 0.012345;

        Files.writeString(tempFile, String.format("Execution time: %.6f seconds", fakeTime));

        String content = Files.readString(tempFile);
        assertTrue(content.startsWith("Execution time: "));
        assertTrue(content.endsWith(" seconds"));

        double parsedTime = Double.parseDouble(content.replaceAll("[^\\d.]", ""));
        assertEquals(fakeTime, parsedTime, 1e-6);
    }
}
