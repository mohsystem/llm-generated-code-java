package llama3.task25;

import llama3.task25.Task25_PERPLEXITY_llama_3_sonar_large_32k_chat;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task25_TestCase {

    @Test
    void testCase1() {
        String[] input = {};
        String[] expected = {};
        assertEquals(Arrays.asList(expected),
                (Task25_PERPLEXITY_llama_3_sonar_large_32k_chat.number(input)));
    }

    @Test
    void testCase2() {
        String[] input = {"Hello"};
        String[] expected = {"1: Hello"};
        assertEquals(Arrays.asList(expected),
                (Task25_PERPLEXITY_llama_3_sonar_large_32k_chat.number(input)));
    }

    @Test
    void testCase3() {
        String[] input = {"Hello", "World"};
        String[] expected = {"1: Hello", "2: World"};
        assertEquals(Arrays.asList(expected),
                (Task25_PERPLEXITY_llama_3_sonar_large_32k_chat.number(input)));
    }

    @Test
    void testCase4() {
        String[] input = {"a", "b", "c"};
        String[] expected = {"1: a", "2: b", "3: c"};
        assertEquals(Arrays.asList(expected),
                (Task25_PERPLEXITY_llama_3_sonar_large_32k_chat.number(input)));
    }

    @Test
    void testCase5() {
        String[] input = {"This is a long line", "Another long line"};
        String[] expected = {"1: This is a long line", "2: Another long line"};
        assertEquals(Arrays.asList(expected),
                (Task25_PERPLEXITY_llama_3_sonar_large_32k_chat.number(input)));
    }

    @Test
    void testCase6() {
        String[] input = {"Line 1", "", "Line 3"};
        String[] expected = {"1: Line 1", "2: ", "3: Line 3"};
        assertEquals(Arrays.asList(expected),
                (Task25_PERPLEXITY_llama_3_sonar_large_32k_chat.number(input)));
    }

    @Test
    void testCase7() {
        String[] input = {"!@#$%^", "&*()_+", "[]{}"};
        String[] expected = {"1: !@#$%^", "2: &*()_+", "3: []{}"};
        assertEquals(Arrays.asList(expected),
                (Task25_PERPLEXITY_llama_3_sonar_large_32k_chat.number(input)));
    }

    @Test
    void testCase8() {
        String[] input = {"123", "456", "789"};
        String[] expected = {"1: 123", "2: 456", "3: 789"};
        assertEquals(Arrays.asList(expected),
                (Task25_PERPLEXITY_llama_3_sonar_large_32k_chat.number(input)));
    }

    @Test
    void testCase9() {
        String[] input = {"  leading", "trailing  ", "  both  "};
        String[] expected = {"1:   leading", "2: trailing  ", "3:   both  "};
        assertEquals(Arrays.asList(expected),
                (Task25_PERPLEXITY_llama_3_sonar_large_32k_chat.number(input)));
    }

    @Test
    void testCase10() {
        String[] input = IntStream.range(0, 1000)
                .mapToObj(i -> "line " + i)
                .toArray(String[]::new);
        String[] expected = IntStream.range(0, 1000)
                .mapToObj(i -> (i + 1) + ": line " + i)
                .toArray(String[]::new);
        assertEquals(Arrays.asList(expected),
                (Task25_PERPLEXITY_llama_3_sonar_large_32k_chat.number(input)));
    }
}
