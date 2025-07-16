package gtp4o.task135;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Task135Test {

    @Test
    public void testGenerateTokenNotNull() {
        Task135_OPENAI_gpt_4o csrf = new Task135_OPENAI_gpt_4o();
        String sessionId = "SESSION123";
        String token = csrf.generateToken(sessionId);

        assertNotNull(token, "Token should not be null");
        assertTrue(token.endsWith(sessionId), "Token should end with sessionId");
    }

    @Test
    public void testTokenIsDifferentEachTime() {
        Task135_OPENAI_gpt_4o csrf = new Task135_OPENAI_gpt_4o();
        String sessionId = "SESSION456";
        String token1 = csrf.generateToken(sessionId);
        String token2 = csrf.generateToken(sessionId);

        assertNotEquals(token1, token2, "Each token generation should return a new value");
    }

    @Test
    public void testValidateTokenSuccess() {
        Task135_OPENAI_gpt_4o csrf = new Task135_OPENAI_gpt_4o();
        String sessionId = "SESSION789";
        String token = csrf.generateToken(sessionId);

        assertTrue(csrf.validateToken(token, sessionId), "Validation should succeed with correct token and sessionId");
    }

    @Test
    public void testValidateTokenFailsIfTokenModified() {
        Task135_OPENAI_gpt_4o csrf = new Task135_OPENAI_gpt_4o();
        String sessionId = "SESSIONABC";
        String token = csrf.generateToken(sessionId);

        String modifiedToken = token + "XYZ";

        assertFalse(csrf.validateToken(modifiedToken, sessionId), "Validation should fail with modified token");
    }

    @Test
    public void testValidateTokenFailsIfSessionIdModified() {
        Task135_OPENAI_gpt_4o csrf = new Task135_OPENAI_gpt_4o();
        String sessionId = "SESSIONXYZ";
        String token = csrf.generateToken(sessionId);

        String wrongSessionId = "SESSIONZZZ";

        assertFalse(csrf.validateToken(token, wrongSessionId), "Validation should fail with wrong sessionId");
    }
}
