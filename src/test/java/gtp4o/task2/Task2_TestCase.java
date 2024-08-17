package gtp4o.task2;

import claude.task2.Task2_CLAUDE_claude_3_5_sonnet_20240620;
import gemini.task2.Task2_GEMINI_gemini_1_5_pro_001;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task2_TestCase {
    @ParameterizedTest(name = "Test case {index}: {2}")
    @MethodSource("phoneNumberTestCases")
    void testCreatePhoneNumber(int[] input, String expected, String testName) {
        String result = Task2_OPENAI_gpt_4o.createPhoneNumber(input);
        assertEquals(expected, result, testName);
    }

    private static Stream<Arguments> phoneNumberTestCases() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "(123) 456-7890", "Normal case"),
                Arguments.of(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, "(000) 000-0000", "All zeros"),
                Arguments.of(new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, "(999) 999-9999", "All nines"),
                Arguments.of(new int[]{1, 0, 1, 0, 1, 0, 1, 0, 1, 0}, "(101) 010-1010", "Alternating digits"),
                Arguments.of(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, "(012) 345-6789", "Ascending order"),
                Arguments.of(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, "(987) 654-3210", "Descending order"),
                Arguments.of(new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3, 3}, "(111) 222-3333", "Repeated digits"),
                Arguments.of(new int[]{5, 2, 9, 3, 7, 1, 0, 8, 6, 4}, "(529) 371-0864", "Random mix"),
                Arguments.of(new int[]{7, 4, 2, 8, 5, 0, 9, 1, 3, 6}, "(742) 850-9136", "Another random mix"),
                Arguments.of(new int[]{1, 1, 1, 1, 1, 1, 1, 1}, "(111) 111-11", "Edge case (all same digit except one)")
        );
    }

    @Test
    void testInvalidInput() {
        // This test case checks for handling of invalid input (array of incorrect length)
        int[] invalidInput = {1, 2, 3, 4, 5};
        try {
            Task2_OPENAI_gpt_4o.createPhoneNumber(invalidInput);
        } catch (ArrayIndexOutOfBoundsException e) {
            // Expected exception
            throw new AssertionError("IllegalArgumentException should be thrown");

        }
    }
}