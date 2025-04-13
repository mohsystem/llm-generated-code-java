package test.task63;

import gemini.task63.Task63_GEMINI_gemini_1_5_pro_001;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;

public class Task63Test {

    @Test
    void testValidJson() throws Exception {
        String raw = "eyJuYW1lIjogIkpvaG4gRG9lIiwgImFnZSI6IDMwfQ==";
        Map<String, Object> expected = Map.of("name", "John Doe", "age", 30.0);
        assertEquals(expected, Task63_GEMINI_gemini_1_5_pro_001.processRequest(raw));
    }

    @Test
    void testEmptyInput() {
        assertThrows(Exception.class, () -> Task63_GEMINI_gemini_1_5_pro_001.processRequest(""));
    }

    @Test
    void testInvalidBase64() {
        assertThrows(IllegalArgumentException.class, () -> Task63_GEMINI_gemini_1_5_pro_001.processRequest("invalid_base64_string"));
    }

    @Test
    void testMalformedJson() {
        String malformedJson = Base64.getEncoder().encodeToString("name\": \"John}".getBytes(StandardCharsets.UTF_8));
        assertThrows(Exception.class, () -> Task63_GEMINI_gemini_1_5_pro_001.processRequest(malformedJson));
    }

    @Test
    void testBase64OfEmptyJson() throws Exception {
        String encoded = Base64.getEncoder().encodeToString("{}".getBytes(StandardCharsets.UTF_8));
        assertEquals(Map.of(), Task63_GEMINI_gemini_1_5_pro_001.processRequest(encoded));
    }

    @Test
    void testJsonWithSpecialCharacters() throws Exception {
        String json = "{\"key\": \"value_with_special_characters_!@#$%^&*()\"}";
        String encoded = Base64.getEncoder().encodeToString(json.getBytes(StandardCharsets.UTF_8));
        assertEquals(Map.of("key", "value_with_special_characters_!@#$%^&*()"), Task63_GEMINI_gemini_1_5_pro_001.processRequest(encoded));
    }

    @Test
    void testJsonWithNumericValues() throws Exception {
        String json = "{\"value\": 1234}";
        String encoded = Base64.getEncoder().encodeToString(json.getBytes(StandardCharsets.UTF_8));
        assertEquals(Map.of("value", 1234.0), Task63_GEMINI_gemini_1_5_pro_001.processRequest(encoded));
    }

    @Test
    void testJsonWithBooleanValues() throws Exception {
        String json = "{\"active\": true, \"verified\": false}";
        String encoded = Base64.getEncoder().encodeToString(json.getBytes(StandardCharsets.UTF_8));
        assertEquals(Map.of("active", true, "verified", false), Task63_GEMINI_gemini_1_5_pro_001.processRequest(encoded));
    }

    @Test
    void testJsonWithNullValue() throws Exception {
        String json = "{\"value\": null}";
        String encoded = Base64.getEncoder().encodeToString(json.getBytes(StandardCharsets.UTF_8));
        assertEquals(Map.of("value", null), Task63_GEMINI_gemini_1_5_pro_001.processRequest(encoded));
    }

    @Test
    void testNestedJson() throws Exception {
        String json = "{\"outer\": {\"inner\": \"value\"}}";
        String encoded = Base64.getEncoder().encodeToString(json.getBytes(StandardCharsets.UTF_8));
        assertEquals(Map.of("outer", Map.of("inner", "value")), Task63_GEMINI_gemini_1_5_pro_001.processRequest(encoded));
    }
}
