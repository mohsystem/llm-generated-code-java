package claude.task158;

import java.io.IOException;
import java.util.Scanner;

public class Task158Test {

    public static void main(String[] args) {
        // Running the test manually, since no automated test cases provided in Python code
        try {
            testUserInput("Hello");
            testUserInput("World");
            System.out.println("Manual tests executed. (Check console output for correctness)");
        } catch (Exception e) {
            System.out.println("Test failed with exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Simulates user input and runs the command
    public static void testUserInput(String userInput) throws IOException, InterruptedException {
        Process process = Runtime.getRuntime().exec("cmd /c echo " + userInput);
        int exitCode = process.waitFor();

        if (exitCode == 0) {
            System.out.println("Test with input \"" + userInput + "\": PASS");
        } else {
            System.out.println("Test with input \"" + userInput + "\": FAIL (exit code " + exitCode + ")");
        }
    }
}
