package gtp4o.task104;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task104Test {

    private static final int BUFFER_SIZE = 10;

    // محاكاة لكلاس JNI
    static class MockBufferProgram {
        private final char[] buffer = new char[BUFFER_SIZE];
        private int index = 0;

        public void addChar(char c) {
            if (index < BUFFER_SIZE) {
                buffer[index++] = c;
            }
        }

        public String getBufferContent() {
            return new String(buffer, 0, index);
        }
    }

    @Test
    void testBufferFillsCorrectly() {
        MockBufferProgram program = new MockBufferProgram();
        String input = "ABCDEFGHIJ";
        for (char c : input.toCharArray()) {
            program.addChar(c);
        }
        assertEquals("ABCDEFGHIJ", program.getBufferContent());
    }

    @Test
    void testBufferStopsAtLimit() {
        MockBufferProgram program = new MockBufferProgram();
        String input = "ABCDEFGHIJKL"; // 12 chars
        for (char c : input.toCharArray()) {
            program.addChar(c);
        }
        assertEquals("ABCDEFGHIJ", program.getBufferContent()); // only first 10 stored
    }

    @Test
    void testPartialFill() {
        MockBufferProgram program = new MockBufferProgram();
        String input = "AB";
        for (char c : input.toCharArray()) {
            program.addChar(c);
        }
        assertEquals("AB", program.getBufferContent());
    }

    @Test
    void testEmptyInput() {
        MockBufferProgram program = new MockBufferProgram();
        assertEquals("", program.getBufferContent());
    }
}
