package gtp4o.task62;

import org.json.JSONObject;
import org.json.JSONException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Task62Test {

    @Test
    public void testValidJson() {
        String jsonStr = "{\"name\": \"John\", \"age\": 30, \"city\": \"New York\"}";
        JSONObject obj = new JSONObject(jsonStr);
        assertEquals("John", obj.getString("name"));
        assertEquals(30, obj.getInt("age"));
        assertEquals("New York", obj.getString("city"));
    }

    @Test
    public void testEmptyJson() {
        String jsonStr = "{}";
        JSONObject obj = new JSONObject(jsonStr);
        assertEquals(0, obj.length());
    }

    @Test
    public void testJsonWithArray_ShouldThrow() {
        String jsonStr = "[1, 2, 3, 4]";
        assertThrows(JSONException.class, () -> new JSONObject(jsonStr));
    }

    @Test
    public void testJsonWithNestedObjects() {
        String jsonStr = "{\"person\": {\"name\": \"Alice\", \"age\": 25}, \"city\": \"Wonderland\"}";
        JSONObject obj = new JSONObject(jsonStr);
        JSONObject person = obj.getJSONObject("person");
        assertEquals("Alice", person.getString("name"));
        assertEquals(25, person.getInt("age"));
        assertEquals("Wonderland", obj.getString("city"));
    }

    @Test
    public void testJsonWithBooleanValues() {
        String jsonStr = "{\"active\": true, \"verified\": false}";
        JSONObject obj = new JSONObject(jsonStr);
        assertTrue(obj.getBoolean("active"));
        assertFalse(obj.getBoolean("verified"));
    }

    @Test
    public void testJsonWithNullValue() {
        String jsonStr = "{\"value\": null}";
        JSONObject obj = new JSONObject(jsonStr);
        assertTrue(obj.has("value"));
        assertTrue(obj.isNull("value"));
    }

    @Test
    public void testMalformedJsonMissingBracket() {
        String jsonStr = "{\"name\": \"John\", \"age\": 30, \"city\": \"New York\"";
        assertThrows(JSONException.class, () -> new JSONObject(jsonStr));
    }

    @Test
    public void testMalformedJsonUnexpectedComma() {
        String jsonStr = "{\"name\": \"John\", \"age\": 30,}";
        assertThrows(JSONException.class, () -> new JSONObject(jsonStr));
    }

    @Test
    public void testMalformedJsonUnquotedKey() {
        String jsonStr = "{name: \"John\", \"age\": 30}";
        assertThrows(JSONException.class, () -> new JSONObject(jsonStr));
    }

    @Test
    public void testInvalidJsonType_ShouldThrow() {
        String jsonStr = "Just a string, not JSON";
        assertThrows(JSONException.class, () -> new JSONObject(jsonStr));
    }
}
