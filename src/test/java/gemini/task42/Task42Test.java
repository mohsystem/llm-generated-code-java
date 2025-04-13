package gemini.task42;

import org.junit.jupiter.api.*;

import java.io.*;
import java.nio.file.*;
import java.security.MessageDigest;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Task42Test {

    private static final String USERS_FILE = "users.txt";

    @BeforeEach
    void clearFile() throws IOException {
        Files.deleteIfExists(Path.of(USERS_FILE));
        Files.createFile(Path.of(USERS_FILE));
    }

    @Test
    @Order(1)
    void testRegisterNewUser() throws Exception {
        assertTrue(register("bob", "securepassword"));
        assertTrue(fileContainsUser("bob", "securepassword"));
    }

    @Test
    @Order(2)
    void testRegisterExistingUser() throws Exception {
        assertTrue(register("alice", "password123"));
        assertFalse(register("alice", "newpassword"));
    }

    @Test
    @Order(3)
    void testLoginSuccessful() throws Exception {
        register("charlie", "mypassword");
        assertTrue(authenticate("charlie", "mypassword"));
    }

    @Test
    @Order(4)
    void testLoginFailureIncorrectPassword() throws Exception {
        register("david", "password");
        assertFalse(authenticate("david", "wrongpassword"));
    }

    @Test
    @Order(5)
    void testLoginFailureNonExistentUser() throws Exception {
        assertFalse(authenticate("nonexistent", "password"));
    }

    @Test
    @Order(6)
    void testMultipleUsers() throws Exception {
        register("eve", "pass1");
        register("frank", "pass2");
        assertTrue(authenticate("eve", "pass1"));
        assertTrue(authenticate("frank", "pass2"));
    }

    @Test
    @Order(7)
    void testHashConsistency() throws Exception {
        String hash1 = hashPassword("password");
        String hash2 = hashPassword("password");
        assertEquals(hash1, hash2);
    }

    @Test
    @Order(8)
    void testLoginWithAlteredStoredPassword() throws Exception {
        register("grace", "password");
        replacePassword("grace", "wrongpass");
        assertFalse(authenticate("grace", "password"));
    }

    @Test
    @Order(9)
    void testRegisterLoginEmptyPassword() throws Exception {
        assertTrue(register("hank", ""));
        assertTrue(authenticate("hank", ""));
        assertFalse(authenticate("hank", "wrongpassword"));
    }

    @Test
    @Order(10)
    void testLongPassword() throws Exception {
        String longPassword = "a".repeat(1000);
        assertTrue(register("ida", longPassword));
        assertTrue(authenticate("ida", longPassword));
        assertFalse(authenticate("ida", "shortpassword"));
    }


    private boolean register(String username, String password) throws IOException {
        if (fileContainsUser(username)) return false;

        String hashedPassword = hashPassword(password);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USERS_FILE, true))) {
            writer.write(username + ":" + hashedPassword);
            writer.newLine();
        }
        return true;
    }

    private boolean authenticate(String username, String password) throws IOException {
        String hashedPassword = hashPassword(password);
        try (BufferedReader reader = new BufferedReader(new FileReader(USERS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2 && parts[0].equals(username) && parts[1].equals(hashedPassword)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean fileContainsUser(String username, String password) throws IOException {
        String hashed = hashPassword(password);
        return Files.lines(Path.of(USERS_FILE))
                .anyMatch(line -> line.equals(username + ":" + hashed));
    }

    private boolean fileContainsUser(String username) throws IOException {
        return Files.lines(Path.of(USERS_FILE))
                .anyMatch(line -> line.startsWith(username + ":"));
    }

    private void replacePassword(String username, String newPassword) throws IOException {
        StringBuilder newContent = new StringBuilder();
        for (String line : Files.readAllLines(Path.of(USERS_FILE))) {
            String[] parts = line.split(":");
            if (parts[0].equals(username)) {
                newContent.append(username).append(":").append(hashPassword(newPassword)).append("\n");
            } else {
                newContent.append(line).append("\n");
            }
        }
        Files.writeString(Path.of(USERS_FILE), newContent.toString());
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) sb.append(String.format("%02x", b));
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
