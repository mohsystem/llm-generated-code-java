package llama3.task99;

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

        Task99_PERPLEXITY_llama_3_sonar_large_32k_chat.main(null);

        System.setOut(originalOut);
        inputFile.delete();

        return testOut.toString().trim();
    }

    @Test
    public void testValidPatternMatches() throws Exception {
        String input = """
                123 Starts correctly and ends well.
                9999 fine ending.
                Hello world.
                567 No dot
                """;

        String expected = """
                123 Starts correctly and ends well.
                9999 fine ending.""";

        String output = runMainWithInputFile(input);
        assertEquals(expected.lines().toList(), output.lines().toList());
    }

    @Test
    public void testNoMatchingLines() throws Exception {
        String input = """
                no numbers here.
                123 ends wrongly
                text only
                """;

        String output = runMainWithInputFile(input);
        assertEquals(List.of(), output.lines().toList());
    }
}
