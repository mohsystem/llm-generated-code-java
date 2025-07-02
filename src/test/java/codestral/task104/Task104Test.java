package codestral.task104;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task104Test {

    private String truncateInput(String input, int bufferSize) {
        if (input.length() > bufferSize) {
            return input.substring(0, bufferSize);
        }
        return input;
    }

    @Test
    void testInputShorterThanBuffer() {
        String input = "hello";
        assertEquals("hello", truncateInput(input, 10));
    }

    @Test
    void testInputEqualToBuffer() {
        String input = "abcdefghij";
        assertEquals("abcdefghij", truncateInput(input, 10));
    }

    @Test
    void testInputLongerThanBuffer() {
        String input = "abcdefghijklmnop";
        assertEquals("abcdefghij", truncateInput(input, 10));
    }

    @Test
    void testEmptyInput() {
        String input = "";
        assertEquals("", truncateInput(input, 10));
    }

    @Test
    void testExactlyOneCharacterOver() {
        String input = "abcdefghijk";
        assertEquals("abcdefghij", truncateInput(input, 10));
    }
}
