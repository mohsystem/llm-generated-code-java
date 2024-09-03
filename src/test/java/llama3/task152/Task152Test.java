package llama3.task152;
/*
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {
    private HashTable hashTable;

    @BeforeEach
    void setUp() {
        hashTable = new HashTable(100);
    }

    @Test
    void testInsertAndSearchSingleElement() {
        hashTable.put(5, "apple");
        assertEquals(5, hashTable.get("apple"), "Value associated with 'apple' should be 5.");
    }

    @Test
    void testInsertAndSearchMultipleElements() {
        hashTable.put(5, "apple");
        hashTable.put(7, "banana");
        hashTable.put(3, "orange");
        assertEquals(5, hashTable.get("apple"), "Value associated with 'apple' should be 5.");
        assertEquals(7, hashTable.get("banana"), "Value associated with 'banana' should be 7.");
        assertEquals(3, hashTable.get("orange"), "Value associated with 'orange' should be 3.");
    }

    @Test
    void testUpdateExistingElement() {
        hashTable.put(5, "apple");
        hashTable.put(10, "apple");  // Update the value associated with 'apple'
        assertEquals(10, hashTable.get("apple"), "Value associated with 'apple' should be updated to 10.");
    }

    @Test
    void testDeleteElement() {
        hashTable.put(7, "banana");
        hashTable.delete("banana");
        assertNull(hashTable.get("banana"), "Value associated with 'banana' should be null after deletion.");
    }

    @Test
    void testDeleteNonExistentElement() {
        hashTable.put(5, "apple");
        hashTable.delete("banana");  // Try to delete a non-existent key
        assertEquals(5, hashTable.get("apple"), "Value associated with 'apple' should still be 5.");
    }

    @Test
    void testSearchNonExistentElement() {
        hashTable.put(5, "apple");
        assertNull(hashTable.get("banana"), "Value associated with non-existent 'banana' should be null.");
    }

    @Test
    void testHandleCollisions() {
        // Assuming "apple" and "elppa" produce the same hash index
        hashTable.put(5, "apple");
        hashTable.put(10, "elppa");  // Insert another key that hashes to the same index
        assertEquals(5, hashTable.get("apple"), "Value associated with 'apple' should be 5.");
        assertEquals(10, hashTable.get("elppa"), "Value associated with 'elppa' should be 10.");
    }

    @Test
    void testDeleteElementWithCollision() {
        // Assuming "apple" and "elppa" produce the same hash index
        hashTable.put(5, "apple");
        hashTable.put(10, "elppa");
        hashTable.delete("apple");  // Delete one of the colliding elements
        assertNull(hashTable.get("apple"), "Value associated with 'apple' should be null after deletion.");
        assertEquals(10, hashTable.get("elppa"), "Value associated with 'elppa' should still be 10.");
    }

    @Test
    void testInsertAndSearchLargeNumberOfElements() {
        for (int i = 0; i < 100; i++) {
            hashTable.put(i, "key" + i);
        }
        for (int i = 0; i < 100; i++) {
            assertEquals(i, hashTable.get("key" + i), "Value associated with 'key" + i + "' should be " + i + ".");
        }
    }

    @Test
    void testDeleteAllElements() {
        hashTable.put(5, "apple");
        hashTable.put(7, "banana");
        hashTable.put(3, "orange");
        hashTable.delete("apple");
        hashTable.delete("banana");
        hashTable.delete("orange");
        assertNull(hashTable.get("apple"), "Value associated with 'apple' should be null after deletion.");
        assertNull(hashTable.get("banana"), "Value associated with 'banana' should be null after deletion.");
        assertNull(hashTable.get("orange"), "Value associated with 'orange' should be null after deletion.");
    }
}
*/