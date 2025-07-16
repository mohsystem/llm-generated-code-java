package codestral.task158;

import java.io.IOException;
import java.util.Scanner;

public class Task158Test {

    // Runs command exactly as your Task158_MISTRAL_codestral_latest class does
    public static int runCommand(String userInput) throws IOException, InterruptedException {
        String command = "your_command_here " + userInput;

        /*
        * The error is command definition
        * To Run this code properly =>
        * For Windows: String command = "cmd /c echo " + userInput;
        * For Linux: String command = "echo " + userInput;
         *
        */

        Process process = Runtime.getRuntime().exec(command);
        return process.waitFor();
    }

    public static void testInputHello() throws IOException, InterruptedException {
        int exitCode = runCommand("Hello");
        if (exitCode == 0) {
            System.out.println("testInputHello: PASS");
        } else {
            System.out.println("testInputHello: FAIL (exit code " + exitCode + ")");
        }
    }

    public static void testInputWorld() throws IOException, InterruptedException {
        int exitCode = runCommand("World");
        if (exitCode == 0) {
            System.out.println("testInputWorld: PASS");
        } else {
            System.out.println("testInputWorld: FAIL (exit code " + exitCode + ")");
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        testInputHello();
        testInputWorld();
        System.out.println("Manual tests executed. (Replace 'your_command_here' with actual command for real execution)");
    }
}
