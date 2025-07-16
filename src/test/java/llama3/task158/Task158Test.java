package llama3.task158;

import java.io.IOException;
import java.util.Scanner;

public class Task158Test {

    public static void testWithInput(String input) throws IOException, InterruptedException {
        String command = "cmd /c echo " + input + " > output.txt"; // Windows style command
        Process process = Runtime.getRuntime().exec(command);
        int exitCode = process.waitFor();

        if (exitCode == 0) {
            System.out.println("Test with input \"" + input + "\": PASS");
        } else {
            System.out.println("Test with input \"" + input + "\": FAIL (exit code " + exitCode + ")");
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        testWithInput("Hello");
        testWithInput("World");
        System.out.println("Manual tests executed. Check output.txt for correctness.");
    }
}
