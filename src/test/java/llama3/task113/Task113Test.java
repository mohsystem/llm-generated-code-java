package llama3.task113;

import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class Task113Test {

    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUpStreams() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    private void provideInput(String data) {
        System.setIn(new ByteArrayInputStream(data.getBytes()));
    }

    private void runMain() {
        Task113_PERPLEXITY_llama_3_sonar_large_32k_chat.main(new String[]{});
    }

    @Test
    void testSingleString() {
        provideInput("1\nHello\n");
        runMain();
        String output = outContent.toString();
        assertTrue(output.contains("Concatenated string: Hello"));
    }

    @Test
    void testMultipleStrings() {
        provideInput("3\nHello\nWorld\nPython\n");
        runMain();
        String output = outContent.toString();
        assertTrue(output.contains("Concatenated string: HelloWorldPython"));
    }

    @Test
    void testNoStrings() {
        provideInput("0\n");
        runMain();
        String output = outContent.toString();
        assertTrue(output.contains("Concatenated string: "));
    }
}
