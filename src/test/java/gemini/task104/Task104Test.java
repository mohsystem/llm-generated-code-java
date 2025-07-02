package gemini.task104;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task104Test {

    private static final int BUFFER_SIZE = 1024;

    private String simulateBufferedRead(String input) {
        char[] buffer = new char[BUFFER_SIZE];
        int charsToRead = Math.min(input.length(), BUFFER_SIZE);
        input.getChars(0, charsToRead, buffer, 0);
        return new String(buffer, 0, charsToRead);
    }

    @Test
    void testShortInput() {
        String input = "Hello Gemini!";
        assertEquals("Hello Gemini!", simulateBufferedRead(input));
    }

    @Test
    void testExactBufferSize() {
        String input = "A".repeat(BUFFER_SIZE);
        assertEquals("A".repeat(BUFFER_SIZE), simulateBufferedRead(input));
    }

    @Test
    void testInputLongerThanBuffer() {
        String input = "B".repeat(BUFFER_SIZE + 100);
        assertEquals("B".repeat(BUFFER_SIZE), simulateBufferedRead(input));
    }

    @Test
    void testEmptyInput() {
        assertEquals("", simulateBufferedRead(""));
    }

    @Test
    void testOneCharOverLimit() {
        String input = "X".repeat(BUFFER_SIZE + 1);
        assertEquals("X".repeat(BUFFER_SIZE), simulateBufferedRead(input));
    }
}
