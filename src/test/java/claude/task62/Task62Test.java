package claude.task62;

import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Task62Test {

    @Test
    public void testValidJson() {
        String jsonStr = "{\"name\": \"John\", \"age\": 30, \"city\": \"New York\"}";
        JSONObject expected = new JSONObject(jsonStr);
        JSONObject actual = Task62_CLAUDE_claude_3_5_sonnet_20240620.parseJsonAndGetRoot(jsonStr);
        assertEquals(expected.toString(), actual != null ? actual.toString() : null);
    }

    @Test
    public void testEmptyJson() {
        String jsonStr = "{}";
        JSONObject expected = new JSONObject(jsonStr);
        JSONObject actual = Task62_CLAUDE_claude_3_5_sonnet_20240620.parseJsonAndGetRoot(jsonStr);
        assertEquals(expected.toString(), actual != null ? actual.toString() : null);
    }

    @Test
    public void testJsonWithArray() {
        String jsonStr = "[1, 2, 3, 4]";
        Object result = Task62_CLAUDE_claude_3_5_sonnet_20240620.parseJsonAndGetRoot(jsonStr);
        assertNull(result);
    }

    @Test
    public void testJsonWithNestedObjects() {
        String jsonStr = "{\"person\": {\"name\": \"Alice\", \"age\": 25}, \"city\": \"Wonderland\"}";
        JSONObject expected = new JSONObject(jsonStr);
        JSONObject actual = Task62_CLAUDE_claude_3_5_sonnet_20240620.parseJsonAndGetRoot(jsonStr);
        assertEquals(expected.toString(), actual != null ? actual.toString() : null);
    }

    @Test
    public void testJsonWithBooleanValues() {
        String jsonStr = "{\"active\": true, \"verified\": false}";
        JSONObject expected = new JSONObject(jsonStr);
        JSONObject actual = Task62_CLAUDE_claude_3_5_sonnet_20240620.parseJsonAndGetRoot(jsonStr);
        assertEquals(expected.toString(), actual != null ? actual.toString() : null);
    }

    @Test
    public void testJsonWithNullValue() {
        String jsonStr = "{\"value\": null}";
        JSONObject expected = new JSONObject(jsonStr);
        JSONObject actual = Task62_CLAUDE_claude_3_5_sonnet_20240620.parseJsonAndGetRoot(jsonStr);
        assertEquals(expected.toString(), actual != null ? actual.toString() : null);
    }

    @Test
    public void testMalformedJsonMissingBracket() {
        String jsonStr = "{\"name\": \"John\", \"age\": 30, \"city\": \"New York\"";
        assertNull(Task62_CLAUDE_claude_3_5_sonnet_20240620.parseJsonAndGetRoot(jsonStr));
    }

    @Test
    public void testMalformedJsonUnexpectedComma() {
        String jsonStr = "{\"name\": \"John\", \"age\": 30,}";
        assertNull(Task62_CLAUDE_claude_3_5_sonnet_20240620.parseJsonAndGetRoot(jsonStr));
    }

    @Test
    public void testMalformedJsonUnquotedKey() {
        String jsonStr = "{name: \"John\", \"age\": 30}";
        assertNull(Task62_CLAUDE_claude_3_5_sonnet_20240620.parseJsonAndGetRoot(jsonStr));
    }

    @Test
    public void testInvalidJsonType() {
        String jsonStr = "Just a string, not JSON";
        assertNull(Task62_CLAUDE_claude_3_5_sonnet_20240620.parseJsonAndGetRoot(jsonStr));
    }
}
