package gtp4o.task159;

import org.junit.jupiter.api.*;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class Task159Test {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    void testValidReadFromBuffer() {
        String input = String.join("\n",
                "3",     // buffer size
                "0",     // read index 0
                "1",     // read index 1
                "2",     // read index 2
                "-1"     // exit
        ) + "\n";

        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Task159_OPENAI_gpt_4o.main(null);

        String out = output.toString();
        assertTrue(out.contains("Value at index 0: 0"));
        assertTrue(out.contains("Value at index 1: 0"));
        assertTrue(out.contains("Value at index 2: 0"));
    }

    @Test
    void testOutOfBoundsAccess() {
        String input = String.join("\n",
                "2",   // buffer size
                "5",   // invalid index
                "-1"   // exit
        ) + "\n";

        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Task159_OPENAI_gpt_4o.main(null);

        String out = output.toString();
        assertTrue(out.contains("Index out of bounds."));
    }

    @Test
    void testInvalidInputHandling() {
        String input = String.join("\n",
                "2",       // buffer size
                "abc",     // invalid input
                "-1"       // won't be read
        ) + "\n";

        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThrows(Exception.class, () -> Task159_OPENAI_gpt_4o.main(null));
    }
}
