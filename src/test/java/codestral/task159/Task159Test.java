package codestral.task159;

import org.junit.jupiter.api.*;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class Task159Test {

    private static final String FILE_NAME = "buffer.dat";

    @BeforeEach
    void prepareBufferFile() throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(FILE_NAME, "rw")) {
            raf.setLength(1024); // 1KB
            for (int i = 0; i < 1024; i++) {
                raf.writeByte(i % 256); // write values 0..255 repeatedly
            }
        }
    }

    @AfterEach
    void cleanup() {
        new File(FILE_NAME).delete(); // clean after test
    }

    @Test
    void testReadValidIndices() {
        String input = "0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Task159_MISTRAL_codestral_latest.main(null);

        String output = out.toString();
        assertTrue(output.contains("Value at index: 0"), "Expected value 0 at index 0");

        // Run another test at different index
        input = "100\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        out.reset();

        Task159_MISTRAL_codestral_latest.main(null);

        output = out.toString();
        assertTrue(output.contains("Value at index: 100"), "Expected value 100 at index 100");
    }

    @Test
    void testOutOfBoundsIndexHandledGracefully() {
        String input = "1024\n"; // beyond file size
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Task159_MISTRAL_codestral_latest.main(null);

        String output = out.toString();
        assertTrue(output.contains("java.io.EOFException"), "Expected EOFException to be printed.");
    }

}
