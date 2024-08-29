package claude.task182;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task182Test {

    private Task182_CLAUDE_claude_3_5_sonnet_20240620 phoneNumberCleaner;

    @BeforeEach
    void setUp() {
        phoneNumberCleaner = new Task182_CLAUDE_claude_3_5_sonnet_20240620();
    }

    @Test
    void testCleanPhoneNumber_withCountryCodeAndPunctuation() {
        String input = "+1 (613)-995-0253";
        String expected = "6139950253";
        assertEquals(expected, Task182_CLAUDE_claude_3_5_sonnet_20240620.cleanPhoneNumber(input));
    }

    @Test
    void testCleanPhoneNumber_withHyphensOnly() {
        String input = "613-995-0253";
        String expected = "6139950253";
        assertEquals(expected, Task182_CLAUDE_claude_3_5_sonnet_20240620.cleanPhoneNumber(input));
    }

    @Test
    void testCleanPhoneNumber_withSpacesAndCountryCode() {
        String input = "1 613 995 0253";
        String expected = "6139950253";
        assertEquals(expected, Task182_CLAUDE_claude_3_5_sonnet_20240620.cleanPhoneNumber(input));
    }

    @Test
    void testCleanPhoneNumber_withDots() {
        String input = "613.995.0253";
        String expected = "6139950253";
        assertEquals(expected, Task182_CLAUDE_claude_3_5_sonnet_20240620.cleanPhoneNumber(input));
    }

    @Test
    void testCleanPhoneNumber_withCountryCodeNoPunctuation() {
        String input = "16139950253";
        String expected = "6139950253";
        assertEquals(expected, Task182_CLAUDE_claude_3_5_sonnet_20240620.cleanPhoneNumber(input));
    }

    @Test
    void testCleanPhoneNumber_withInvalid11DigitNumber() {
        String input = "26139950253";
        assertThrows(IllegalArgumentException.class, () -> Task182_CLAUDE_claude_3_5_sonnet_20240620.cleanPhoneNumber(input));
    }

    @Test
    void testCleanPhoneNumber_withInvalidLength() {
        String input = "613995025";
        assertThrows(IllegalArgumentException.class, () -> Task182_CLAUDE_claude_3_5_sonnet_20240620.cleanPhoneNumber(input));
    }

    @Test
    void testCleanPhoneNumber_withLettersInInput() {
        String input = "613-995-ABCD";
        assertThrows(IllegalArgumentException.class, () -> Task182_CLAUDE_claude_3_5_sonnet_20240620.cleanPhoneNumber(input));
    }

    @Test
    void testCleanPhoneNumber_withMultipleCountryCodes() {
        String input = "+1 1 613-995-0253";
        assertThrows(IllegalArgumentException.class, () -> Task182_CLAUDE_claude_3_5_sonnet_20240620.cleanPhoneNumber(input));
    }

    @Test
    void testCleanPhoneNumber_withEmptyString() {
        String input = "";
        assertThrows(IllegalArgumentException.class, () -> Task182_CLAUDE_claude_3_5_sonnet_20240620.cleanPhoneNumber(input));
    }
}
