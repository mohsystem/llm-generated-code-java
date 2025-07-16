package gtp4o.task7;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class Task7Test {

    private static final String TEST_SERVER_ADDRESS = "127.0.0.1";
    private static final int TEST_PORT = 5000;
    private static Process serverProcess;
    private static Socket clientSocket;
    private static PrintWriter out;
    private static BufferedReader in;

    // Start the server before running any tests
    @BeforeAll
    public static void startServer() {
        try {
            // Start the server using ProcessBuilder
            serverProcess = new ProcessBuilder("java", "-cp", ".", "gtp4o.task7.Task7_OPENAI_gpt_4o")
                    .inheritIO()  // Redirects the server's output to the console
                    .start();

            // Wait for the server to start before running tests
            Thread.sleep(1000); // Give it a second to ensure the server is up and listening
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            fail("Failed to start the server");
        }
    }

    // Setup client before each test
    @BeforeEach
    public void setUp() {
        try {
            clientSocket = new Socket(TEST_SERVER_ADDRESS, TEST_PORT);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
            fail("Failed to set up the client socket");
        }
    }

    // Test for a successful login scenario
    @Test
    public void testLoginSuccess() {
        String username = "testUser";
        String password = "testPassword";

        // Send login request to the server
        out.println("{\"action\":\"login\",\"username\":\"" + username + "\",\"password\":\"" + password + "\"}");

        try {
            // Read the response from the server
            String response = in.readLine();
            assertNotNull(response, "Response should not be null");

            // Check if response is as expected
            assertTrue(response.contains("Login successful"), "Expected login success message, but got: " + response);
        } catch (IOException e) {
            e.printStackTrace();
            fail("Error during communication with the server");
        }
    }

    // Test for failed login scenario (invalid credentials)
    @Test
    public void testLoginFailure() {
        String username = "wrongUser";
        String password = "wrongPassword";

        // Send login request to the server
        out.println("{\"action\":\"login\",\"username\":\"" + username + "\",\"password\":\"" + password + "\"}");

        try {
            // Read the response from the server
            String response = in.readLine();
            assertNotNull(response, "Response should not be null");

            // Check if response indicates failure
            assertTrue(response.contains("Invalid credentials"), "Expected failure message, but got: " + response);
        } catch (IOException e) {
            e.printStackTrace();
            fail("Error during communication with the server");
        }
    }

    // Cleanup after each test to close connections
    @AfterEach
    public void tearDown() {
        try {
            if (clientSocket != null && !clientSocket.isClosed()) {
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Stop the server after all tests are completed
    @AfterAll
    public static void stopServer() {
        if (serverProcess != null) {
            serverProcess.destroy(); // Stop the server process
        }
    }
}
