package gemini.task99;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;

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

        Task99_GEMINI_gemini_1_5_pro_001.main(null);

        System.setOut(originalOut);
        inputFile.delete();

        return testOut.toString().trim();
    }

    @Test
    public void testOnlyNumbersWithDotMatch() throws Exception {
        String input = """
                123.
                Just some text.
                456.789
                42.
                88 text.
                """;

        String expected = """
                123.
                42.""";

        String output = runMainWithInputFile(input);
        assertEquals(expected.lines().toList(), output.lines().toList());
    }

    @Test
    public void testNoMatches() throws Exception {
        String input = """
                Hello.
                123 text.
                7
                """;

        String output = runMainWithInputFile(input);
        assertEquals(List.of(), output.lines().toList());
    }
}
