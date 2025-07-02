package gtp4o.task118;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task118Test {

    @Test
    void testValidClassAIP() {
        assertTrue(Task118_OPENAI_gpt_4o.validateIP("10.0.0.1"));
    }

    @Test
    void testValidClassBIP() {
        assertTrue(Task118_OPENAI_gpt_4o.validateIP("172.16.0.1"));
    }

    @Test
    void testValidClassCIP() {
        assertTrue(Task118_OPENAI_gpt_4o.validateIP("192.168.0.1"));
    }

    @Test
    void testValidClassDIP() {
        assertTrue(Task118_OPENAI_gpt_4o.validateIP("224.0.0.1"));
    }

    @Test
    void testValidClassEIP() {
        assertTrue(Task118_OPENAI_gpt_4o.validateIP("240.0.0.1"));
    }

    @Test
    void testInvalidIPNonNumericOctets() {
        assertFalse(Task118_OPENAI_gpt_4o.validateIP("192.abc.0.1"));
    }

    @Test
    void testInvalidIPOutOfRangeOctets() {
        assertFalse(Task118_OPENAI_gpt_4o.validateIP("256.0.0.1"));
    }

    @Test
    void testInvalidIPEmptyOctets() {
        assertFalse(Task118_OPENAI_gpt_4o.validateIP("192.168..1"));
    }

    @Test
    void testInvalidIPMissingOctets() {
        assertFalse(Task118_OPENAI_gpt_4o.validateIP("192.168.0"));
    }

    @Test
    void testInvalidIPExtraOctets() {
        assertFalse(Task118_OPENAI_gpt_4o.validateIP("192.168.0.1.1"));
    }
}
