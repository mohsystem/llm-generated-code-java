package gtp4o.task63;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.google.gson.Gson;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Task63Test {

    Gson gson = new Gson();

    private String encode(Object obj) {
        return Base64.getEncoder().encodeToString(gson.toJson(obj).getBytes(StandardCharsets.UTF_8));
    }

    @Test
    public void testValidJson() {
        String input = "eyJuYW1lIjogIkpvaG4gRG9lIiwgImFnZSI6IDMwfQ==";
        String output = Task63_OPENAI_gpt_4o.processRequest(input);
        assertTrue(output.contains("John Doe"));
        assertTrue(output.contains("30"));
    }

    @Test
    public void testEmptyInput() {
        String result = Task63_OPENAI_gpt_4o.processRequest("");
        assertNull(result);
    }

    @Test
    public void testInvalidBase64() {
        String result = Task63_OPENAI_gpt_4o.processRequest("invalid!!");
        assertNull(result);
    }

    @Test
    public void testMalformedJson() {
        String brokenJson = Base64.getEncoder().encodeToString("name\": \"John}".getBytes(StandardCharsets.UTF_8));
        String result = Task63_OPENAI_gpt_4o.processRequest(brokenJson);
        assertNull(result);
    }

    @Test
    public void testEmptyJson() {
        String input = encode(new Object());
        String output = Task63_OPENAI_gpt_4o.processRequest(input);
        assertEquals("{}", output.trim());
    }

    @Test
    public void testSpecialCharacters() {
        String value = "value_with_special_characters_!@#$%^&*()";
        String input = encode(new Data(value));
        String output = Task63_OPENAI_gpt_4o.processRequest(input);
        assertTrue(output.contains(value));
    }

    @Test
    public void testNumericValue() {
        String input = encode(new Data("1234"));
        String output = Task63_OPENAI_gpt_4o.processRequest(input);
        assertTrue(output.contains("1234"));
    }

    @Test
    public void testBooleanValue() {
        String input = encode(new Data("true"));
        String output = Task63_OPENAI_gpt_4o.processRequest(input);
        assertTrue(output.toLowerCase().contains("true"));
    }

    @Test
    public void testNullValue() {
        String input = encode(new Data(null));
        String output = Task63_OPENAI_gpt_4o.processRequest(input);
        assertTrue(output.contains("null"));
    }

    @Test
    public void testNestedJsonSimulation() {
        String nestedJson = Base64.getEncoder().encodeToString("{\"outer\": {\"inner\": \"value\"}}".getBytes(StandardCharsets.UTF_8));
        String output = Task63_OPENAI_gpt_4o.processRequest(nestedJson);
        assertTrue(output.contains("outer"));
        assertTrue(output.contains("inner"));
        assertTrue(output.contains("value"));
    }


}
