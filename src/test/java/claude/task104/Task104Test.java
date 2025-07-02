package claude.task104;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task104Test {

    private static final int BUFFER_SIZE = 100;

    private String simulateBuffer(String[] inputs) {
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
    void testNormalAddition() {
        String[] inputs = {"hello", "world", "123"};
        assertEquals("helloworld123", simulateBuffer(inputs));
    }

    @Test
    void testExactBufferLimit() {
        String[] inputs = {"a".repeat(50), "b".repeat(50)};
        assertEquals("a".repeat(50) + "b".repeat(50), simulateBuffer(inputs));
    }

    @Test
    void testBufferOverflowAttempt() {
        String[] inputs = {"a".repeat(90), "b".repeat(15)};
        assertEquals("a".repeat(90), simulateBuffer(inputs));
    }

    @Test
    void testQuitBeforeLimit() {
        String[] inputs = {"abc", "q", "def"};
        assertEquals("abc", simulateBuffer(inputs));
    }

    @Test
    void testMultipleOverflows() {
        String[] inputs = {"a".repeat(70), "b".repeat(20), "c".repeat(15)};
        assertEquals("a".repeat(70) + "b".repeat(20), simulateBuffer(inputs));
    }

    @Test
    void testOnlyQuit() {
        String[] inputs = {"q"};
        assertEquals("", simulateBuffer(inputs));
    }

    @Test
    void testFinalInputCausesOverflow() {
        String[] inputs = {"abc", "x".repeat(200)};
        assertEquals("abc", simulateBuffer(inputs));
    }
}
