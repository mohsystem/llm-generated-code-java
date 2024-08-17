package claude.task7;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.*;
import java.io.*;
import java.net.Socket;

import static org.junit.jupiter.api.Assertions.*;

public class Task7_TestCase {

    private static Thread serverThread;
    private static final int PORT = 5000;

    @BeforeAll
    static void startServer() {
        serverThread = new Thread(() -> {
            try {
                Server server = new Server(PORT);
                server.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        serverThread.start();

        // Give server time to start
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testValidLogin() throws IOException, ParseException {
        Client client = new Client();
        client.startConnection("localhost", PORT);

        // Simulate valid credentials
        createCredentialsFile("validuser:validpass");

        JSONObject request = new JSONObject();
        request.put("action", "login");
        request.put("username", "validuser");
        request.put("password", "validpass");

        client.out.println(request.toJSONString());
        String response = client.in.readLine();

        JSONObject jsonResponse = (JSONObject) new JSONParser().parse(response);
        assertEquals("success", jsonResponse.get("status"));
        assertEquals("Login successful", jsonResponse.get("message"));

        client.stopConnection();
    }

    @Test
    void testInvalidLogin() throws IOException, ParseException {
        Client client = new Client();
        client.startConnection("localhost", PORT);

        // Simulate valid credentials
        createCredentialsFile("validuser:validpass");

        JSONObject request = new JSONObject();
        request.put("action", "login");
        request.put("username", "invaliduser");
        request.put("password", "invalidpass");

        client.out.println(request.toJSONString());
        String response = client.in.readLine();

        JSONObject jsonResponse = (JSONObject) new JSONParser().parse(response);
        assertEquals("failure", jsonResponse.get("status"));
        assertEquals("Invalid credentials", jsonResponse.get("message"));

        client.stopConnection();
    }

    @Test
    void testEmptyUsernameLogin() throws IOException, ParseException {
        Client client = new Client();
        client.startConnection("localhost", PORT);

        createCredentialsFile("validuser:validpass");

        JSONObject request = new JSONObject();
        request.put("action", "login");
        request.put("username", "");
        request.put("password", "validpass");

        client.out.println(request.toJSONString());
        String response = client.in.readLine();

        JSONObject jsonResponse = (JSONObject) new JSONParser().parse(response);
        assertEquals("failure", jsonResponse.get("status"));
        assertEquals("Invalid credentials", jsonResponse.get("message"));

        client.stopConnection();
    }

    @Test
    void testEmptyPasswordLogin() throws IOException, ParseException {
        Client client = new Client();
        client.startConnection("localhost", PORT);

        createCredentialsFile("validuser:validpass");

        JSONObject request = new JSONObject();
        request.put("action", "login");
        request.put("username", "validuser");
        request.put("password", "");

        client.out.println(request.toJSONString());
        String response = client.in.readLine();

        JSONObject jsonResponse = (JSONObject) new JSONParser().parse(response);
        assertEquals("failure", jsonResponse.get("status"));
        assertEquals("Invalid credentials", jsonResponse.get("message"));

        client.stopConnection();
    }

    @Test
    void testMultipleClientsLogin() throws IOException, ParseException {
        Client client1 = new Client();
        client1.startConnection("localhost", PORT);

        Client client2 = new Client();
        client2.startConnection("localhost", PORT);

        createCredentialsFile("validuser:validpass");

        // Client 1
        JSONObject request1 = new JSONObject();
        request1.put("action", "login");
        request1.put("username", "validuser");
        request1.put("password", "validpass");
        client1.out.println(request1.toJSONString());

        String response1 = client1.in.readLine();
        JSONObject jsonResponse1 = (JSONObject) new JSONParser().parse(response1);
        assertEquals("success", jsonResponse1.get("status"));
        assertEquals("Login successful", jsonResponse1.get("message"));

        // Client 2 (invalid credentials)
        JSONObject request2 = new JSONObject();
        request2.put("action", "login");
        request2.put("username", "invaliduser");
        request2.put("password", "invalidpass");
        client2.out.println(request2.toJSONString());

        String response2 = client2.in.readLine();
        JSONObject jsonResponse2 = (JSONObject) new JSONParser().parse(response2);
        assertEquals("failure", jsonResponse2.get("status"));
        assertEquals("Invalid credentials", jsonResponse2.get("message"));

        client1.stopConnection();
        client2.stopConnection();
    }

    @Test
    void testClientAfterInvalidLogin() throws IOException, ParseException {
        Client client = new Client();
        client.startConnection("localhost", PORT);

        createCredentialsFile("validuser:validpass");

        // Invalid login attempt
        JSONObject request = new JSONObject();
        request.put("action", "login");
        request.put("username", "invaliduser");
        request.put("password", "invalidpass");
        client.out.println(request.toJSONString());

        String response = client.in.readLine();
        JSONObject jsonResponse = (JSONObject) new JSONParser().parse(response);
        assertEquals("failure", jsonResponse.get("status"));
        assertEquals("Invalid credentials", jsonResponse.get("message"));

        // Valid login attempt after invalid login
        request.put("username", "validuser");
        request.put("password", "validpass");
        client.out.println(request.toJSONString());

        response = client.in.readLine();
        jsonResponse = (JSONObject) new JSONParser().parse(response);
        assertEquals("success", jsonResponse.get("status"));
        assertEquals("Login successful", jsonResponse.get("message"));

        client.stopConnection();
    }

    @Test
    void testServerRejectsEmptyLoginRequest() throws IOException, ParseException {
        Client client = new Client();
        client.startConnection("localhost", PORT);

        // Sending an empty request
        client.out.println("");

        String response = client.in.readLine();
        assertNull(response); // Expecting no response or a server exception

        client.stopConnection();
    }

    @Test
    void testServerProcessesSimultaneousLogins() throws IOException, ParseException, InterruptedException {
        createCredentialsFile("user1:pass1\nuser2:pass2");

        Thread clientThread1 = new Thread(() -> {
            try {
                Client client = new Client();
                client.startConnection("localhost", PORT);

                JSONObject request = new JSONObject();
                request.put("action", "login");
                request.put("username", "user1");
                request.put("password", "pass1");
                client.out.println(request.toJSONString());

                String response = client.in.readLine();
                JSONObject jsonResponse = (JSONObject) new JSONParser().parse(response);
                assertEquals("success", jsonResponse.get("status"));
                assertEquals("Login successful", jsonResponse.get("message"));

                client.stopConnection();
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
        });

        Thread clientThread2 = new Thread(() -> {
            try {
                Client client = new Client();
                client.startConnection("localhost", PORT);

                JSONObject request = new JSONObject();
                request.put("action", "login");
                request.put("username", "user2");
                request.put("password", "pass2");
                client.out.println(request.toJSONString());

                String response = client.in.readLine();
                JSONObject jsonResponse = (JSONObject) new JSONParser().parse(response);
                assertEquals("success", jsonResponse.get("status"));
                assertEquals("Login successful", jsonResponse.get("message"));

                client.stopConnection();
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
        });

        clientThread1.start();
        clientThread2.start();

        clientThread1.join();
        clientThread2.join();
    }

    @Test
    void testClientDisconnectsGracefully() throws IOException, ParseException {
        Client client = new Client();
        client.startConnection("localhost", PORT);

        createCredentialsFile("user:pass");

        JSONObject request = new JSONObject();
        request.put("action", "login");
        request.put("username", "user");
        request.put("password", "pass");
        client.out.println(request.toJSONString());

        String response = client.in.readLine();
        JSONObject jsonResponse = (JSONObject) new JSONParser().parse(response);
        assertEquals("success", jsonResponse.get("status"));
        assertEquals("Login successful", jsonResponse.get("message"));

        client.stopConnection();

        // Try reconnecting after disconnect
        client.startConnection("localhost", PORT);
        client.out.println(request.toJSONString());

        response = client.in.readLine();
        jsonResponse = (JSONObject) new JSONParser().parse(response);
        assertEquals("success", jsonResponse.get("status"));
        assertEquals("Login successful", jsonResponse.get("message"));

        client.stopConnection();
    }

    @Test
    void testInvalidPortConnection() {
        Exception exception = assertThrows(IOException.class, () -> {
            Client client = new Client();
            client.startConnection("localhost", 9999); // Invalid port
        });

        String expectedMessage = "Connection refused";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @AfterAll
    static void stopServer() {
        serverThread.interrupt();
    }

    private void createCredentialsFile(String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt"))) {
            writer.write(content);
        }
    }
}
