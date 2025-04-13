package gemini.task89;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

public class Task89Test {

    private void provideInput(String data) {
        System.setIn(new ByteArrayInputStream(data.getBytes()));
    }

    @Test
    void testExactMatch() {
        provideInput("secret123\n");
        assertTrue(Task89_GEMINI_gemini_1_5_pro_001.checkPassword("secret123"));
    }

    @Test
    void testMismatchLength() {
        provideInput("secret12\n");
        assertFalse(Task89_GEMINI_gemini_1_5_pro_001.checkPassword("secret123"));
    }

    @Test
    void testOneCharDifferent() {
        provideInput("secret124\n");
        assertFalse(Task89_GEMINI_gemini_1_5_pro_001.checkPassword("secret123"));
    }

    @Test
    void testEmptyInputVsEmptyStored() {
        provideInput("\n");
        assertTrue(Task89_GEMINI_gemini_1_5_pro_001.checkPassword(""));
    }

    @Test
    void testEmptyStoredNonEmptyInput() {
        provideInput("abc\n");
        assertFalse(Task89_GEMINI_gemini_1_5_pro_001.checkPassword(""));
    }

    @Test
    void testEmptyInputNonEmptyStored() {
        provideInput("\n");
        assertFalse(Task89_GEMINI_gemini_1_5_pro_001.checkPassword("abc"));
    }
}
