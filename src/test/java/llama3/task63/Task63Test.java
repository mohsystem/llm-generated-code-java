package llama3.task63;

import llama3.task63.Task63_PERPLEXITY_llama_3_sonar_large_32k_chat;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static org.junit.jupiter.api.Assertions.*;

public class Task63Test {

    private String encode(String json) {
        return Base64.getEncoder().encodeToString(json.getBytes(StandardCharsets.UTF_8));
    }

    private JSONObject parse(String json) {
        return new JSONObject(json);
    }

    @Test
    void testValidJson() throws Exception {
        String raw = "eyJuYW1lIjogIkpvaG4gRG9lIiwgImFnZSI6IDMwfQ==";
        JSONObject expected = new JSONObject().put("name", "John Doe").put("age", 30);
        assertEquals(expected.toString(), Task63_PERPLEXITY_llama_3_sonar_large_32k_chat.processRequest(raw).toString());
    }

    @Test
    void testEmptyInput() {
        assertThrows(Exception.class, () -> Task63_PERPLEXITY_llama_3_sonar_large_32k_chat.processRequest(""));
    }

    @Test
    void testInvalidBase64() {
        assertThrows(IllegalArgumentException.class, () -> Task63_PERPLEXITY_llama_3_sonar_large_32k_chat.processRequest("invalid_base64"));
    }

    @Test
    void testMalformedJson() {
        String brokenJson = encode("name\": \"John}");
        assertThrows(Exception.class, () -> Task63_PERPLEXITY_llama_3_sonar_large_32k_chat.processRequest(brokenJson));
    }

    @Test
    void testBase64OfEmptyJson() throws Exception {
        String encoded = encode("{}");
        assertEquals(parse("{}").toString(), Task63_PERPLEXITY_llama_3_sonar_large_32k_chat.processRequest(encoded).toString());
    }

    @Test
    void testJsonWithSpecialCharacters() throws Exception {
        String json = "{\"key\": \"value_with_special_characters_!@#$%^&*()\"}";
        String encoded = encode(json);
        JSONObject expected = new JSONObject().put("key", "value_with_special_characters_!@#$%^&*()");
        assertEquals(expected.toString(), Task63_PERPLEXITY_llama_3_sonar_large_32k_chat.processRequest(encoded).toString());
    }

    @Test
    void testJsonWithNumericValues() throws Exception {
        String json = "{\"value\": 1234}";
        String encoded = encode(json);
        JSONObject expected = new JSONObject().put("value", 1234);
        assertEquals(expected.toString(), Task63_PERPLEXITY_llama_3_sonar_large_32k_chat.processRequest(encoded).toString());
    }

    @Test
    void testJsonWithBooleanValues() throws Exception {
        String json = "{\"active\": true, \"verified\": false}";
        String encoded = encode(json);
        JSONObject expected = new JSONObject().put("active", true).put("verified", false);
        assertEquals(expected.toString(), Task63_PERPLEXITY_llama_3_sonar_large_32k_chat.processRequest(encoded).toString());
    }

    @Test
    void testJsonWithNullValue() throws Exception {
        String json = "{\"value\": null}";
        String encoded = encode(json);
        JSONObject expected = new JSONObject().put("value", JSONObject.NULL);
        assertEquals(expected.toString(), Task63_PERPLEXITY_llama_3_sonar_large_32k_chat.processRequest(encoded).toString());
    }

    @Test
    void testNestedJson() throws Exception {
        String json = "{\"outer\": {\"inner\": \"value\"}}";
        String encoded = encode(json);
        JSONObject expected = new JSONObject().put("outer", new JSONObject().put("inner", "value"));
        assertEquals(expected.toString(), Task63_PERPLEXITY_llama_3_sonar_large_32k_chat.processRequest(encoded).toString());
    }
}
