package codestral.task136;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class Task136Test {

    private Authentication auth;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        auth = new Authentication();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void testRegisterSuccess() {
        auth.register("user1", "password1");
        assertTrue(outContent.toString().contains("User registered successfully."));
    }

    @Test
    void testLoginSuccess() {
        auth.register("user2", "password2");
        outContent.reset();
        auth.login("user2", "password2");
        assertTrue(outContent.toString().contains("Login successful."));
    }

    @Test
    void testLoginWrongPassword() {
        auth.register("user3", "password3");
        outContent.reset();
        auth.login("user3", "wrongpassword");
        assertTrue(outContent.toString().contains("Invalid username or password."));
    }

    @Test
    void testLoginNonexistentUser() {
        auth.login("nonexistent", "somepassword");
        assertTrue(outContent.toString().contains("Invalid username or password."));
    }
}
