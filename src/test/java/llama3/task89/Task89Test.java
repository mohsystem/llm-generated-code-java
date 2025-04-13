package llama3.task89;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class Task89Test {

    private void writePasswordFile(String password) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("password.txt"))) {
            writer.write(password);
        }
    }

    private boolean passwordsMatch(String stored, String input) {
        if (stored.length() != input.length()) return false;
        for (int i = 0; i < stored.length(); i++) {
            if (stored.charAt(i) != input.charAt(i)) return false;
        }
        return true;
    }

    @BeforeEach
    void cleanFile() {
        new java.io.File("password.txt").delete();
    }

    @Test
    void testExactMatch() throws IOException {
        writePasswordFile("secret123");
        assertTrue(passwordsMatch("secret123", "secret123"));
    }

    @Test
    void testDifferentLength() throws IOException {
        writePasswordFile("secret123");
        assertFalse(passwordsMatch("secret123", "secret12"));
    }

    @Test
    void testMismatchCharacter() throws IOException {
        writePasswordFile("secret123");
        assertFalse(passwordsMatch("secret123", "secret124"));
    }

    @Test
    void testEmptyPasswordMatch() throws IOException {
        writePasswordFile("");
        assertThrows(Exception.class, () -> {
            try (Scanner scanner = new Scanner(new java.io.File("password.txt"))) {
                scanner.next();
            }
        });
    }

    @Test
    void testSingleSpaceMismatch() throws IOException {
        writePasswordFile(" ");
        assertFalse(passwordsMatch(" ", "abc"));
    }
}
