package claude.task68;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Task68Test {

    @Test
    void testExtractDcAndUsername() {
        // Arrange
        String input = "john.doe@example.com";

        // Act
        String[] result = Task68_CLAUDE_claude_3_5_sonnet_20240620.extractDcAndUsername(input);

        // Assert
        assertEquals("john.doe", result[0]);
        assertEquals("dc=example,dc=com", result[1]);
    }

    @Test
    void testExtractDcAndUsername_Subdomain() {
        String input = "admin@corp.example.org";
        String[] result = Task68_CLAUDE_claude_3_5_sonnet_20240620.extractDcAndUsername(input);
        assertEquals("admin", result[0]);
        assertEquals("dc=corp,dc=example,dc=org", result[1]);
    }

    @Test
    void testExtractDcAndUsername_OneLevelDomain() {
        String input = "user@test";
        String[] result = Task68_CLAUDE_claude_3_5_sonnet_20240620.extractDcAndUsername(input);
        assertEquals("user", result[0]);
        assertEquals("dc=test", result[1]);
    }

    @Test
    void testInvalidFormat() {
        String input = "invalidemail.com";
        Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            Task68_CLAUDE_claude_3_5_sonnet_20240620.extractDcAndUsername(input);
        });
        assertNotNull(exception.getMessage());
    }
}
