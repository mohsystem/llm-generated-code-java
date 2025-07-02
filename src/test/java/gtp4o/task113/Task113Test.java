package gtp4o.task113;

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
        Task113_OPENAI_gpt_4o.main(new String[]{});
    }

    @Test
    void testSingleString() {
        provideInput("Hello\n\n");
        runMain();
        String output = outContent.toString().trim();
        assertTrue(output.contains("Concatenated result: Hello"));
    }

    @Test
    void testMultipleStrings() {
        provideInput("Hello\nWorld\nPython\n\n");
        runMain();
        String output = outContent.toString().trim();
        assertTrue(output.contains("Concatenated result: HelloWorldPython"));
    }


}
