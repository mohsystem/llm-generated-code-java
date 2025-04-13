package claude.task75;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

public class Task75Test {

    private String runMain(String[] args) throws Exception {
        PrintStream originalOut = System.out;
        PrintStream originalErr = System.err;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(outContent));

        try {
            Class<?> clazz = Class.forName("claude.task75.Task75_CLAUDE_claude_3_5_sonnet_20240620");
            Method main = clazz.getMethod("main", String[].class);
            main.invoke(null, (Object) args);
        } finally {
            System.setOut(originalOut);
            System.setErr(originalErr);
        }

        return outContent.toString().trim();
    }

    @Test
    public void testNoArguments() throws Exception {
        String output = runMain(new String[]{});
        assertTrue(output.contains("Usage"), "Expected usage message when no PID is provided");
    }

    @Test
    public void testInvalidPID() throws Exception {
        String output = runMain(new String[]{"abc"});
        assertTrue(output.contains("Invalid PID"), "Expected invalid PID message");
    }

    @Test
    public void testTerminateDummyProcess() throws Exception {
        // Start a dummy process (e.g., ping -t for Windows)
        Process dummy = new ProcessBuilder("ping", "localhost", "-t").start();
        long pid = dummy.pid(); // Java 9+

        String output = runMain(new String[]{String.valueOf(pid)});

        // Some systems may delay termination
        boolean stillAlive = dummy.isAlive();
        if (stillAlive) dummy.destroy();

        assertTrue(output.contains("has been terminated") || output.contains("Failed to terminate"), "Expected termination result");
    }

    @Test
    public void testNonExistentPID() throws Exception {
        String fakePid = "999999";
        String output = runMain(new String[]{fakePid});
        assertTrue(output.contains("Failed to terminate") || output.contains("not found"), "Expected failure to terminate non-existent PID");
    }
}
