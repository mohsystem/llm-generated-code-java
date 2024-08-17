package gemini.task28;

import org.junit.jupiter.api.Test;

import static gemini.task28.Task28_GEMINI_gemini_1_5_pro_001.whoLikesIt;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task28Test {
    @Test
    void testNoLikes() {
        // Test when there are no names in the array
        assertEquals("no one likes this", whoLikesIt(new String[]{}));
    }

    @Test
    void testOneLike() {
        // Test when there is one name in the array
        assertEquals("Peter likes this", whoLikesIt(new String[]{"Peter"}));
    }

    @Test
    void testTwoLikes() {
        // Test when there are two names in the array
        assertEquals("Jacob and Alex like this", whoLikesIt(new String[]{"Jacob", "Alex"}));
    }

    @Test
    void testThreeLikes() {
        // Test when there are three names in the array
        assertEquals("Max, John and Mark like this", whoLikesIt(new String[]{"Max", "John", "Mark"}));
    }

    @Test
    void testFourLikes() {
        // Test when there are four names in the array
        assertEquals("Alex, Jacob and 2 others like this", whoLikesIt(new String[]{"Alex", "Jacob", "Mark", "Max"}));
    }

    @Test
    void testFiveLikes() {
        // Test when there are five names in the array
        assertEquals("John, Paul and 3 others like this", whoLikesIt(new String[]{"John", "Paul", "George", "Ringo", "Brian"}));
    }

    @Test
    void testSixLikes() {
        // Test when there are six names in the array
        assertEquals("Alice, Bob and 4 others like this", whoLikesIt(new String[]{"Alice", "Bob", "Charlie", "Dave", "Eve", "Frank"}));
    }

    @Test
    void testNamesWithSpaces() {
        // Test when names contain spaces
        assertEquals("Anna Marie, John Doe and 2 others like this", whoLikesIt(new String[]{"Anna Marie", "John Doe", "Jane Smith", "Joe Public"}));
    }

    @Test
    void testDuplicateNames() {
        // Test when names are duplicated in the array
        assertEquals("Sam, Sam and 1 other like this", whoLikesIt(new String[]{"Sam", "Sam", "Alex"}));
    }

    @Test
    void testLongArray() {
        // Test with a long array of names
        String[] names = {"Tom", "Dick", "Harry", "Sally", "Jane", "Susan", "Bill", "Bob"};
        assertEquals("Tom, Dick and 6 others like this", whoLikesIt(names));
    }
}