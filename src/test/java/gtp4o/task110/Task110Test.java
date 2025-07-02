package gtp4o.task110;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task110Test {

    @Test
    public void testValidHttpUrl() {
        assertTrue(Task110_OPENAI_gpt_4o.validateURL("http://example.com"));
    }

    @Test
    public void testValidHttpsUrl() {
        assertTrue(Task110_OPENAI_gpt_4o.validateURL("https://example.com"));
    }

    @Test
    public void testValidFtpUrl() {
        assertTrue(Task110_OPENAI_gpt_4o.validateURL("ftp://example.com"));
    }

    @Test
    public void testValidLocalhostUrl() {
        assertTrue(Task110_OPENAI_gpt_4o.validateURL("http://localhost"));
    }

    @Test
    public void testValidIPv4Url() {
        assertTrue(Task110_OPENAI_gpt_4o.validateURL("http://127.0.0.1"));
    }

    @Test
    public void testValidIPv6Url() {
        assertTrue(Task110_OPENAI_gpt_4o.validateURL("http://[::1]"));
    }

    @Test
    public void testValidUrlWithPort() {
        assertTrue(Task110_OPENAI_gpt_4o.validateURL("http://example.com:8080"));
    }

    @Test
    public void testInvalidUrlMissingScheme() {
        assertFalse(Task110_OPENAI_gpt_4o.validateURL("example.com"));
    }

    @Test
    public void testInvalidUrlWithInvalidDomain() {
        assertFalse(Task110_OPENAI_gpt_4o.validateURL("http://-example.com"));
    }

    @Test
    public void testInvalidUrlWithInvalidTLD() {
        assertFalse(Task110_OPENAI_gpt_4o.validateURL("http://example"));
    }
}
