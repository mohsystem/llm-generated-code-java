package gtp4o.task131;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.*;
import java.util.*;

class Task131Test {

    private static final String FILE_NAME = "userData.ser";
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    private ByteArrayOutputStream outContent;
    private ByteArrayOutputStream errContent;

    @BeforeEach
    void setUpStreams() {
        outContent = new ByteArrayOutputStream();
        errContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
        System.setErr(originalErr);
        File file = new File(FILE_NAME);
        if (file.exists()) {
            file.delete();
        }
    }

    private void serializeObject(Object obj) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(FILE_NAME);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(obj);
        out.close();
        fileOut.close();
    }

    private void runMain() {
        Task131_OPENAI_gpt_4o.main(new String[]{});
    }

    @Test
    void testValidObjectDeserialization() throws Exception {
        HashMap<String, Object> original = new HashMap<>();
        original.put("name", "John");
        original.put("age", 30);

        serializeObject(original);
        runMain();

        String output = outContent.toString().trim();
        assertTrue(output.contains("John") && output.contains("30"), "Output should contain serialized object data");
    }

    @Test
    void testInvalidFile() {
        // No file created
        runMain();

        String errorOutput = errContent.toString();
        assertTrue(errorOutput.contains("FileNotFoundException"), "Error output should show file not found exception");
    }

    @Test
    void testEmptyFile() throws Exception {
        // Create an empty file
        new FileOutputStream(FILE_NAME).close();

        runMain();

        String errorOutput = errContent.toString();
        assertTrue(errorOutput.contains("StreamCorruptedException") || errorOutput.contains("EOFException"), "Error output should show stream corruption or EOF error");
    }

    @Test
    void testArrayDeserialization() throws Exception {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        serializeObject(list);
        runMain();

        String output = outContent.toString().trim();
        assertTrue(output.contains("1") && output.contains("2") && output.contains("3") && output.contains("4"), "Output should contain the array elements");
    }
}
