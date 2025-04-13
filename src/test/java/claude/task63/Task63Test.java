package claude.task63;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.Base64;

import static org.junit.jupiter.api.Assertions.*;

public class Task63Test {

    @Test
    public void testValidJson() {
        String rawData = "eyJuYW1lIjogIkpvaG4gRG9lIiwgImFnZSI6IDMwfQ==";
        JSONObject result = Task63_CLAUDE_claude_3_5_sonnet_20240620.processRequest(rawData);
        assertEquals("John Doe", result.getString("name"));
        assertEquals(30, result.getInt("age"));
    }

    @Test
    public void testEmptyInput() {
        String rawData = "";
        assertNull(Task63_CLAUDE_claude_3_5_sonnet_20240620.processRequest(rawData));
    }

    @Test
    public void testInvalidBase64() {
        String rawData = "invalid_base64_string";
        assertNull(Task63_CLAUDE_claude_3_5_sonnet_20240620.processRequest(rawData));
    }

    @Test
    public void testMalformedJson() {
        String malformedJson = "name\": \"John}";
        String rawData = Base64.getEncoder().encodeToString(malformedJson.getBytes());
        assertNull(Task63_CLAUDE_claude_3_5_sonnet_20240620.processRequest(rawData));
    }

    @Test
    public void testBase64OfEmptyJson() {
        String rawData = Base64.getEncoder().encodeToString("{}".getBytes());
        JSONObject result = Task63_CLAUDE_claude_3_5_sonnet_20240620.processRequest(rawData);
        assertEquals(0, result.length());
    }

    @Test
    public void testJsonWithSpecialCharacters() {
        String original = "{\"key\": \"value_with_special_characters_!@#$%^&*()\"}";
        String rawData = Base64.getEncoder().encodeToString(original.getBytes());
        JSONObject result = Task63_CLAUDE_claude_3_5_sonnet_20240620.processRequest(rawData);
        assertEquals("value_with_special_characters_!@#$%^&*()", result.getString("key"));
    }

    @Test
    public void testJsonWithNumericValues() {
        String original = "{\"value\": 1234}";
        String rawData = Base64.getEncoder().encodeToString(original.getBytes());
        JSONObject result = Task63_CLAUDE_claude_3_5_sonnet_20240620.processRequest(rawData);
        assertEquals(1234, result.getInt("value"));
    }

    @Test
    public void testJsonWithBooleanValues() {
        String original = "{\"active\": true, \"verified\": false}";
        String rawData = Base64.getEncoder().encodeToString(original.getBytes());
        JSONObject result = Task63_CLAUDE_claude_3_5_sonnet_20240620.processRequest(rawData);
        assertTrue(result.getBoolean("active"));
        assertFalse(result.getBoolean("verified"));
    }

    @Test
    public void testJsonWithNullValue() {
        String original = "{\"value\": null}";
        String rawData = Base64.getEncoder().encodeToString(original.getBytes());
        JSONObject result = Task63_CLAUDE_claude_3_5_sonnet_20240620.processRequest(rawData);
        assertTrue(result.has("value"));
        assertTrue(result.isNull("value"));
    }

    @Test
    public void testNestedJson() {
        String original = "{\"outer\": {\"inner\": \"value\"}}";
        String rawData = Base64.getEncoder().encodeToString(original.getBytes());
        JSONObject result = Task63_CLAUDE_claude_3_5_sonnet_20240620.processRequest(rawData);
        JSONObject inner = result.getJSONObject("outer");
        assertEquals("value", inner.getString("inner"));
    }
}
