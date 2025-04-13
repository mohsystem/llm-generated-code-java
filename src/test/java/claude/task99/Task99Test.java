package claude.task99;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task99Test {

    private String runMainWithInputFile(String fileContent) throws Exception {
        File inputFile = new File("input.txt");
        try (FileWriter writer = new FileWriter(inputFile)) {
            writer.write(fileContent);
        }

        PrintStream originalOut = System.out;
        ByteArrayOutputStream testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));

        Task99_CLAUDE_claude_3_5_sonnet_20240620.main(null);

        System.setOut(originalOut);
        inputFile.delete();

        return testOut.toString().trim();
    }

    @Test
    public void testPatternMatchesWithEscapedDot() throws Exception {
        String input = """
                123 valid line\\.
                456 another good one\\.
                789 no backslash dot
                This is invalid.
                """;

        String expected = """
                123 valid line\\.
                456 another good one\\.""";

        String output = runMainWithInputFile(input);
        assertEquals(expected, output);
    }

    @Test
    public void testNoMatchLines() throws Exception {
        String input = """
                just a line
                55 ends with dot.
                99 nothing special
                """;

        String output = runMainWithInputFile(input);
        assertEquals("", output);
    }
}
