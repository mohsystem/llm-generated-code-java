package claude.task164;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Task164Test {

    @Test
    public void test_various_last_name_lengths() {
        String[] input = {"Jennifer Figueroa", "Heather Mcgee", "Amanda Schwartz", "Nicole Yoder", "Melissa Hoffman"};
        String[] expected = {"Heather Mcgee", "Nicole Yoder", "Melissa Hoffman", "Jennifer Figueroa", "Amanda Schwartz"};
        assertArrayEquals(expected, Task164_CLAUDE_claude_3_5_sonnet_20240620.lastNameLensort(input));
    }

    @Test
    public void test_same_last_name_length() {
        String[] input = {"John Doe", "Alice Lee", "Bob Zee", "Carol Foe"};
        String[] expected = {"Bob Zee", "Alice Lee", "Carol Foe", "John Doe"};
        assertArrayEquals(expected, Task164_CLAUDE_claude_3_5_sonnet_20240620.lastNameLensort(input));
    }

    @Test
    public void test_single_name() {
        String[] input = {"James Bond"};
        String[] expected = {"James Bond"};
        assertArrayEquals(expected, Task164_CLAUDE_claude_3_5_sonnet_20240620.lastNameLensort(input));
    }

    @Test
    public void test_multiple_names_same_last_name_length() {
        String[] input = {"Tom Jones", "Jerry Jones", "Rick Jones", "Bob Smith", "Paul Smith"};
        String[] expected = {"Bob Smith", "Paul Smith", "Tom Jones", "Jerry Jones", "Rick Jones"};
        assertArrayEquals(expected, Task164_CLAUDE_claude_3_5_sonnet_20240620.lastNameLensort(input));
    }

    @Test
    public void test_single_letter_last_names() {
        String[] input = {"A B", "C D", "E F", "G H", "I J"};
        String[] expected = {"A B", "C D", "E F", "G H", "I J"};
        assertArrayEquals(expected, Task164_CLAUDE_claude_3_5_sonnet_20240620.lastNameLensort(input));
    }

    @Test
    public void test_varied_last_name_lengths() {
        String[] input = {"A B", "C Def", "E Fghij", "G Hijklmn", "I J"};
        String[] expected = {"A B", "I J", "C Def", "E Fghij", "G Hijklmn"};
        assertArrayEquals(expected, Task164_CLAUDE_claude_3_5_sonnet_20240620.lastNameLensort(input));
    }

    @Test
    public void test_long_last_names() {
        String[] input = {"Anna Longnamehere", "Bob Shortname", "Carl Mediumname", "Dave Longestnamehere"};
        String[] expected = {"Bob Shortname", "Carl Mediumname", "Anna Longnamehere", "Dave Longestnamehere"};
        assertArrayEquals(expected, Task164_CLAUDE_claude_3_5_sonnet_20240620.lastNameLensort(input));
    }

    @Test
    public void test_varying_lengths() {
        String[] input = {"Alice Wonderland", "Bob Marley", "Charlie Brown", "David Bowie", "Edward Norton"};
        String[] expected = {"Bob Marley", "David Bowie", "Charlie Brown", "Edward Norton", "Alice Wonderland"};
        assertArrayEquals(expected, Task164_CLAUDE_claude_3_5_sonnet_20240620.lastNameLensort(input));
    }

    @Test
    public void test_names_with_punctuation() {
        String[] input = {"James Brown", "Elijah Davis", "Noah Johnson", "Liam O'Neill", "Oliver Smith"};
        String[] expected = {"James Brown", "Elijah Davis", "Noah Johnson", "Liam O'Neill", "Oliver Smith"};
        assertArrayEquals(expected, Task164_CLAUDE_claude_3_5_sonnet_20240620.lastNameLensort(input));
    }

    @Test
    public void test_already_sorted_names() {
        String[] input = {"Aaron Smith", "Brad Jones", "Chris Lee", "Derek Adams", "Evan Brown"};
        String[] expected = {"Chris Lee", "Brad Jones", "Aaron Smith", "Derek Adams", "Evan Brown"};
        assertArrayEquals(expected, Task164_CLAUDE_claude_3_5_sonnet_20240620.lastNameLensort(input));
    }
}
