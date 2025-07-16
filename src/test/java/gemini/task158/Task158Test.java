package gemini.task158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task158Test {

    // Runs a command and captures error output, returns exit code
    public static int runCommand(String command) throws IOException, InterruptedException {
        Process process = Runtime.getRuntime().exec(command);
        BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        String line;
        while ((line = errorReader.readLine()) != null) {
            System.err.println(line);
        }
        return process.waitFor();
    }

    public void test_echo_hello() throws IOException, InterruptedException {
        String command = "cmd /c echo Hello";  // Windows command example
        int exitCode = runCommand(command);
        if (exitCode == 0) {
            System.out.println("test_echo_hello: PASS");
        } else {
            System.out.println("test_echo_hello: FAIL");
        }
    }

    public void test_echo_world() throws IOException, InterruptedException {
        String command = "cmd /c echo World";  // Windows command example
        int exitCode = runCommand(command);
        if (exitCode == 0) {
            System.out.println("test_echo_world: PASS");
        } else {
            System.out.println("test_echo_world: FAIL");
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Task158Test test = new Task158Test();
        test.test_echo_hello();
        test.test_echo_world();
    }
}
