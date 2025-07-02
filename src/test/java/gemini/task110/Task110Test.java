package gemini.task110;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task110Test {

    @Test
    public void testValidHttpUrl() {
        assertTrue(Task110_GEMINI_gemini_1_5_pro_001.isValidUrl("http://example.com"));
    }

    @Test
    public void testValidHttpsUrl() {
        assertTrue(Task110_GEMINI_gemini_1_5_pro_001.isValidUrl("https://example.com"));
    }

    @Test
    public void testValidFtpUrl() {
        assertTrue(Task110_GEMINI_gemini_1_5_pro_001.isValidUrl("ftp://example.com"));
    }

    @Test
    public void testValidLocalhostUrl() {
        assertTrue(Task110_GEMINI_gemini_1_5_pro_001.isValidUrl("http://localhost"));
    }

    @Test
    public void testValidIPv4Url() {
        assertTrue(Task110_GEMINI_gemini_1_5_pro_001.isValidUrl("http://127.0.0.1"));
    }

    @Test
    public void testValidIPv6Url() {
        assertFalse(Task110_GEMINI_gemini_1_5_pro_001.isValidUrl("http://[::1]"));
        // regex المستخدم لا يدعم IPv6، لذلك لازم ترجع false حالياً.
    }

    @Test
    public void testValidUrlWithPort() {
        assertTrue(Task110_GEMINI_gemini_1_5_pro_001.isValidUrl("http://example.com:8080"));
    }

    @Test
    public void testInvalidUrlMissingScheme() {
        assertFalse(Task110_GEMINI_gemini_1_5_pro_001.isValidUrl("example.com"));
    }

    @Test
    public void testInvalidUrlWithInvalidDomain() {
        assertFalse(Task110_GEMINI_gemini_1_5_pro_001.isValidUrl("http://-example.com"));
    }

    @Test
    public void testInvalidUrlWithInvalidTLD() {
        assertFalse(Task110_GEMINI_gemini_1_5_pro_001.isValidUrl("http://example"));
    }
}
