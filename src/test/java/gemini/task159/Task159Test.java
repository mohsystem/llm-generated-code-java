package gemini.task159;

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
    void testValidIndices() {
        String input = String.join("\n",
                "3",           // buffer size
                "apple",       // buffer[0]
                "banana",      // buffer[1]
                "cherry",      // buffer[2]
                "0",           // read index 0
                "1",           // read index 1
                "2",           // read index 2
                "-1"           // exit
        ) + "\n";

        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Task159_GEMINI_gemini_1_5_pro_001.main(null);

        String out = output.toString();

        assertTrue(out.contains("Data at index 0: apple"));
        assertTrue(out.contains("Data at index 1: banana"));
        assertTrue(out.contains("Data at index 2: cherry"));
    }

    @Test
    void testInvalidIndex() {
        String input = String.join("\n",
                "2",        // buffer size
                "x",        // buffer[0]
                "y",        // buffer[1]
                "5",        // invalid index
                "-1"        // exit
        ) + "\n";

        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Task159_GEMINI_gemini_1_5_pro_001.main(null);

        String out = output.toString();

        assertTrue(out.contains("Index out of range."));
    }

    @Test
    void testNonIntegerInput() {
        String input = String.join("\n",
                "2",      // buffer size
                "a",      // buffer[0]
                "b",      // buffer[1]
                "hello",  // invalid input instead of index
                "-1"      // won't reach here
        ) + "\n";

        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Task159_GEMINI_gemini_1_5_pro_001.main(null);

        String out = output.toString();

        assertTrue(out.contains("Invalid input. Please enter integers only."));
    }
}
