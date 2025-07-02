package llama3.task131;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;

class Task131Test {

    private static final ObjectMapper objectMapper = new ObjectMapper();

     private static byte[] jsonToSerializedBytes(String json) {
        try {
             Map<?, ?> map = objectMapper.readValue(json, Map.class);
             ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(map);
            oos.flush();
            return baos.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("Error during JSON to serialized bytes conversion", e);
        }
    }

    @Test
    void testValidJson() {
        String jsonInput = "{\"name\": \"John\", \"age\": 30}";
        byte[] serializedData = jsonToSerializedBytes(jsonInput);
        Object deserializedObject = Task131_PERPLEXITY_llama_3_sonar_large_32k_chat.deserializeData(serializedData);

        assertNotNull(deserializedObject, "Deserialized object should not be null");
        assertTrue(deserializedObject instanceof Map, "Deserialized object should be a Map");

        Map<?, ?> map = (Map<?, ?>) deserializedObject;
        assertEquals("John", map.get("name"));
        assertEquals(30, map.get("age"));
    }

    @Test
    void testInvalidJson() {
        String invalidJsonInput = "{\"name\": \"John\", \"age\": 30";  // Missing closing }
        byte[] serializedData;
        try {
            serializedData = jsonToSerializedBytes(invalidJsonInput);
            fail("Expected an exception during JSON parsing");
        } catch (RuntimeException e) {
            // Expected exception
        }
    }

    @Test
    void testEmptyJson() {
        String emptyJsonInput = "{}";
        byte[] serializedData = jsonToSerializedBytes(emptyJsonInput);
        Object deserializedObject = Task131_PERPLEXITY_llama_3_sonar_large_32k_chat.deserializeData(serializedData);

        assertNotNull(deserializedObject, "Deserialized object should not be null");
        assertTrue(deserializedObject instanceof Map, "Deserialized object should be a Map");

        Map<?, ?> map = (Map<?, ?>) deserializedObject;
        assertTrue(map.isEmpty(), "Deserialized map should be empty");
    }
}
