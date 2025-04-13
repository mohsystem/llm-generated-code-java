package codestral.task44;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

public class Task44Test {

    private boolean invokeValidateInput(String input) throws Exception {
        Method method = Task44_MISTRAL_codestral_latest.class.getDeclaredMethod("validateInput", String.class);
        method.setAccessible(true);
        return (boolean) method.invoke(null, input);
    }

    private String capturePerformOperations(String input) throws Exception {
        Method method = Task44_MISTRAL_codestral_latest.class.getDeclaredMethod("performOperations", String.class);
        method.setAccessible(true);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(output));

        method.invoke(null, input);

        System.setOut(originalOut);
        return output.toString();
    }

    @Test
    void testValidInput() throws Exception {
        assertTrue(invokeValidateInput("Hello World"));
        assertTrue(invokeValidateInput("12345"));
        assertTrue(invokeValidateInput("A1 B2 C3"));
    }

    @Test
    void testInvalidInputSpecialCharacters() throws Exception {
        assertFalse(invokeValidateInput("Hello@World"));
        assertFalse(invokeValidateInput("12345!"));
        assertFalse(invokeValidateInput("A1 B2 C3?"));
    }

    @Test
    void testEmptyInput() throws Exception {
        assertTrue(invokeValidateInput(""));
        assertEquals("Performing operations on: \n", capturePerformOperations(""));
    }

    @Test
    void testInputWithLeadingAndTrailingSpaces() throws Exception {
        String input = "  Hello World  ";
        assertTrue(invokeValidateInput(input));
        assertEquals("Performing operations on:   Hello World  \n", capturePerformOperations(input));
    }

    @Test
    void testNumericInput() throws Exception {
        String input = "12345";
        assertTrue(invokeValidateInput(input));
        assertEquals("Performing operations on: 12345\n", capturePerformOperations(input));
    }

    @Test
    void testMixedInput() throws Exception {
        String input = "abc 123";
        assertTrue(invokeValidateInput(input));
        assertEquals("Performing operations on: abc 123\n", capturePerformOperations(input));
    }

    @Test
    void testInvalidInputWithNewlines() throws Exception {
        assertFalse(invokeValidateInput("Hello\nWorld"));
        assertFalse(invokeValidateInput("123\n456"));
    }

    @Test
    void testInputWithTabs() throws Exception {
        assertFalse(invokeValidateInput("Hello\tWorld"));
        assertFalse(invokeValidateInput("123\t456"));
    }

    @Test
    void testAllValidCharacters() throws Exception {
        String input = "Valid input 123";
        assertTrue(invokeValidateInput(input));
        assertEquals("Performing operations on: Valid input 123\n", capturePerformOperations(input));
    }

    @Test
    void testLongInput() throws Exception {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            sb.append("a");
        }
        String input = sb.toString();
        assertTrue(invokeValidateInput(input));
        assertEquals("Performing operations on: " + input + "\n", capturePerformOperations(input));
    }
}
