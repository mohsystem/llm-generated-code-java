package claude.task118;

import org.junit.jupiter.api.*;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class Task118Test {

    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUpStreams() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    private String getPrintedOutput() {
        return outContent.toString().trim();
    }

    @Test
    void testValidClassAIP() {
        Task118_CLAUDE_claude_3_5_sonnet_20240620.processIP("10.0.0.1");
        assertEquals("Valid IP address. Class: A", getPrintedOutput());
    }

    @Test
    void testValidClassBIP() {
        Task118_CLAUDE_claude_3_5_sonnet_20240620.processIP("172.16.0.1");
        assertEquals("Valid IP address. Class: B", getPrintedOutput());
    }

    @Test
    void testValidClassCIP() {
        Task118_CLAUDE_claude_3_5_sonnet_20240620.processIP("192.168.0.1");
        assertEquals("Valid IP address. Class: C", getPrintedOutput());
    }

    @Test
    void testValidClassDIP() {
        Task118_CLAUDE_claude_3_5_sonnet_20240620.processIP("224.0.0.1");
        assertEquals("Valid IP address. Class: D", getPrintedOutput());
    }

    @Test
    void testValidClassEIP() {
        Task118_CLAUDE_claude_3_5_sonnet_20240620.processIP("240.0.0.1");
        assertEquals("Valid IP address. Class: E", getPrintedOutput());
    }

    @Test
    void testInvalidIPNonNumericOctets() {
        Task118_CLAUDE_claude_3_5_sonnet_20240620.processIP("192.abc.0.1");
        assertEquals("Invalid IP address", getPrintedOutput());
    }

    @Test
    void testInvalidIPOutOfRangeOctets() {
        Task118_CLAUDE_claude_3_5_sonnet_20240620.processIP("256.0.0.1");
        assertEquals("Invalid IP address", getPrintedOutput());
    }

    @Test
    void testInvalidIPEmptyOctets() {
        Task118_CLAUDE_claude_3_5_sonnet_20240620.processIP("192.168..1");
        assertEquals("Invalid IP address", getPrintedOutput());
    }

    @Test
    void testInvalidIPMissingOctets() {
        Task118_CLAUDE_claude_3_5_sonnet_20240620.processIP("192.168.0");
        assertEquals("Invalid IP address", getPrintedOutput());
    }

    @Test
    void testInvalidIPExtraOctets() {
        Task118_CLAUDE_claude_3_5_sonnet_20240620.processIP("192.168.0.1.1");
        assertEquals("Invalid IP address", getPrintedOutput());
    }
}
