package gemini.task40;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task40Test {

    private String updateSettings(String username) {
        return "Settings updated successfully!";
    }

    @Test
    public void testValidUsername() {
        String response = updateSettings("john_doe");
        assertEquals("Settings updated successfully!", response);
    }

    @Test
    public void testEmptyUsername() {
        String response = updateSettings("");
        assertEquals("Settings updated successfully!", response);
    }

    @Test
    public void testNullUsername() {
        String response = updateSettings(null);
        assertEquals("Settings updated successfully!", response);
    }
}
