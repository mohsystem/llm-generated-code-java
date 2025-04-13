package codestral.task63;

import com.google.gson.internal.LinkedTreeMap;
import org.junit.jupiter.api.Test;

import java.util.Base64;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class Task63Test {

    @Test
    public void testValidJson() {
        String rawData = "eyJuYW1lIjogIkpvaG4gRG9lIiwgImFnZSI6IDMwfQ=="; // {"name": "John Doe", "age": 30}
        Object result = Task63_MISTRAL_codestral_latest.processRequest(rawData);
        Map<?, ?> json = (Map<?, ?>) result;
        assertEquals("John Doe", json.get("name"));
        assertEquals(30.0, json.get("age")); // Gson uses double for numbers by default
    }

    @Test
    public void testEmptyInput_shouldThrow() {
        String rawData = "";
        assertThrows(IllegalArgumentException.class, () -> Task63_MISTRAL_codestral_latest.processRequest(rawData));
    }

    @Test
    public void testInvalidBase64_shouldThrow() {
        String rawData = "invalid_base64_string";
        assertThrows(IllegalArgumentException.class, () -> Task63_MISTRAL_codestral_latest.processRequest(rawData));
    }

    @Test
    public void testMalformedJson_shouldThrow() {
        String malformedJson = "name\": \"John}";
        String rawData = Base64.getEncoder().encodeToString(malformedJson.getBytes());
        assertThrows(com.google.gson.JsonSyntaxException.class, () -> Task63_MISTRAL_codestral_latest.processRequest(rawData));
    }

    @Test
    public void testBase64OfEmptyJson() {
        String rawData = Base64.getEncoder().encodeToString("{}".getBytes());
        Object result = Task63_MISTRAL_codestral_latest.processRequest(rawData);
        Map<?, ?> json = (Map<?, ?>) result;
        assertEquals(0, json.size());
    }

    @Test
    public void testJsonWithSpecialCharacters() {
        String json = "{\"key\": \"value_with_special_characters_!@#$%^&*()\"}";
        String rawData = Base64.getEncoder().encodeToString(json.getBytes());
        Object result = Task63_MISTRAL_codestral_latest.processRequest(rawData);
        Map<?, ?> jsonMap = (Map<?, ?>) result;
        assertEquals("value_with_special_characters_!@#$%^&*()", jsonMap.get("key"));
    }

    @Test
    public void testJsonWithNumericValues() {
        String json = "{\"value\": 1234}";
        String rawData = Base64.getEncoder().encodeToString(json.getBytes());
        Object result = Task63_MISTRAL_codestral_latest.processRequest(rawData);
        Map<?, ?> jsonMap = (Map<?, ?>) result;
        assertEquals(1234.0, jsonMap.get("value")); // GSON converts numbers to Double
    }

    @Test
    public void testJsonWithBooleanValues() {
        String json = "{\"active\": true, \"verified\": false}";
        String rawData = Base64.getEncoder().encodeToString(json.getBytes());
        Object result = Task63_MISTRAL_codestral_latest.processRequest(rawData);
        Map<?, ?> jsonMap = (Map<?, ?>) result;
        assertEquals(true, jsonMap.get("active"));
        assertEquals(false, jsonMap.get("verified"));
    }

    @Test
    public void testJsonWithNullValue() {
        String json = "{\"value\": null}";
        String rawData = Base64.getEncoder().encodeToString(json.getBytes());
        Object result = Task63_MISTRAL_codestral_latest.processRequest(rawData);
        Map<?, ?> jsonMap = (Map<?, ?>) result;
        assertTrue(jsonMap.containsKey("value"));
        assertNull(jsonMap.get("value"));
    }

    @Test
    public void testNestedJson() {
        String json = "{\"outer\": {\"inner\": \"value\"}}";
        String rawData = Base64.getEncoder().encodeToString(json.getBytes());
        Object result = Task63_MISTRAL_codestral_latest.processRequest(rawData);
        Map<?, ?> outer = (Map<?, ?>) result;
        Map<?, ?> inner = (Map<?, ?>) outer.get("outer");
        assertEquals("value", inner.get("inner"));
    }
}
