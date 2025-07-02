package codestral.task131;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.*;
import java.util.*;

class Task131Test {

    @Test
    void testValidDeserialization() throws Exception {
        // Create a simple serializable object (HashMap)
        HashMap<String, Object> original = new HashMap<>();
        original.put("name", "John");
        original.put("age", 30);

        byte[] serializedData = serializeObject(original);
        Object deserialized = Task131_MISTRAL_codestral_latest.deserialize(serializedData);

        assertTrue(deserialized instanceof HashMap, "Deserialized object should be a HashMap");

        @SuppressWarnings("unchecked")
        HashMap<String, Object> deserializedMap = (HashMap<String, Object>) deserialized;
        assertEquals("John", deserializedMap.get("name"));
        assertEquals(30, deserializedMap.get("age"));
    }

    @Test
    void testInvalidDeserialization() {
        byte[] invalidData = "not a serialized object".getBytes();

        assertThrows(IOException.class, () -> {
            Task131_MISTRAL_codestral_latest.deserialize(invalidData);
        }, "Should throw IOException for invalid serialized data");
    }

    @Test
    void testEmptyDeserialization() {
        byte[] emptyData = new byte[0];

        assertThrows(IOException.class, () -> {
            Task131_MISTRAL_codestral_latest.deserialize(emptyData);
        }, "Should throw IOException for empty input");
    }

    @Test
    void testArrayDeserialization() throws Exception {
        // Serialize an ArrayList
        ArrayList<Integer> originalList = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        byte[] serializedData = serializeObject(originalList);
        Object deserialized = Task131_MISTRAL_codestral_latest.deserialize(serializedData);

        assertTrue(deserialized instanceof ArrayList, "Deserialized object should be an ArrayList");

        @SuppressWarnings("unchecked")
        ArrayList<Integer> deserializedList = (ArrayList<Integer>) deserialized;
        assertEquals(Arrays.asList(1, 2, 3, 4), deserializedList);
    }

    // Helper function to serialize an object into byte[]
    private byte[] serializeObject(Object obj) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bos);
        out.writeObject(obj);
        out.flush();
        return bos.toByteArray();
    }
}
