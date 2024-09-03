package gtp4o.task152;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/*
class HashTableTest {
    private HashTable hashTable;

    @BeforeEach
    void setUp() {
        hashTable = new HashTable();
    }

    @Test
    void testInsertAndSearchSingleElement() {
        hashTable.insert(5, "apple");
        assertEquals(5, hashTable.search("apple"), "Value associated with 'apple' should be 5.");
    }

    @Test
    void testInsertAndSearchMultipleElements() {
        hashTable.insert(5, "apple");
        hashTable.insert(7, "banana");
        hashTable.insert(3, "orange");
        assertEquals(5, hashTable.search("apple"), "Value associated with 'apple' should be 5.");
        assertEquals(7, hashTable.search("banana"), "Value associated with 'banana' should be 7.");
        assertEquals(3, hashTable.search("orange"), "Value associated with 'orange' should be 3.");
    }

    @Test
    void testUpdateExistingElement() {
        hashTable.insert(5, "apple");
        hashTable.insert(10, "apple");  // Update the value associated with 'apple'
        assertEquals(10, hashTable.search("apple"), "Value associated with 'apple' should be updated to 10.");
    }

    @Test
    void testDeleteElement() {
        hashTable.insert(7, "banana");
        hashTable.delete("banana");
        assertNull(hashTable.search("banana"), "Value associated with 'banana' should be null after deletion.");
    }

    @Test
    void testDeleteNonExistentElement() {
        hashTable.insert(5, "apple");
        hashTable.delete("banana");  // Try to delete a non-existent key
        assertEquals(5, hashTable.search("apple"), "Value associated with 'apple' should still be 5.");
    }

    @Test
    void testSearchNonExistentElement() {
        hashTable.insert(5, "apple");
        assertNull(hashTable.search("banana"), "Value associated with non-existent 'banana' should be null.");
    }

    @Test
    void testHandleCollisions() {
        // Assuming "apple" and "elppa" produce the same hash index
        hashTable.insert(5, "apple");
        hashTable.insert(10, "elppa");  // Insert another key that hashes to the same index
        assertEquals(5, hashTable.search("apple"), "Value associated with 'apple' should be 5.");
        assertEquals(10, hashTable.search("elppa"), "Value associated with 'elppa' should be 10.");
    }

    @Test
    void testDeleteElementWithCollision() {
        // Assuming "apple" and "elppa" produce the same hash index
        hashTable.insert(5, "apple");
        hashTable.insert(10, "elppa");
        hashTable.delete("apple");  // Delete one of the colliding elements
        assertNull(hashTable.search("apple"), "Value associated with 'apple' should be null after deletion.");
        assertEquals(10, hashTable.search("elppa"), "Value associated with 'elppa' should still be 10.");
    }

    @Test
    void testInsertAndSearchLargeNumberOfElements() {
        for (int i = 0; i < 100; i++) {
            hashTable.insert(i, "key" + i);
        }
        for (int i = 0; i < 100; i++) {
            assertEquals(i, hashTable.search("key" + i), "Value associated with 'key" + i + "' should be " + i + ".");
        }
    }

    @Test
    void testDeleteAllElements() {
        hashTable.insert(5, "apple");
        hashTable.insert(7, "banana");
        hashTable.insert(3, "orange");
        hashTable.delete("apple");
        hashTable.delete("banana");
        hashTable.delete("orange");
        assertNull(hashTable.search("apple"), "Value associated with 'apple' should be null after deletion.");
        assertNull(hashTable.search("banana"), "Value associated with 'banana' should be null after deletion.");
        assertNull(hashTable.search("orange"), "Value associated with 'orange' should be null after deletion.");
    }
}
*/
