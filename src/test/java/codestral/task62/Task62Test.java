package codestral.task62;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task62Test {

    @Test
    public void testValidJson() {
        String jsonStr = "{\"name\": \"John\", \"age\": 30, \"city\": \"New York\"}";
         assertEquals("name", Task62_MISTRAL_codestral_latest.getRootElement(jsonStr));
    }

    @Test
    public void testEmptyJson() {
        String jsonStr = "{}";
        assertThrows(java.util.NoSuchElementException.class, () -> {
            Task62_MISTRAL_codestral_latest.getRootElement(jsonStr);
        });
    }

    @Test
    public void testJsonWithArray() {
        String jsonStr = "[1, 2, 3, 4]";
        assertThrows(org.json.JSONException.class, () -> {
            Task62_MISTRAL_codestral_latest.getRootElement(jsonStr);
        });
    }

    @Test
    public void testJsonWithNestedObjects() {
        String jsonStr = "{\"person\": {\"name\": \"Alice\", \"age\": 25}, \"city\": \"Wonderland\"}";
        assertEquals("person", Task62_MISTRAL_codestral_latest.getRootElement(jsonStr));
    }

    @Test
    public void testJsonWithBooleanValues() {
        String jsonStr = "{\"active\": true, \"verified\": false}";
        assertEquals("active", Task62_MISTRAL_codestral_latest.getRootElement(jsonStr));
    }

    @Test
    public void testJsonWithNullValue() {
        String jsonStr = "{\"value\": null}";
        assertEquals("value", Task62_MISTRAL_codestral_latest.getRootElement(jsonStr));
    }

    @Test
    public void testMalformedJsonMissingBracket() {
        String jsonStr = "{\"name\": \"John\", \"age\": 30, \"city\": \"New York\"";
        assertThrows(org.json.JSONException.class, () -> {
            Task62_MISTRAL_codestral_latest.getRootElement(jsonStr);
        });
    }

    @Test
    public void testMalformedJsonUnexpectedComma() {
        String jsonStr = "{\"name\": \"John\", \"age\": 30,}";
        assertThrows(org.json.JSONException.class, () -> {
            Task62_MISTRAL_codestral_latest.getRootElement(jsonStr);
        });
    }

    @Test
    public void testMalformedJsonUnquotedKey() {
        String jsonStr = "{name: \"John\", \"age\": 30}";
        assertThrows(org.json.JSONException.class, () -> {
            Task62_MISTRAL_codestral_latest.getRootElement(jsonStr);
        });
    }

    @Test
    public void testInvalidJsonType() {
        String jsonStr = "Just a string, not JSON";
        assertThrows(org.json.JSONException.class, () -> {
            Task62_MISTRAL_codestral_latest.getRootElement(jsonStr);
        });
    }
}
