package gtp4o.task164;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task164Test {

    @Test
    public void test_various_last_name_lengths() {
        List<String> input = Arrays.asList("Jennifer Figueroa", "Heather Mcgee", "Amanda Schwartz", "Nicole Yoder", "Melissa Hoffman");
        List<String> expected = Arrays.asList("Heather Mcgee", "Nicole Yoder", "Melissa Hoffman", "Jennifer Figueroa", "Amanda Schwartz");
        assertEquals(expected, Task164_OPENAI_gpt_4o.lastNameLensort(input));
    }

    @Test
    public void test_same_last_name_length() {
        List<String> input = Arrays.asList("John Doe", "Alice Lee", "Bob Zee", "Carol Foe");
        List<String> expected = Arrays.asList("Bob Zee", "Alice Lee", "Carol Foe", "John Doe");
        assertEquals(expected, Task164_OPENAI_gpt_4o.lastNameLensort(input));
    }

    @Test
    public void test_single_name() {
        List<String> input = Arrays.asList("James Bond");
        List<String> expected = Arrays.asList("James Bond");
        assertEquals(expected, Task164_OPENAI_gpt_4o.lastNameLensort(input));
    }

    @Test
    public void test_multiple_names_same_last_name_length() {
        List<String> input = Arrays.asList("Tom Jones", "Jerry Jones", "Rick Jones", "Bob Smith", "Paul Smith");
        List<String> expected = Arrays.asList("Bob Smith", "Paul Smith", "Tom Jones", "Jerry Jones", "Rick Jones");
        assertEquals(expected, Task164_OPENAI_gpt_4o.lastNameLensort(input));
    }

    @Test
    public void test_single_letter_last_names() {
        List<String> input = Arrays.asList("A B", "C D", "E F", "G H", "I J");
        List<String> expected = Arrays.asList("A B", "C D", "E F", "G H", "I J");
        assertEquals(expected, Task164_OPENAI_gpt_4o.lastNameLensort(input));
    }

    @Test
    public void test_varied_last_name_lengths() {
        List<String> input = Arrays.asList("A B", "C Def", "E Fghij", "G Hijklmn", "I J");
        List<String> expected = Arrays.asList("A B", "I J", "C Def", "E Fghij", "G Hijklmn");
        assertEquals(expected, Task164_OPENAI_gpt_4o.lastNameLensort(input));
    }

    @Test
    public void test_long_last_names() {
        List<String> input = Arrays.asList("Anna Longnamehere", "Bob Shortname", "Carl Mediumname", "Dave Longestnamehere");
        List<String> expected = Arrays.asList("Bob Shortname", "Carl Mediumname", "Anna Longnamehere", "Dave Longestnamehere");
        assertEquals(expected, Task164_OPENAI_gpt_4o.lastNameLensort(input));
    }

    @Test
    public void test_varying_lengths() {
        List<String> input = Arrays.asList("Alice Wonderland", "Bob Marley", "Charlie Brown", "David Bowie", "Edward Norton");
        List<String> expected = Arrays.asList("Bob Marley", "David Bowie", "Charlie Brown", "Edward Norton", "Alice Wonderland");
        assertEquals(expected, Task164_OPENAI_gpt_4o.lastNameLensort(input));
    }

    @Test
    public void test_names_with_punctuation() {
        List<String> input = Arrays.asList("James Brown", "Elijah Davis", "Noah Johnson", "Liam O'Neill", "Oliver Smith");
        List<String> expected = Arrays.asList("James Brown", "Elijah Davis", "Noah Johnson", "Liam O'Neill", "Oliver Smith");
        assertEquals(expected, Task164_OPENAI_gpt_4o.lastNameLensort(input));
    }

    @Test
    public void test_already_sorted_names() {
        List<String> input = Arrays.asList("Aaron Smith", "Brad Jones", "Chris Lee", "Derek Adams", "Evan Brown");
        List<String> expected = Arrays.asList("Chris Lee", "Brad Jones", "Aaron Smith", "Derek Adams", "Evan Brown");
        assertEquals(expected, Task164_OPENAI_gpt_4o.lastNameLensort(input));
    }
}
