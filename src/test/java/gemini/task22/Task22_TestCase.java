package gemini.task22;

import org.junit.jupiter.api.Test;
import java.util.List;
import static gemini.task22.Task22_GEMINI_gemini_1_5_pro_001.filterList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task22_TestCase {

    @Test
    void testMixedList() {
        // Test with a list containing integers and strings
        List<Object> input = List.of(1, 2, "a", "b");
        List<Object> expected = List.of(1, 2);
        assertEquals(expected, filterList(input));
    }

    @Test
    void testEmptyList() {
        // Test with an empty list
        List<Object> input = List.of();
        List<Object> expected = List.of();
        assertEquals(expected, filterList(input));
    }

    @Test
    void testAllStrings() {
        // Test with a list containing only strings
        List<Object> input = List.of("a", "b", "c");
        List<Object> expected = List.of();
        assertEquals(expected, filterList(input));
    }

    @Test
    void testAllIntegers() {
        // Test with a list containing only integers
        List<Object> input = List.of(1, 2, 3, 4);
        List<Object> expected = List.of(1, 2, 3, 4);
        assertEquals(expected, filterList(input));
    }

    @Test
    void testStringsAndIntegersMixed() {
        // Test with a list of mixed strings and integers with varied content
        List<Object> input = List.of(1, "a", 2, "b", 0, 15);
        List<Object> expected = List.of(1, 2, 0, 15);
        assertEquals(expected, filterList(input));
    }

    @Test
    void testSingleElementInteger() {
        // Test with a list containing a single integer
        List<Object> input = List.of(5);
        List<Object> expected = List.of(5);
        assertEquals(expected, filterList(input));
    }

    @Test
    void testSingleElementString() {
        // Test with a list containing a single string
        List<Object> input = List.of("onlyString");
        List<Object> expected = List.of();
        assertEquals(expected, filterList(input));
    }

    @Test
    void testIntegersAndNumericStrings() {
        // Test with a list containing integers and numeric strings
        List<Object> input = List.of(1, "2", "three", 4, "5");
        List<Object> expected = List.of(1, 4);
        assertEquals(expected, filterList(input));
    }

    @Test
    void testNegativeIntegers() {
        // Test with a list containing negative integers and strings
        List<Object> input = List.of(-1, "-2", 3, "4");
        List<Object> expected = List.of(-1, 3);
        assertEquals(expected, filterList(input));
    }

    @Test
    void testLargeList() {
        // Test with a large list of integers and strings
        List<Object> input = List.of(
                100, "200", 300, "400", 500, "600", 700, "800", 900, "1000",
                1100, "1200", 1300, "1400", 1500, "1600", 1700, "1800", 1900, "2000"
        );
        List<Object> expected = List.of(
                100, 300, 500, 700, 900, 1100, 1300, 1500, 1700, 1900
        );
        assertEquals(expected, filterList(input));
    }
}
