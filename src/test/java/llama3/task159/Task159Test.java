package llama3.task159;

import org.junit.jupiter.api.*;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class Task159Test {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    void testValidIndices() {
        String input = String.join("\n",
                "5",    // buffer size
                "0",    // should print 0
                "3",    // should print 3
                "4",    // should print 4
                "-1"    // exit
        ) + "\n";

        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Task159_PERPLEXITY_llama_3_sonar_large_32k_chat.main(null);

        String out = output.toString();
        assertTrue(out.contains("Buffer[0] = 0"));
        assertTrue(out.contains("Buffer[3] = 3"));
        assertTrue(out.contains("Buffer[4] = 4"));
    }

    @Test
    void testInvalidIndex() {
        String input = String.join("\n",
                "3",    // buffer size
                "-2",   // invalid
                "3",    // invalid
                "-1"    // exit
        ) + "\n";

        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Task159_PERPLEXITY_llama_3_sonar_large_32k_chat.main(null);

        String out = output.toString();
        assertTrue(out.contains("Invalid index"));
    }

    @Test
    void testNonIntegerInput() {
        String input = String.join("\n",
                "2",      // buffer size
                "abc"     // invalid input, should throw
        ) + "\n";

        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThrows(Exception.class, () -> Task159_PERPLEXITY_llama_3_sonar_large_32k_chat.main(null));
    }
}
