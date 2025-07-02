package llama3.task104;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task104Test {

    private static final int BUFFER_SIZE = 20;

    private String simulatePythonBuffer(String[] inputs) {
        StringBuilder buffer = new StringBuilder();
        for (String input : inputs) {
            if (input.equalsIgnoreCase("q")) {
                break;
            }
            if (buffer.length() + input.length() <= BUFFER_SIZE) {
                buffer.append(input);
            } else {
                System.out.println("Error: Buffer overflow. Cannot add more than " + BUFFER_SIZE + " characters.");
            }
        }
        return buffer.toString();
    }

    @Test
    void testShortPassword() {
        String[] inputs = {"Ab1"};
        assertEquals("Ab1", simulatePythonBuffer(inputs));
    }

    @Test
    void testNoUppercase() {
        String[] inputs = {"abcdefgh1"};
        assertEquals("abcdefgh1", simulatePythonBuffer(inputs));
    }

    @Test
    void testNoLowercase() {
        String[] inputs = {"ABCDEF1"};
        assertEquals("ABCDEF1", simulatePythonBuffer(inputs));
    }

    @Test
    void testNoDigit() {
        String[] inputs = {"Abcdefgh"};
        assertEquals("Abcdefgh", simulatePythonBuffer(inputs));
    }

    @Test
    void testValidPassword() {
        String[] inputs = {"Abcdefg1"};
        assertEquals("Abcdefg1", simulatePythonBuffer(inputs));
    }

    @Test
    void testPasswordExactly20Chars() {
        String[] inputs = {"A1bcdefgH2ijklmNOPQR"};
        assertEquals("A1bcdefgH2ijklmNOPQR", simulatePythonBuffer(inputs));
    }

    @Test
    void testPasswordWithOverflow() {
        String[] inputs = {"abcdefghij", "klmnopqrstu"}; // total > 20
        assertEquals("abcdefghij", simulatePythonBuffer(inputs));
    }

    @Test
    void testQuitBeforeAddingAll() {
        String[] inputs = {"1234", "q", "5678"};
        assertEquals("1234", simulatePythonBuffer(inputs));
    }

    @Test
    void testBufferFillsThenIgnoresExtra() {
        String[] inputs = {"abc", "defghijklmno", "xyz", "q"};
        assertEquals("abcdefghijklmno", simulatePythonBuffer(inputs));
    }

    @Test
    void testOnlyQuit() {
        String[] inputs = {"q"};
        assertEquals("", simulatePythonBuffer(inputs));
    }
}
