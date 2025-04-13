package gemini.task62;

import org.json.JSONObject;
import org.json.JSONArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Task62Test {

    @Test
    public void testValidJson() {
        String jsonStr = "{\"name\": \"John\", \"age\": 30, \"city\": \"New York\"}";
        JSONObject expected = new JSONObject(jsonStr);
        Object actual = Task62_GEMINI_gemini_1_5_pro_001.getRootElement(jsonStr);
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void testEmptyJson() {
        String jsonStr = "{}";
        JSONObject expected = new JSONObject(jsonStr);
        Object actual = Task62_GEMINI_gemini_1_5_pro_001.getRootElement(jsonStr);
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void testJsonWithArray() {
        String jsonStr = "[1, 2, 3, 4]";
        JSONArray expected = new JSONArray(jsonStr);
        Object actual = Task62_GEMINI_gemini_1_5_pro_001.getRootElement(jsonStr);
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void testJsonWithNestedObjects() {
        String jsonStr = "{\"person\": {\"name\": \"Alice\", \"age\": 25}, \"city\": \"Wonderland\"}";
        JSONObject expected = new JSONObject(jsonStr);
        Object actual = Task62_GEMINI_gemini_1_5_pro_001.getRootElement(jsonStr);
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void testJsonWithBooleanValues() {
        String jsonStr = "{\"active\": true, \"verified\": false}";
        JSONObject expected = new JSONObject(jsonStr);
        Object actual = Task62_GEMINI_gemini_1_5_pro_001.getRootElement(jsonStr);
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void testJsonWithNullValue() {
        String jsonStr = "{\"value\": null}";
        JSONObject expected = new JSONObject(jsonStr);
        Object actual = Task62_GEMINI_gemini_1_5_pro_001.getRootElement(jsonStr);
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void testMalformedJsonMissingBracket() {
        String jsonStr = "{\"name\": \"John\", \"age\": 30, \"city\": \"New York\"";
        assertNull(Task62_GEMINI_gemini_1_5_pro_001.getRootElement(jsonStr));
    }

    @Test
    public void testMalformedJsonUnexpectedComma() {
        String jsonStr = "{\"name\": \"John\", \"age\": 30,}";
        assertNull(Task62_GEMINI_gemini_1_5_pro_001.getRootElement(jsonStr));
    }

    @Test
    public void testMalformedJsonUnquotedKey() {
        String jsonStr = "{name: \"John\", \"age\": 30}";
        assertNull(Task62_GEMINI_gemini_1_5_pro_001.getRootElement(jsonStr));
    }

    @Test
    public void testInvalidJsonType() {
        String jsonStr = "Just a string, not JSON";
        assertEquals("Just a string, not JSON", Task62_GEMINI_gemini_1_5_pro_001.getRootElement(jsonStr));
    }
}
