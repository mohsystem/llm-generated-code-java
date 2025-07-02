package claude.task159;

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
    void testValidIndicesAndExit() {
        String input = "0\n25\n50\n99\n-1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Task159_CLAUDE_claude_3_5_sonnet_20240620.main(null);

        String out = output.toString();
        System.out.println("=== Output ===\n" + out + "==============");

        assertTrue(out.contains("Data at index 0: A"));
        assertTrue(out.contains("Data at index 25: Z"));
        assertTrue(out.contains("Data at index 50: Y")); // 50 % 26 = 24 → Y
        assertTrue(out.contains("Data at index 99: V")); // 99 % 26 = 21 → V ✅
    }

    @Test
    void testInvalidIndicesAndExit() {
        String input = "-5\n100\n200\n-1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Task159_CLAUDE_claude_3_5_sonnet_20240620.main(null);

        String out = output.toString();
        assertTrue(out.contains("Invalid index. Please enter a number between 0 and 99."));
    }

    @Test
    void testNonIntegerInputAndExit() {
        String input = "abc\n10.5\n5\n-1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Task159_CLAUDE_claude_3_5_sonnet_20240620.main(null);

        String out = output.toString();
        assertTrue(out.contains("Invalid input. Please enter a valid integer."));
        assertTrue(out.contains("Data at index 5: F"));
    }
}
