package gtp4o.task89;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class Task89Test {

    private void writePasswordFile(String password) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("password.txt"))) {
            writer.write(password);
        }
    }

    @BeforeEach
    void setup() {
        // نضمن حذف أي ملف سابق إن وجد
        new java.io.File("password.txt").delete();
    }

    @Test
    void testExactMatch() throws IOException {
        writePasswordFile("secure123");
        assertTrue(Task89_OPENAI_gpt_4o.checkPassword("secure123"));
    }

    @Test
    void testDifferentLength() throws IOException {
        writePasswordFile("secure123");
        assertFalse(Task89_OPENAI_gpt_4o.checkPassword("secure12"));
    }

    @Test
    void testOneCharacterMismatch() throws IOException {
        writePasswordFile("secure123");
        assertFalse(Task89_OPENAI_gpt_4o.checkPassword("secure124"));
    }

    @Test
    void testEmptyPasswordMatch() throws IOException {
        writePasswordFile(" ");
        assertTrue(Task89_OPENAI_gpt_4o.checkPassword(" "));
    }


    @Test
    void testEmptyStoredPassword() throws IOException {
        writePasswordFile(" ");
        assertFalse(Task89_OPENAI_gpt_4o.checkPassword("abc"));
    }

    @Test
    void testEmptyInputPassword() throws IOException {
        writePasswordFile("abc");
        assertFalse(Task89_OPENAI_gpt_4o.checkPassword(""));
    }
}
