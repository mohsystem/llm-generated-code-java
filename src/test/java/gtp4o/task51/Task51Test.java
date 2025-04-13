package gtp4o.task51;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task51Test {

    @Test
    public void testCase1() {
        assertEquals("bcd", Task51_OPENAI_gpt_4o.encrypt("abc"));
    }

    @Test
    public void testCase2() {
        assertEquals("BCD", Task51_OPENAI_gpt_4o.encrypt("ABC"));
    }

    @Test
    public void testCase3() {
        assertEquals("yza", Task51_OPENAI_gpt_4o.encrypt("xyz"));
    }

    @Test
    public void testCase4() {
        assertEquals("YZA", Task51_OPENAI_gpt_4o.encrypt("XYZ"));
    }

    @Test
    public void testCase5() {
        assertEquals("b c-d", Task51_OPENAI_gpt_4o.encrypt("a b-c"));
    }

    @Test
    public void testCase6() {
        assertEquals("Ifmmp Xpsme", Task51_OPENAI_gpt_4o.encrypt("Hello World"));
    }

    @Test
    public void testCase7() {
        assertEquals("", Task51_OPENAI_gpt_4o.encrypt(""));
    }

    @Test
    public void testCase8() {
        assertEquals("1234!@#$", Task51_OPENAI_gpt_4o.encrypt("1234!@#$"));
    }

    @Test
    public void testCase9() {
        assertEquals("Kbwb_8", Task51_OPENAI_gpt_4o.encrypt("Java_8"));
    }

    @Test
    public void testCase10() {
        assertEquals("aaa AAA", Task51_OPENAI_gpt_4o.encrypt("zzz ZZZ"));
    }

}
