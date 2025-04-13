package gemini.task70;

import org.junit.jupiter.api.*;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class Task70Test {

    private static final String JAVA_COMMAND = "java";
    private static final String CLASS_NAME = "gemini.task70.Task70_GEMINI_gemini_1_5_pro_001";

    private String runMainWithArg(String... args) throws IOException, InterruptedException {
        ProcessBuilder builder = new ProcessBuilder(buildCommand(args));
        builder.redirectErrorStream(true); // Combine stderr + stdout
        Process process = builder.start();

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder output = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line).append("\n");
        }

        process.waitFor();
        return output.toString().trim();
    }

    private String[] buildCommand(String... args) {
        String[] base = {JAVA_COMMAND, "-cp", System.getProperty("java.class.path"), CLASS_NAME};
        String[] full = new String[base.length + args.length];
        System.arraycopy(base, 0, full, 0, base.length);
        System.arraycopy(args, 0, full, base.length, args.length);
        return full;
    }

    @Test
    void testReadExistingFile() throws Exception {
        File temp = File.createTempFile("readTest", ".txt");
        String content = "Gemini\nFile\nContent";
        try (FileWriter writer = new FileWriter(temp)) {
            writer.write(content);
        }

        String output = runMainWithArg(temp.getAbsolutePath());
        assertEquals(content, output);
        temp.delete();
    }

    @Test
    void testReadNonExistingFile() throws Exception {
        String fakePath = "nonexistent_" + System.nanoTime() + ".txt";
        String output = runMainWithArg(fakePath);

        assertTrue(output.contains("Error reading file"), output);
    }

    @Test
    void testMissingArgument() throws Exception {
        String output = runMainWithArg();
        assertTrue(output.contains("Please provide the file path"), output);
    }
}
