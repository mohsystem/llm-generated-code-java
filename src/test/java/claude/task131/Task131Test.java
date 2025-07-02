package claude.task131;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.*;

class Task131Test {

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
        Task131_CLAUDE_claude_3_5_sonnet_20240620.main(new String[]{});
    }

    @Test
    void testValidJsonInput() {
        String input = "{\"name\": \"John\", \"age\": 30}\n";
        provideInput(input);
        runMain();
        String output = outContent.toString().trim();

        assertTrue(output.contains("Deserialized data:"), "Output should mention 'Deserialized data:'");
        assertTrue(output.contains("\"name\" : \"John\""), "Output should contain the name field");
        assertTrue(output.contains("\"age\" : 30"), "Output should contain the age field");
    }

    @Test
    void testInvalidJsonInput() {
        String input = "{name: John, age: 30}\n";  // Invalid JSON (missing quotes)
        provideInput(input);
        runMain();
        String output = outContent.toString().trim();

        assertTrue(output.contains("Error: Invalid JSON data"), "Output should mention invalid JSON error");
    }

    @Test
    void testEmptyJsonObject() {
        String input = "{}\n";
        provideInput(input);
        runMain();
        String output = outContent.toString().trim();

        assertTrue(output.contains("Deserialized data:"), "Output should mention 'Deserialized data:'");
        assertTrue(output.contains("{ }") || output.contains("{}"), "Output should contain empty JSON object");
    }

    @Test
    void testArrayJsonInput() {
        String input = "[1, 2, 3, 4]\n";
        provideInput(input);
        runMain();
        String output = outContent.toString().trim();

        assertTrue(output.contains("Deserialized data:"), "Output should mention 'Deserialized data:'");
        assertTrue(output.contains("[ 1, 2, 3, 4 ]") || output.contains("[1,2,3,4]") || output.contains("[ 1 , 2 , 3 , 4 ]"), "Output should contain array");
    }
}
