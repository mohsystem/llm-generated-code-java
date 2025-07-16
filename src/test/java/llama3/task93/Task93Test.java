package llama3.task93;

import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class Task93Test {

    // Helper method to simulate the file reading and sorting functionality
    public List<String> readAndSortRecords(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        List<String[]> records = new ArrayList<>();
        String line;

        // Read each line, split by ":" and add to the list
        while ((line = br.readLine()) != null) {
            String[] record = line.split(":");
            if (record.length == 2) {
                records.add(record);
            }
        }

        // Sort records based on the first element (key)
        Collections.sort(records, (a, b) -> a[0].compareTo(b[0]));

        // Build sorted output without extra spaces between key and value
        List<String> sortedRecords = new ArrayList<>();
        for (String[] record : records) {
            sortedRecords.add(record[0].trim() + ":" + record[1].trim());  // Ensure no extra spaces
        }
        return sortedRecords;
    }

    @Test
    void testReadAndSortRecords() throws IOException {
        // Arrange: Prepare the test file with unsorted key-value pairs
        File testFile = new File("testfile.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(testFile));
        writer.write("key3: value3\n");
        writer.write("key1: value1\n");
        writer.write("key2: value2\n");
        writer.close();

        // Act: Call the method that reads and sorts the file records
        List<String> sortedRecords = readAndSortRecords("testfile.txt");

        // Expected sorted records
        List<String> expectedRecords = Arrays.asList(
                "key1:value1",
                "key2:value2",
                "key3:value3"
        );

        // Assert: Verify that the records are sorted as expected
        assertEquals(expectedRecords, sortedRecords);

        // Clean up the file after test
        testFile.delete();
    }
}
