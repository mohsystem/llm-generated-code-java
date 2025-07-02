package codestral.task139;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.io.*;

class Task139Test {

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

    private double extractAreaFromOutput() {
        String output = outContent.toString().replace("\r", ""); // نحذف \r لأي نظام تشغيل
        int index = output.indexOf("The area of the circle is:");
        if (index != -1) {
            String part = output.substring(index + "The area of the circle is:".length()).trim();
            try {
                return Double.parseDouble(part);
            } catch (Exception e) {
                throw new AssertionError("Failed to parse area value from output: " + part);
            }
        } else {
            throw new AssertionError("Area not found in output. Full Output:\n" + output);
        }
    }


    private void runAppWithInput(String input) {
        provideInput(input + "\n");
        Task139_MISTRAL_codestral_latest.main(new String[]{});
    }

    @Test
    void testRadiusZero() {
        runAppWithInput("0");
        double result = extractAreaFromOutput();
        assertEquals(0.0, result, 1e-6);
    }

    @Test
    void testRadiusOne() {
        runAppWithInput("1");
        double result = extractAreaFromOutput();
        assertEquals(Math.PI, result, 1e-6);
    }

    @Test
    void testRadiusTwoPointFive() {
        runAppWithInput("2.5");
        double result = extractAreaFromOutput();
        assertEquals(Math.PI * 2.5 * 2.5, result, 1e-6);
    }

    @Test
    void testRadiusTen() {
        runAppWithInput("10");
        double result = extractAreaFromOutput();
        assertEquals(Math.PI * 10 * 10, result, 1e-6);
    }

    @Test
    void testRadiusNegative() {
        runAppWithInput("-5");
        double result = extractAreaFromOutput();
        assertEquals(Math.PI * 5 * 5, result, 1e-6);
    }

    @Test
    void testRadiusLarge() {
        runAppWithInput("1000");
        double result = extractAreaFromOutput();
        assertEquals(Math.PI * 1000 * 1000, result, 1e-6);
    }

    @Test
    void testRadiusPi() {
        runAppWithInput("3.1416");
        double result = extractAreaFromOutput();
        assertEquals(Math.PI * 3.1416 * 3.1416, result, 1e-6);
    }

    @Test
    void testRadiusSmall() {
        runAppWithInput("0.1");
        double result = extractAreaFromOutput();
        assertEquals(Math.PI * 0.1 * 0.1, result, 1e-6);
    }

    @Test
    void testRadiusLargeFloating() {
        runAppWithInput("1234.567");
        double result = extractAreaFromOutput();
        assertEquals(Math.PI * 1234.567 * 1234.567, result, 1e-6);
    }

    @Test
    void testRadiusDecimal() {
        runAppWithInput("9.99");
        double result = extractAreaFromOutput();
        assertEquals(Math.PI * 9.99 * 9.99, result, 1e-6);
    }
}
