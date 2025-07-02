package gemini.task140;

import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class Task140Test {

    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUpStreams() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    private void provideInput(String data) {
        System.setIn(new ByteArrayInputStream(data.getBytes()));
    }

    private String getOutput() {
        return outContent.toString().trim();
    }

    private void runMain() {
        Task140_GEMINI_gemini_1_5_pro_001.main(new String[]{});
    }

    @Test
    void testAddition() {
        provideInput("3\n+\n5\n");
        runMain();
        assertTrue(getOutput().contains("8.0"));
    }

    @Test
    void testSubtraction() {
        provideInput("10\n-\n4\n");
        runMain();
        assertTrue(getOutput().contains("6.0"));
    }

    @Test
    void testMultiplication() {
        provideInput("7\n*\n6\n");
        runMain();
        assertTrue(getOutput().contains("42.0"));
    }

    @Test
    void testDivision() {
        provideInput("9\n/\n3\n");
        runMain();
        assertTrue(getOutput().contains("3.0"));
    }

    @Test
    void testDivisionByZero() {
        provideInput("5\n/\n0\n");
        runMain();
        assertTrue(getOutput().contains("Division by zero error!"));
    }

    @Test
    void testInvalidOperator() {
        provideInput("5\n^\n3\n");
        runMain();
        assertTrue(getOutput().contains("Invalid operator!"));
    }

    @Test
    void testNegativeNumbersAddition() {
        provideInput("-3\n+\n-7\n");
        runMain();
        assertTrue(getOutput().contains("-10.0"));
    }

    @Test
    void testNegativeNumbersSubtraction() {
        provideInput("-10\n-\n-5\n");
        runMain();
        assertTrue(getOutput().contains("-5.0"));
    }

    @Test
    void testNegativeNumbersMultiplication() {
        provideInput("-4\n*\n5\n");
        runMain();
        assertTrue(getOutput().contains("-20.0"));
    }

    @Test
    void testNegativeNumbersDivision() {
        provideInput("-10\n/\n2\n");
        runMain();
        assertTrue(getOutput().contains("-5.0"));
    }

    @Test
    void testFloatNumbersAddition() {
        provideInput("5.5\n+\n2.2\n");
        runMain();
        assertTrue(getOutput().contains("7.7"));
    }

    @Test
    void testFloatNumbersMultiplication() {
        provideInput("5.5\n*\n2.2\n");
        runMain();
        assertTrue(getOutput().contains("12.1"));
    }
}
