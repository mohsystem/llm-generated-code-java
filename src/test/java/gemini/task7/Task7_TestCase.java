package gemini.task7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class Task7_TestCase {

    private static final int PORT = 65432;
    private static Map<String, String> users = new HashMap<>();

    @BeforeEach
    public void setup() {
        // Load the user credentials into the test map for validation
        users.put("user1", "password1");
        users.put("user2", "password2");
    }

    // Test Case 1: Successful login with valid credentials
    @Test
    public void testLoginValidCredentials() throws IOException {
        // Simulate the server
        ServerSocket serverSocket = new ServerSocket(PORT);
        Socket clientSocket = new Socket("localhost", PORT);
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        // Send valid login request
        out.println("user1");
        out.println("password1");

        // Expect successful login message
        String response = in.readLine();
        assertEquals("Login successful!", response);

        // Close sockets after the test
        clientSocket.close();
        serverSocket.close();
    }

    // Test Case 2: Failed login with incorrect credentials
    @Test
    public void testLoginInvalidCredentials() throws IOException {
        // Simulate the server
        ServerSocket serverSocket = new ServerSocket(PORT);
        Socket clientSocket = new Socket("localhost", PORT);
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        // Send invalid login request
        out.println("user1");
        out.println("wrongpassword");

        // Expect invalid login message
        String response = in.readLine();
        assertEquals("Invalid credentials!", response);

        // Close sockets after the test
        clientSocket.close();
        serverSocket.close();
    }

    // Test Case 3: Multiple clients logging in successfully
    @Test
    public void testMultipleClientLogin() throws IOException {
        // Simulate the server
        ServerSocket serverSocket = new ServerSocket(PORT);

        // Client 1 login
        Socket clientSocket1 = new Socket("localhost", PORT);
        PrintWriter out1 = new PrintWriter(clientSocket1.getOutputStream(), true);
        BufferedReader in1 = new BufferedReader(new InputStreamReader(clientSocket1.getInputStream()));
        out1.println("user1");
        out1.println("password1");
        String response1 = in1.readLine();
        assertEquals("Login successful!", response1);

        // Client 2 login
        Socket clientSocket2 = new Socket("localhost", PORT);
        PrintWriter out2 = new PrintWriter(clientSocket2.getOutputStream(), true);
        BufferedReader in2 = new BufferedReader(new InputStreamReader(clientSocket2.getInputStream()));
        out2.println("user2");
        out2.println("password2");
        String response2 = in2.readLine();
        assertEquals("Login successful!", response2);

        // Close client sockets after the test
        clientSocket1.close();
        clientSocket2.close();
        serverSocket.close();
    }

    // Test Case 4: Invalid login credentials handling
    @Test
    public void testServerHandlesInvalidLoginCorrectly() throws IOException {
        // Simulate the server
        ServerSocket serverSocket = new ServerSocket(PORT);
        Socket clientSocket = new Socket("localhost", PORT);
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        // Send invalid credentials
        out.println("nonexistentuser");
        out.println("wrongpassword");

        // Expect invalid login response
        String response = in.readLine();
        assertEquals("Invalid credentials!", response);

        // Close sockets after the test
        clientSocket.close();
        serverSocket.close();
    }
}
