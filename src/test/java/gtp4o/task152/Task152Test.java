package gtp4o.task152;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Task152Test {

    static class HashTable {
        private final int size;
        private List<Node>[] table;

        static class Node {
            String key;
            String value;

            Node(String key, String value) {
                this.key = key;
                this.value = value;
            }
        }

        @SuppressWarnings("unchecked")
        public HashTable(int size) {
            this.size = size;
            table = new LinkedList[size];
            for (int i = 0; i < size; i++) {
                table[i] = new LinkedList<>();
            }
        }

        private int hashFunction(String key) {
            return Math.abs(key.hashCode()) % size;
        }

        public void insert(String key, String value) {
            int idx = hashFunction(key);
            List<Node> bucket = table[idx];
            for (Node node : bucket) {
                if (node.key.equals(key)) {
                    node.value = value;
                    return;
                }
            }
            bucket.add(new Node(key, value));
        }

        public void delete(String key) {
            int idx = hashFunction(key);
            List<Node> bucket = table[idx];
            bucket.removeIf(node -> node.key.equals(key));
        }

        public String search(String key) {
            int idx = hashFunction(key);
            List<Node> bucket = table[idx];
            for (Node node : bucket) {
                if (node.key.equals(key)) {
                    return node.value;
                }
            }
            return null;
        }
    }

    public static void test() {
        try {
            HashTable table = new HashTable(10);

            // Test insert and search
            table.insert("key1", "value1");
            assert Objects.equals(table.search("key1"), "value1") : "Test Case 1 Failed";

            // Test insert overwrite
            table.insert("key1", "value2");
            assert Objects.equals(table.search("key1"), "value2") : "Test Case 2 Failed";

            // Test search non-existent key
            assert table.search("nonexistent_key") == null : "Test Case 3 Failed";

            // Test delete existing key
            table.insert("key1", "value1");
            table.delete("key1");
            assert table.search("key1") == null : "Test Case 4 Failed";

            // Test delete non-existent key
            table.delete("nonexistent_key");
            assert table.search("nonexistent_key") == null : "Test Case 5 Failed";

            // Test insert multiple keys
            table.insert("key1", "value1");
            table.insert("key2", "value2");
            table.insert("key3", "value3");
            assert Objects.equals(table.search("key1"), "value1") : "Test Case 6 Failed";
            assert Objects.equals(table.search("key2"), "value2") : "Test Case 7 Failed";
            assert Objects.equals(table.search("key3"), "value3") : "Test Case 8 Failed";

            // Test collision handling with size=1 to force collisions
            table = new HashTable(1);
            table.insert("key1", "value1");
            table.insert("key2", "value2");
            assert Objects.equals(table.search("key1"), "value1") : "Test Case 9 Failed";
            assert Objects.equals(table.search("key2"), "value2") : "Test Case 10 Failed";

            // Test delete key from empty table
            table.delete("key1");
            assert table.search("key1") == null : "Test Case 11 Failed";

            // Test insert and delete all keys
            String[] keys = {"key1", "key2", "key3", "key4", "key5"};
            for (String key : keys) {
                table.insert(key, "value_" + key);
            }
            for (String key : keys) {
                table.delete(key);
                assert table.search(key) == null : "Test Case 12 Failed for key: " + key;
            }

            // Test reinsert after delete
            table.insert("key1", "value1");
            table.delete("key1");
            table.insert("key1", "value2");
            assert Objects.equals(table.search("key1"), "value2") : "Test Case 13 Failed";

            System.out.println("All test cases passed!");
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        test();
    }
}
