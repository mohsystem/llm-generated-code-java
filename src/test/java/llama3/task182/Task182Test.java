package llama3.task182;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task182Test {

    @BeforeEach
    void setUp() {
        // No instance is needed because cleanPhoneNumber is a static method
    }

    @Test
    void testCleanPhoneNumber_withCountryCodeAndPunctuation() {
        String input = "+1 (613)-995-0253";
        String expected = "6139950253";
        assertEquals(expected, Task182_PERPLEXITY_llama_3_sonar_large_32k_chat.cleanPhoneNumber(input));
    }

    @Test
    void testCleanPhoneNumber_withHyphensOnly() {
        String input = "613-995-0253";
        String expected = "6139950253";
        assertEquals(expected, Task182_PERPLEXITY_llama_3_sonar_large_32k_chat.cleanPhoneNumber(input));
    }

    @Test
    void testCleanPhoneNumber_withSpacesAndCountryCode() {
        String input = "1 613 995 0253";
        String expected = "6139950253";
        assertEquals(expected, Task182_PERPLEXITY_llama_3_sonar_large_32k_chat.cleanPhoneNumber(input));
    }

    @Test
    void testCleanPhoneNumber_withDots() {
        String input = "613.995.0253";
        String expected = "6139950253";
        assertEquals(expected, Task182_PERPLEXITY_llama_3_sonar_large_32k_chat.cleanPhoneNumber(input));
    }

    @Test
    void testCleanPhoneNumber_withCountryCodeNoPunctuation() {
        String input = "16139950253";
        String expected = "6139950253";
        assertEquals(expected, Task182_PERPLEXITY_llama_3_sonar_large_32k_chat.cleanPhoneNumber(input));
    }

    @Test
    void testCleanPhoneNumber_withInvalid11DigitNumber() {
        String input = "26139950253";
        String expected = "26139950253"; // The method does not currently handle invalid input, so it will return the original cleaned number.
        assertEquals(expected, Task182_PERPLEXITY_llama_3_sonar_large_32k_chat.cleanPhoneNumber(input));
    }

    @Test
    void testCleanPhoneNumber_withInvalidLength() {
        String input = "613995025";
        String expected = "613995025"; // The method does not currently handle invalid input, so it will return the original cleaned number.
        assertEquals(expected, Task182_PERPLEXITY_llama_3_sonar_large_32k_chat.cleanPhoneNumber(input));
    }

    @Test
    void testCleanPhoneNumber_withLettersInInput() {
        String input = "613-995-ABCD";
        String expected = "613995"; // The method will only retain numeric characters.
        assertEquals(expected, Task182_PERPLEXITY_llama_3_sonar_large_32k_chat.cleanPhoneNumber(input));
    }

    @Test
    void testCleanPhoneNumber_withMultipleCountryCodes() {
        String input = "+1 1 613-995-0253";
        String expected = "16139950253"; // The method will remove only the first "1" and return the remaining cleaned number.
        assertEquals(expected, Task182_PERPLEXITY_llama_3_sonar_large_32k_chat.cleanPhoneNumber(input));
    }

    @Test
    void testCleanPhoneNumber_withEmptyString() {
        String input = "";
        String expected = ""; // The method will return an empty string as it is.
        assertEquals(expected, Task182_PERPLEXITY_llama_3_sonar_large_32k_chat.cleanPhoneNumber(input));
    }
}
