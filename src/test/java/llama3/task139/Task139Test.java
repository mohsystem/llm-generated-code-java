package llama3.task139;

import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

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

    private void runMain() {
        Task139_PERPLEXITY_llama_3_sonar_large_32k_chat.main(new String[]{});
    }

    private double extractAreaFromOutput() {
        String output = outContent.toString();
        int index = output.indexOf("The area of the circle is:");
        if (index == -1) {
            throw new AssertionError("Area not found in output. Full Output:\n" + output);
        }
        String after = output.substring(index + "The area of the circle is:".length()).trim();
        return Double.parseDouble(after);
    }

    @Test
    void testRadiusZero() {
        provideInput("0\n");
        runMain();
        double area = extractAreaFromOutput();
        assertEquals(0.0, area, 1e-9);
    }

    @Test
    void testRadiusOne() {
        provideInput("1\n");
        runMain();
        double area = extractAreaFromOutput();
        assertEquals(Math.PI, area, 1e-9);
    }

    @Test
    void testRadiusTwoPointFive() {
        provideInput("2.5\n");
        runMain();
        double area = extractAreaFromOutput();
        assertEquals(Math.PI * 2.5 * 2.5, area, 1e-9);
    }

    @Test
    void testRadiusTen() {
        provideInput("10\n");
        runMain();
        double area = extractAreaFromOutput();
        assertEquals(Math.PI * 100, area, 1e-9);
    }

    @Test
    void testRadiusNegative() {
        provideInput("-5\n");
        runMain();
        double area = extractAreaFromOutput();
        assertEquals(Math.PI * 25, area, 1e-9);
    }

    @Test
    void testRadiusLarge() {
        provideInput("1000\n");
        runMain();
        double area = extractAreaFromOutput();
        assertEquals(Math.PI * 1000000, area, 1e-6);
    }

    @Test
    void testRadiusSmall() {
        provideInput("0.1\n");
        runMain();
        double area = extractAreaFromOutput();
        assertEquals(Math.PI * 0.01, area, 1e-9);
    }

    @Test
    void testRadiusPi() {
        provideInput(Math.PI + "\n");
        runMain();
        double area = extractAreaFromOutput();
        assertEquals(Math.PI * Math.PI * Math.PI, area, 1e-9);
    }

    @Test
    void testRadiusLargeFloating() {
        provideInput("1234.5678\n");
        runMain();
        double area = extractAreaFromOutput();
        assertEquals(Math.PI * Math.pow(1234.5678, 2), area, 1e-6);
    }

    @Test
    void testRadiusDecimal() {
        provideInput("10.0\n");
        runMain();
        double area = extractAreaFromOutput();
        assertEquals(Math.PI * 100, area, 1e-9);
    }
}
