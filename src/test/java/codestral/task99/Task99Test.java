package codestral.task99;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task99Test {

    private String runMainWithInputFile(String fileContent) throws Exception {
        File inputFile = new File("path_to_your_file.txt");
        try (FileWriter writer = new FileWriter(inputFile)) {
            writer.write(fileContent);
        }

        PrintStream originalOut = System.out;
        ByteArrayOutputStream testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));

        Task99_MISTRAL_codestral_latest.main(null);

        System.setOut(originalOut);
        inputFile.delete();

        return testOut.toString().trim();
    }

    @Test
    public void testValidMatches() throws Exception {
        String input = """
                123 This line ends with a dot.
                Not valid line.
                456Another valid one.
                78 ends without dot
                """;

        String expected = """
                123 This line ends with a dot.
                456Another valid one.""";

        String output = runMainWithInputFile(input);
        assertEquals(expected.lines().toList(), output.lines().toList());
    }

    @Test
    public void testNoMatch() throws Exception {
        String input = """
                no numbers here.
                Just text.
                . starts with dot
                123 but no dot
                """;

        String output = runMainWithInputFile(input);
        assertEquals(List.of(), output.lines().toList());
    }
}
