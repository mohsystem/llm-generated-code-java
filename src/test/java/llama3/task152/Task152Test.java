package llama3.task152;

import java.util.Objects;

public class Task152Test {

    static class HashTable {
        private int size;
        private int[] slots;
        private String[] data;

        public HashTable(int size) {
            this.size = size;
            this.slots = new int[size];
            this.data = new String[size];
        }

        public void put(int key, String value) {
            int hashValue = hashFunction(key, size);

            if (slots[hashValue] == 0) {
                slots[hashValue] = key;
                data[hashValue] = value;
            } else {
                if (slots[hashValue] == key) {
                    data[hashValue] = value; // replace
                } else {
                    int nextSlot = rehash(hashValue, size);
                    while (slots[nextSlot] != 0 && slots[nextSlot] != key) {
                        nextSlot = rehash(nextSlot, size);
                    }

                    if (slots[nextSlot] == 0) {
                        slots[nextSlot] = key;
                        data[nextSlot] = value;
                    } else {
                        data[nextSlot] = value; // replace
                    }
                }
            }
        }

        public int hashFunction(int key, int size) {
            return key % size;
        }

        public int rehash(int oldHash, int size) {
            return (oldHash + 1) % size;
        }

        public String get(int key) {
            int startSlot = hashFunction(key, size);

            String value = null;
            boolean stop = false;
            boolean found = false;
            int position = startSlot;
            while (slots[position] != 0 && !found && !stop) {
                if (slots[position] == key) {
                    found = true;
                    value = data[position];
                } else {
                    position = rehash(position, size);
                    if (position == startSlot) {
                        stop = true;
                    }
                }
            }
            return value;
        }

        public void delete(int key) {
            int startSlot = hashFunction(key, size);

            boolean stop = false;
            boolean found = false;
            int position = startSlot;
            while (slots[position] != 0 && !found && !stop) {
                if (slots[position] == key) {
                    found = true;
                    slots[position] = 0;
                    data[position] = null;
                } else {
                    position = rehash(position, size);
                    if (position == startSlot) {
                        stop = true;
                    }
                }
            }
        }
    }

    public static void test() {
        try {
            HashTable table = new HashTable(10);

            // Test insert and search
            table.put(1, "value1");
            assert Objects.equals(table.get(1), "value1") : "Test Case 1 Failed";

            // Test insert overwrite
            table.put(1, "value2");
            assert Objects.equals(table.get(1), "value2") : "Test Case 2 Failed";

            // Test search non-existent key
            assert table.get(999) == null : "Test Case 3 Failed";

            // Test delete existing key
            table.put(1, "value1");
            table.delete(1);
            assert table.get(1) == null : "Test Case 4 Failed";

            // Test delete non-existent key
            table.delete(999);
            assert table.get(999) == null : "Test Case 5 Failed";

            // Test insert multiple keys
            table.put(1, "value1");
            table.put(2, "value2");
            table.put(3, "value3");
            assert Objects.equals(table.get(1), "value1") : "Test Case 6 Failed";
            assert Objects.equals(table.get(2), "value2") : "Test Case 7 Failed";
            assert Objects.equals(table.get(3), "value3") : "Test Case 8 Failed";

            // Test collision handling with size=1 to force collisions
            table = new HashTable(1);
            table.put(1, "value1");
            table.put(2, "value2");
            assert Objects.equals(table.get(1), "value1") : "Test Case 9 Failed";
            assert Objects.equals(table.get(2), "value2") : "Test Case 10 Failed";

            // Test delete key from empty table
            table.delete(1);
            assert table.get(1) == null : "Test Case 11 Failed";

            // Test insert and delete all keys
            int[] keys = {1, 2, 3, 4, 5};
            for (int key : keys) {
                table.put(key, "value_" + key);
            }
            for (int key : keys) {
                table.delete(key);
                assert table.get(key) == null : "Test Case 12 Failed for key: " + key;
            }

            // Test reinsert after delete
            table.put(1, "value1");
            table.delete(1);
            table.put(1, "value2");
            assert Objects.equals(table.get(1), "value2") : "Test Case 13 Failed";

            System.out.println("All test cases passed!");
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        test();
    }
}
