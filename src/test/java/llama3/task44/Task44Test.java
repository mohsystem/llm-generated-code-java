package llama3.task44;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

public class Task44Test {

    private String invokeValidateInput(String input) {
        try {
            Method method = Task44_PERPLEXITY_llama_3_sonar_large_32k_chat.class
                    .getDeclaredMethod("validateInput", String.class);
            method.setAccessible(true);
            method.invoke(null, input);
            return "VALID";
        } catch (Exception e) {
            return e.getCause().getMessage(); // Get the actual exception message thrown inside the method
        }
    }

    @Test
    void testValidInputLettersOnly() {
        assertEquals("VALID", invokeValidateInput("Hello"));
        assertEquals("VALID", invokeValidateInput("World"));
        assertEquals("VALID", invokeValidateInput("AbcXYZ"));
    }

    @Test
    void testInvalidInputWithSpaces() {
        assertEquals("Input should only contain alphabets", invokeValidateInput("Hello World"));
        assertEquals("Input should only contain alphabets", invokeValidateInput("A B C"));
    }

    @Test
    void testInvalidInputWithNumbers() {
        assertEquals("Input should only contain alphabets", invokeValidateInput("123"));
        assertEquals("Input should only contain alphabets", invokeValidateInput("abc123"));
        assertEquals("Input should only contain alphabets", invokeValidateInput("1A2B3C"));
    }

    @Test
    void testInvalidInputWithSymbols() {
        assertEquals("Input should only contain alphabets", invokeValidateInput("Hello@World"));
        assertEquals("Input should only contain alphabets", invokeValidateInput("Test!"));
        assertEquals("Input should only contain alphabets", invokeValidateInput("Nice#Job"));
    }

    @Test
    void testEmptyInput() {
        assertEquals("Input should only contain alphabets", invokeValidateInput(""));
    }

    @Test
    void testValidInputAllUppercase() {
        assertEquals("VALID", invokeValidateInput("HELLO"));
    }

    @Test
    void testValidInputAllLowercase() {
        assertEquals("VALID", invokeValidateInput("hello"));
    }

    @Test
    void testInputWithNewlinesOrTabs() {
        assertEquals("Input should only contain alphabets", invokeValidateInput("hello\nworld"));
        assertEquals("Input should only contain alphabets", invokeValidateInput("hello\tworld"));
    }

    @Test
    void testLongValidInput() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000; i++) sb.append("a");
        assertEquals("VALID", invokeValidateInput(sb.toString()));
    }
}
