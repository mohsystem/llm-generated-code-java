package gtp4o.task158;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Task158Test {

    // Runs a command and returns exit code
    public static int runCommand(String command) throws Exception {
        Process process = Runtime.getRuntime().exec(command);
        return process.waitFor();
    }

    public void test_echo_hello() throws Exception {
        String command = "cmd /c echo Hello";  // Windows example matching typical command
        int exitCode = runCommand(command);
        if (exitCode == 0) {
            System.out.println("test_echo_hello: PASS");
        } else {
            System.out.println("test_echo_hello: FAIL");
        }
    }

    public void test_echo_world() throws Exception {
        String command = "cmd /c echo World";
        int exitCode = runCommand(command);
        if (exitCode == 0) {
            System.out.println("test_echo_world: PASS");
        } else {
            System.out.println("test_echo_world: FAIL");
        }
    }

    public static void main(String[] args) throws Exception {
        Task158Test test = new Task158Test();
        test.test_echo_hello();
        test.test_echo_world();
    }
}
