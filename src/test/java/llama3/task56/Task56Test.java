package llama3.task56;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task56Test {

    @Test
    public void testTokenLengthIs32() {
        String token = Task56_PERPLEXITY_llama_3_sonar_large_32k_chat.generateToken("admin", "pass");
        assertEquals(32, token.length(), "Token must be exactly 32 characters long like the Python version");
    }

    @Test
    public void testTokenIsAlphanumericOnly() {
        String token = Task56_PERPLEXITY_llama_3_sonar_large_32k_chat.generateToken("admin", "pass");
        assertTrue(token.matches("^[a-zA-Z0-9]+$"), "Token must contain only alphanumeric characters a-zA-Z0-9");
    }

    @Test
    public void testTokenIsDifferentEachTime() throws InterruptedException {
        String token1 = Task56_PERPLEXITY_llama_3_sonar_large_32k_chat.generateToken("admin", "pass");
        Thread.sleep(1);
        String token2 = Task56_PERPLEXITY_llama_3_sonar_large_32k_chat.generateToken("admin", "pass");
        assertNotEquals(token1, token2, "Tokens should be different on each call due to randomness");
    }
}
