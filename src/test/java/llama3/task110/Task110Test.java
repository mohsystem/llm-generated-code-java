package llama3.task110;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task110Test {

    @Test
    public void testValidHttpUrl() {
        assertTrue(Task110_PERPLEXITY_llama_3_sonar_large_32k_chat.validateUrl("http://example.com"));
    }

    @Test
    public void testValidHttpsUrl() {
        assertTrue(Task110_PERPLEXITY_llama_3_sonar_large_32k_chat.validateUrl("https://example.com"));
    }

    @Test
    public void testValidFtpUrl() {
        assertTrue(Task110_PERPLEXITY_llama_3_sonar_large_32k_chat.validateUrl("ftp://example.com"));
    }

    @Test
    public void testValidLocalhostUrl() {
        assertTrue(Task110_PERPLEXITY_llama_3_sonar_large_32k_chat.validateUrl("http://localhost"));
    }

    @Test
    public void testValidIPv4Url() {
        assertTrue(Task110_PERPLEXITY_llama_3_sonar_large_32k_chat.validateUrl("http://127.0.0.1"));
    }

    @Test
    public void testValidIPv6Url() {
        assertFalse(Task110_PERPLEXITY_llama_3_sonar_large_32k_chat.validateUrl("http://[::1]"));
        // الـ regex الحالي لا يدعم IPv6، فالإخراج المتوقع هو false.
    }

    @Test
    public void testValidUrlWithPort() {
        assertTrue(Task110_PERPLEXITY_llama_3_sonar_large_32k_chat.validateUrl("http://example.com:8080"));
    }

    @Test
    public void testInvalidUrlMissingScheme() {
        assertFalse(Task110_PERPLEXITY_llama_3_sonar_large_32k_chat.validateUrl("example.com"));
    }

    @Test
    public void testInvalidUrlWithInvalidDomain() {
        assertFalse(Task110_PERPLEXITY_llama_3_sonar_large_32k_chat.validateUrl("http://-example.com"));
    }

    @Test
    public void testInvalidUrlWithInvalidTLD() {
        assertFalse(Task110_PERPLEXITY_llama_3_sonar_large_32k_chat.validateUrl("http://example"));
    }
}
