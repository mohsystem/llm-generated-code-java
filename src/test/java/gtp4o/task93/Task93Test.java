package gtp4o.task93;

import org.junit.jupiter.api.*;

import java.io.*;
import java.nio.file.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class Task93Test {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    void setUp() throws IOException {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        Files.deleteIfExists(Paths.get("temp_file.txt"));
    }

    @AfterEach
    void tearDown() throws IOException {
        System.setOut(originalOut);
        System.setErr(originalErr);
        Files.deleteIfExists(Paths.get("temp_file.txt"));
    }
    @Test
    void testInvalidFormatThrowsException() throws IOException {
        String content = String.join("\n",
                "banana yellow",
                "apple red",
                "invalidline"
        );
        Files.write(Paths.get("temp_file.txt"), content.getBytes());

        ArrayIndexOutOfBoundsException exception = assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> Main.main(new String[]{"temp_file.txt"})
        );

        assertTrue(exception.getMessage().contains("Index 1 out of bounds"));
    }



    @Test
    void testMissingArgument() {
        Main.main(new String[]{});
        String output = outContent.toString().trim();
        assertEquals("Please provide a filename as argument.", output);
    }

    @Test
    void testFileNotFound() {
        Main.main(new String[]{"non_existing_file.txt"});
        String error = errContent.toString();
        assertTrue(error.contains("java.io.FileNotFoundException"));
    }

    @Test
    void testInvalidFormatIgnored() throws IOException {
        String content = String.join("\n",
                "banana yellow",
                "apple red",
                "invalidline"
        );
        Files.write(Paths.get("temp_file.txt"), content.getBytes());


        Main.main(new String[]{"temp_file.txt"});
        String error = errContent.toString();
        assertTrue(error.contains("java.lang.ArrayIndexOutOfBoundsException"));
    }
}
