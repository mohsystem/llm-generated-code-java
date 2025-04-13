package gtp4o.task99;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task99Test {

    private String runMainWithInputFile(String content) throws Exception {
        File inputFile = new File("input.txt");
        try (FileWriter writer = new FileWriter(inputFile)) {
            writer.write(content);
        }

        PrintStream originalOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        Task99_OPENAI_gpt_4o.main(null);

        System.setOut(originalOut);
        inputFile.delete();

        return output.toString().trim();
    }

    @Test
    public void testMatchingLines() throws Exception {
        String input = """
                123 This is a valid line.
                456Another valid one.
                Just text.
                Not valid
                9.
                """;

        String expected = """
                123 This is a valid line.
                456Another valid one.
                9.""";

        String output = runMainWithInputFile(input);
        assertEquals(expected.lines().toList(), output.lines().toList());
    }

    @Test
    public void testNoMatchingLines() throws Exception {
        String input = """
                Hello world.
                Starts with letter.
                999 no dot
                """;

        String output = runMainWithInputFile(input);
        assertEquals(List.of(), output.lines().toList());
    }
}
