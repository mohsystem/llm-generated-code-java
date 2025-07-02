package claude.task140;

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
        Task140_CLAUDE_claude_3_5_sonnet_20240620.main(new String[]{});
    }

    @Test
    void testAddition() {
        provideInput("3\n5\n+\n");
        runMain();
        assertTrue(getOutput().contains("Result: 8.0"));
    }

    @Test
    void testSubtraction() {
        provideInput("10\n4\n-\n");
        runMain();
        assertTrue(getOutput().contains("Result: 6.0"));
    }

    @Test
    void testMultiplication() {
        provideInput("7\n6\n*\n");
        runMain();
        assertTrue(getOutput().contains("Result: 42.0"));
    }

    @Test
    void testDivision() {
        provideInput("9\n3\n/\n");
        runMain();
        assertTrue(getOutput().contains("Result: 3.0"));
    }

    @Test
    void testDivisionByZero() {
        provideInput("5\n0\n/\n");
        runMain();
        assertTrue(getOutput().contains("Error: Division by zero"));
    }

    @Test
    void testInvalidOperator() {
        provideInput("5\n3\n^\n");
        runMain();
        assertTrue(getOutput().contains("Error: Invalid operator"));
    }

    @Test
    void testNegativeNumbersAddition() {
        provideInput("-3\n-7\n+\n");
        runMain();
        assertTrue(getOutput().contains("Result: -10.0"));
    }

    @Test
    void testNegativeNumbersSubtraction() {
        provideInput("-10\n-5\n-\n");
        runMain();
        assertTrue(getOutput().contains("Result: -5.0"));
    }

    @Test
    void testNegativeNumbersMultiplication() {
        provideInput("-4\n5\n*\n");
        runMain();
        assertTrue(getOutput().contains("Result: -20.0"));
    }

    @Test
    void testNegativeNumbersDivision() {
        provideInput("-10\n2\n/\n");
        runMain();
        assertTrue(getOutput().contains("Result: -5.0"));
    }

    @Test
    void testFloatNumbersAddition() {
        provideInput("5.5\n2.2\n+\n");
        runMain();
        assertTrue(getOutput().contains("Result: 7.7"));
    }

    @Test
    void testFloatNumbersMultiplication() {
        provideInput("5.5\n2.2\n*\n");
        runMain();
         assertTrue(getOutput().contains("12.1"));
    }
}
